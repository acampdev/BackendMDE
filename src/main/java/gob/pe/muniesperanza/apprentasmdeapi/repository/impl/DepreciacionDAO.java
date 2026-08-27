package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.DepreciacionBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArancelIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.DepreciacionIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepreciacionDAO extends SimpleJdbcDaoBase implements DepreciacionIDAO {


  public DepreciacionDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public ClsResultDAO insertarDepreciacion(DepreciacionBean depreciacionBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_depreciacion")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodDepreciacion", Types.VARCHAR),
                                            new SqlParameter("CodDepreciacionAnterior", Types.VARCHAR),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodTipoCasa", Types.VARCHAR),
                                            new SqlParameter("CodNivelAntiguedad", Types.VARCHAR),
                                            new SqlParameter("CodMaterialEstructural", Types.VARCHAR),
                                            new SqlParameter("MuyBueno", Types.DECIMAL),
                                            new SqlParameter("Bueno", Types.DECIMAL),
                                            new SqlParameter("Regular", Types.DECIMAL),
                                            new SqlParameter("Malo", Types.DECIMAL),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodDepreciacion", null);
      inParams.put("CodDepreciacionAnterior", depreciacionBean.getCodDepreciacionAnterior());
      inParams.put("Anio", depreciacionBean.getAnio());
      inParams.put("CodTipoCasa", depreciacionBean.getCodTipoCasa());
      inParams.put("CodNivelAntiguedad", depreciacionBean.getCodNivelAntiguedad());
      inParams.put("CodMaterialEstructural", depreciacionBean.getCodMaterialEstructural());
      inParams.put("MuyBueno", depreciacionBean.getMuyBueno());
      inParams.put("Bueno", depreciacionBean.getBueno());
      inParams.put("Regular", depreciacionBean.getRegular());
      inParams.put("Malo", depreciacionBean.getMalo());
      inParams.put("CodUsuario", 1);

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
  public ClsResultDAO actualizarDepreciacion(DepreciacionBean depreciacionBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_depreciacion")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodDepreciacion", Types.VARCHAR),
                                            new SqlParameter("CodDepreciacionAnterior", Types.VARCHAR),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodTipoCasa", Types.VARCHAR),
                                            new SqlParameter("CodNivelAntiguedad", Types.VARCHAR),
                                            new SqlParameter("CodMaterialEstructural", Types.VARCHAR),
                                            new SqlParameter("MuyBueno", Types.DECIMAL),
                                            new SqlParameter("Bueno", Types.DECIMAL),
                                            new SqlParameter("Regular", Types.DECIMAL),
                                            new SqlParameter("Malo", Types.DECIMAL),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("CodDepreciacion", depreciacionBean.getCodDepreciacion());
      inParams.put("CodDepreciacionAnterior", depreciacionBean.getCodDepreciacionAnterior());
      inParams.put("Anio", depreciacionBean.getAnio());
      inParams.put("CodTipoCasa", depreciacionBean.getCodTipoCasa());
      inParams.put("CodNivelAntiguedad", depreciacionBean.getCodNivelAntiguedad());
      inParams.put("CodMaterialEstructural", depreciacionBean.getCodMaterialEstructural());
      inParams.put("MuyBueno", depreciacionBean.getMuyBueno());
      inParams.put("Bueno", depreciacionBean.getBueno());
      inParams.put("Regular", depreciacionBean.getRegular());
      inParams.put("Malo", depreciacionBean.getMalo());
      inParams.put("CodUsuario", 1);
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
  public List<DepreciacionBean> listarDepreciacion(Integer anio, String codTipoCasa) throws Exception {

    List<DepreciacionBean> lista = new ArrayList<DepreciacionBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_depreciacion").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodDepreciacion", Types.VARCHAR),
                                            new SqlParameter("CodDepreciacionAnterior", Types.VARCHAR),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodTipoCasa", Types.VARCHAR),
                                            new SqlParameter("CodNivelAntiguedad", Types.VARCHAR),
                                            new SqlParameter("CodMaterialEstructural", Types.VARCHAR),
                                            new SqlParameter("MuyBueno", Types.DECIMAL),
                                            new SqlParameter("Bueno", Types.DECIMAL),
                                            new SqlParameter("Regular", Types.DECIMAL),
                                            new SqlParameter("Malo", Types.DECIMAL),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("CodDepreciacion", null);
      inParams.put("CodDepreciacionAnterior", null);
      inParams.put("Anio", anio);
      inParams.put("CodTipoCasa", codTipoCasa);
      inParams.put("CodNivelAntiguedad", null);
      inParams.put("CodMaterialEstructural", null);
      inParams.put("MuyBueno", null);
      inParams.put("Bueno", null);
      inParams.put("Regular", null);
      inParams.put("Malo", null);
      inParams.put("CodUsuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String, Object>>) result.get("#result-set-1");

      if (listaBd != null && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          DepreciacionBean obj = new DepreciacionBean();
          obj.setCodDepreciacion(temp.get("codDepreciacion") != null ? String.valueOf(temp.get("codDepreciacion")) : null);
          obj.setAnio(temp.get("Anio") != null ? Integer.parseInt(temp.get("Anio").toString()) : null);
          obj.setCodTipoCasa(temp.get("CodTipoCasa") != null ? String.valueOf(temp.get("CodTipoCasa")) : null);
          obj.setCodNivelAntiguedad(temp.get("CodNivelAntiguedad") != null ? String.valueOf(temp.get("CodNivelAntiguedad")) : null);
          obj.setCodMaterialEstructural(temp.get("CodMaterialEstructural") != null ? String.valueOf(temp.get(
                  "CodMaterialEstructural")) : null);
          obj.setNivelAntiguedad(temp.get("nivelAntiguedad") != null ? String.valueOf(temp.get("nivelAntiguedad")) :
                                         null);
          obj.setMaterialEstructural(temp.get("materialEstructural") != null ? String.valueOf(temp.get(
                  "materialEstructural")) : null);
          obj.setMuyBueno(temp.get("muyBueno") != null ? Double.valueOf(String.valueOf(temp.get("muyBueno"))) : null);
          obj.setBueno(temp.get("bueno") != null ? Double.valueOf(String.valueOf(temp.get("bueno"))) : null);
          obj.setRegular(temp.get("regular") != null ? Double.valueOf(String.valueOf(temp.get("regular"))) : null);
          obj.setMalo(temp.get("malo") != null ? Double.valueOf(String.valueOf(temp.get("malo"))) : null);


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








