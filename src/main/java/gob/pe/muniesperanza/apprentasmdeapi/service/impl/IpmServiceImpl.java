package gob.pe.muniesperanza.apprentasmdeapi.service.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.IpmBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.IpmIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.IpmService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IpmServiceImpl  implements IpmService {

  private final IpmIDAO ipmIDAO;

  public IpmServiceImpl(IpmIDAO ipmIDAO) {
    this.ipmIDAO = ipmIDAO;
  }


  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertar(IpmBean ipmBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  ipmIDAO.insertar(ipmBean);
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
  public ClsResultDAO actualizar(IpmBean ipmBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  ipmIDAO.actualizar(ipmBean);
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
  public List<IpmBean> listar(Integer anio) throws Exception {
    return ipmIDAO.listar(anio);
  }
}
