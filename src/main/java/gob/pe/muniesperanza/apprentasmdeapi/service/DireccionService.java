package gob.pe.muniesperanza.apprentasmdeapi.service;


import gob.pe.muniesperanza.apprentasmdeapi.bean.DireccionBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface DireccionService {

  public ClsResultDAO insertar(DireccionBean direccionBean)  throws Exception;

  public ClsResultDAO actualizar(DireccionBean direccionBean)  throws Exception;

  public List<DireccionBean> listar(String parametrosBusqueda, Integer codUsuario) throws Exception;


}
