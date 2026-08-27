package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.model.Barrio;
import gob.pe.muniesperanza.apprentasmdeapi.repository.BarrioIDAO;
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
public class BarrioDAO extends SimpleJdbcDaoBase implements BarrioIDAO {

  //  Constructor
  public BarrioDAO(DataSource dataSource) {
    super(dataSource);
  }



  // Query para llamar a la vista
  private static final String LISTAR_BARRIO = "SELECT * FROM vw_barrios";
  private static final String CATALOG_NAME = "dbo";
  private static final String SP_BARRIO = "sp_barrios";
  private static final String BUSCAR_BARRIO = "SELECT I_CodBarrio codBarrio,I_CodSector codSector, V_Nombre nombreBarrio FROM BARRIO WHERE I_CodBarrio  = ?";

  // Metodo para listar barrios
  @Override
  public List<Barrio> listarBarrio() {
    return jdbcTemplate.query(LISTAR_BARRIO, new BeanPropertyRowMapper<>(Barrio.class));
  }

  //  Metodo para insertar barrios
  public Barrio insertarBarrio(Barrio barrio) {
    try{
      executeStoredProcedure(1, null, barrio.getNombreBarrio(),barrio.getCodSector());
      return barrio;
    }catch(Exception e){
      throw new RuntimeException("Error al insertar barrio: " + e.getMessage(), e);
    }
  }

  // Metodo para actualizar barrios
  public Barrio actualizarBarrio(Barrio barrio) {
    try{
      executeStoredProcedure(2, barrio.getCodBarrio(), barrio.getNombreBarrio(),barrio.getCodSector());
      return jdbcTemplate.queryForObject(
              BUSCAR_BARRIO,
              new BeanPropertyRowMapper<>(Barrio.class),
              barrio.getCodBarrio()
      );
    }catch(Exception e){
      throw new RuntimeException("Error al actualizar barrio: " + e.getMessage(), e);
    }
  }

  private void executeStoredProcedure(int tipo, Integer codBarrio, String nombre,Integer codSector) {
    SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                  .withCatalogName(CATALOG_NAME)
                                  .withProcedureName(SP_BARRIO)
                                  .withoutProcedureColumnMetaDataAccess()
                                  .declareParameters(
                                          new SqlParameter("Tipo", Types.INTEGER),
                                          new SqlParameter("CodBarrio", Types.INTEGER),
                                          new SqlParameter("NombreBarrio", Types.VARCHAR),
                                          new SqlParameter("CodSector", Types.INTEGER),
                                          new SqlParameter("CodUsuario", Types.INTEGER),
                                          new SqlOutParameter("Mensaje", Types.VARCHAR),
                                          new SqlOutParameter("Respuesta", Types.INTEGER)
                                  );

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("Tipo", tipo);
    parameters.put("CodBarrio", codBarrio);
    parameters.put("NombreBarrio", nombre);
    parameters.put("CodSector", codSector);
    parameters.put("CodUsuario", 1);


    Map<String, Object> result = stmt.execute(parameters);

    // Opcional: usar o loguear mensaje y respuesta
    String mensaje = (String) result.get("Mensaje");
    Integer respuesta = (Integer) result.get("Respuesta");

    System.out.println("SP_BARRIO → Respuesta: " + respuesta + ", Mensaje: " + mensaje);

    if (respuesta != null && respuesta != 1) {
      throw new RuntimeException("Error del SP: " + mensaje);
    }
  }
}
