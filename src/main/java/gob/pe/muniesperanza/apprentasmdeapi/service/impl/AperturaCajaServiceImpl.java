package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AperturaCajaBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AperturaCajaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.AperturaCajaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AperturaCajaServiceImpl   implements AperturaCajaService {

  private final AperturaCajaIDAO aperturaCajaIDAO;

  public AperturaCajaServiceImpl(AperturaCajaIDAO aperturaCajaIDAO) {
    this.aperturaCajaIDAO = aperturaCajaIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO apertura(AperturaCajaBean aperturaCajaBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  aperturaCajaIDAO.apertura(aperturaCajaBean);
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
  public ClsResultDAO cierre(AperturaCajaBean aperturaCajaBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  aperturaCajaIDAO.cierre(aperturaCajaBean);
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
  public List<AperturaCajaBean> listar(Integer codUsuario) throws Exception {
    return aperturaCajaIDAO.listar(codUsuario);
  }

}
