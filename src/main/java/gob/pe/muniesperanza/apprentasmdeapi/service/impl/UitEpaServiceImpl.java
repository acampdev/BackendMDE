package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.UitEpaBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.UitEpaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.UitEpaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UitEpaServiceImpl  implements UitEpaService {

  private final UitEpaIDAO uitEpaIDAO;

  public UitEpaServiceImpl(UitEpaIDAO uitEpaIDAO) {
    this.uitEpaIDAO = uitEpaIDAO;
  }
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarUitEpa(UitEpaBean uitEpaBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  uitEpaIDAO.insertarUitEpa( uitEpaBean);
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
  public ClsResultDAO actualizarUitEpa(UitEpaBean uitEpaBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  uitEpaIDAO.actualizarUitEpa(uitEpaBean);
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
  public List<UitEpaBean> listarUitEpa(Integer anio) throws Exception {
    return uitEpaIDAO.listarUitEpa(anio);
  }

}
