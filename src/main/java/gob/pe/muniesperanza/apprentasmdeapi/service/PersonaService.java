package gob.pe.muniesperanza.apprentasmdeapi.service;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PersonaBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface PersonaService {

  public ClsResultDAO insertarPersona(PersonaBean personaBean)  throws Exception;

  public ClsResultDAO actualizarPersona(PersonaBean personaBean)  throws Exception;

  public List<PersonaBean> listarPersonaPorTipPerTipDoc(String codTipoPersona,
                                                        String codTipoDocumento,
                                                        String parametroBusqueda) throws Exception;

  public List<PersonaBean> listarPersona(String codTipoDocumento,String numeroDocumento)  throws Exception;


 }
