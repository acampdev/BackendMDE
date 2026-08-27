package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface PredioIDAO {

  public ClsResultDAO insertarPredio(PredioBean predioBean) throws Exception;

  public ClsResultDAO actualizarPredio(PredioBean predioBean) throws Exception;

  public List<PredioBean> listarPredio(Integer anio,String codPredioBase, String parametroBusqueda) throws Exception ;

  public List<PredioBean> listarPredioAll(String codPredioBase,Integer anio) throws Exception;

  public List<PredioBean> listarUsos() throws Exception;
}
