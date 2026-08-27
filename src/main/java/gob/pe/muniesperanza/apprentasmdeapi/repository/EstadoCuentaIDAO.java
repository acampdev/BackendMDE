package gob.pe.muniesperanza.apprentasmdeapi.repository;


import gob.pe.muniesperanza.apprentasmdeapi.bean.EstadoCuentaBean;

import java.util.List;

public interface EstadoCuentaIDAO {

  public List<EstadoCuentaBean> listar(Integer codContribuyente,Integer anio, String codPredio) throws Exception   ;

  public List<EstadoCuentaBean> listarDetalle(Integer codContribuyente,Integer anio, String codPredio) throws Exception   ;

}
