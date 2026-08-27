package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.TurnoBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.TurnoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.TurnoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TurnoServiceImpl   implements TurnoService {

  private final TurnoIDAO turnoIDAO;

  public TurnoServiceImpl(TurnoIDAO turnoIDAO) {
    this.turnoIDAO = turnoIDAO;
  }
  @Transactional(readOnly = true)
  @Override
  public List<TurnoBean> listar() throws Exception {
    return turnoIDAO.listar();
  }
}
