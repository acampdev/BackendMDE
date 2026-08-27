package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioSerenazgoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ArbitrioSerenazgoService {


  public ClsResultDAO insertarArbitrioSerenazgo(ArbitrioSerenazgoBean arbitrioSerenazgoBean) throws Exception ;

  public ClsResultDAO actualizarArbitrioSerenazgo(ArbitrioSerenazgoBean arbitrioSerenazgoBean) throws Exception ;

  public List<ArbitrioSerenazgoBean> listarArbitrioSerenazgo(Integer anio) throws Exception   ;

}