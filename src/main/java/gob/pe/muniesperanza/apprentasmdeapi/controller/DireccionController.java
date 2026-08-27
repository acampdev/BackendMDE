package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.DireccionBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArancelService;
import gob.pe.muniesperanza.apprentasmdeapi.service.BarrioService;
import gob.pe.muniesperanza.apprentasmdeapi.service.DireccionService;
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
@RequestMapping("/api/direccion")
//@RequiredArgsConstructor
public class DireccionController   extends AbstractRestController {

  private DireccionService direccionService;

  @Autowired
  public DireccionController(DireccionService direccionService) {
    this.direccionService = direccionService;
  }

  @PostMapping
  public ResponseEntity<ResponseVO> insertar(@RequestBody DireccionBean direccionBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO =direccionService.insertar(direccionBean);
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
  public ResponseEntity<ResponseVO> actualizar(@RequestBody DireccionBean direccionBean) throws Exception {

    ResponseVO result = null;
    String mensaje = StringUtils.EMPTY;

    try {

      ClsResultDAO clsResultDAO =direccionService.actualizar(direccionBean);

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
      //log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, null, mensaje, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<ResponseVO> listarDireccionPorNombreVia(@RequestParam("parametrosBusqueda") String parametrosBusqueda,
                                                  @RequestParam("codUsuario") Integer codUsuario) throws Exception {

    ResponseVO result = null;
    List<DireccionBean> direccionBeanList = new ArrayList<DireccionBean>();
    try {

      direccionBeanList = direccionService.listar(parametrosBusqueda,codUsuario);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, direccionBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}

