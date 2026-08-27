package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArancelIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ValoresUnitariosIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArancelService;
import gob.pe.muniesperanza.apprentasmdeapi.service.ValoresUnitariosService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ValoresUnitariosServiceImpl  implements ValoresUnitariosService {

  private final ValoresUnitariosIDAO valoresUnitariosIDAO;

  public ValoresUnitariosServiceImpl(ValoresUnitariosIDAO valoresUnitariosIDAO) {
    this.valoresUnitariosIDAO = valoresUnitariosIDAO;
  }
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarValoresUnitarios(ValoresUnitariosBean valoresUnitariosBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  valoresUnitariosIDAO.insertarValoresUnitarios(valoresUnitariosBean);
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
  public ClsResultDAO actualizarValoresUnitarios(ValoresUnitariosBean valoresUnitariosBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  valoresUnitariosIDAO.actualizarValoresUnitarios(valoresUnitariosBean);
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
  public List<ValoresUnitariosBean> listarValoresUnitarios(Integer anio) throws Exception {
    return valoresUnitariosIDAO.listarValoresUnitarios(anio);
  }

}
