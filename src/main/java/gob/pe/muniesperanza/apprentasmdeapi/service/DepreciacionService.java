package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.DepreciacionBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface DepreciacionService {


  public ClsResultDAO insertarDepreciacion(DepreciacionBean depreciacionBean)  throws Exception;

  public ClsResultDAO actualizarDepreciacion(DepreciacionBean depreciacionBean)  throws Exception;

  public List<DepreciacionBean> listarDepreciacion(Integer anio, String codTipoCasa) throws Exception ;

}
