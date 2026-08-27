package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignarCajaBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.Date;
import java.util.List;

public interface AsignarCajaIDAO {

  public ClsResultDAO insertar(AsignarCajaBean asignarCajaBean) throws Exception;

  public ClsResultDAO actualizar(AsignarCajaBean asignarCajaBean) throws Exception;

  public ClsResultDAO eliminar(AsignarCajaBean asignarCajaBean) throws Exception;

  public List<AsignarCajaBean> listar(String terminoBusqueda, Date fecha, Integer codUsuario) throws Exception ;

}
