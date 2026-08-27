package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ResolucionInteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.VencimientoBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PredioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ResolucionInteresIDAO;
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
public class ResolucionInteresDAO  extends SimpleJdbcDaoBase implements ResolucionInteresIDAO {


  public ResolucionInteresDAO(DataSource dataSource) {
    super(dataSource);
  }

  public ClsResultDAO insertar(ResolucionInteresBean resolucionInteresBean) throws  Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_resolucionInteres")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodResolucionInteres", Types.VARCHAR),
                                            new SqlParameter("Descripcion", Types.VARCHAR),
                                            new SqlParameter("AnioFiscal", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodResolucionInteres", resolucionInteresBean.getCodResolucionInteres());
      inParams.put("Descripcion", resolucionInteresBean.getDescripcion());
      inParams.put("AnioFiscal", resolucionInteresBean.getAnioFiscal());
      inParams.put("Tasa", resolucionInteresBean.getTasa());
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

  public ClsResultDAO actualizar(ResolucionInteresBean resolucionInteresBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_resolucionInteres")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodResolucionInteres", Types.VARCHAR),
                                            new SqlParameter("Descripcion", Types.VARCHAR),
                                            new SqlParameter("AnioFiscal", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("CodResolucionInteres", resolucionInteresBean.getCodResolucionInteres());
      inParams.put("Descripcion", resolucionInteresBean.getDescripcion());
      inParams.put("AnioFiscal", resolucionInteresBean.getAnioFiscal());
      inParams.put("Tasa", resolucionInteresBean.getTasa());
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

  public ClsResultDAO eliminar(ResolucionInteresBean resolucionInteresBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_resolucionInteres")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodResolucionInteres", Types.VARCHAR),
                                            new SqlParameter("Descripcion", Types.VARCHAR),
                                            new SqlParameter("AnioFiscal", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // Tipo 3 es para
      inParams.put("CodResolucionInteres", resolucionInteresBean.getCodResolucionInteres());
      inParams.put("Descripcion", resolucionInteresBean.getDescripcion());
      inParams.put("AnioFiscal", resolucionInteresBean.getAnioFiscal());
      inParams.put("Tasa", resolucionInteresBean.getTasa());
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

  public List<ResolucionInteresBean> listar(Integer codResolucionInteres) throws Exception{

    List<ResolucionInteresBean> lista = new ArrayList<ResolucionInteresBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_resolucionInteres")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodResolucionInteres", Types.VARCHAR),
                                            new SqlParameter("Descripcion", Types.VARCHAR),
                                            new SqlParameter("AnioFiscal", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // Tipo 4 es para  listar
      inParams.put("CodResolucionInteres", codResolucionInteres);
      inParams.put("Descripcion", null);
      inParams.put("AnioFiscal", null);
      inParams.put("Tasa", null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          ResolucionInteresBean obj = new ResolucionInteresBean();
          obj.setCodResolucionInteres(Integer.valueOf(String.valueOf(temp.get("codResolucioninteres"))));
          obj.setDescripcion(temp.get("descripcion")!= null ?
                                String.valueOf(temp.get("descripcion")) :
                                null);

          obj.setFechaInicio(Date.valueOf(String.valueOf(temp.get("fechaInicio"))));
          obj.setFechaFin(Date.valueOf(String.valueOf(temp.get("fechaFin"))));

          obj.setCodEstado(String.valueOf(temp.get("codEstado")));
          obj.setEstado(temp.get("estado")!= null ?
                                      String.valueOf(temp.get("estado")) :
                                      null);
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
