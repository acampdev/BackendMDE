package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.file.Path;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceImplTests {

    @TempDir Path tempDir;

    @Test
    void savesListsAndLoadsFile() throws Exception {
        FileServiceImpl service = new FileServiceImpl(tempDir.toString());
        service.init();
        service.save(new MockMultipartFile("file", "predio.txt", "text/plain", "contenido".getBytes()));

        try (Stream<Path> files = service.loadAll()) {
            assertEquals(1, files.count());
        }
        assertEquals("predio.txt", service.load("predio.txt").getFilename());
        try (InputStream content = service.load("predio.txt").getInputStream()) {
            assertArrayEquals("contenido".getBytes(), content.readAllBytes());
        }
    }

    @Test
    void duplicateFilenameIsRejected() {
        FileServiceImpl service = new FileServiceImpl(tempDir.toString());
        service.init();
        var file = new MockMultipartFile("file", "duplicado.txt", "text/plain", new byte[]{1});
        service.save(file);

        RuntimeException error = assertThrows(RuntimeException.class, () -> service.save(file));
        assertEquals("A file of that name already exists.", error.getMessage());
    }

    @Test
    void pathTraversalIsRejected() {
        FileServiceImpl service = new FileServiceImpl(tempDir.toString());
        service.init();
        var file = new MockMultipartFile("file", "../fuera.txt", "text/plain", new byte[]{1});

        assertThrows(RuntimeException.class, () -> service.save(file));
        assertThrows(RuntimeException.class, () -> service.load("../fuera.txt"));
    }
}
