package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ArancelIDAO {

  public ClsResultDAO insertarArancel(ArancelBean arancelBean) throws Exception;

  public ClsResultDAO actualizarArancel(ArancelBean arancelBean) throws Exception;

  public List<ArancelBean> listarArancel( Integer anio, String parametroBusqueda) throws Exception ;

}
