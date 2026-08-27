package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.VencimientoBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ValoresUnitariosIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.VencimientoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ValoresUnitariosService;
import gob.pe.muniesperanza.apprentasmdeapi.service.VencimientoService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VencimientoServiceImpl  implements VencimientoService {

  private final VencimientoIDAO vencimientoIDAO;

  public VencimientoServiceImpl(VencimientoIDAO vencimientoIDAO) {
    this.vencimientoIDAO = vencimientoIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO generar(VencimientoBean vencimientoBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  vencimientoIDAO.generar(vencimientoBean);
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
  public List<VencimientoBean> listar(Integer anio) throws Exception {
    return vencimientoIDAO.listar(anio);
  }



}
