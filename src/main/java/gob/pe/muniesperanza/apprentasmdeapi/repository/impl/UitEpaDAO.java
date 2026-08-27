package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;
import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.UitEpaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.UitEpaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UitEpaDAO extends SimpleJdbcDaoBase implements UitEpaIDAO {

  private static final String LISTAR_UIT_EPA = "SELECT * FROM vw_uit_epa WHERE 1=1 ";


  public UitEpaDAO(DataSource dataSource) {
    super(dataSource);
  }


  @Override
  public ClsResultDAO insertarUitEpa(UitEpaBean uitEpaBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_uit_epa")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodUit", Types.INTEGER),
                                            new SqlParameter("Anio", Types.VARCHAR),
                                            new SqlParameter("Valor", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodUit", null);
      inParams.put("Anio", uitEpaBean.getAnio());
      inParams.put("Valor", uitEpaBean.getValor());
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
  public ClsResultDAO actualizarUitEpa(UitEpaBean uitEpaBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_uit_epa")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodUit", Types.INTEGER),
                                            new SqlParameter("Anio", Types.VARCHAR),
                                            new SqlParameter("Valor", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar

      inParams.put("CodUit", uitEpaBean.getCodUit());
      inParams.put("Anio", uitEpaBean.getAnio());
      inParams.put("Valor", uitEpaBean.getValor());
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
  public List<UitEpaBean> listarUitEpa(Integer anio) throws Exception   {

    String sql = LISTAR_UIT_EPA;
    if (anio != null) {
      sql = sql + " and anio =   "+ anio +" ";
    }

    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UitEpaBean.class));
  }

}
