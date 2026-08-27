package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AuditoriaBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Barrio;
import gob.pe.muniesperanza.apprentasmdeapi.service.AuditoriaService;
import gob.pe.muniesperanza.apprentasmdeapi.service.BarrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaController extends AbstractRestController {

  private final AuditoriaService auditoriaService;

  @Autowired
  public AuditoriaController(AuditoriaService auditoriaService) {
    this.auditoriaService = auditoriaService;
  }

  @GetMapping
  public List<AuditoriaBean> listar()  throws Exception {
    return auditoriaService.listar();
  }
}
