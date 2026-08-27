package gob.pe.muniesperanza.apprentasmdeapi.controller;


import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.bean.UitEpaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.service.UitEpaService;
import gob.pe.muniesperanza.apprentasmdeapi.service.ValoresUnitariosService;
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
@RequestMapping("/api/uitEpa")
@RequiredArgsConstructor
public class UitEpaController extends AbstractRestController {
    @Autowired
    private UitEpaService uitEpaService;
    @PostMapping
    public ResponseEntity<ResponseVO> insertarUitEpa(@RequestBody UitEpaBean uitEpaBean) throws Exception {
      ResponseVO result = null;
      String mensaje = "";
      try {
        ClsResultDAO clsResultDAO = uitEpaService.insertarUitEpa(uitEpaBean);
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
    public ResponseEntity<ResponseVO> actualizarUitEpa(@RequestBody UitEpaBean uitEpaBean) throws Exception {

      ResponseVO result = null;
      String mensaje = StringUtils.EMPTY;

      try {

        ClsResultDAO clsResultDAO = uitEpaService.actualizarUitEpa(uitEpaBean);

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
  public ResponseEntity<ResponseVO> listarUitEpa(@RequestParam("anio")  Integer anio) throws Exception {

    ResponseVO result = null;
    List<UitEpaBean> uitEpaBeanList = new ArrayList<UitEpaBean>();
    try {

      uitEpaBeanList = uitEpaService.listarUitEpa(anio);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, uitEpaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }



}
