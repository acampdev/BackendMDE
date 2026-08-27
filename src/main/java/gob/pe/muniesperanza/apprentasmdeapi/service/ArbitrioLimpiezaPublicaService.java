package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioLimpiezaPublicaBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ArbitrioLimpiezaPublicaService {


  public ClsResultDAO insertarArbitrioLimpiezaPublica(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception ;

  public ClsResultDAO actualizarArbitrioLimpiezaPublica(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception ;

  public List<ArbitrioLimpiezaPublicaBean> listarArbitrioLimpiezaPublica(Integer anio) throws Exception   ;

  public ClsResultDAO insertarArbitrioLimpiezaPublicaOtros(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception;

  public ClsResultDAO actualizarArbitrioLimpiezaPublicaOtros(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception;

  public List<ArbitrioLimpiezaPublicaBean> listarArbitrioLimpiezaPublicaOtros(Integer anio) throws Exception;

}
