package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PisoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface InteresIDAO {

  public ClsResultDAO insertar(InteresBean interesBean) throws Exception;

  public ClsResultDAO actualizar(InteresBean interesBean) throws Exception;


  public ClsResultDAO inactivar(InteresBean interesBean) throws Exception;


  public List<InteresBean> listar(Integer anio) throws Exception ;

}
