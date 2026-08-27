package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.model.Via;
import gob.pe.muniesperanza.apprentasmdeapi.service.ViaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
@RequestMapping("/api/via")
public class ViaController  extends AbstractRestController {
  @Autowired
  private ViaService viaService;

  @GetMapping
  public List<Via> listarVias() {
    return viaService.listarVias();
  }

  @PostMapping
  public Via insertarVia(@RequestBody Via via) {
    return viaService.insertarVias(via);
  }

  @GetMapping(path = {"/listarVia"})
  public ResponseEntity<ResponseVO> listarVia() throws Exception {

    ResponseVO result = null;
    List<Via> viaList = new ArrayList<Via>();
    try {

      viaList = viaService.listarVias();

    } catch (Exception e) {
   //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, viaList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping(value = "/insertarVias")
  public ResponseEntity<ResponseVO> insertarVias(
          @RequestBody  Via via) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
        ClsResultDAO clsResultDAO =viaService.insertarVia(via);
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

  @PutMapping(value = "/actualizarVias")
  public ResponseEntity<ResponseVO> actualizarVias(@RequestBody Via via) throws Exception {

    ResponseVO result = null;
    String mensaje = StringUtils.EMPTY;

    try {

      ClsResultDAO clsResultDAO =viaService.actualizarVia(via);

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




//  @PutMapping("/{codVia}")
//  public Via actualizarVia(@PathVariable Integer codVia, @RequestBody Via via) {
//    via.setCodVia(codVia);
//    return viaService.actualizarVia(via);
//  }
}
