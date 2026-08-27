package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioParquesJardinesBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.EstadoCuentaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArbitrioLimpiezaPublicaService;
import gob.pe.muniesperanza.apprentasmdeapi.service.EstadoCuentaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estadoCuenta")
@RequiredArgsConstructor
public class EstadoCuentaController   extends AbstractRestController {
  @Autowired
  private EstadoCuentaService estadoCuentaService;



  @GetMapping("/listar")
  public ResponseEntity<ResponseVO> listar(@RequestParam("codContribuyente") Integer codContribuyente,
                                           @RequestParam("anio") String anio,
                                           @RequestParam("codPredio") String codPredio) throws Exception {

    ResponseVO result = null;
    Integer anioTemp=null;
    List<EstadoCuentaBean> estadoCuentaBeanList = new ArrayList<EstadoCuentaBean>();
    try {

      if(anio==null || anio.isEmpty()) {
        anioTemp = null;
      } else{
        anioTemp = Integer.parseInt(anio);
      }

      if(codPredio==null || codPredio.isEmpty())
        estadoCuentaBeanList = estadoCuentaService.listar(codContribuyente, anioTemp,  null);
      else
        estadoCuentaBeanList = estadoCuentaService.listar(codContribuyente, anioTemp,  codPredio);



    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, estadoCuentaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/listarDetalle")
  public ResponseEntity<ResponseVO> listarDetalle(@RequestParam("codContribuyente") Integer codContribuyente,
                                                       @RequestParam("anio") Integer anio,
                                                  @RequestParam("codPredio")  String codPredio) throws Exception {

    ResponseVO result = null;
    List<EstadoCuentaBean> estadoCuentaBeanList = new ArrayList<EstadoCuentaBean>();
    try {
      if(codPredio==null || codPredio.isEmpty())
      estadoCuentaBeanList = estadoCuentaService.listarDetalle(codContribuyente, anio,  null);
      else
        estadoCuentaBeanList = estadoCuentaService.listarDetalle(codContribuyente, anio,  codPredio);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, estadoCuentaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
