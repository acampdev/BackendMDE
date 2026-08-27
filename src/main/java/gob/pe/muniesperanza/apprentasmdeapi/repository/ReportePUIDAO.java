package gob.pe.muniesperanza.apprentasmdeapi.repository;


import gob.pe.muniesperanza.apprentasmdeapi.bean.ReportePUBean;

import java.util.List;

public interface ReportePUIDAO {

  public List<ReportePUBean> listar(Integer codContribuyente) throws Exception   ;

}
