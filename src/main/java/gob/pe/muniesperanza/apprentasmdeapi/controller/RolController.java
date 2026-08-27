package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.RolBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;
import gob.pe.muniesperanza.apprentasmdeapi.service.RolService;
import gob.pe.muniesperanza.apprentasmdeapi.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController  extends AbstractRestController {

  private final RolService rolService;
  @Autowired
  public RolController(RolService rolService) {
    this.rolService = rolService;
  }

  @GetMapping
  public List<RolBean> listar() {
    return rolService.listar();
  }
}
