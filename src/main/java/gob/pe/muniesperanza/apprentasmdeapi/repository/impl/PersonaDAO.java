package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PersonaBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PersonaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class PersonaDAO extends SimpleJdbcDaoBase implements PersonaIDAO {

  //  Constructor
  public PersonaDAO(DataSource dataSource) {
    super(dataSource);
  }

  //  Metodo para insertar nuevo contribuyente
  @Override
  public ClsResultDAO insertarPersona(PersonaBean personaBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_persona")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlOutParameter("Codpersona", Types.INTEGER),
                                            new SqlParameter("Codtipopersona", Types.VARCHAR),
                                            new SqlParameter("Codtipodocumento", Types.VARCHAR),
                                            new SqlParameter("Numerodocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("Apellidopaterno", Types.VARCHAR),
                                            new SqlParameter("Apellidomaterno", Types.VARCHAR),
                                            new SqlParameter("Fechanacimiento", Types.DATE),
                                            new SqlParameter("Codestadocivil", Types.VARCHAR),
                                            new SqlParameter("Codsexo", Types.VARCHAR),
                                            new SqlParameter("telefono", Types.VARCHAR),
                                            new SqlParameter("Coddireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Parametrobusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // insertar
     // inParams.put("Codpersona", null);
      inParams.put("Codtipopersona", personaBean.getCodTipopersona());
      inParams.put("Codtipodocumento", personaBean.getCodTipoDocumento());
      inParams.put("Numerodocumento", personaBean.getNumerodocumento());
      inParams.put("Nombres", personaBean.getNombres());
      inParams.put("Apellidopaterno", personaBean.getApellidopaterno());
      inParams.put("Apellidomaterno", personaBean.getApellidomaterno());
      inParams.put("Fechanacimiento", personaBean.getFechanacimiento());
      inParams.put("Codestadocivil", personaBean.getCodestadocivil());
      inParams.put("Codsexo", personaBean.getCodsexo());
      inParams.put("telefono", personaBean.getTelefono());
      inParams.put("Coddireccion", personaBean.getCodDireccion());
      inParams.put("Lote", personaBean.getLote());
      inParams.put("Otros", personaBean.getOtros());
      inParams.put("Parametrobusqueda", null);
      inParams.put("Usuario", 1);

      Map<String, Object> result = stmt.execute(inParams);
      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");
      System.out.println("Respuesta: " + respuesta);
      System.out.println("Mensaje: " + mensaje);

      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      Integer codPersona = (Integer) result.get("Codpersona");
      System.out.println("Codpersona: " + codPersona);
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.INSERTADO, codPersona != null ? String.valueOf(codPersona) : 0);
      response.put(response.MENSAJE_RESPUESTA, mensaje);

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar sp_persona: " + e.getMessage(), e);
    }
    return response;
  }

  @Override
  public ClsResultDAO actualizarPersona(PersonaBean personaBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_persona")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Codpersona", Types.INTEGER),
                                            new SqlParameter("Codtipopersona", Types.VARCHAR),
                                            new SqlParameter("Codtipodocumento", Types.VARCHAR),
                                            new SqlParameter("Numerodocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("Apellidopaterno", Types.VARCHAR),
                                            new SqlParameter("Apellidomaterno", Types.VARCHAR),
                                            new SqlParameter("Fechanacimiento", Types.DATE),
                                            new SqlParameter("Codestadocivil", Types.VARCHAR),
                                            new SqlParameter("Codsexo", Types.VARCHAR),
                                            new SqlParameter("telefono", Types.VARCHAR),
                                            new SqlParameter("Coddireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Parametrobusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 2); // actualizar
      inParams.put("Codpersona", personaBean.getCodPersona());
      inParams.put("Codtipopersona", personaBean.getCodTipopersona());
      inParams.put("Codtipodocumento", personaBean.getCodTipoDocumento());
      inParams.put("Numerodocumento", personaBean.getNumerodocumento());
      inParams.put("Nombres", personaBean.getNombres());
      inParams.put("Apellidopaterno", personaBean.getApellidopaterno());
      inParams.put("Apellidomaterno", personaBean.getApellidomaterno());
      inParams.put("Fechanacimiento", personaBean.getFechanacimiento());
      inParams.put("Codestadocivil", personaBean.getCodestadocivil());
      inParams.put("Codsexo", personaBean.getCodsexo());
      inParams.put("telefono", personaBean.getTelefono());
      inParams.put("Coddireccion", personaBean.getCodDireccion());
      inParams.put("Lote", personaBean.getLote());
      inParams.put("Otros", personaBean.getOtros());
      inParams.put("Parametrobusqueda", null);
      inParams.put("Usuario", 1);

      Map<String, Object> result = stmt.execute(inParams);

      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");

      System.out.println("Respuesta: " + respuesta);
      System.out.println("Mensaje: " + mensaje);

      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar sp_via: " + e.getMessage(), e);
    }
    return response;
  }



  @Override
  public List<PersonaBean> listarPersonaPorTipPerTipDoc(String codTipoPersona,
                                                        String codTipoDocumento,String parametroBusqueda) throws Exception {
    List<PersonaBean> lista = new ArrayList<PersonaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_persona")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlOutParameter("Codpersona", Types.INTEGER),
                                            new SqlParameter("Codtipopersona", Types.VARCHAR),
                                            new SqlParameter("Codtipodocumento", Types.VARCHAR),
                                            new SqlParameter("Numerodocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("Apellidopaterno", Types.VARCHAR),
                                            new SqlParameter("Apellidomaterno", Types.VARCHAR),
                                            new SqlParameter("Fechanacimiento", Types.DATE),
                                            new SqlParameter("Codestadocivil", Types.VARCHAR),
                                            new SqlParameter("Codsexo", Types.VARCHAR),
                                            new SqlParameter("telefono", Types.VARCHAR),
                                            new SqlParameter("Coddireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Parametrobusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // listar
      inParams.put("Codpersona", null);
      inParams.put("Codtipopersona", codTipoPersona);
      inParams.put("Codtipodocumento", codTipoDocumento);
      inParams.put("Numerodocumento", null);
      inParams.put("Nombres", null);
      inParams.put("Apellidopaterno", null);
      inParams.put("Apellidomaterno", null);
      inParams.put("Direccion", null);
      inParams.put("Fechanacimiento", null);
      inParams.put("Codestadocivil", null);
      inParams.put("Codsexo", null);
      inParams.put("telefono", null);
      inParams.put("Coddireccion", null);
      inParams.put("Lote", null);
      inParams.put("Otros", null);
      inParams.put("Parametrobusqueda", parametroBusqueda);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          PersonaBean obj = new PersonaBean();
          obj.setCodPersona(temp.get("codPersona")!= null ? Integer.parseInt(String.valueOf(temp.get("codPersona"))) : null);
          obj.setCodTipopersona(temp.get("codTipoPersona")!= null ? String.valueOf(temp.get("codTipoPersona")) : null);
          obj.setCodTipoDocumento(temp.get("codTipoDocumento")!= null ? String.valueOf(temp.get("codTipoDocumento")) : null);
          obj.setNumerodocumento(temp.get("numeroDocumento")!= null ? String.valueOf(temp.get("numeroDocumento")) : null);
          obj.setNombres(temp.get("nombres")!= null ? String.valueOf(temp.get("nombres")) : null);
          obj.setApellidomaterno(temp.get("apellidoMaterno")!= null ? String.valueOf(temp.get("apellidoMaterno")) :null);
          obj.setApellidopaterno(temp.get("apellidoPaterno")!= null ? String.valueOf(temp.get("apellidoPaterno")) :null);
          obj.setFechanacimiento(temp.get("fechaNacimiento")!= null ? Date.valueOf(String.valueOf(temp.get("fechaNacimiento"))) : null);
          obj.setCodestadocivil(temp.get("codEstadoCivil")!= null ? String.valueOf(temp.get("codEstadoCivil")) : null);
          obj.setCodsexo(temp.get("codSexo")!= null ? String.valueOf(temp.get("codSexo")) : null);
          obj.setTelefono(temp.get("telefono")!= null ? String.valueOf(temp.get("telefono")) : null);
          obj.setDireccion(temp.get("direccion")!= null ? String.valueOf(temp.get("direcciom")) : null);
          obj.setNombrePersona(temp.get("nombrePersona")!= null ? String.valueOf(temp.get("nombrePersona")) : null);
          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar sp_via: " + e.getMessage(), e);
    }
    // return null;
  }




  @Override
  public List<PersonaBean> listarPersona(String codTipoDocumento,String numeroDocumento) throws Exception {
    List<PersonaBean> lista = new ArrayList<PersonaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_persona")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlOutParameter("Codpersona", Types.INTEGER),
                                            new SqlParameter("Codtipopersona", Types.VARCHAR),
                                            new SqlParameter("Codtipodocumento", Types.VARCHAR),
                                            new SqlParameter("Numerodocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("Apellidopaterno", Types.VARCHAR),
                                            new SqlParameter("Apellidomaterno", Types.VARCHAR),
                                            new SqlParameter("Fechanacimiento", Types.DATE),
                                            new SqlParameter("Codestadocivil", Types.VARCHAR),
                                            new SqlParameter("Codsexo", Types.VARCHAR),
                                            new SqlParameter("telefono", Types.VARCHAR),
                                            new SqlParameter("Coddireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Parametrobusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // listar
    //  inParams.put("Codpersona", null);
      inParams.put("Codtipopersona", null);
      inParams.put("Codtipodocumento", codTipoDocumento);
      inParams.put("Numerodocumento", numeroDocumento);
      inParams.put("Nombres", null);
      inParams.put("Apellidopaterno", null);
      inParams.put("Apellidomaterno", null);
      inParams.put("Fechanacimiento", null);
      inParams.put("Codestadocivil", null);
      inParams.put("Codsexo", null);
      inParams.put("telefono", null);
      inParams.put("Coddireccion", null);
      inParams.put("Lote", null);
      inParams.put("Otros", null);
      inParams.put("Parametrobusqueda", null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          PersonaBean obj = new PersonaBean();
          obj.setCodPersona(temp.get("codPersona")!= null ? Integer.parseInt(String.valueOf(temp.get("codPersona"))) : null);
          obj.setCodTipopersona(temp.get("codTipoPersona")!= null ? String.valueOf(temp.get("codTipoPersona")) : null);
          obj.setCodTipoDocumento(temp.get("codTipoDocumento")!= null ? String.valueOf(temp.get("codTipoDocumento")) : null);
          obj.setNumerodocumento(temp.get("numeroDocumento")!= null ? String.valueOf(temp.get("numeroDocumento")) : null);
          obj.setNombres(temp.get("nombres")!= null ? String.valueOf(temp.get("nombres")) : null);
          obj.setApellidomaterno(temp.get("apellidoMaterno")!= null ? String.valueOf(temp.get("apellidoMaterno")) :null);
          obj.setApellidopaterno(temp.get("apellidoPaterno")!= null ? String.valueOf(temp.get("apellidoPaterno")) :null);
          obj.setFechanacimiento(temp.get("fechaNacimiento")!= null ? Date.valueOf(String.valueOf(temp.get("fechaNacimiento"))) : null);
          obj.setCodestadocivil(temp.get("codEstadoCivil")!= null ? String.valueOf(temp.get("codEstadoCivil")) : null);
          obj.setCodsexo(temp.get("codSexo")!= null ? String.valueOf(temp.get("codSexo")) : null);
          obj.setTelefono(temp.get("telefono")!= null ? String.valueOf(temp.get("telefono")) : null);
          obj.setDireccion(temp.get("direccion")!= null ? String.valueOf(temp.get("direcciom")) : null);
          obj.setNombrePersona(temp.get("nombrePersona")!= null ? String.valueOf(temp.get("nombrePersona")) : null);
          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar sp_via: " + e.getMessage(), e);
    }
    // return null;
  }





}

