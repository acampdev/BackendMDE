package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.ReportePUBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ReportePUIDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
@Repository
public class ReportePUDAO  extends SimpleJdbcDaoBase implements ReportePUIDAO {


  public ReportePUDAO(DataSource dataSource) {
    super(dataSource);
  }

  private static final String LISTAR_REPORTE_PU = "select distinct * from dbo.vw_reporte_pu where 1=1";

  @Override
  public List<ReportePUBean> listar(Integer codContribuyente) throws Exception   {
    int anio = LocalDate.now().getYear();
    String reportePU =
            LISTAR_REPORTE_PU.concat("  and codContribuyente ="+codContribuyente + "  and anio="+anio);
    return jdbcTemplate.query(reportePU, new BeanPropertyRowMapper<>(ReportePUBean.class));
  }

}
