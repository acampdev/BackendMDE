package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArancelService;
import gob.pe.muniesperanza.apprentasmdeapi.service.AsignacionPredioService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/asignacionpredio")
@RequiredArgsConstructor
public class AsignacionPredioController    extends AbstractRestController {
    @Autowired
    private AsignacionPredioService asignacionPredioService;
    @PostMapping
    public ResponseEntity<ResponseVO> insertarAsignacionPredio(@RequestBody AsignacionPredioBean asignacionPredioBean) throws Exception {
      ResponseVO result = null;
      String mensaje = "";
      try {
        ClsResultDAO clsResultDAO =asignacionPredioService.insertarAsignacionPredio(asignacionPredioBean);
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
  public ResponseEntity<ResponseVO> actualizarAsignacionPredio(@RequestBody AsignacionPredioBean asignacionPredioBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =asignacionPredioService.actualizarAsignacionPredio(asignacionPredioBean);
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
    public ResponseEntity<ResponseVO> listarAsignacionPredio(@RequestParam("anio") Integer anio,
                                                             @RequestParam("codContribuyente") Integer codContribuyente) throws Exception {

      ResponseVO result = null;
      List<AsignacionPredioBean> asignacionPredionBeanList = new ArrayList<AsignacionPredioBean>();
      try {

        asignacionPredionBeanList = asignacionPredioService.listarAsignacionPredio(anio,codContribuyente);

      } catch (Exception e) {
        //   log.error(e.getMessage(), e);

        result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
      }

      result = buildResponse(Constantes.STATUS_SUCCESS, asignacionPredionBeanList, null, null);

      return new ResponseEntity<>(result, HttpStatus.OK);
    }

  @PostMapping("/desasignar")
  public ResponseEntity<ResponseVO> desasignarAsignacionPredio(@RequestBody AsignacionPredioBean asignacionPredioBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =asignacionPredioService.desasignarAsignacionPredio(asignacionPredioBean);
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


  @GetMapping("/prevalidarBeneficioPensionista")
  public ResponseEntity<ResponseVO> prevalidarBeneficioPensionista(@RequestParam Integer codContribuyente) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =asignacionPredioService.prevalidarBeneficioPensionista(codContribuyente);
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

  @GetMapping("/prevalidarBeneficioAdultoMayor")
  public ResponseEntity<ResponseVO> prevalidarBeneficioAdultoMayor(@RequestParam Integer codContribuyente) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =asignacionPredioService.prevalidarBeneficioAdultoMayor(codContribuyente);
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
}
