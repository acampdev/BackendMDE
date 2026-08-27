package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AlcabalaBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface AlcabalaIDAO {


  public ClsResultDAO insertar(AlcabalaBean alcabalaBean) throws Exception;

  public ClsResultDAO actualizar(AlcabalaBean alcabalaBean) throws Exception;

  public List<AlcabalaBean> listar(Integer anio) throws Exception ;

}
