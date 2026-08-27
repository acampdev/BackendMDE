package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioParquesJardinesBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArbitrioParquesJardinesService;
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
@RequestMapping("/api/arbitrioParquesJardines")
@RequiredArgsConstructor
public class ArbitrioParquesJardinesController     extends AbstractRestController {
  @Autowired
  private ArbitrioParquesJardinesService arbitrioParquesJardinesService;
  @PostMapping
  public ResponseEntity<ResponseVO> insertarArbitrioParquesJardines(@RequestBody ArbitrioParquesJardinesBean arbitrioParquesJardinesBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =arbitrioParquesJardinesService.insertarArbitrioParquesJardines(arbitrioParquesJardinesBean);
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
  public ResponseEntity<ResponseVO> actualizarArbitrioParquesJardines(@RequestBody ArbitrioParquesJardinesBean arbitrioParquesJardinesBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =arbitrioParquesJardinesService.actualizarArbitrioParquesJardines(arbitrioParquesJardinesBean);
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
  public ResponseEntity<ResponseVO> listarArbitrioParquesJardines(@RequestParam("anio") Integer anio) throws Exception {

    ResponseVO result = null;
    List<ArbitrioParquesJardinesBean> arbitrioParquesJardinesBeanList = new ArrayList<ArbitrioParquesJardinesBean>();
    try {

      arbitrioParquesJardinesBeanList = arbitrioParquesJardinesService.listarArbitrioParquesJardines(anio);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, arbitrioParquesJardinesBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
