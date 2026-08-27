package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ContribuyenteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PersonaBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ContribuyenteIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PersonaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ContribuyenteService;
import gob.pe.muniesperanza.apprentasmdeapi.service.PersonaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

  private final PersonaIDAO personaIDAO;

  public PersonaServiceImpl(PersonaIDAO personaIDAO) {
    this.personaIDAO = personaIDAO;
  }


  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarPersona(PersonaBean personaBean) throws Exception {
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = personaIDAO.insertarPersona(personaBean);
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
  public ClsResultDAO actualizarPersona(PersonaBean personaBean) throws Exception {
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO = personaIDAO.actualizarPersona(personaBean);
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





  public List<PersonaBean> listarPersonaPorTipPerTipDoc(String codTipoPersona,
                                                                                   String codTipoDocumento,
                                                                                   String parametroBusqueda) throws Exception {
    return personaIDAO.listarPersonaPorTipPerTipDoc(codTipoPersona, codTipoDocumento,
            parametroBusqueda);

  }

  @Transactional(readOnly = true)
  @Override
  public List<PersonaBean> listarPersona(String codTipoDocumento,String numeroDocumento)  throws Exception {
    return personaIDAO.listarPersona(codTipoDocumento, numeroDocumento);
  }





}
