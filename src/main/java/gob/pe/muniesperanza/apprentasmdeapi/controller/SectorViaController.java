package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.model.SectorVia;
import gob.pe.muniesperanza.apprentasmdeapi.service.SectorViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sectorVia")
public class SectorViaController {

  @Autowired
  private SectorViaService sectorViaService;

  @GetMapping
  public List<SectorVia> llenarCombo() {
    return sectorViaService.llenarCombo();
  }
}
