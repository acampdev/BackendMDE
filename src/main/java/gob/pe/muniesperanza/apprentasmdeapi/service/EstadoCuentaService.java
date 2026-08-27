package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.EstadoCuentaBean;

import java.util.List;

public interface EstadoCuentaService {

  public List<EstadoCuentaBean> listar(Integer codContribuyente, Integer anio, String codPredio) throws Exception   ;

  public List<EstadoCuentaBean> listarDetalle(Integer codContribuyente,Integer anio, String codPredio) throws Exception   ;

}
