package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PersonaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.PersonaService;
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
@RequestMapping("/api/persona")
public class PersonaController   extends AbstractRestController {

  private final PersonaService personaService;

  @Autowired
  public PersonaController(PersonaService personaService) {
    this.personaService = personaService;
  }



  @PostMapping
  public ResponseEntity<ResponseVO> insertarPersona( @RequestBody PersonaBean personaBean) throws Exception {
    ResponseVO result = null;
    String mensaje = "";
    try {
      ClsResultDAO clsResultDAO = personaService.insertarPersona(personaBean);
      BigDecimal codigoResp = new BigDecimal(String.valueOf(clsResultDAO.get(ClsResultDAO.CODIGO_RESPUESTA)));
      if (codigoResp.intValue() == 1) {
        String codigoPersona = (String) clsResultDAO.get("INSERTADO");
        mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
        result = buildResponse(Boolean.TRUE, codigoPersona, mensaje, null);
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
  public ResponseEntity<ResponseVO> actualizarPersona(@RequestBody PersonaBean personaBean) throws Exception {

    ResponseVO result = null;
    String mensaje = StringUtils.EMPTY;

    try {

      ClsResultDAO clsResultDAO =personaService.actualizarPersona(personaBean);

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


  @GetMapping("/listarPersona")
  public ResponseEntity<ResponseVO> listarPersona(@RequestParam("codTipoDocumento") String codTipoDocumento,
                                                                           @RequestParam("numeroDocumento") String numeroDocumento) throws Exception {

    ResponseVO result = null;
    List<PersonaBean> personaBeanList = new ArrayList<PersonaBean>();
    try {

      personaBeanList = personaService.listarPersona( codTipoDocumento, numeroDocumento);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, personaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/listarPersonaPorTipPerTipDoc")
  public ResponseEntity<ResponseVO> listarPersonaPorTipPerTipDoc(@RequestParam("codTipoPersona") String codTipoPersona,
                                                                                   @RequestParam("codTipoDocumento") String codTipoDocumento,
                                                                                   @RequestParam("parametroBusqueda") String parametroBusqueda) throws Exception {

    ResponseVO result = null;
    List<PersonaBean> personaBeanList = new ArrayList<PersonaBean>();
    try {

      personaBeanList = personaService.listarPersonaPorTipPerTipDoc(codTipoPersona,
              codTipoDocumento, parametroBusqueda);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, personaBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
 }





}

