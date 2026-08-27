package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PisoBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.FraccionamientoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.InteresIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.FraccionamientoService;
import gob.pe.muniesperanza.apprentasmdeapi.service.InteresService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class InteresServiceImpl  implements InteresService {

  private final InteresIDAO interesIDAO;

  public InteresServiceImpl(InteresIDAO interesIDAO) {
    this.interesIDAO = interesIDAO;
  }


  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertar(InteresBean interesBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  interesIDAO.insertar(interesBean);
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
  public ClsResultDAO actualizar(InteresBean interesBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  interesIDAO.actualizar(interesBean);
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
  public ClsResultDAO inactivar(InteresBean interesBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  interesIDAO.inactivar(interesBean);
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
  public List<InteresBean> listar(Integer anio) throws Exception {
    return interesIDAO.listar(anio);
  }


}
