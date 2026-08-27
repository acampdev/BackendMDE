package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioLimpiezaPublicaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioSerenazgoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.util.CollectionUtils;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArbitrioLimpiezaPublicaIDAO {

  public ClsResultDAO insertarArbitrioLimpiezaPublica(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception ;

  public ClsResultDAO actualizarArbitrioLimpiezaPublica(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception ;

  public List<ArbitrioLimpiezaPublicaBean> listarArbitrioLimpiezaPublica(Integer anio) throws Exception   ;

  public ClsResultDAO insertarArbitrioLimpiezaPublicaOtros(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception;

  public ClsResultDAO actualizarArbitrioLimpiezaPublicaOtros(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception;

  public List<ArbitrioLimpiezaPublicaBean> listarArbitrioLimpiezaPublicaOtros(Integer anio) throws Exception;

}
