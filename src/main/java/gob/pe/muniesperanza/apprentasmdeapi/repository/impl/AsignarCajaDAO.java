package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignarCajaBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AsignarCajaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.*;
@Repository
public class AsignarCajaDAO extends SimpleJdbcDaoBase implements AsignarCajaIDAO {

  public AsignarCajaDAO(DataSource dataSource) {
    super(dataSource);
  }

  public ClsResultDAO insertar(AsignarCajaBean asignarCajaBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_asignarCaja")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAsignacionCaja", Types.INTEGER),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("CodCaja", Types.INTEGER),
                                            new SqlParameter("CodTurno", Types.INTEGER),
                                            new SqlParameter("Fecha", Types.DATE),
                                            new SqlParameter("TerminoBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodAsignacionCaja", null);
      inParams.put("CodUsuario", asignarCajaBean.getCodUsuario());
      inParams.put("CodCaja", asignarCajaBean.getCodCaja());
      inParams.put("CodTurno", asignarCajaBean.getCodTurno());
      inParams.put("Fecha", asignarCajaBean.getFecha());
      inParams.put("TerminoBusqueda", asignarCajaBean.getTerminoBusqueda());
      inParams.put("Usuario", asignarCajaBean.getUsuario());

      Map<String, Object> result = stmt.execute(inParams);
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

  public ClsResultDAO actualizar(AsignarCajaBean asignarCajaBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_asignarCaja")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAsignacionCaja", Types.INTEGER),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("CodCaja", Types.INTEGER),
                                            new SqlParameter("CodTurno", Types.INTEGER),
                                            new SqlParameter("Fecha", Types.DATE),
                                            new SqlParameter("TerminoBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para modificar
      inParams.put("CodAsignacionCaja", asignarCajaBean.getCodAsignacionCaja());
      inParams.put("CodUsuario", asignarCajaBean.getCodUsuario());
      inParams.put("CodCaja", asignarCajaBean.getCodCaja());
      inParams.put("CodTurno", asignarCajaBean.getCodTurno());
      inParams.put("Fecha", asignarCajaBean.getFecha());
      inParams.put("TerminoBusqueda", asignarCajaBean.getTerminoBusqueda());
      inParams.put("Usuario",  asignarCajaBean.getUsuario());

      Map<String, Object> result = stmt.execute(inParams);
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

  public ClsResultDAO eliminar(AsignarCajaBean asignarCajaBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_asignarCaja")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAsignacionCaja", Types.INTEGER),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("CodCaja", Types.INTEGER),
                                            new SqlParameter("CodTurno", Types.INTEGER),
                                            new SqlParameter("Fecha", Types.DATE),
                                            new SqlParameter("TerminoBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // Tipo 3 es para eliminar
      inParams.put("CodAsignacionCaja", asignarCajaBean.getCodAsignacionCaja());
      inParams.put("CodUsuario", asignarCajaBean.getCodUsuario());
      inParams.put("CodCaja", asignarCajaBean.getCodCaja());
      inParams.put("CodTurno", asignarCajaBean.getCodTurno());
      inParams.put("Fecha", asignarCajaBean.getFecha());
      inParams.put("TerminoBusqueda", asignarCajaBean.getTerminoBusqueda());
      inParams.put("Usuario",  asignarCajaBean.getUsuario());

      Map<String, Object> result = stmt.execute(inParams);
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




  @Override
  public List<AsignarCajaBean> listar(String terminoBusqueda, Date fecha, Integer codUsuario) throws Exception   {

    List<AsignarCajaBean> lista = new ArrayList<AsignarCajaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_asignarCaja").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAsignacionCaja", Types.INTEGER),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("CodCaja", Types.INTEGER),
                                            new SqlParameter("CodTurno", Types.INTEGER),
                                            new SqlParameter("Fecha", Types.DATE),
                                            new SqlParameter("TerminoBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 4); // Tipo 4 es para listar
      inParams.put("CodAsignacionCaja", null);
      inParams.put("CodUsuario",  null);
      inParams.put("CodCaja",  null);
      inParams.put("CodTurno", null);
      inParams.put("Fecha", fecha);
      inParams.put("TerminoBusqueda", terminoBusqueda);
      inParams.put("Usuario", codUsuario);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          AsignarCajaBean obj = new AsignarCajaBean();
          obj.setCodAsignacionCaja(temp.get("codAsignacion")!= null ? Integer.parseInt(String.valueOf(temp.get(
                  "codAsignacion"))) : null);
          obj.setCodCaja(temp.get("codCaja")!= null ?  Integer.parseInt(String.valueOf(temp.get("codCaja"))) : null);
          obj.setNumCaja(temp.get("numCaja")!= null ? String.valueOf(temp.get("numCaja")) : null);
          obj.setNombreUsuario(temp.get("nombreUsuario")!= null ? String.valueOf(temp.get("nombreUsuario")) : null);
          obj.setTurno(temp.get("turno")!= null ? String.valueOf(temp.get("turno")) : null);
          obj.setFecha(java.sql.Date.valueOf(String.valueOf(temp.get("fechaAsignacion"))));
          obj.setEstado(temp.get("estado")!= null ? String.valueOf(temp.get("estado")) : null);



          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      System.err.println("Error de conexión: " + e.getMessage());
    }
    return lista;
  }


}
