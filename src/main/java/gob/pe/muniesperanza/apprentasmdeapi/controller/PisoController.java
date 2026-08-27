package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PisoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.AsignacionPredioService;
import gob.pe.muniesperanza.apprentasmdeapi.service.PisoService;
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
@RequestMapping("/api/piso")
@RequiredArgsConstructor
public class PisoController     extends AbstractRestController {
  @Autowired
  private PisoService pisoService;
  @PostMapping
  public ResponseEntity<ResponseVO> insertarPiso(@RequestBody PisoBean pisoBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = pisoService.insertarPiso(pisoBean);
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
  public ResponseEntity<ResponseVO> actualizarPiso(@RequestBody PisoBean pisoBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = pisoService.actualizarPiso(pisoBean);
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
  public ResponseEntity<ResponseVO> eliminarPiso(@RequestBody PisoBean pisoBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = pisoService.eliminarPiso(pisoBean);
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
  public ResponseEntity<ResponseVO> listarPiso(@RequestParam("anio")  Integer anio,
                                            //   @RequestParam("codPiso")  String codPiso,
                                               @RequestParam("codPredioBase")  String codPredioBase
                                              // @RequestParam("numeroPiso")  String numeroPiso
                                                ) throws Exception {

    ResponseVO result = null;
    List<PisoBean> pisoBeanList = new ArrayList<PisoBean>();
    try {
      Integer codPisoTmp = null;  Integer numeroPisoTmp = null;
     // if(codPiso!=null && codPiso.trim().length()>0)
      //  codPisoTmp = Integer.parseInt(codPiso);

     // if(numeroPiso!=null && numeroPiso.trim().length()>0)
      //  numeroPisoTmp = Integer.parseInt(numeroPiso);


      pisoBeanList = pisoService.listarPiso(anio, codPredioBase);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, pisoBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }


  @GetMapping("/all")
  public ResponseEntity<ResponseVO> listarPisoAll(@RequestParam("codPredioBase") String  codPredioBase,
                                                    @RequestParam("anio") String anio,
   @RequestParam("numeroPiso") String  numeroPiso) throws Exception {

    ResponseVO result = null;
    List<PisoBean> pisoBeanList = new ArrayList<PisoBean>();
    try {
      String codPredioBaseTmp=null;
      Integer anioTmp=null;
      Integer numeroPisoTmp=null;
      if(anio !=null && !anio.isEmpty())
        anioTmp=Integer.parseInt(anio);

      if(codPredioBase !=null && !codPredioBase.isEmpty())
        codPredioBaseTmp=codPredioBase;

      if(numeroPiso !=null && !numeroPiso.isEmpty()){
        numeroPisoTmp=Integer.parseInt(numeroPiso);
      }
      pisoBeanList = pisoService.listarPisoAll( codPredioBaseTmp,anioTmp,numeroPisoTmp);
    } catch (Exception e) {
      //   log.error(e.getMessage(), e);
      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, pisoBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}

