package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AlcabalaBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AlcabalaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.AlcabalaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import gob.pe.muniesperanza.apprentasmdeapi.exception.ApiException;

import java.util.List;
@Service
public class AlcabalaServiceImpl    implements AlcabalaService {

  private final AlcabalaIDAO alcabalaIDAO;

  public AlcabalaServiceImpl(AlcabalaIDAO alcabalaIDAO) {
    this.alcabalaIDAO = alcabalaIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertar(AlcabalaBean alcabalaBean) throws Exception{
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  alcabalaIDAO.insertar(alcabalaBean);
      if (objResultDAO.get(objResultDAO.CODIGO_RESPUESTA).equals(objResultDAO.ERROR_THROW)) {
        return objResultDAO;
      }
    } catch (Exception e) {
      throw new ApiException(HttpStatus.SERVICE_UNAVAILABLE, "ALCABALA_INSERT_FAILED",
              "No se pudo registrar la alcabala", e);
    }
    return objResultDAO;
  }
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO actualizar(AlcabalaBean alcabalaBean) throws Exception{
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  alcabalaIDAO.actualizar(alcabalaBean);
      if (objResultDAO.get(objResultDAO.CODIGO_RESPUESTA).equals(objResultDAO.ERROR_THROW)) {
        return objResultDAO;
      }
    } catch (Exception e) {
      throw new ApiException(HttpStatus.SERVICE_UNAVAILABLE, "ALCABALA_UPDATE_FAILED",
              "No se pudo actualizar la alcabala", e);
    }
    return objResultDAO;
  }
  @Transactional(readOnly = true)
  @Override
  public List<AlcabalaBean> listar(Integer anio) throws Exception {
    return alcabalaIDAO.listar(anio);
  }
}
