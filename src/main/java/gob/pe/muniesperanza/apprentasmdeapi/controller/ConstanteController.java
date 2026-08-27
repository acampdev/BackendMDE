package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.*;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArancelService;
import gob.pe.muniesperanza.apprentasmdeapi.service.ConstanteService;
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
@RequestMapping("/api/constante")
@RequiredArgsConstructor
public class ConstanteController   extends AbstractRestController {
  @Autowired
  private ConstanteService constanteService;


  @GetMapping("/listarConstantePadre")
  public ResponseEntity<ResponseVO> listarConstantePadre(@RequestParam("codConstante") String codConstante) throws Exception {

    ResponseVO result = null;
    List<ConstanteBean> constanteBeanList = new ArrayList<ConstanteBean>();
    try {

      constanteBeanList = constanteService.listarConstantePadre(codConstante);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, constanteBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/listarConstanteHijo")
  public ResponseEntity<ResponseVO> listarConstanteHijo(@RequestParam("codConstante") String codConstante) throws Exception {

    ResponseVO result = null;
    List<ConstanteBean> constanteBeanList = new ArrayList<ConstanteBean>();
    try {

      constanteBeanList = constanteService.listarConstanteHijo(codConstante);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, constanteBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
  @GetMapping("/listarGrupoUso")
  public List<GrupoUsoBean> listarGrupoUso(){
    return constanteService.listarGrupoUso();}

  @GetMapping("/listarRuta")
  public List<RutaBean> listarRuta(){
    return constanteService.listarRuta();
  }
  @GetMapping("/listarUbicacionAreaVerde")
  public List<UbicacionAreaVerde> listarUbicacionAreaVerde() {
    return constanteService.listarUbicacionAreaVerde();}

  @GetMapping("/listarUsoPredio")
  public List<UsoPredio> listarUsoPredio() {
    return constanteService.listarUsoPredio();}

  @GetMapping("/listarZona")
  public List<ZonaBean> listarZona() {
    return constanteService.listarZona();}


}
