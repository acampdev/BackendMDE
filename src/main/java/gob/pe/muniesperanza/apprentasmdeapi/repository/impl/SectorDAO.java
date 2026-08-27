package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CuadranteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TipoUnidadUrbanaBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SectorIDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SectorDAO extends SimpleJdbcDaoBase implements SectorIDAO {

  private static final String LISTAR_SECTOR = "SELECT * FROM vw_sectores where  1=1 ";
  private static final String BUSCAR_SECTOR = "SELECT I_CodSector as codSector, V_Nombre as nombreSector FROM SECTOR WHERE I_CodSector = ?";
  private static final String SP_SECTOR = "sp_sectores";
  private static final String CATALOG_NAME = "dbo";

  private static final String LISTAR_CUADRANTE = "SELECT  codCuadrante,descripcionCuadrante descripcion FROM vw_cuadrantes ";
  private static final String LISTAR_TIPO_UNIDAD_URBANA = "SELECT  *  FROM vw_tipoUnidadUrbana ";


  public SectorDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public List<Sector> listarSectorCodigoNombre(Integer codSector, String nombre) {

    String sql = LISTAR_SECTOR;
    if (codSector != null && codSector > 0) {
      sql = sql + " and codSector =   "+ codSector +" ";
    }

    if (nombre != null) {
      sql = sql + " and nombreSector like   '%"+ nombre +"%' ";
    }


    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Sector.class));
  }

  @Override
  public List<Sector> listarSector() {
    return jdbcTemplate.query(LISTAR_SECTOR, new BeanPropertyRowMapper<>(Sector.class));
  }

  private void executeStoredProcedure(int tipo, Integer codSector,Integer codUnidadUrbana, String nombre,
                                      Integer cuadrante) {
    SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                  .withCatalogName(CATALOG_NAME)
                                  .withProcedureName(SP_SECTOR)
                                  .withoutProcedureColumnMetaDataAccess()
                                  .declareParameters(
                                          new SqlParameter("Tipo", Types.INTEGER),
                                          new SqlParameter("CodSector", Types.INTEGER),
                                          new SqlParameter("CodUnidadUrbana", Types.INTEGER),
                                          new SqlParameter("Nombre", Types.VARCHAR),
                                          new SqlParameter("Cuadrante", Types.INTEGER),
                                          new SqlParameter("CodUsuario", Types.INTEGER),
                                          new SqlOutParameter("Mensaje", Types.VARCHAR),
                                          new SqlOutParameter("Respuesta", Types.INTEGER)
                                  );

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("Tipo", tipo);
    parameters.put("CodSector", codSector);
    parameters.put("CodUnidadUrbana", codUnidadUrbana);
    parameters.put("Nombre", nombre);
    parameters.put("Cuadrante", cuadrante);
    parameters.put("CodUsuario", 1);

    Map<String, Object> result = stmt.execute(parameters);

    // Opcional: usar o loguear mensaje y respuesta
    String mensaje = (String) result.get("Mensaje");
    Integer respuesta = (Integer) result.get("Respuesta");

    System.out.println("SP_SECTOR → Respuesta: " + respuesta + ", Mensaje: " + mensaje);

    if (respuesta != null && respuesta != 1) {
      throw new RuntimeException("Error del SP: " + mensaje);
    }
  }

  @Override
  public Sector insertarSector(Sector sector) {
    try {
      executeStoredProcedure(1, null, sector.getCodUnidadUrbana(), sector.getNombreSector(),sector.getCodCuadrante());
      return sector;
    } catch (Exception e) {
      throw new RuntimeException("Error al insertar sector: " + e.getMessage(), e);
    }
  }

  @Override
  public Sector actualizarSector(Sector sector) {
    try {
      executeStoredProcedure(2, sector.getCodSector(), sector.getCodUnidadUrbana(), sector.getNombreSector(),
              sector.getCodCuadrante());
      return jdbcTemplate.queryForObject(
              BUSCAR_SECTOR,
              new BeanPropertyRowMapper<>(Sector.class),
              sector.getCodSector()
      );
    } catch (Exception e) {
      throw new RuntimeException("Error al actualizar sector: " + e.getMessage(), e);
    }
  }

  @Override
  public List<CuadranteBean> listarCuadrante() {
    return jdbcTemplate.query(LISTAR_CUADRANTE, new BeanPropertyRowMapper<>(CuadranteBean.class));
  }


  @Override
  public List<TipoUnidadUrbanaBean> listarTipoUnidadUrbana() {
    return jdbcTemplate.query(LISTAR_TIPO_UNIDAD_URBANA, new BeanPropertyRowMapper<>(TipoUnidadUrbanaBean.class));
  }
}