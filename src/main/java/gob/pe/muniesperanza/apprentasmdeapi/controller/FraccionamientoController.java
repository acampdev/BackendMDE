package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.*;
import gob.pe.muniesperanza.apprentasmdeapi.service.BarrioService;
import gob.pe.muniesperanza.apprentasmdeapi.service.FraccionamientoService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/fraccionamiento")
public class FraccionamientoController  extends AbstractRestController {

  private final FraccionamientoService fraccionamientoService;

  @Autowired
  public FraccionamientoController(FraccionamientoService fraccionamientoService) {
    this.fraccionamientoService = fraccionamientoService;
  }

  @PostMapping
  public ResponseEntity<ResponseVO> insertarFraccionamiento(
          @RequestBody FraccionamientoBean fraccionamientoBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
     // fraccionamientoBeanList =
       //       fraccionamientoService.insertarFraccionamiento(fraccionamientoBean);
      ClsResultDAO clsResultDAO = fraccionamientoService.insertarFraccionamiento(fraccionamientoBean);
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
  public ResponseEntity<ResponseVO> listar(@RequestParam("codContribuyente")  Integer codContribuyente
  ) throws Exception {

    ResponseVO result = null;
    List<FraccionamientoBean> fraccionamientoBeanList = new ArrayList<FraccionamientoBean>();
    try {

      fraccionamientoBeanList = fraccionamientoService.listarFraccionamiento(codContribuyente);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, fraccionamientoBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/listarCronograma")
  public ResponseEntity<ResponseVO> listarCronograma(@RequestParam("anio")  Integer anio,
                                                     @RequestParam("codResolucion")  Integer codResolucion  ) throws Exception {

    ResponseVO result = null;
    List<CronogramaBean> cronogramaBeanList = new ArrayList<CronogramaBean>();
    try {

      cronogramaBeanList = fraccionamientoService.listarCronograma(anio,codResolucion);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, cronogramaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/listarCronogramaContri")
  public ResponseEntity<ResponseVO> listarCronogramaContri( @RequestParam("codContribuyente")  Integer codContribuyente  ) throws Exception {

    ResponseVO result = null;
    List<CronogramaBean> cronogramaBeanList = new ArrayList<CronogramaBean>();
    try {

      cronogramaBeanList = fraccionamientoService.listarCronogramaContri(codContribuyente);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, cronogramaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
