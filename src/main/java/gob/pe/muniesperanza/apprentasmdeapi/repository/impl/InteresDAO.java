package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PersonaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PisoBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.InteresIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PisoIDAO;
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
public class InteresDAO extends SimpleJdbcDaoBase implements InteresIDAO {



  public InteresDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public List<InteresBean> listar(Integer anio) throws Exception {
    List<InteresBean> lista = new ArrayList<InteresBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_interes")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodInteres", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("CodTipo", Types.VARCHAR),
                                            new SqlParameter("CodClase", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // listar
      inParams.put("CodInteres",null);
      inParams.put("Anio", anio);
      inParams.put("Tasa", null);
      inParams.put("CodTipo", null);
      inParams.put("CodClase", null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          InteresBean obj = new InteresBean();

          obj.setCodInteres(temp.get("CodInteres")!= null ? Integer.parseInt(String.valueOf(temp.get("CodInteres"))) : null);
          obj.setAnio(temp.get("Anio")!= null ? Integer.parseInt(String.valueOf(temp.get("Anio"))) : null);
          obj.setTasa(temp.get("Tasa")!= null ? Double.parseDouble(String.valueOf(temp.get("Tasa"))) : null);
          obj.setCodTipo(temp.get("CodTipo")!= null ? String.valueOf(temp.get("CodTipo")) : null);
          obj.setCodClase(temp.get("CodClase")!= null ? String.valueOf(temp.get("CodClase")) : null);
          obj.setCodEstado(temp.get("CodEstado")!= null ? String.valueOf(temp.get("CodEstado")) : null);
          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar sp_interes: " + e.getMessage(), e);
    }
    // return null;
  }
  @Override
  public ClsResultDAO insertar(InteresBean interesBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_interes")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodInteres", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("CodTipo", Types.VARCHAR),
                                            new SqlParameter("CodClase", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 2 es para insertar
      inParams.put("CodInteres", interesBean.getCodInteres());
      inParams.put("Anio", interesBean.getAnio());
      inParams.put("Tasa", interesBean.getTasa());
      inParams.put("CodTipo", interesBean.getCodTipo());
      inParams.put("CodClase", interesBean.getCodClase());
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      String mensaje = (String) result.get("Mensaje");
      Integer respuesta = (Integer) result.get("Respuesta");

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
  public ClsResultDAO actualizar(InteresBean interesBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_interes")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodInteres", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("CodTipo", Types.VARCHAR),
                                            new SqlParameter("CodClase", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 3 es para acualizar
      inParams.put("CodInteres", interesBean.getCodInteres());
      inParams.put("Anio", interesBean.getAnio());
      inParams.put("Tasa", interesBean.getTasa());
      inParams.put("CodTipo", interesBean.getCodTipo());
      inParams.put("CodClase", interesBean.getCodClase());

      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      String mensaje = (String) result.get("Mensaje");
      Integer respuesta = (Integer) result.get("Respuesta");

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
  public ClsResultDAO inactivar(InteresBean interesBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_interes")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodInteres", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("CodTipo", Types.VARCHAR),
                                            new SqlParameter("CodClase", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // Tipo 3 es para eliminar
      inParams.put("CodInteres", interesBean.getCodInteres());
      inParams.put("Anio", interesBean.getAnio());
      inParams.put("Tasa", interesBean.getTasa());
      inParams.put("CodTipo", interesBean.getCodTipo());
      inParams.put("CodClase", interesBean.getCodClase());

      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      String mensaje = (String) result.get("Mensaje");
      Integer respuesta = (Integer) result.get("Respuesta");

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

}
