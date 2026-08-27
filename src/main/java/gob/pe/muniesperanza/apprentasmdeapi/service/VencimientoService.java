package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.VencimientoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface VencimientoService {

  public ClsResultDAO generar(VencimientoBean vencimientoBean) throws Exception;

  public List<VencimientoBean> listar(Integer anio) throws Exception ;

}
