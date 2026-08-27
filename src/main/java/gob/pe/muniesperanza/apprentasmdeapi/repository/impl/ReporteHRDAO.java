package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ReporteHRBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ReporteHRIDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ReporteHRDAO   extends SimpleJdbcDaoBase implements ReporteHRIDAO {


  public ReporteHRDAO(DataSource dataSource) {
    super(dataSource);
  }

 // private static final String LISTAR_REPORTE_HR = "select * from dbo.vw_reporte_hr where 1=1";

  @Override
  public List<ReporteHRBean> listar(Integer codContribuyente) throws Exception   {
    int anio = LocalDate.now().getYear();
    String sql ="select * from vw_reporte_hr where  codContribuyente ="+codContribuyente + " and  anio = "+anio;
   // LISTAR_REPORTE_HR.concat(sql);
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ReporteHRBean.class));
  }

}
