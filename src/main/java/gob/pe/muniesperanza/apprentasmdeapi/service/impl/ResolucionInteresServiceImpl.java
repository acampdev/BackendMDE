package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ResolucionInteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ResolucionInteresIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.VencimientoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ResolucionInteresService;
import gob.pe.muniesperanza.apprentasmdeapi.service.VencimientoService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ResolucionInteresServiceImpl   implements ResolucionInteresService {

  private final ResolucionInteresIDAO resolucionInteresIDAO;

  public ResolucionInteresServiceImpl(ResolucionInteresIDAO resolucionInteresIDAO) {
    this.resolucionInteresIDAO = resolucionInteresIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertar(ResolucionInteresBean resolucionInteresBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  resolucionInteresIDAO.insertar(resolucionInteresBean);
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
  public ClsResultDAO actualizar(ResolucionInteresBean resolucionInteresBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  resolucionInteresIDAO.actualizar(resolucionInteresBean);
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
  public ClsResultDAO eliminar(ResolucionInteresBean resolucionInteresBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  resolucionInteresIDAO.eliminar(resolucionInteresBean);
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
  public List<ResolucionInteresBean> listar(Integer codResolucionInteres) throws Exception{
    return resolucionInteresIDAO.listar(codResolucionInteres);
  }

}
