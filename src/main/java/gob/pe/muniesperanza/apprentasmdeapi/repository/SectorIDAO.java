package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CuadranteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TipoUnidadUrbanaBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;

import java.util.List;

public interface SectorIDAO {

  public List<Sector> listarSectorCodigoNombre(Integer codSector, String nombre);

  List<Sector> listarSector();

  Sector insertarSector(Sector sector);

  Sector actualizarSector(Sector sector);

  public List<CuadranteBean> listarCuadrante();

  public List<TipoUnidadUrbanaBean> listarTipoUnidadUrbana() ;

  }
