package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioSerenazgoBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArbitrioSerenazgoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArbitrioSerenazgoService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ArbitrioSerenazgoServiceImpl   implements ArbitrioSerenazgoService {

  private final ArbitrioSerenazgoIDAO arbitrioSerenazgoIDAO;

  public ArbitrioSerenazgoServiceImpl(ArbitrioSerenazgoIDAO arbitrioSerenazgoIDAO) {
    this.arbitrioSerenazgoIDAO = arbitrioSerenazgoIDAO;
  }
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarArbitrioSerenazgo(ArbitrioSerenazgoBean arbitrioSerenazgoBean) throws Exception  {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  arbitrioSerenazgoIDAO.insertarArbitrioSerenazgo(  arbitrioSerenazgoBean);
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
  public ClsResultDAO actualizarArbitrioSerenazgo(ArbitrioSerenazgoBean arbitrioSerenazgoBean) throws Exception  {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  arbitrioSerenazgoIDAO.actualizarArbitrioSerenazgo(  arbitrioSerenazgoBean);
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
  public List<ArbitrioSerenazgoBean> listarArbitrioSerenazgo(Integer anio) throws Exception  {
    return arbitrioSerenazgoIDAO.listarArbitrioSerenazgo(anio);
  }

}
