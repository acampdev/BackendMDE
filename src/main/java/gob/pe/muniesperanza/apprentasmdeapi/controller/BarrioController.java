package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.model.Barrio;
import gob.pe.muniesperanza.apprentasmdeapi.service.BarrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barrio")
public class BarrioController   extends AbstractRestController {

  private final BarrioService barrioService;

  @Autowired
  public BarrioController(BarrioService barrioService) {
    this.barrioService = barrioService;
  }

  @GetMapping
  public List<Barrio> listarBarrio() {
    return barrioService.listarBarrio();
  }

  @PostMapping
  public Barrio insertarBarrio(@RequestBody Barrio barrio) {
    return barrioService.insertarBarrio(barrio);
  }

  @PutMapping
  public Barrio actualizarBarrio(@RequestBody Barrio barrio) {
   // barrio.setCodBarrio(codBarrio);
    return barrioService.actualizarBarrio(barrio);
  }
}
