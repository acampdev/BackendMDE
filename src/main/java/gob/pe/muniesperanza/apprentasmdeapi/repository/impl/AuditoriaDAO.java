package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AuditoriaBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AuditoriaIDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AuditoriaDAO  extends SimpleJdbcDaoBase implements AuditoriaIDAO {

  //  Constructor
  public AuditoriaDAO(DataSource dataSource) {
    super(dataSource);
  }



  // Query para llamar a la vista
  private static final String LISTAR = "SELECT * FROM vw_auditoria";

  @Override
  public List<AuditoriaBean> listar() {
    return jdbcTemplate.query(LISTAR, new BeanPropertyRowMapper<>(AuditoriaBean.class));
  }
}
