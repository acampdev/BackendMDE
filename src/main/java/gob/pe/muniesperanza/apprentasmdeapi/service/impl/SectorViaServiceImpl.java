package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.model.SectorVia;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SectorViaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.SectorViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectorViaServiceImpl implements SectorViaService {

  private final SectorViaIDAO sectorViaIDAO;

  public SectorViaServiceImpl(SectorViaIDAO sectorViaIDAO) {
    this.sectorViaIDAO = sectorViaIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<SectorVia> llenarCombo() {
    return sectorViaIDAO.llenarCombo();
  }
}
