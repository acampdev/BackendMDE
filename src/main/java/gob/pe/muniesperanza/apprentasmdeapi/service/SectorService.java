package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CuadranteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TipoUnidadUrbanaBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;

import java.util.List;

public interface SectorService {

  List<Sector> listarSectorCodigoNombre(Integer codSector, String nombre);

  List<Sector> listarSector();

  Sector insertarSector(Sector sector);

  Sector actualizarSector(Sector sector);

  public List<CuadranteBean> listarCuadrante();

  public List<TipoUnidadUrbanaBean> listarTipoUnidadUrbana() ;

  }
