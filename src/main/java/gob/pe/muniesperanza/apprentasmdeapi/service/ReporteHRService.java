package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ReporteHRBean;

import java.util.List;

public interface ReporteHRService {

  public List<ReporteHRBean> listar(Integer codContribuyente) throws Exception;

}
