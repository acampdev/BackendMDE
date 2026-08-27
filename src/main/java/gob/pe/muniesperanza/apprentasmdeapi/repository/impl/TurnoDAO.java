package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.TurnoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.UitEpaBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.TurnoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.UitEpaIDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TurnoDAO  extends SimpleJdbcDaoBase implements TurnoIDAO {

  private static final String LISTAR = "SELECT * FROM vw_turno WHERE 1=1 ";


  public TurnoDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public List<TurnoBean> listar() throws Exception   {

    String sql = LISTAR;

    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TurnoBean.class));
  }

}
