package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ReporteHRBean;

import java.util.List;

public interface ReporteHRIDAO {
  public List<ReporteHRBean> listar(Integer codContribuyente) throws Exception   ;

}
