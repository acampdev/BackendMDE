package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArancelService;
import gob.pe.muniesperanza.apprentasmdeapi.service.PredioService;
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
@RequestMapping("/api/predio")
@RequiredArgsConstructor
public class PredioController extends AbstractRestController {
  @Autowired
  private PredioService predioService;

  @PostMapping
  public ResponseEntity<ResponseVO> insertarPredio(@RequestBody PredioBean predioBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = predioService.insertarPredio(predioBean);
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
  public ResponseEntity<ResponseVO> actualizarPredio(@RequestBody PredioBean predioBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = predioService.actualizarPredio(predioBean);
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
  public ResponseEntity<ResponseVO> listarPredio(@RequestParam("anio") String anio,
                                                 @RequestParam("codPredioBase") String codPredioBase,
                                                 @RequestParam("parametroBusqueda") String parametroBusqueda) throws Exception {

    ResponseVO result = null;
    List<PredioBean> predioBeanList = new ArrayList<PredioBean>();
    try {
           Integer anioTmp=null;
           String codPredioBaseTmp=null;
           String parametroBusquedaTmp=null;
           if(codPredioBase !=null && !codPredioBase.isEmpty())
             codPredioBaseTmp=codPredioBase;

           if(parametroBusqueda !=null && !parametroBusqueda.isEmpty())
             parametroBusquedaTmp=parametroBusqueda;

           if(anio !=null && !anio.isEmpty())
             anioTmp=Integer.parseInt(anio);

      predioBeanList = predioService.listarPredio(anioTmp,codPredioBaseTmp,parametroBusquedaTmp);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, predioBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }


  @GetMapping("/all")
  public ResponseEntity<ResponseVO> listarPredioAll(@RequestParam("codPredioBase") String  codPredioBase,
          @RequestParam("anio") String anio) throws Exception {

    ResponseVO result = null;
    List<PredioBean> predioBeanList = new ArrayList<PredioBean>();
    try {
      String codPredioBaseTmp=null;
      Integer anioTmp=null;
      if(anio !=null && !anio.isEmpty())
        anioTmp=Integer.parseInt(anio);

      if(codPredioBase !=null && !codPredioBase.isEmpty())
        codPredioBaseTmp=codPredioBase;

      predioBeanList = predioService.listarPredioAll( codPredioBaseTmp,anioTmp);
    } catch (Exception e) {
      //   log.error(e.getMessage(), e);
      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, predioBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/usos")
  public ResponseEntity<ResponseVO> listarUsos() throws Exception {
    ResponseVO result = null;
    List<PredioBean> predioBeanList = new ArrayList<>();
    try {
      predioBeanList = predioService.listarUsos();
    } catch (Exception e) {
      //   log.error(e.getMessage(), e);
      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, predioBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}

