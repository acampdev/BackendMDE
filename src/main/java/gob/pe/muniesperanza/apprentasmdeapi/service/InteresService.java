package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface InteresService {

  public ClsResultDAO insertar(InteresBean interesBean) throws Exception;

  public ClsResultDAO actualizar(InteresBean interesBean) throws Exception;


  public ClsResultDAO inactivar(InteresBean interesBean) throws Exception;


  public List<InteresBean> listar(Integer anio) throws Exception ;

}
