package gob.pe.muniesperanza.apprentasmdeapi.service.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.TimBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TimCboBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.TimIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.TimService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TimServiceImpl implements TimService {

  private final TimIDAO timIDAO;

  public TimServiceImpl(TimIDAO timIDAO) {
    this.timIDAO = timIDAO;
  }



  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO actualizar(TimBean timBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  timIDAO.actualizar(timBean);
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
  public ClsResultDAO eliminar(TimBean timBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  timIDAO.eliminar(timBean);
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
  public List<TimBean> listar(Integer anio,Integer periodo, Integer codTributo, Integer codResolucionInteres) throws Exception {
    return timIDAO.listar(anio,periodo,codTributo,codResolucionInteres);
  }

  @Transactional(readOnly = true)
  @Override
  public List<TimCboBean> listarTimCbo(){
    return timIDAO.listarTimCbo();
  }

}
