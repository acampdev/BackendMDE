package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioLimpiezaPublicaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioSerenazgoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArbitrioLimpiezaPublicaService;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArbitrioSerenazgoService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/arbitrioLimpiezaPublica")
@RequiredArgsConstructor
public class ArbitrioLimpiezaPublicaController  extends AbstractRestController {
  @Autowired
  private ArbitrioLimpiezaPublicaService arbitrioLimpiezaPublicaService;
  @PostMapping
  public ResponseEntity<ResponseVO> insertarArbitrioLimpiezaPublica(@RequestBody ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =arbitrioLimpiezaPublicaService.insertarArbitrioLimpiezaPublica(arbitrioLimpiezaPublicaBean);
      BigDecimal codigoResp = new BigDecimal(String.valueOf(clsResultDAO.get(ClsResultDAO.CODIGO_RESPUESTA)));
      if (codigoResp.intValue() == 1) {
        // String codigoVia = (String) clsResultDAO.get("INSERTADO");
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Boolean.TRUE, mensaje, null, null);
      } else {
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Constantes.STATUS_ERROR, mensaje, Constantes.MESSAGE_ERROR, null);
      }

    } catch (Exception e) {
      // logger.error(e.getMessage(), e);
      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PutMapping
    public ResponseEntity<ResponseVO> actualizarArbitrioLimpiezaPublica(@RequestBody ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =arbitrioLimpiezaPublicaService.actualizarArbitrioLimpiezaPublica(arbitrioLimpiezaPublicaBean);
      BigDecimal codigoResp = new BigDecimal(String.valueOf(clsResultDAO.get(ClsResultDAO.CODIGO_RESPUESTA)));
      if (codigoResp.intValue() == 1) {
        // String codigoVia = (String) clsResultDAO.get("INSERTADO");
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Boolean.TRUE, mensaje, null, null);
      } else {
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Constantes.STATUS_ERROR, mensaje, Constantes.MESSAGE_ERROR, null);
      }

    } catch (Exception e) {
      // logger.error(e.getMessage(), e);
      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(result, HttpStatus.OK);
  }



  @GetMapping
  public ResponseEntity<ResponseVO> listarArbitrioLimpiezaPublica(@RequestParam("anio") Integer anio) throws Exception {

    ResponseVO result = null;
    List<ArbitrioLimpiezaPublicaBean> arbitrioLimpiezaPublicaBeanList = new ArrayList<ArbitrioLimpiezaPublicaBean>();
    try {

      arbitrioLimpiezaPublicaBeanList = arbitrioLimpiezaPublicaService.listarArbitrioLimpiezaPublica(anio);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, arbitrioLimpiezaPublicaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping("/insertarArbitrioLimpiezaPublicaOtros")
  public ResponseEntity<ResponseVO> insertarArbitrioLimpiezaPublicaOtros(@RequestBody ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =arbitrioLimpiezaPublicaService.insertarArbitrioLimpiezaPublicaOtros(arbitrioLimpiezaPublicaBean);
      BigDecimal codigoResp = new BigDecimal(String.valueOf(clsResultDAO.get(ClsResultDAO.CODIGO_RESPUESTA)));
      if (codigoResp.intValue() == 1) {
        // String codigoVia = (String) clsResultDAO.get("INSERTADO");
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Boolean.TRUE, mensaje, null, null);
      } else {
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Constantes.STATUS_ERROR, mensaje, Constantes.MESSAGE_ERROR, null);
      }

    } catch (Exception e) {
      // logger.error(e.getMessage(), e);
      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PutMapping("/actualizarArbitrioLimpiezaPublicaOtros")
  public ResponseEntity<ResponseVO> actualizarArbitrioLimpiezaPublicaOtros(@RequestBody ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =arbitrioLimpiezaPublicaService.actualizarArbitrioLimpiezaPublicaOtros(arbitrioLimpiezaPublicaBean);
      BigDecimal codigoResp = new BigDecimal(String.valueOf(clsResultDAO.get(ClsResultDAO.CODIGO_RESPUESTA)));
      if (codigoResp.intValue() == 1) {
        // String codigoVia = (String) clsResultDAO.get("INSERTADO");
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Boolean.TRUE, mensaje, null, null);
      } else {
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Constantes.STATUS_ERROR, mensaje, Constantes.MESSAGE_ERROR, null);
      }

    } catch (Exception e) {
      // logger.error(e.getMessage(), e);
      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(result, HttpStatus.OK);
  }



  @GetMapping("/listarArbitrioLimpiezaPublicaOtros")
  public ResponseEntity<ResponseVO> listarArbitrioLimpiezaPublicaOtros(@RequestParam("anio") Integer anio) throws Exception {

    ResponseVO result = null;
    List<ArbitrioLimpiezaPublicaBean> arbitrioLimpiezaPublicaBeanList = new ArrayList<ArbitrioLimpiezaPublicaBean>();
    try {

      arbitrioLimpiezaPublicaBeanList = arbitrioLimpiezaPublicaService.listarArbitrioLimpiezaPublicaOtros(anio);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, arbitrioLimpiezaPublicaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}

