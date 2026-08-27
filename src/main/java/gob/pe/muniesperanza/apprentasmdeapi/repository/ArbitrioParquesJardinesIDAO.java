package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioParquesJardinesBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioSerenazgoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ArbitrioParquesJardinesIDAO {

  public ClsResultDAO insertarArbitrioParquesJardines(ArbitrioParquesJardinesBean arbitrioParquesJardinesBean) throws Exception ;

  public ClsResultDAO actualizarArbitrioParquesJardines(ArbitrioParquesJardinesBean arbitrioParquesJardinesBean) throws Exception ;

  public List<ArbitrioParquesJardinesBean> listarArbitrioParquesJardines(Integer anio) throws Exception   ;

}
