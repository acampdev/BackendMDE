package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioParquesJardinesBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArbitrioParquesJardinesIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArbitrioParquesJardinesService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ArbitrioParquesJardinesServiceImpl    implements ArbitrioParquesJardinesService {

  private final ArbitrioParquesJardinesIDAO arbitrioParquesJardinesIDAO;


  public ArbitrioParquesJardinesServiceImpl(ArbitrioParquesJardinesIDAO arbitrioParquesJardinesIDAO) {
    this.arbitrioParquesJardinesIDAO = arbitrioParquesJardinesIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarArbitrioParquesJardines(ArbitrioParquesJardinesBean arbitrioParquesJardinesBean) throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = arbitrioParquesJardinesIDAO.insertarArbitrioParquesJardines(arbitrioParquesJardinesBean);
      if (objResultDAO.get(objResultDAO.CODIGO_RESPUESTA).equals(objResultDAO.ERROR_THROW)) {
        return objResultDAO;
      }
    } catch (Exception e) {
      // TODO: handle exception
      //log.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return objResultDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO actualizarArbitrioParquesJardines(ArbitrioParquesJardinesBean arbitrioParquesJardinesBean) throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = arbitrioParquesJardinesIDAO.actualizarArbitrioParquesJardines(arbitrioParquesJardinesBean);
      if (objResultDAO.get(objResultDAO.CODIGO_RESPUESTA).equals(objResultDAO.ERROR_THROW)) {
        return objResultDAO;
      }
    } catch (Exception e) {
      // TODO: handle exception
      //log.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return objResultDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<ArbitrioParquesJardinesBean> listarArbitrioParquesJardines(Integer anio) throws Exception {
    return arbitrioParquesJardinesIDAO.listarArbitrioParquesJardines(anio);
  }
}

