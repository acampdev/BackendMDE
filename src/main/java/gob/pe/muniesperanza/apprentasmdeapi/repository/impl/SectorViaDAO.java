package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.model.SectorVia;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SectorViaIDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SectorViaDAO extends SimpleJdbcDaoBase implements SectorViaIDAO {

  public SectorViaDAO(DataSource dataSource) {
    super(dataSource);
  }

  // Query para llenar el combo de sectores y vias
  private static final String LLENAR_COMBO = "SELECT * FROM SectorVia";

  @Override
  public List<SectorVia> llenarCombo(){
    return jdbcTemplate.query(LLENAR_COMBO, new BeanPropertyRowMapper<>(SectorVia.class));
  }
}
