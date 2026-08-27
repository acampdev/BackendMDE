package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.UsuarioBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.UsuarioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class UsuarioDAO  extends SimpleJdbcDaoBase implements UsuarioIDAO {


  public UsuarioDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public ClsResultDAO insertar(UsuarioBean usuarioBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();
    try {
       Integer tipo = 1;
       Map<String, Object> result = parametros(usuarioBean, tipo);
      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");
      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);
    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;
  }

  public ClsResultDAO actualizar(UsuarioBean usuarioBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();
    try {
    Integer tipo = 2;
    Map<String, Object> result = parametros(usuarioBean, tipo);
    Integer respuesta = (Integer) result.get("Respuesta");
    String mensaje = (String) result.get("Mensaje");
    if (respuesta == 0) {
      response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
      return response;
    }
    response.put(response.CODIGO_RESPUESTA, 1);
    response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);
  } catch (Throwable e) {
    // logger.error(e.getMessage(), e);
    throw new Exception(e.getMessage(), e);
  }
    return response;
}

  public ClsResultDAO darBaja(UsuarioBean usuarioBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();
    try {
      Integer tipo = 3;
      Map<String, Object> result = parametros(usuarioBean, tipo);
      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");
      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);
    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;

  }

  public ClsResultDAO activar(UsuarioBean usuarioBean) throws Exception{ ClsResultDAO response = new ClsResultDAO();
    try {
      Integer tipo = 4;
      Map<String, Object> result = parametros(usuarioBean, tipo);
      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");
      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);
    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;
  }

  public ClsResultDAO cambiarClave(UsuarioBean usuarioBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();
    try {
      Integer tipo = 5;
      Map<String, Object> result = parametros(usuarioBean, tipo);
      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");
      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);
    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;
  }

  public ClsResultDAO verificarSupervisorCajero(UsuarioBean usuarioBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();
    try {
      Integer tipo = 7;
      Map<String, Object> result = parametros(usuarioBean, tipo);
      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");
      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);
    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;
  }

  public List<UsuarioBean> listar(String parametroBusqueda) throws Exception{

   List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
    try {
      Integer tipo = 6;
      UsuarioBean usuarioBean = new UsuarioBean();
      usuarioBean.setParametroBusqueda(parametroBusqueda);
      Map<String, Object> result = parametros(usuarioBean, tipo);
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          UsuarioBean obj = new UsuarioBean();
          obj.setCodUsuario(temp.get("codUsuario")!= null ?  Integer.parseInt(String.valueOf(temp.get("codUsuario"))) : null);
          obj.setUsername(temp.get("username")!= null ? (String.valueOf(temp.get("username"))) : null);
          obj.setNombrePersona(temp.get("nombrePersona")!= null ? String.valueOf(temp.get("nombrePersona")) : null);
          obj.setDocumento(temp.get("documento")!= null ? String.valueOf(temp.get("documento")) : null);
          obj.setRol(temp.get("rol")!= null ? String.valueOf(temp.get("rol")) : null);
          obj.setEstado(temp.get("estado")!= null ? String.valueOf(temp.get("estado")) :null);
          return obj;
        }).toList();
      }
      return lista;
    } catch (Exception e) {
      System.err.println("Error de conexión: " + e.getMessage());
    }
    return lista;
  }


  private Map<String, Object>  parametros(UsuarioBean usuarioBean, Integer tipo) throws Exception{
    Map<String, Object> inParams = new HashMap<>();
    Map<String, Object> result;
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_usuario")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("NombrePersona", Types.VARCHAR),
                                            new SqlParameter("Documento", Types.VARCHAR),
                                            new SqlParameter("Username", Types.VARCHAR),
                                            new SqlParameter("Password", Types.VARCHAR),
                                            new SqlParameter("CodRol", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      inParams.put("Tipo", tipo);
      inParams.put("CodUsuario", usuarioBean.getCodUsuario());
      inParams.put("NombrePersona", usuarioBean.getNombrePersona());
      inParams.put("Documento", usuarioBean.getDocumento());
      inParams.put("Username", usuarioBean.getUsername());
      inParams.put("Password", usuarioBean.getPassword());
      inParams.put("CodRol", usuarioBean.getCodRol());
      inParams.put("Usuario", usuarioBean.getUsuario());
      inParams.put("ParametroBusqueda", usuarioBean.getParametroBusqueda());

      result = stmt.execute(inParams);

    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return result;
  }


}
