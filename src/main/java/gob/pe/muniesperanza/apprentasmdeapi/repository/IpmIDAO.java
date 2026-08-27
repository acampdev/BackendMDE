package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.IpmBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface IpmIDAO {

  public ClsResultDAO insertar(IpmBean ipmBean) throws Exception;

  public ClsResultDAO actualizar(IpmBean ipmBean) throws Exception;

  public List<IpmBean> listar(Integer anio) throws Exception ;

}
