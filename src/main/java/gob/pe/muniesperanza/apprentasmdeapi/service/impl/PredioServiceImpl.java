package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PredioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.PredioService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PredioServiceImpl implements PredioService {

  private final PredioIDAO predioIDAO;

  public PredioServiceImpl(PredioIDAO predioIDAO) {
    this.predioIDAO = predioIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarPredio(PredioBean predioBean) throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = predioIDAO.insertarPredio(predioBean);
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
  public ClsResultDAO actualizarPredio(PredioBean predioBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = predioIDAO.actualizarPredio(predioBean);
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
  public List<PredioBean> listarPredio(Integer anio,String codPredioBase, String parametroBusqueda) throws Exception {
    return predioIDAO.listarPredio( anio, codPredioBase,  parametroBusqueda);
  }

  @Transactional(readOnly = true)
  @Override
  public List<PredioBean> listarPredioAll(String codPredioBase,Integer anio) throws Exception {
    return predioIDAO.listarPredioAll(codPredioBase, anio);
  }

  @Override
  public List<PredioBean> listarUsos() throws Exception {
    return predioIDAO.listarUsos();
  }

}
