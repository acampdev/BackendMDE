package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.model.Via;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ViaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ViaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ViaServiceImpl implements ViaService {

  private final ViaIDAO viaIDAO;

  public ViaServiceImpl(ViaIDAO viaIDAO) {
    this.viaIDAO = viaIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Via> listarVias() {
    return viaIDAO.listarVias();
  }

  @Transactional
  @Override
  public Via insertarVias(Via via) {
    return viaIDAO.insertarVia(via);
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarVia(Via via)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  viaIDAO.insertarVias(via);
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
  public ClsResultDAO actualizarVia(Via via)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  viaIDAO.actualizarVia(via);
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

//  @Transactional
//  @Override
//  public Via actualizarVia(Via via) {
//    return viaIDAO.actualizarVia(via);
//  }


}
