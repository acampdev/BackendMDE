package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.TimBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TimCboBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.model.Barrio;
import gob.pe.muniesperanza.apprentasmdeapi.repository.TimIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
public class TimDAO extends SimpleJdbcDaoBase implements TimIDAO {

  private static final String LISTAR_TIM_CBO = "SELECT * FROM cbo_tim";
  public TimDAO(DataSource dataSource) {
    super(dataSource);
  }

  /*
  @Override
  public ClsResultDAO insertar(TimBean timBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_interes")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodTIM", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodTributo", Types.INTEGER),
                                            new SqlParameter("Periodo", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.INTEGER),
                                            new SqlParameter("CodResolucionInteres", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Respuesta", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodTIM", timBean.getICodTIM());
      inParams.put("Anio", timBean.getAnio());
      inParams.put("CodTributo", timBean.getCodTributo());
      inParams.put("Periodo", timBean.getPeriodo());
      inParams.put("Tasa", timBean.getTasa());
      inParams.put("CodResolucionInteres", timBean.getCodResolucionInteres());
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
  */

  @Override
  public ClsResultDAO actualizar(TimBean timBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_tim")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodTIM", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodTributo", Types.INTEGER),
                                            new SqlParameter("Periodo", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("CodResolucionInteres", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para acualizar
      inParams.put("CodTIM", timBean.getCodTIM());
      inParams.put("Anio", timBean.getAnio());
      inParams.put("CodTributo", timBean.getCodTributo());
      inParams.put("Periodo", timBean.getPeriodo());
      inParams.put("Tasa", timBean.getTasa());
      inParams.put("CodResolucionInteres", timBean.getCodResolucionInteres());
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
  public ClsResultDAO eliminar(TimBean timBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_tim")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodTIM", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodTributo", Types.INTEGER),
                                            new SqlParameter("Periodo", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("CodResolucionInteres", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // Tipo 3 es para eliminar
      inParams.put("CodTIM", timBean.getCodTIM());
      inParams.put("Anio", timBean.getAnio());
      inParams.put("CodTributo", timBean.getCodTributo());
      inParams.put("Periodo", timBean.getPeriodo());
      inParams.put("Tasa", timBean.getTasa());
      inParams.put("CodResolucionInteres", timBean.getCodResolucionInteres());

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
  public List<TimBean> listar(Integer anio,Integer periodo, Integer codTributo, Integer codResolucionInteres) throws Exception {
    List<TimBean> lista = new ArrayList<TimBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_tim")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodTIM", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodTributo", Types.INTEGER),
                                            new SqlParameter("Periodo", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("CodResolucionInteres", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // listar
      inParams.put("CodTIM",null);
      inParams.put("Anio", anio);
      inParams.put("CodTributo", codTributo);
      inParams.put("Periodo", periodo);
      inParams.put("Tasa", null);
      inParams.put("CodResolucionInteres", codResolucionInteres);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          TimBean obj = new TimBean();

          obj.setCodTIM(temp.get("codTim")!= null ? Integer.parseInt(String.valueOf(temp.get("codTim"))) : null);
          obj.setAnio(temp.get("anio")!= null ? Integer.parseInt(String.valueOf(temp.get("Anio"))) : null);
          obj.setTasa(temp.get("Tasa")!= null ? Double.parseDouble(String.valueOf(temp.get("Tasa"))) : null);
          obj.setPeriodo(temp.get("periodo")!= null ? Integer.parseInt(String.valueOf(temp.get("periodo"))) : null);
          obj.setCodResolucionInteres(temp.get("codResolucionInteres")!= null ? Integer.parseInt(String.valueOf(temp.get(
                  "codResolucionInteres"))) : null);
           obj.setCodTributo(temp.get("codTributo")!= null ?
                                     Integer.parseInt(String.valueOf(temp.get("codTributo"))) : null);

          obj.setMes(temp.get("mes")!= null ? String.valueOf(temp.get("mes")) : null);
          obj.setResolucion(temp.get("resolucion")!= null ? String.valueOf(temp.get("resolucion")) : null);
          obj.setEstadoResolucion(temp.get("estadoResolucion")!= null ? String.valueOf(temp.get("estadoResolucion")) :
                                          null);
          obj.setFechaInicio(temp.get("fechaInicio")!= null ?
                                     Date.valueOf(String.valueOf(temp.get("fechaInicio"))) : null);
          obj.setFechaFin(temp.get("fechaFin")!= null ?
                                     Date.valueOf(String.valueOf(temp.get("fechaFin"))) : null);
          obj.setTributo(temp.get("tributo")!= null ? String.valueOf(temp.get("tributo")) :
                                          null);
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
  public List<TimCboBean> listarTimCbo() {
    return jdbcTemplate.query(LISTAR_TIM_CBO, new BeanPropertyRowMapper<>(TimCboBean.class));
  }
}