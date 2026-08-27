package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioLimpiezaPublicaBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArbitrioLimpiezaPublicaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArbitrioLimpiezaPublicaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArbitrioLimpiezaPublicaServiceImpl  implements ArbitrioLimpiezaPublicaService {

  private final ArbitrioLimpiezaPublicaIDAO arbitrioLimpiezaPublicaIDAO;


  public ArbitrioLimpiezaPublicaServiceImpl(ArbitrioLimpiezaPublicaIDAO arbitrioLimpiezaPublicaIDAO) {
    this.arbitrioLimpiezaPublicaIDAO = arbitrioLimpiezaPublicaIDAO;
  }
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarArbitrioLimpiezaPublica(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception  {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  arbitrioLimpiezaPublicaIDAO.insertarArbitrioLimpiezaPublica(  arbitrioLimpiezaPublicaBean);
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
  public ClsResultDAO actualizarArbitrioLimpiezaPublica(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception  {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  arbitrioLimpiezaPublicaIDAO.actualizarArbitrioLimpiezaPublica(  arbitrioLimpiezaPublicaBean);
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
  public List<ArbitrioLimpiezaPublicaBean> listarArbitrioLimpiezaPublica(Integer anio) throws Exception  {
    return arbitrioLimpiezaPublicaIDAO.listarArbitrioLimpiezaPublica(anio);
  }


  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarArbitrioLimpiezaPublicaOtros(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception  {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  arbitrioLimpiezaPublicaIDAO.insertarArbitrioLimpiezaPublicaOtros(arbitrioLimpiezaPublicaBean);
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
  public ClsResultDAO actualizarArbitrioLimpiezaPublicaOtros(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception  {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  arbitrioLimpiezaPublicaIDAO.actualizarArbitrioLimpiezaPublicaOtros(arbitrioLimpiezaPublicaBean);
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
  public List<ArbitrioLimpiezaPublicaBean> listarArbitrioLimpiezaPublicaOtros(Integer anio) throws Exception  {
    return arbitrioLimpiezaPublicaIDAO.listarArbitrioLimpiezaPublicaOtros(anio);
  }


}
