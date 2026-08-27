package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ReportePUBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ReportePUIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ReportePUService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ReportePUServiceImpl   implements ReportePUService {

  private final ReportePUIDAO reportePUIDAO;

  public ReportePUServiceImpl(ReportePUIDAO reportePUIDAO) {
    this.reportePUIDAO = reportePUIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<ReportePUBean> listar(Integer codContribuyente) throws Exception {
    return reportePUIDAO.listar(codContribuyente);
  }

}
