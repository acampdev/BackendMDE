package gob.pe.muniesperanza.apprentasmdeapi.controller;


import gob.pe.muniesperanza.apprentasmdeapi.bean.ContribuyenteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ContribuyenteService;
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
@RequestMapping("/api/contribuyente")
public class ContribuyenteController  extends AbstractRestController {

  private final ContribuyenteService contribuyenteService;

  @Autowired
  public ContribuyenteController(ContribuyenteService contribuyenteService) {
    this.contribuyenteService = contribuyenteService;
  }


  @PostMapping
  public ResponseEntity<ResponseVO> insertarContribuyente(@RequestBody ContribuyenteBean contribuyenteBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = contribuyenteService.insertarContribuyente(contribuyenteBean);
      BigDecimal codigoResp = new BigDecimal(String.valueOf(clsResultDAO.get(ClsResultDAO.CODIGO_RESPUESTA)));
      if (codigoResp.intValue() == 1) {
        // String codigoContribuyente = (String) clsResultDAO.get("INSERTADO");
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
  public ResponseEntity<ResponseVO> actualizarContribuyente(@RequestBody ContribuyenteBean contribuyenteBean) throws Exception {

    ResponseVO result = null;
    String mensaje = StringUtils.EMPTY;

    try {

      ClsResultDAO clsResultDAO =contribuyenteService.actualizarContribuyente(contribuyenteBean);

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


  @PostMapping("/asignarConyugeRepresentante")
  public ResponseEntity<ResponseVO> asignarConyugeRepresentante(@RequestBody ContribuyenteBean contribuyenteBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = contribuyenteService.asignarConyugeRepresentante(contribuyenteBean);
      BigDecimal codigoResp = new BigDecimal(String.valueOf(clsResultDAO.get(ClsResultDAO.CODIGO_RESPUESTA)));
      if (codigoResp.intValue() == 1) {
        // String codigoContribuyente = (String) clsResultDAO.get("INSERTADO");
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

  @PostMapping("/quitarConyugeRepresentante")
  public ResponseEntity<ResponseVO> quitarConyugeRepresentante(@RequestBody ContribuyenteBean contribuyenteBean) throws Exception {

    ResponseVO result = null;
    String mensaje = StringUtils.EMPTY;

    try {

      ClsResultDAO clsResultDAO =contribuyenteService.quitarConyugeRepresentante(contribuyenteBean);

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
  public ResponseEntity<ResponseVO> listarContribuyente(@RequestParam("codigoContribuyente") String codigoContribuyente)
                                                //        @RequestParam("codigoPersona") String codigoPersona)
                                                        throws      Exception {

    ResponseVO result = null;
    List<ContribuyenteBean> contribuyenteBeanList = new ArrayList<ContribuyenteBean>();

    Integer codContribuyente = 0;
    Integer codPersona =0;
    try {
      if(codigoContribuyente!=null && codigoContribuyente.trim().length()>0)
        codContribuyente = Integer.parseInt(codigoContribuyente);
     // if(codigoPersona!=null && codigoPersona.trim().length()>0)
     //   codPersona = Integer.parseInt(codigoPersona);


      contribuyenteBeanList = contribuyenteService.listarContribuyente(codContribuyente,codPersona);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, contribuyenteBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/general")
  public ResponseEntity<ResponseVO> listarGeneral(@RequestParam("parametroBusqueda") String parametroBusqueda,
                                                  @RequestParam("codigoContribuyente") String codigoContribuyente,
                                                  @RequestParam("codTipoContribuyente") String codTipoContribuyente,
                                                  @RequestParam("esExonerado") String esExonerado,
                                                  @RequestParam("esPensionista") String esPensionista) throws Exception {

    ResponseVO result = null;
    List<ContribuyenteBean> contribuyenteBeanList = new ArrayList<ContribuyenteBean>();
    try {
      String codTipoContribuyenteTemp=null;
      Integer codigoContribuyenteTemp=null;
      Boolean esExoneradoTemp =null;
      Boolean esPensionistaTemp =null;
      if(codTipoContribuyente!=null && !codTipoContribuyente.isEmpty()){
        codTipoContribuyenteTemp = codTipoContribuyente;
      }
      if(codigoContribuyente!=null && !codigoContribuyente.isEmpty())
        codigoContribuyenteTemp =  Integer.parseInt(codigoContribuyente);
      if(esExonerado!=null && !esExonerado.isEmpty()) {
         Integer temp = Integer.parseInt(esExonerado);
         if(temp==1){
           esExoneradoTemp = Boolean.TRUE;
         }else{
           esExoneradoTemp = Boolean.FALSE;
         }
      }
      if(esPensionista!=null && !esPensionista.isEmpty()) {
        Integer temp = Integer.parseInt(esPensionista);
        if(temp==1){
          esPensionistaTemp = Boolean.TRUE;
        }else{
          esPensionistaTemp = Boolean.FALSE;
        }
      }

      contribuyenteBeanList = contribuyenteService.listarGeneral(parametroBusqueda,codigoContribuyenteTemp,codTipoContribuyenteTemp,esExoneradoTemp,
              esPensionistaTemp);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, contribuyenteBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }







}
