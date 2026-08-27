package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TurnoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.UitEpaBean;
import gob.pe.muniesperanza.apprentasmdeapi.service.TurnoService;
import gob.pe.muniesperanza.apprentasmdeapi.service.UitEpaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/turno")
@RequiredArgsConstructor
public class TurnoController extends AbstractRestController {

  @Autowired
  private TurnoService turnoService;

  @GetMapping
  public ResponseEntity<ResponseVO> listar() throws Exception {



    ResponseVO result = null;
    List<TurnoBean> turnoBeanList = new ArrayList<TurnoBean>();
    try {

      turnoBeanList = turnoService.listar();

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, turnoBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }


}
