package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ReporteHRBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ReporteHRIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ReporteHRService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ReporteHRServiceImpl   implements ReporteHRService {

  private final ReporteHRIDAO reporteHRIDAO;

  public ReporteHRServiceImpl(ReporteHRIDAO reporteHRIDAO) {
    this.reporteHRIDAO = reporteHRIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<ReporteHRBean> listar(Integer codContribuyente) throws Exception {
    return reporteHRIDAO.listar(codContribuyente);
  }

}
