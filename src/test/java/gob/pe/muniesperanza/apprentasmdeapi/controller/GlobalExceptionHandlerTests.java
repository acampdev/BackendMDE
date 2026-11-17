package gob.pe.muniesperanza.apprentasmdeapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTests {

    @Test
    void oversizedUploadReturnsPayloadTooLarge() {
        var response = new GlobalExceptionHandler()
                .handleMaxSizeException(new MaxUploadSizeExceededException(2_000_000),
                        new MockHttpServletRequest("POST", "/api/upload"));

        assertEquals(HttpStatus.PAYLOAD_TOO_LARGE, response.getStatusCode());
        assertEquals("El tamaño del archivo excede el límite permitido", response.getBody().getDetail());
        assertEquals("UPLOAD_TOO_LARGE", response.getBody().getProperties().get("code"));
    }
}
