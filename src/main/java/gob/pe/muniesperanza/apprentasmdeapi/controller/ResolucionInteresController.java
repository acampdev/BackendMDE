package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ResolucionInteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.service.ResolucionInteresService;
import gob.pe.muniesperanza.apprentasmdeapi.service.ValoresUnitariosService;
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
@RequestMapping("/api/resolucionInteres")
@RequiredArgsConstructor
public class ResolucionInteresController extends AbstractRestController {
  @Autowired
  private ResolucionInteresService resolucionInteresService;
  @PostMapping
  public ResponseEntity<ResponseVO> insertar(@RequestBody ResolucionInteresBean resolucionInteresBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =resolucionInteresService.insertar(resolucionInteresBean);
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
    public ResponseEntity<ResponseVO> actualizar(@RequestBody ResolucionInteresBean resolucionInteresBean) throws Exception {
      ResponseVO result = null;
      String mensaje = "";
      try {
        ClsResultDAO clsResultDAO = resolucionInteresService.actualizar(resolucionInteresBean);
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



  @PutMapping("/eliminar")
  public ResponseEntity<ResponseVO> eliminar(@RequestBody ResolucionInteresBean resolucionInteresBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = resolucionInteresService.eliminar(resolucionInteresBean);
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
  public ResponseEntity<ResponseVO> listar(@RequestParam("codResolucionInteres")  Integer codResolucionInteres) throws Exception {

    ResponseVO result = null;
    List<ResolucionInteresBean> resolucionInteresBeanList = new ArrayList<ResolucionInteresBean>();
    try {

      resolucionInteresBeanList = resolucionInteresService.listar(codResolucionInteres);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, resolucionInteresBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }


}
