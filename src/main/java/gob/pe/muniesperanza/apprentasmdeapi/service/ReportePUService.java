package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ReportePUBean;

import java.util.List;

public interface ReportePUService {

  public List<ReportePUBean> listar(Integer codContribuyente) throws Exception;

}
