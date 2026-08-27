package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.EstadoCuentaBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.EstadoCuentaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.EstadoCuentaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EstadoCuentaServiceImpl    implements EstadoCuentaService {

  private final EstadoCuentaIDAO estadoCuentaIDAO;


  public EstadoCuentaServiceImpl(EstadoCuentaIDAO estadoCuentaIDAO) {
    this.estadoCuentaIDAO = estadoCuentaIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<EstadoCuentaBean> listar(Integer codContribuyente, Integer anio, String codPredio) throws Exception {
    return estadoCuentaIDAO.listar(codContribuyente,anio,  codPredio);
  }
  @Transactional(readOnly = true)
  @Override
  public List<EstadoCuentaBean> listarDetalle(Integer codContribuyente,Integer anio, String codPredio) throws Exception   {
    return estadoCuentaIDAO.listarDetalle(codContribuyente,anio,  codPredio);
  }

}
