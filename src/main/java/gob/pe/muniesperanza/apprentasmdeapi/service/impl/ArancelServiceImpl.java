package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArancelIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArancelService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArancelServiceImpl implements ArancelService {

  private final ArancelIDAO arancelIDAO;

  public ArancelServiceImpl(ArancelIDAO arancelIDAO) {
    this.arancelIDAO = arancelIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarArancel(ArancelBean arancelBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  arancelIDAO.insertarArancel(arancelBean);
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
  public ClsResultDAO actualizarArancel(ArancelBean arancelBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  arancelIDAO.actualizarArancel(arancelBean);
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
  public List<ArancelBean> listarArancel(Integer anio,  String parametroBusqueda) throws Exception {
    return arancelIDAO.listarArancel( anio, parametroBusqueda);
  }




}
