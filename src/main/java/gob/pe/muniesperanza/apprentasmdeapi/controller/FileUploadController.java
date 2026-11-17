package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.FotoPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FileUploadController {
  private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

  @Autowired
  FileService storageService;

  @PostMapping("/api/upload")
  public String uploadFile(@RequestPart("file") MultipartFile file) {
    if (file.isEmpty()) {
      return "El archivo está vacío";
    }

    try {
      // Guardar el archivo en el disco o en la ubicación deseada
      byte[] bytes = file.getBytes();
      // Aquí se podría implementar la lógica para guardar el archivo
      // por ejemplo, usando Files.write(path, bytes);
      // Se necesita crear la lógica para definir la ruta de guardado.
      // Se puede utilizar la propiedad "upload.dir" del application.properties
      // para definir la ruta
      // String uploadDir = env.getProperty("upload.dir");
      log.info("File uploaded successfully: {}", file.getOriginalFilename());
      storageService.save(file);

      return "Archivo subido exitosamente";
    } catch (Exception e) {
      return "Error al subir el archivo: " + e.getMessage();
    }
  }

  @GetMapping("/api/files")
  public ResponseEntity<List<FotoPredioBean>> getListFiles() {
    List<FotoPredioBean> fileInfos = storageService.loadAll().map(path -> {
      String filename = path.getFileName().toString();
      String url = MvcUriComponentsBuilder
                           .fromMethodName(FileUploadController.class, "getFile", path.getFileName().toString()).build().toString();

      return new FotoPredioBean(filename, url);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
  }

  @GetMapping("/files/{filename:.+}")
  @ResponseBody
  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.load(filename);
    return ResponseEntity.ok()
                   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }




}
