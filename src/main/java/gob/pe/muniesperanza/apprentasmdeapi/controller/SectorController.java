package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CuadranteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TipoUnidadUrbanaBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;
import gob.pe.muniesperanza.apprentasmdeapi.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sector")
public class SectorController extends AbstractRestController {

  private final SectorService sectorService;
  @Autowired
  public SectorController(SectorService sectorService) {
    this.sectorService = sectorService;
  }

  @GetMapping("/listarSectorCodigoNombre")
  public List<Sector> listarSectorCodigoNombre(@RequestParam("codSector") Integer codSector, @RequestParam("nombreSector") String nombreSector) {
    return sectorService.listarSectorCodigoNombre(codSector, nombreSector);
  }


  @GetMapping
  public List<Sector> listarSector() {
    return sectorService.listarSector();
  }

  @PostMapping
  public Sector insertarSector(@RequestBody Sector sector) {
    return sectorService.insertarSector(sector);
  }

  @PutMapping
  public Sector actualizarSector(@RequestBody Sector sector) {
    return sectorService.actualizarSector(sector);
  }


  @GetMapping("/listarCuadrante")
  public List<CuadranteBean> listarCuadrante() {
    return sectorService.listarCuadrante();
  }

  @GetMapping("/listarTipoUnidadUrbana")
  public List<TipoUnidadUrbanaBean> listarTipoUnidadUrbana()   {
    return sectorService.listarTipoUnidadUrbana();
  }

  }
