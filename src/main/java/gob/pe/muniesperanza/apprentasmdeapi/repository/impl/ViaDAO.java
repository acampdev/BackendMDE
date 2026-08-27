package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.model.Via;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ViaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ViaDAO extends SimpleJdbcDaoBase implements ViaIDAO {

  public ViaDAO(DataSource dataSource) {
    super(dataSource);
  }

  // Query para llamar a la vista
  private static final String LISTAR_VIA = "SELECT * FROM vw_vias";

  @Override
  public List<Via> listarVias() {

    return jdbcTemplate.query(LISTAR_VIA, new BeanPropertyRowMapper<>(Via.class));
  }
//
//  //  Metodo para insertar nueva via
  @Override
  public Via insertarVia(Via via) {
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
          .withCatalogName("dbo")
          .withProcedureName("sp_vias")
          .withoutProcedureColumnMetaDataAccess()
          .declareParameters(
              new SqlParameter("Tipo", Types.INTEGER),
              new SqlParameter("CodVia", Types.INTEGER),
              new SqlParameter("NombreVia", Types.VARCHAR),
              new SqlParameter("CodTipoVia", Types.VARCHAR),
              new SqlParameter("CodBarrio", Types.INTEGER),
                  new SqlParameter("CodSector", Types.INTEGER),
                  new SqlParameter("CodUsuario", Types.INTEGER),
              new SqlOutParameter("Mensaje", Types.VARCHAR),
              new SqlOutParameter("Respuesta", Types.INTEGER)
          );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1);
      inParams.put("CodVia", null);
      inParams.put("NombreVia", via.getNombreVia());
      inParams.put("CodTipoVia", via.getCodTipoVia());
      inParams.put("CodBarrio", via.getCodBarrio());
      inParams.put("CodSector", via.getCodSector());

      inParams.put("CodUsuario", 1);

      Map<String, Object> result = stmt.execute(inParams);

      String mensaje = (String) result.get("Mensaje");
      Integer respuesta = (Integer) result.get("Respuesta");

      System.out.println("Respuesta: " + respuesta);
      System.out.println("Mensaje: " + mensaje);

      return via;

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar sp_via: " + e.getMessage(), e);
    }
  }

  @Override
  public ClsResultDAO insertarVias(Via via) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_vias")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodVia", Types.INTEGER),
                                            new SqlParameter("NombreVia", Types.VARCHAR),
                                            new SqlParameter("CodTipoVia", Types.VARCHAR),
                                            new SqlParameter("CodBarrio", Types.INTEGER),
                                            new SqlParameter("CodSector", Types.INTEGER),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodVia", null);
      inParams.put("NombreVia", via.getNombreVia());
      inParams.put("CodTipoVia", via.getCodTipoVia());
      inParams.put("CodBarrio", via.getCodBarrio());
      inParams.put("CodSector", via.getCodSector());
      inParams.put("CodUsuario", 1);
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
  public ClsResultDAO actualizarVia(Via via) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_vias")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodVia", Types.INTEGER),
                                            new SqlParameter("NombreVia", Types.VARCHAR),
                                            new SqlParameter("CodTipoVia", Types.VARCHAR),
                                            new SqlParameter("CodBarrio", Types.INTEGER),
                                            new SqlParameter("CodSector", Types.INTEGER),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("CodVia", via.getCodVia());
      inParams.put("NombreVia", via.getNombreVia());
      inParams.put("CodTipoVia", via.getCodTipoVia());
      inParams.put("CodBarrio", via.getCodBarrio());
      inParams.put("CodSector", via.getCodSector());
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
  public ClsResultDAO obtenerVia(Integer codVia)
          throws Exception{

    ClsResultDAO response = new ClsResultDAO();

    try {

      String sql = "SELECT I_CodVia codVia,C_CodTipoVia codTipoVia, V_Nombre nombreVia FROM Via  where I_CodVia"+codVia;
     // List<Map<String, Object>> listaBd = jdbcTemplate.queryForList(sql);

     List<Via> vias = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Via.class));

      if(!CollectionUtils.isEmpty(vias)) {
        response.put("VIA", vias);
      }

    } catch (Throwable e) {
     // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;
  }


}