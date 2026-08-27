package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioLimpiezaPublicaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioSerenazgoBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArbitrioLimpiezaPublicaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArbitrioSerenazgoIDAO;
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
public class ArbitrioLimpiezaPublicaDAO  extends SimpleJdbcDaoBase implements ArbitrioLimpiezaPublicaIDAO {


  public ArbitrioLimpiezaPublicaDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public ClsResultDAO insertarArbitrioLimpiezaPublica(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_limpiezaPublica")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("TasaMensual", Types.DECIMAL),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodCriterio", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("Anio", arbitrioLimpiezaPublicaBean.getAnio());
      inParams.put("TasaMensual", arbitrioLimpiezaPublicaBean.getTasaMensual());
      inParams.put("CodZona", arbitrioLimpiezaPublicaBean.getCodZona());
      inParams.put("CodCriterio", arbitrioLimpiezaPublicaBean.getCodCriterio());
      inParams.put("Usuario", 1);

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
  public ClsResultDAO actualizarArbitrioLimpiezaPublica(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_limpiezaPublica")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("TasaMensual", Types.DECIMAL),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodCriterio", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("Anio", arbitrioLimpiezaPublicaBean.getAnio());
      inParams.put("TasaMensual", arbitrioLimpiezaPublicaBean.getTasaMensual());
      inParams.put("CodZona", arbitrioLimpiezaPublicaBean.getCodZona());
      inParams.put("CodCriterio", arbitrioLimpiezaPublicaBean.getCodCriterio());
      inParams.put("Usuario", 1);

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
  public List<ArbitrioLimpiezaPublicaBean> listarArbitrioLimpiezaPublica(Integer anio) throws Exception   {

    List<ArbitrioLimpiezaPublicaBean> lista = new ArrayList<ArbitrioLimpiezaPublicaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_limpiezaPublica")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("TasaMensual", Types.DECIMAL),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodCriterio", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("Anio", anio);
      inParams.put("TasaMensual", null);
      inParams.put("CodZona", null);
      inParams.put("CodCriterio",  null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          ArbitrioLimpiezaPublicaBean obj = new ArbitrioLimpiezaPublicaBean();
          // obj.setAnio(Integer.valueOf(String.valueOf(temp.get("anio"))));
          obj.setNombreZona(temp.get("nombreZona")!= null ? String.valueOf(temp.get("nombreZona")) :
                                         null);

          obj.setTasaMensual(temp.get("tasaMensual")!= null ? Double.valueOf(String.valueOf(temp.get(
                  "tasaMensual"))):  null);
          obj.setTasaAnual(temp.get("tasaAnual")!= null ? Double.valueOf(String.valueOf(temp.get(
                  "tasaAnual"))):  null);

          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      System.err.println("Error de conexión: " + e.getMessage());
    }
    return lista;
  }

  @Override
  public ClsResultDAO insertarArbitrioLimpiezaPublicaOtros(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_limpiezaPublica")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("TasaMensual", Types.DECIMAL),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodCriterio", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // Tipo 1 es para insertar otros
      inParams.put("Anio", arbitrioLimpiezaPublicaBean.getAnio());
      inParams.put("TasaMensual", arbitrioLimpiezaPublicaBean.getTasaMensual());
      inParams.put("CodZona", arbitrioLimpiezaPublicaBean.getCodZona());
      inParams.put("CodCriterio", arbitrioLimpiezaPublicaBean.getCodCriterio());
      inParams.put("Usuario", 1);

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
  public ClsResultDAO actualizarArbitrioLimpiezaPublicaOtros(ArbitrioLimpiezaPublicaBean arbitrioLimpiezaPublicaBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_limpiezaPublica")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("TasaMensual", Types.DECIMAL),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodCriterio", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 5); // Tipo 5 es para actualizar otros
      inParams.put("Anio", arbitrioLimpiezaPublicaBean.getAnio());
      inParams.put("TasaMensual", arbitrioLimpiezaPublicaBean.getTasaMensual());
      inParams.put("CodZona", arbitrioLimpiezaPublicaBean.getCodZona());
      inParams.put("CodCriterio", arbitrioLimpiezaPublicaBean.getCodCriterio());
      inParams.put("Usuario", 1);

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
  public List<ArbitrioLimpiezaPublicaBean> listarArbitrioLimpiezaPublicaOtros(Integer anio) throws Exception   {

    List<ArbitrioLimpiezaPublicaBean> lista = new ArrayList<ArbitrioLimpiezaPublicaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_limpiezaPublica")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("TasaMensual", Types.DECIMAL),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodCriterio", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 6); // Tipo 6 es para listar otros
      inParams.put("Anio", anio);
      inParams.put("TasaMensual", null);
      inParams.put("CodZona", null);
      inParams.put("CodCriterio",  null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          ArbitrioLimpiezaPublicaBean obj = new ArbitrioLimpiezaPublicaBean();
          obj.setCriterioUso(temp.get("criterioUso")!= null ? String.valueOf(temp.get("criterioUso")) :
                                    null);

          obj.setTasaMensual(temp.get("tasaMensual")!= null ? Double.valueOf(String.valueOf(temp.get(
                  "tasaMensual"))):  null);
          obj.setTasaAnual(temp.get("tasaAnual")!= null ? Double.valueOf(String.valueOf(temp.get(
                  "tasaAnual"))):  null);

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

