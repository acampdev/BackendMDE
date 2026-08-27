package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioParquesJardinesBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioSerenazgoBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArbitrioParquesJardinesIDAO;
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
public class ArbitrioParquesJardinesDAO  extends SimpleJdbcDaoBase implements ArbitrioParquesJardinesIDAO {


  public ArbitrioParquesJardinesDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public ClsResultDAO insertarArbitrioParquesJardines(ArbitrioParquesJardinesBean arbitrioParquesJardinesBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_parquesJardines")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodRuta", Types.VARCHAR),
                                            new SqlParameter("CodUbicacion", Types.VARCHAR),
                                            new SqlParameter("TasaAnual", Types.DECIMAL),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("Anio", arbitrioParquesJardinesBean.getAnio());
      inParams.put("CodRuta", arbitrioParquesJardinesBean.getCodRuta());
      inParams.put("CodUbicacion", arbitrioParquesJardinesBean.getCodUbicacion());
      inParams.put("TasaAnual", arbitrioParquesJardinesBean.getTasaAnual());
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
  public ClsResultDAO actualizarArbitrioParquesJardines(ArbitrioParquesJardinesBean arbitrioParquesJardinesBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_parquesJardines")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodRuta", Types.VARCHAR),
                                            new SqlParameter("CodUbicacion", Types.VARCHAR),
                                            new SqlParameter("TasaAnual", Types.DECIMAL),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("Anio", arbitrioParquesJardinesBean.getAnio());
      inParams.put("CodRuta", arbitrioParquesJardinesBean.getCodRuta());
      inParams.put("CodUbicacion", arbitrioParquesJardinesBean.getCodUbicacion());
      inParams.put("TasaAnual", arbitrioParquesJardinesBean.getTasaAnual());
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
  public List<ArbitrioParquesJardinesBean> listarArbitrioParquesJardines(Integer anio) throws Exception   {

    List<ArbitrioParquesJardinesBean> lista = new ArrayList<ArbitrioParquesJardinesBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_arbitrio_parquesJardines").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodRuta", Types.VARCHAR),
                                            new SqlParameter("CodUbicacion", Types.VARCHAR),
                                            new SqlParameter("TasaAnual", Types.DECIMAL),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("Anio", anio);
      inParams.put("CodRuta", null);
      inParams.put("CodUbicacion", null);
      inParams.put("TasaAnual",  null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          ArbitrioParquesJardinesBean obj = new ArbitrioParquesJardinesBean();
          // obj.setAnio(Integer.valueOf(String.valueOf(temp.get("anio"))));
          obj.setNombreRuta(temp.get("nombreRuta")!= null ? String.valueOf(temp.get("nombreRuta")) :
                                         null);
          obj.setUbicacionAreaVerde(temp.get("ubicacionAreaVerde")!= null ? String.valueOf(temp.get("ubicacionAreaVerde")) :
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
