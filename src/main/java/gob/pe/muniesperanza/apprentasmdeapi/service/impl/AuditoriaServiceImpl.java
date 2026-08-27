package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AuditoriaBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AuditoriaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.AuditoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AuditoriaServiceImpl implements AuditoriaService {
  private final AuditoriaIDAO auditoriaIDAO;

  public AuditoriaServiceImpl(AuditoriaIDAO auditoriaIDAO) {
    this.auditoriaIDAO = auditoriaIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<AuditoriaBean> listar() throws Exception {
    return auditoriaIDAO.listar();
  }

}
