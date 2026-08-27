package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ContribuyenteBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Contribuyente;
import gob.pe.muniesperanza.apprentasmdeapi.model.Via;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ContribuyenteIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ContribuyenteService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {

  private final ContribuyenteIDAO contribuyenteIDAO;

  public ContribuyenteServiceImpl(ContribuyenteIDAO contribuyenteIDAO) {
    this.contribuyenteIDAO = contribuyenteIDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarContribuyente(ContribuyenteBean contribuyenteBean)  throws Exception {
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  contribuyenteIDAO.insertarContribuyente(contribuyenteBean);
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
  public ClsResultDAO actualizarContribuyente(ContribuyenteBean contribuyenteBean)  throws Exception {
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  contribuyenteIDAO.actualizarContribuyente(contribuyenteBean);
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
  public ClsResultDAO asignarConyugeRepresentante(ContribuyenteBean contribuyenteBean)  throws Exception {
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  contribuyenteIDAO.asignarConyugeRepresentante(contribuyenteBean);
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
  public ClsResultDAO quitarConyugeRepresentante(ContribuyenteBean contribuyenteBean)  throws Exception {
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  contribuyenteIDAO.quitarConyugeRepresentante(contribuyenteBean);
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
  public List<ContribuyenteBean> listarContribuyente(Integer codigoContribuyente,Integer codigoPersona) throws Exception {
    return contribuyenteIDAO.listarContribuyente(codigoContribuyente,codigoPersona);
  }

  @Transactional(readOnly = true)
  @Override
  public List<ContribuyenteBean> listarGeneral(String parametroBusqueda, Integer codigoContribuyente,String codTipoContribuyente,
                                               Boolean esExonerado,Boolean esPensionista) throws Exception {
    return contribuyenteIDAO.listarGeneral(parametroBusqueda,codigoContribuyente,codTipoContribuyente,esExonerado,
            esPensionista);
  }



}
