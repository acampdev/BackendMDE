package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.bean.VencimientoBean;
import gob.pe.muniesperanza.apprentasmdeapi.service.VencimientoService;
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
@RequestMapping("/api/vencimiento")
@RequiredArgsConstructor
public class VencimientoController  extends AbstractRestController {
    @Autowired
    private VencimientoService vencimientoService;
    @PostMapping
    public ResponseEntity<ResponseVO> generar(@RequestBody VencimientoBean vencimientoBean) throws Exception {
      ResponseVO result = null;
      String mensaje = "";
      try {
        ClsResultDAO clsResultDAO =vencimientoService.generar(vencimientoBean);
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
  public ResponseEntity<ResponseVO> listar(@RequestParam("anio")  Integer anio) throws Exception {

    ResponseVO result = null;
    List<VencimientoBean> vencimientoBeanList = new ArrayList<VencimientoBean>();
    try {

      vencimientoBeanList = vencimientoService.listar(anio);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, vencimientoBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }



}
