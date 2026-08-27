package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.DepreciacionBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.DepreciacionIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.DepreciacionService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepreciacionServiceImpl implements DepreciacionService {

  private final DepreciacionIDAO depreciacionIDAO;

  public DepreciacionServiceImpl(DepreciacionIDAO depreciacionIDAO) {
    this.depreciacionIDAO = depreciacionIDAO;
  }

  @Transactional(readOnly = true)
  @Override
  public List<DepreciacionBean> listarDepreciacion(Integer anio, String codTipoCasa)  throws Exception {
    return depreciacionIDAO.listarDepreciacion(anio, codTipoCasa);
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarDepreciacion(DepreciacionBean depreciacionBean) throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = depreciacionIDAO.insertarDepreciacion(depreciacionBean);
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
  public ClsResultDAO actualizarDepreciacion(DepreciacionBean depreciacionBean) throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = depreciacionIDAO.actualizarDepreciacion(depreciacionBean);
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
}