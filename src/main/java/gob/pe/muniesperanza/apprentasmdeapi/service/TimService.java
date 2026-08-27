package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.TimBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TimCboBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface TimService {

  public ClsResultDAO actualizar(TimBean timBean) throws Exception;

  public ClsResultDAO eliminar(TimBean timBean) throws Exception;

  public List<TimBean> listar(Integer anio, Integer periodo, Integer codTributo, Integer codResolucionInteres) throws Exception ;

  public List<TimCboBean> listarTimCbo();
}
