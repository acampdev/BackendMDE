package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.model.Barrio;
import gob.pe.muniesperanza.apprentasmdeapi.repository.BarrioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.BarrioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BarrioServiceImpl implements BarrioService {
  private final BarrioIDAO barrioIDAO;

  public BarrioServiceImpl(BarrioIDAO barrioIDAO) {
    this.barrioIDAO = barrioIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Barrio> listarBarrio() {
    return barrioIDAO.listarBarrio();
  }

  @Transactional(readOnly = false)
  @Override
  public Barrio insertarBarrio(Barrio barrio) {
    return barrioIDAO.insertarBarrio(barrio);
  }

  @Transactional(readOnly = false)
  @Override
  public Barrio actualizarBarrio(Barrio barrio) {
    return barrioIDAO.actualizarBarrio(barrio);
  }
}
