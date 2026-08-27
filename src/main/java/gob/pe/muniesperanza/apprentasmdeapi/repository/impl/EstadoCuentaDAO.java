package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioParquesJardinesBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.EstadoCuentaBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArbitrioParquesJardinesIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.EstadoCuentaIDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.*;

@Repository
public class EstadoCuentaDAO extends SimpleJdbcDaoBase implements EstadoCuentaIDAO {


  public EstadoCuentaDAO(DataSource dataSource) {
    super(dataSource);
  }

  public List<EstadoCuentaBean> listar(Integer codContribuyente, Integer anio, String codPredio) throws Exception {

    List<EstadoCuentaBean> lista = new ArrayList<EstadoCuentaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_estadoCuenta").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 1); // Tipo 1 es para listar
      inParams.put("CodContribuyente", codContribuyente);
      inParams.put("Anio", anio);
      inParams.put("CodPredio", codPredio);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String, Object>>) result.get("#result-set-1");

      if (listaBd != null && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          EstadoCuentaBean obj = new EstadoCuentaBean();
          obj.setAnio(Integer.valueOf(String.valueOf(temp.get("anio"))));
          obj.setTotalPredial(temp.get("totalPredial") != null ? Double.valueOf(String.valueOf(temp.get("totalPredial"))) : null);
          obj.setTotalArbitrial(temp.get("totalArbitrial") != null ? Double.valueOf(String.valueOf(temp.get("totalArbitrial"))) :null);
          obj.setTotalCargos(temp.get("totalCargos") != null ? Double.valueOf(String.valueOf(temp.get("totalCargos"))) : null);
          obj.setTotalPagado(temp.get("totalPagado") != null ? Double.valueOf(String.valueOf(temp.get("totalPagado"))) : null);
          obj.setSaldoNeto(temp.get("saldoNeto") != null ? Double.valueOf(String.valueOf(temp.get("saldoNeto"))) : null);



          return obj;

        }).toList();
      }
      return lista;

    } catch (Exception e) {
      System.err.println("Error de conexión: " + e.getMessage());
    }
    return lista;
  }

  public List<EstadoCuentaBean> listarDetalle(Integer codContribuyente, Integer anio, String codPredio) throws Exception {

    List<EstadoCuentaBean> lista = new ArrayList<EstadoCuentaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_estadoCuenta").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 2); // Tipo 2  es para listar
      inParams.put("CodContribuyente", codContribuyente);
      inParams.put("Anio", anio);
      inParams.put("CodPredio", codPredio);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String, Object>>) result.get("#result-set-1");

      if (listaBd != null && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          EstadoCuentaBean obj = new EstadoCuentaBean();
          obj.setAnio(Integer.valueOf(String.valueOf(temp.get("anio"))));
          obj.setTributo(temp.get("tributo") != null ? String.valueOf(temp.get("tributo")) :
                                 null);
          obj.setGrupoTributo(temp.get("grupoTributo") != null ? String.valueOf(temp.get("grupoTributo")) :
                                      null);

          obj.setTotalCargos(temp.get("totalCargos") != null ? Double.valueOf(String.valueOf(temp.get(
                  "totalCargos"))) : null);
          obj.setTotalPagado(temp.get("totalPagado") != null ? Double.valueOf(String.valueOf(temp.get(
                  "totalPagado"))) : null);
          obj.setSaldoNeto(temp.get("saldoNeto") != null ? Double.valueOf(String.valueOf(temp.get(
                  "saldoNeto"))) : null);
          obj.setCargo1(temp.get("cargo_ene") != null ? Double.valueOf(String.valueOf(temp.get("cargo_ene"))) : null);
          obj.setAbono1(temp.get("abono_ene") != null ? Double.valueOf(String.valueOf(temp.get("abono_ene"))) : null);
          obj.setCargo2(temp.get("cargo_feb") != null ? Double.valueOf(String.valueOf(temp.get("cargo_feb"))) : null);
          obj.setAbono2(temp.get("abono_feb") != null ? Double.valueOf(String.valueOf(temp.get("abono_feb"))) : null);
          obj.setCargo3(temp.get("cargo_mar") != null ? Double.valueOf(String.valueOf(temp.get("cargo_mar"))) : null);
          obj.setAbono3(temp.get("abono_mar") != null ? Double.valueOf(String.valueOf(temp.get("abono_mar"))) : null);
          obj.setCargo4(temp.get("cargo_abr") != null ? Double.valueOf(String.valueOf(temp.get("cargo_abr"))) : null);
          obj.setAbono4(temp.get("abono_abr") != null ? Double.valueOf(String.valueOf(temp.get("abono_abr"))) : null);
          obj.setCargo5(temp.get("cargo_may") != null ? Double.valueOf(String.valueOf(temp.get("cargo_may"))) : null);
          obj.setAbono5(temp.get("abono_may") != null ? Double.valueOf(String.valueOf(temp.get("abono_may"))) : null);
          obj.setCargo6(temp.get("cargo_jun") != null ? Double.valueOf(String.valueOf(temp.get("cargo_jun"))) : null);
          obj.setAbono6(temp.get("abono_jun") != null ? Double.valueOf(String.valueOf(temp.get("abono_jun"))) : null);
          obj.setCargo7(temp.get("cargo_jul") != null ? Double.valueOf(String.valueOf(temp.get("cargo_jul"))) : null);
          obj.setAbono7(temp.get("abono_jul") != null ? Double.valueOf(String.valueOf(temp.get("abono_jul"))) : null);
          obj.setCargo8(temp.get("cargo_ago") != null ? Double.valueOf(String.valueOf(temp.get("cargo_ago"))) : null);
          obj.setAbono8(temp.get("abono_ago") != null ? Double.valueOf(String.valueOf(temp.get("abono_ago"))) : null);
          obj.setCargo9(temp.get("cargo_sep") != null ? Double.valueOf(String.valueOf(temp.get("cargo_sep"))) : null);
          obj.setAbono9(temp.get("abono_sep") != null ? Double.valueOf(String.valueOf(temp.get("abono_sep"))) : null);
          obj.setCargo10(temp.get("cargo_oct") != null ? Double.valueOf(String.valueOf(temp.get("cargo_oct"))) : null);
          obj.setAbono10(temp.get("abono_oct") != null ? Double.valueOf(String.valueOf(temp.get("abono_oct"))) : null);
          obj.setCargo11(temp.get("cargo_nov") != null ? Double.valueOf(String.valueOf(temp.get("cargo_nov"))) : null);
          obj.setAbono11(temp.get("abono_nov") != null ? Double.valueOf(String.valueOf(temp.get("abono_nov"))) : null);
          obj.setCargo12(temp.get("cargo_dic") != null ? Double.valueOf(String.valueOf(temp.get("cargo_dic"))) : null);
          obj.setAbono12(temp.get("abono_dic") != null ? Double.valueOf(String.valueOf(temp.get("abono_dic"))) : null);
          obj.setVenc_ene(temp.get("venc_ene") != null ? (Date) temp.get("venc_ene") : null);
          obj.setVenc_feb(temp.get("venc_feb") != null ? (Date) temp.get("venc_feb") : null);
          obj.setVenc_mar(temp.get("venc_mar") != null ? (Date) temp.get("venc_mar") : null);
          obj.setVenc_abr(temp.get("venc_abr") != null ? (Date) temp.get("venc_abr") : null);
          obj.setVenc_may(temp.get("venc_may") != null ? (Date) temp.get("venc_may") : null);
          obj.setVenc_jun(temp.get("venc_jun") != null ? (Date) temp.get("venc_jun") : null);
          obj.setVenc_jul(temp.get("venc_jul") != null ? (Date) temp.get("venc_jul") : null);
          obj.setVenc_ago(temp.get("venc_ago") != null ? (Date) temp.get("venc_ago") : null);
          obj.setVenc_sep(temp.get("venc_sep") != null ? (Date) temp.get("venc_sep") : null);
          obj.setVenc_oct(temp.get("venc_oct") != null ? (Date) temp.get("venc_oct") : null);
          obj.setVenc_nov(temp.get("venc_nov") != null ? (Date) temp.get("venc_nov") : null);
          obj.setVenc_dic(temp.get("venc_dic") != null ? (Date) temp.get("venc_dic") : null);

//          obj.setVenc_ene(temp.get("venc_ene") != null ? ((java.sql.Date) temp.get("venc_ene")).toLocalDate() : null);
//          obj.setVenc_feb(temp.get("venc_feb") != null ? ((java.sql.Date) temp.get("venc_feb")).toLocalDate() : null);
//          obj.setVenc_mar(temp.get("venc_mar") != null ? ((java.sql.Date) temp.get("venc_mar")).toLocalDate() : null);
//          obj.setVenc_abr(temp.get("venc_abr") != null ? ((java.sql.Date) temp.get("venc_abr")).toLocalDate() : null);
//          obj.setVenc_may(temp.get("venc_may") != null ? ((java.sql.Date) temp.get("venc_may")).toLocalDate() : null);
//          obj.setVenc_jun(temp.get("venc_jun") != null ? ((java.sql.Date) temp.get("venc_jun")).toLocalDate() : null);
//          obj.setVenc_jul(temp.get("venc_jul") != null ? ((java.sql.Date) temp.get("venc_jul")).toLocalDate() : null);
//          obj.setVenc_ago(temp.get("venc_ago") != null ? ((java.sql.Date) temp.get("venc_ago")).toLocalDate() : null);
//          obj.setVenc_sep(temp.get("venc_sep") != null ? ((java.sql.Date) temp.get("venc_sep")).toLocalDate() : null);
//          obj.setVenc_oct(temp.get("venc_oct") != null ? ((java.sql.Date) temp.get("venc_oct")).toLocalDate() : null);
//          obj.setVenc_nov(temp.get("venc_nov") != null ? ((java.sql.Date) temp.get("venc_nov")).toLocalDate() : null);
//          obj.setVenc_dic(temp.get("venc_dic") != null ? ((java.sql.Date) temp.get("venc_dic")).toLocalDate() : null);
          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      System.err.println("Error de conexión: " + e.getMessage());
    }
    return lista;
  }

}
