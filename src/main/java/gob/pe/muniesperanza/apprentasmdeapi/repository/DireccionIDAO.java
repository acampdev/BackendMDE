package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.DireccionBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface DireccionIDAO {


  public ClsResultDAO insertar(DireccionBean direccionBean) throws Exception;

  public ClsResultDAO actualizar(DireccionBean direccionBean) throws Exception;

  public List<DireccionBean> listar(String parametroBusqueda, Integer codUsuario) throws Exception;


}
