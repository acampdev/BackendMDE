package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CuadranteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TipoUnidadUrbanaBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SectorIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.SectorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {
  private final SectorIDAO sectorIDAO;

  public SectorServiceImpl(SectorIDAO sectorIDAO) {
    this.sectorIDAO = sectorIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Sector> listarSectorCodigoNombre(Integer codSector, String nombre)
  {
    return sectorIDAO.listarSectorCodigoNombre(codSector, nombre);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Sector> listarSector() {
    return sectorIDAO.listarSector();
  }

  @Transactional(readOnly = false)
  @Override
  public Sector insertarSector(Sector sector) {
    return sectorIDAO.insertarSector(sector);
  }

  @Transactional
  @Override
  public Sector actualizarSector(Sector sector) {
    return sectorIDAO.actualizarSector(sector);
  }

  @Transactional(readOnly = true)
  @Override
  public List<CuadranteBean> listarCuadrante() {
    return sectorIDAO.listarCuadrante();
  }

  @Transactional(readOnly = true)
  @Override
  public List<TipoUnidadUrbanaBean> listarTipoUnidadUrbana()  {
    return sectorIDAO.listarTipoUnidadUrbana();
  }

}
