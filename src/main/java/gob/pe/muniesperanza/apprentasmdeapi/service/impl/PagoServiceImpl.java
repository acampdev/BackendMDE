package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PagoBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.InteresIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PagoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.InteresService;
import gob.pe.muniesperanza.apprentasmdeapi.service.PagoService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PagoServiceImpl implements PagoService {

  private final PagoIDAO pagoIDAO;

  public PagoServiceImpl(PagoIDAO pagoIDAO) {
    this.pagoIDAO = pagoIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO pagoOrdinario(PagoBean pagoBean)  throws Exception {
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = pagoIDAO.pagoOrdinario(pagoBean);
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
  public ClsResultDAO pagoCuotaFraccionamiento(PagoBean pagoBean) throws Exception{
    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = pagoIDAO.pagoCuotaFraccionamiento(pagoBean);
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
  public List<PagoBean> listarPagos(Integer codContribuyente, Integer numeroPago, Integer anio) throws Exception  {
    return pagoIDAO.listarPagos(codContribuyente, numeroPago, anio);
  }

}
