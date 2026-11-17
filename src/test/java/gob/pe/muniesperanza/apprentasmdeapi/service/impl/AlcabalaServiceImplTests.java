package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AlcabalaBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AlcabalaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import gob.pe.muniesperanza.apprentasmdeapi.exception.ApiException;

@ExtendWith(MockitoExtension.class)
class AlcabalaServiceImplTests {

    @Mock AlcabalaIDAO dao;

    @Test
    void insertReturnsStoredProcedureResult() throws Exception {
        AlcabalaBean input = AlcabalaBean.builder().anio(2026).tasa(3.0).build();
        ClsResultDAO result = new ClsResultDAO();
        result.put(ClsResultDAO.CODIGO_RESPUESTA, 1);
        when(dao.insertar(input)).thenReturn(result);

        assertSame(result, new AlcabalaServiceImpl(dao).insertar(input));
    }

    @Test
    void storedProcedureErrorIsPreserved() throws Exception {
        AlcabalaBean input = new AlcabalaBean();
        ClsResultDAO result = new ClsResultDAO();
        result.put(ClsResultDAO.CODIGO_RESPUESTA, ClsResultDAO.ERROR_THROW);
        result.put(ClsResultDAO.MENSAJE_RESPUESTA, "año duplicado");
        when(dao.insertar(input)).thenReturn(result);

        ClsResultDAO actual = new AlcabalaServiceImpl(dao).insertar(input);

        assertEquals(ClsResultDAO.ERROR_THROW, actual.get(ClsResultDAO.CODIGO_RESPUESTA));
        assertEquals("año duplicado", actual.get(ClsResultDAO.MENSAJE_RESPUESTA));
    }

    @Test
    void databaseExceptionPropagatesForRollback() throws Exception {
        when(dao.insertar(any())).thenThrow(new Exception("procedure unavailable"));

        ApiException error = assertThrows(ApiException.class,
                () -> new AlcabalaServiceImpl(dao).insertar(new AlcabalaBean()));
        assertEquals("ALCABALA_INSERT_FAILED", error.getCode());
        assertEquals("procedure unavailable", error.getCause().getMessage());
    }

    @Test
    void listDelegatesYearAndWriteMethodRollsBackOnException() throws Exception {
        var expected = List.of(AlcabalaBean.builder().anio(2026).build());
        when(dao.listar(2026)).thenReturn(expected);
        AlcabalaServiceImpl service = new AlcabalaServiceImpl(dao);

        assertSame(expected, service.listar(2026));
        Method insert = AlcabalaServiceImpl.class.getMethod("insertar", AlcabalaBean.class);
        Transactional transaction = insert.getAnnotation(Transactional.class);
        assertArrayEquals(new Class<?>[]{Exception.class}, transaction.rollbackFor());
    }
}
