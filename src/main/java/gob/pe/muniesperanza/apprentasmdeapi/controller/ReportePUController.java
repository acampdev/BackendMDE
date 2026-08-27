package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PisoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ReportePUBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.service.PisoService;
import gob.pe.muniesperanza.apprentasmdeapi.service.ReportePUService;
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
@RequestMapping("/api/pu")
@RequiredArgsConstructor
public class ReportePUController   extends AbstractRestController {

  @Autowired
  private ReportePUService reportePUService;


  @GetMapping
  public ResponseEntity<ResponseVO> listar(@RequestParam("codContribuyente")  Integer codContribuyente

  ) throws Exception {

    ResponseVO result = null;
    List<ReportePUBean> reportePUBeanList = new ArrayList<ReportePUBean>();
    try {

      reportePUBeanList = reportePUService.listar(codContribuyente);

    } catch (Exception e) {
      //   log.error(e.getMessage(), e);

      result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    result = buildResponse(Constantes.STATUS_SUCCESS, reportePUBeanList, null, null);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
