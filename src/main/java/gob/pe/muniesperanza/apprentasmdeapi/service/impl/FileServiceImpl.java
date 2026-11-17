package gob.pe.muniesperanza.apprentasmdeapi.service.impl;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import gob.pe.muniesperanza.apprentasmdeapi.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceImpl implements FileService {
  private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

  private final Path root;

  public FileServiceImpl(@Value("${storage.location:uploads}") String storageLocation) {
    this.root = Paths.get(storageLocation).toAbsolutePath().normalize();
  }

  @Override
  public void init() {
    try {
      log.info("Initializing upload directory at {}", root);
      Files.createDirectories(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file) {
    try {
      Path destination = resolveFilename(file.getOriginalFilename());
      Files.copy(file.getInputStream(), destination);
    } catch (Exception e) {
      if (e instanceof FileAlreadyExistsException) {
        throw new RuntimeException("A file of that name already exists.");
      }

      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  public Resource load(String filename) {
    try {
      Path file = resolveFilename(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }

  @Override
  public Resource downloadFile(String filename) {
    Path file = resolveFilename(filename);

     try{


        Resource resource = new UrlResource(file.toUri());

        if (resource.exists() || resource.isReadable()) {
          return resource;


      }
    }catch (Exception e){
      log.warn("Unable to download file {}", filename, e);
      return null;
    }
    return null;
  }

  private Path resolveFilename(String filename) {
    if (filename == null || filename.isBlank()) {
      throw new RuntimeException("Invalid filename.");
    }
    Path resolved = root.resolve(filename).normalize();
    if (!resolved.startsWith(root)) {
      throw new RuntimeException("Invalid filename.");
    }
    return resolved;
  }
}
