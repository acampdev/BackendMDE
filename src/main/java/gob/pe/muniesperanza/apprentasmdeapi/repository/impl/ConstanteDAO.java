package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.*;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ConstanteIDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
public class ConstanteDAO  extends SimpleJdbcDaoBase implements ConstanteIDAO {


  public ConstanteDAO(DataSource dataSource) {
    super(dataSource);
  }

  private static final String LISTAR_GRUPO_USO = "  select I_CodGrupoUso codigo,V_Descripcion descripcion from grupo_uso";
  private static final String LISTAR_RUTA =         "  select I_CodRuta codigo,V_Descripcion descripcion," +
                                                                 "V_Abreviatura abreviatura from ruta";
  private static final String LISTAR_UBICACION_AREA_VERDE =         "  select I_CodUbicacionAreaVerde codigo,V_Descripcion " +
                                                                 "descripcion, V_Abreviatura abreviatura from ubicacion_areaverde" ;
  private static final String LISTAR_USO_PREDIO =         "  select I_CodUso codUso,V_Descripcion descripcion," +
                                                                 "I_CodCriterio codCriterio,I_CodGrupoUso codGrupoUso from uso" ;
  private static final String LISTAR_ZONA =         "  select I_CodZona codigo,V_Descripcion descripcion, " +
                                                          "V_Abreviatura abreviatura from zona ";


  @Override
  public List<ConstanteBean> listarConstantePadre(String codConstante) throws Exception   {

    List<ConstanteBean> lista = new ArrayList<ConstanteBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_constantes").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("codConstante", Types.VARCHAR)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 1); // Tipo 1 es para listar padre
      inParams.put("codConstante", codConstante);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          ConstanteBean obj = new ConstanteBean();
          obj.setCodConstante(String.valueOf(temp.get("codConstante")));
          obj.setNombreCategoria(String.valueOf(temp.get("nombreCategoria")));
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
  public List<ConstanteBean> listarConstanteHijo(String codConstante) throws Exception   {

    List<ConstanteBean> lista = new ArrayList<ConstanteBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_constantes").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("codConstante", Types.VARCHAR)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 2); // Tipo 1 es para listar hijo
      inParams.put("codConstante", codConstante);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          ConstanteBean obj = new ConstanteBean();
          obj.setCodConstante(String.valueOf(temp.get("codConstante")));
          obj.setNombreCategoria(String.valueOf(temp.get("nombreCategoria")));
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
  public List<GrupoUsoBean> listarGrupoUso() {
    return jdbcTemplate.query(LISTAR_GRUPO_USO, new BeanPropertyRowMapper<>(GrupoUsoBean.class));
  }
  @Override
  public List<RutaBean> listarRuta() {
    return jdbcTemplate.query(LISTAR_RUTA, new BeanPropertyRowMapper<>(RutaBean.class));
  }
  @Override
  public List<UbicacionAreaVerde> listarUbicacionAreaVerde() {
    return jdbcTemplate.query(LISTAR_UBICACION_AREA_VERDE, new BeanPropertyRowMapper<>(UbicacionAreaVerde.class));
  }
  @Override
  public List<UsoPredio> listarUsoPredio() {
    return jdbcTemplate.query(LISTAR_USO_PREDIO, new BeanPropertyRowMapper<>(UsoPredio.class));
  }
  @Override
  public List<ZonaBean> listarZona() {
    return jdbcTemplate.query(LISTAR_ZONA, new BeanPropertyRowMapper<>(ZonaBean.class));
  }
}
