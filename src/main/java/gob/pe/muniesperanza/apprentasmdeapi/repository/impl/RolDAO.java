package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.RolBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.RolIDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class RolDAO  extends SimpleJdbcDaoBase implements RolIDAO {

  private static final String LISTAR = "select I_CodRol codRol ,V_Descripcion descripcion FROM dbo.rol where  1=1 ";

  public RolDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public List<RolBean> listar() {
    return jdbcTemplate.query(LISTAR, new BeanPropertyRowMapper<>(RolBean.class));
  }
}
