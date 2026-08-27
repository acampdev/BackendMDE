package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.RolBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;
import gob.pe.muniesperanza.apprentasmdeapi.repository.RolIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SectorIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.RolService;
import gob.pe.muniesperanza.apprentasmdeapi.service.SectorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RolServiceImpl  implements RolService {
  private final RolIDAO rolIDAO;

  public RolServiceImpl(RolIDAO rolIDAO) {
    this.rolIDAO = rolIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<RolBean> listar()
  {
    return rolIDAO.listar();
  }
}
