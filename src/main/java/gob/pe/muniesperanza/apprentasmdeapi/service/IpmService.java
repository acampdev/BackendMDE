package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.IpmBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface IpmService {

  public ClsResultDAO insertar(IpmBean ipmBean) throws Exception;

  public ClsResultDAO actualizar(IpmBean ipmBean) throws Exception;

  public List<IpmBean> listar(Integer anio) throws Exception ;

}
