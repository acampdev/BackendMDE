package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ResolucionInteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ResolucionInteresService {

  public ClsResultDAO insertar(ResolucionInteresBean resolucionInteresBean) throws Exception;

  public ClsResultDAO actualizar(ResolucionInteresBean resolucionInteresBean) throws Exception;

  public ClsResultDAO eliminar(ResolucionInteresBean resolucionInteresBean) throws Exception;

  public List<ResolucionInteresBean> listar(Integer codResolucionInteres) throws Exception;

}
