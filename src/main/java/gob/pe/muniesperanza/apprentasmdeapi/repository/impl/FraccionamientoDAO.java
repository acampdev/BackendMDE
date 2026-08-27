package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CronogramaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.FraccionamientoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PisoBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.FraccionamientoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class FraccionamientoDAO extends SimpleJdbcDaoBase implements FraccionamientoIDAO {


  public FraccionamientoDAO(DataSource dataSource) {
    super(dataSource);
  }


  @Override
  public ClsResultDAO insertarFraccionamiento(FraccionamientoBean fraccionamientoBean) throws Exception {
    List<FraccionamientoBean> lista = new ArrayList<FraccionamientoBean>();
    ClsResultDAO response = new ClsResultDAO();
    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_fraccionamiento")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("TipoResolucion", Types.VARCHAR),
                                            new SqlParameter("DeudaInsoluta", Types.DOUBLE),
                                            new SqlParameter("CuotaInicial", Types.DOUBLE),
                                            new SqlParameter("NumeroCuotas", Types.INTEGER),
                                            new SqlParameter("AnioDeudaInicio", Types.INTEGER),
                                            new SqlParameter("PeriodoInicio", Types.INTEGER),
                                            new SqlParameter("AnioDeudaFin", Types.INTEGER),
                                            new SqlParameter("PeriodoFin", Types.INTEGER),
                                            new SqlParameter("Solicitante", Types.VARCHAR),
                                            new SqlParameter("TipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumDocumento", Types.VARCHAR),
                                            new SqlParameter("Cargo", Types.VARCHAR),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("AnioResoAnterior", Types.INTEGER),
                                            new SqlParameter("CodResoAnterior", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodResolucion", Types.INTEGER),
                                          //  new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodContribuyente",fraccionamientoBean.getCodContribuyente());
      inParams.put("TipoResolucion", fraccionamientoBean.getTipoResolucion());
      inParams.put("DeudaInsoluta", fraccionamientoBean.getDeudaInsoluta());
      inParams.put("CuotaInicial", fraccionamientoBean.getCuotaInicial());
      inParams.put("NumeroCuotas", fraccionamientoBean.getNumeroCuotas());
       inParams.put("AnioDeudaInicio", fraccionamientoBean.getAnioDeudaInicio());
      inParams.put("PeriodoInicio", fraccionamientoBean.getPeriodoInicio());
      inParams.put("AnioDeudaFin", fraccionamientoBean.getAnioDeudaFin());
      inParams.put("PeriodoFin",fraccionamientoBean.getPeriodoFin());
      inParams.put("Solicitante", fraccionamientoBean.getSolicitante());
      inParams.put("TipoDocumento",fraccionamientoBean.getTipoDocumento());
      inParams.put("NumDocumento", fraccionamientoBean.getNumDocumento());
      inParams.put("Cargo", fraccionamientoBean.getCargo());
      inParams.put("CodUsuario", fraccionamientoBean.getCodUsuario());
      inParams.put("AnioResoAnterior", fraccionamientoBean.getAnioResoAnterior());
      inParams.put("CodResoAnterior", fraccionamientoBean.getCodResoAnterior());
      inParams.put("Anio", fraccionamientoBean.getAnio());
      inParams.put("CodResolucion",  null);
    //  inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      String mensaje = (String) result.get("Mensaje");
      Integer respuesta = (Integer) result.get("Respuesta");
      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        response.put("lista", lista);
        return response;
      }
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          FraccionamientoBean obj = new FraccionamientoBean();

          obj.setAnio(temp.get("Anio")!= null ? Integer.parseInt(String.valueOf(temp.get("Anio"))) : null);

          obj.setDeudaInsoluta(temp.get("DeudaInsoluta")!= null ? Double.parseDouble(String.valueOf(temp.get(
                  "DeudaInsoluta"))) : null);
          obj.setCuotaInicial(temp.get("CuotaInicial")!= null ?
                           Double.parseDouble(String.valueOf(temp.get("CuotaInicial"))) : null);
          obj.setCapitalNeto(temp.get("M_CapitalNeto")!= null ?
                                      Double.parseDouble(String.valueOf(temp.get("M_CapitalNeto"))) : null);
          obj.setTasaMensual(temp.get("DE_TasaMensual")!= null ?
                                      Double.parseDouble(String.valueOf(temp.get("DE_TasaMensual"))) : null);
          obj.setMontoCuota(temp.get("DE_TasaMensual")!= null ?
                                     Double.parseDouble(String.valueOf(temp.get("DE_TasaMensual"))) : null);
          obj.setNumeroCuotas(temp.get("NumeroCuotas")!= null ?
                                     Integer.parseInt(String.valueOf(temp.get("NumeroCuotas"))) : null);
          obj.setTotalInteres(temp.get("M_TotalInteres")!= null ?
                                     Double.parseDouble(String.valueOf(temp.get("M_TotalInteres"))) : null);
          obj.setTotalFraccionado(temp.get("M_TotalFraccionado")!= null ?
                                     Double.parseDouble(String.valueOf(temp.get("M_TotalFraccionado"))) : null);

          return obj;
        }).toList();
      }
     // return lista;

      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
      response.put("lista", lista);

    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;
  }

  @Override
  public List<FraccionamientoBean> listarFraccionamiento(Integer codContribuyente) throws Exception {


    List<FraccionamientoBean> lista = new ArrayList<FraccionamientoBean>();
    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_fraccionamiento")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("TipoResolucion", Types.VARCHAR),
                                            new SqlParameter("DeudaInsoluta", Types.DOUBLE),
                                            new SqlParameter("CuotaInicial", Types.DOUBLE),
                                            new SqlParameter("NumeroCuotas", Types.INTEGER),
                                            new SqlParameter("AnioDeudaInicio", Types.INTEGER),
                                            new SqlParameter("PeriodoInicio", Types.INTEGER),
                                            new SqlParameter("AnioDeudaFin", Types.INTEGER),
                                            new SqlParameter("PeriodoFin", Types.INTEGER),
                                            new SqlParameter("Solicitante", Types.VARCHAR),
                                            new SqlParameter("TipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumDocumento", Types.VARCHAR),
                                            new SqlParameter("Cargo", Types.VARCHAR),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("AnioResoAnterior", Types.INTEGER),
                                            new SqlParameter("CodResoAnterior", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodResolucion", Types.INTEGER),
                                            //  new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para listar
      inParams.put("CodContribuyente",codContribuyente);
      inParams.put("TipoResolucion", null);
      inParams.put("DeudaInsoluta",  null);
      inParams.put("CuotaInicial",  null);
      inParams.put("NumeroCuotas",  null);
      inParams.put("AnioDeudaInicio",  null);
      inParams.put("PeriodoInicio",  null);
      inParams.put("AnioDeudaFin",  null);
      inParams.put("PeriodoFin", null);
      inParams.put("Solicitante",  null);
      inParams.put("TipoDocumento", null);
      inParams.put("NumDocumento",  null);
      inParams.put("Cargo",  null);
      inParams.put("CodUsuario",  null);
      inParams.put("AnioResoAnterior",  null);
      inParams.put("CodResoAnterior",  null);
      inParams.put("Anio", null);
      inParams.put("CodResolucion",  null);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          FraccionamientoBean obj = new FraccionamientoBean();

          obj.setAnio(temp.get("anio")!= null ? Integer.parseInt(String.valueOf(temp.get("anio"))) : null);
          obj.setCodContribuyente(temp.get("codContribuyente")!= null ?
                                          Integer.parseInt(String.valueOf(temp.get("codContribuyente"))) : null);
          obj.setTipoResolucion(temp.get("tipoResolucion")!= null ?
                                        String.valueOf(temp.get("tipoResolucion")) : null);
          obj.setAnioDeudaInicio(temp.get("anioDeudaInicio")!= null ?
                                         Integer.parseInt(String.valueOf(temp.get("anioDeudaInicio"))) : null);
          obj.setAnioDeudaFin(temp.get("anioDeudaFin")!= null ?
                                         Integer.parseInt(String.valueOf(temp.get("anioDeudaFin"))) : null);
          obj.setPeriodoInicio(temp.get("periodoInicio")!= null ?
                                      Integer.parseInt(String.valueOf(temp.get("periodoInicio"))) : null);
          obj.setPeriodoFin(temp.get("periodoFin")!= null ?
                                      Integer.parseInt(String.valueOf(temp.get("periodoFin"))) : null);
          obj.setSolicitante(temp.get("solicitante")!= null ?
                                    String.valueOf(temp.get("solicitante")) : null);
          obj.setTipoDocumento(temp.get("tipoDocumento")!= null ?
                                     String.valueOf(temp.get("tipoDocumento")) : null);
          obj.setNumDocumento(temp.get("numDocumento")!= null ?
                                       String.valueOf(temp.get("numDocumento")) : null);
          obj.setCargo(temp.get("cargo")!= null ?
                                      String.valueOf(temp.get("cargo")) : null);
          obj.setDeudaInsoluta(temp.get("deudaInsoluta")!= null ? Double.parseDouble(String.valueOf(temp.get(
                  "deudaInsoluta"))) : null);
          obj.setCuotaInicial(temp.get("cuotaInicial")!= null ?
                                      Double.parseDouble(String.valueOf(temp.get("cuotaInicial"))) : null);
          obj.setCapitalNeto(temp.get("capitalNeto")!= null ?
                                     Double.parseDouble(String.valueOf(temp.get("capitalNeto"))) : null);
          obj.setTasaMensual(temp.get("tasaMensual")!= null ?
                                     Double.parseDouble(String.valueOf(temp.get("tasaMensual"))) : null);
          obj.setMontoCuota(temp.get("montoMensual")!= null ?
                                    Double.parseDouble(String.valueOf(temp.get("montoMensual"))) : null);
          obj.setNumeroCuotas(temp.get("numeroCuotas")!= null ?
                                      Integer.parseInt(String.valueOf(temp.get("numeroCuotas"))) : null);
          obj.setTotalInteres(temp.get("totalInteres")!= null ?
                                      Double.parseDouble(String.valueOf(temp.get("totalInteres"))) : null);
          obj.setTotalFraccionado(temp.get("totalFraccionado")!= null ?
                                          Double.parseDouble(String.valueOf(temp.get("totalFraccionado"))) : null);

          return obj;
        }).toList();
      }
      return lista;


    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }

  }

  @Override
  public List<CronogramaBean> listarCronograma(Integer anio,Integer codResolucion) throws Exception {


    List<CronogramaBean> lista = new ArrayList<CronogramaBean>();
    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_fraccionamiento")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("TipoResolucion", Types.VARCHAR),
                                            new SqlParameter("DeudaInsoluta", Types.DOUBLE),
                                            new SqlParameter("CuotaInicial", Types.DOUBLE),
                                            new SqlParameter("NumeroCuotas", Types.INTEGER),
                                            new SqlParameter("AnioDeudaInicio", Types.INTEGER),
                                            new SqlParameter("PeriodoInicio", Types.INTEGER),
                                            new SqlParameter("AnioDeudaFin", Types.INTEGER),
                                            new SqlParameter("PeriodoFin", Types.INTEGER),
                                            new SqlParameter("Solicitante", Types.VARCHAR),
                                            new SqlParameter("TipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumDocumento", Types.VARCHAR),
                                            new SqlParameter("Cargo", Types.VARCHAR),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("AnioResoAnterior", Types.INTEGER),
                                            new SqlParameter("CodResoAnterior", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodResolucion", Types.INTEGER),
                                            //  new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("CodContribuyente", null);
      inParams.put("TipoResolucion", null);
      inParams.put("DeudaInsoluta", null);
      inParams.put("CuotaInicial", null);
      inParams.put("NumeroCuotas", null);
       inParams.put("AnioDeudaInicio", null);
      inParams.put("PeriodoInicio", null);
      inParams.put("AnioDeudaFin", null);
      inParams.put("PeriodoFin", null);
      inParams.put("Solicitante", null);
      inParams.put("TipoDocumento", null);
      inParams.put("NumDocumento", null);
      inParams.put("Cargo", null);
      inParams.put("CodUsuario", null);
      inParams.put("AnioResoAnterior", null);
      inParams.put("CodResoAnterior", null);
      inParams.put("Anio", anio);
      inParams.put("CodResolucion", codResolucion);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String, Object>>) result.get("#result-set-1");

      if (listaBd != null && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          CronogramaBean obj = new CronogramaBean();

          obj.setAnio(temp.get("anio") != null ? Integer.parseInt(String.valueOf(temp.get("anio"))) : null);
          obj.setCodResolucion(temp.get("codResolucion") != null ?  Integer.parseInt(String.valueOf(temp.get("codResolucion"))) : null);
          obj.setNumeroCuota(temp.get("numeroCuota") != null ?  Integer.parseInt(String.valueOf(temp.get("numeroCuota"))) : null);
          obj.setSaldoInicio(temp.get("saldoInicio") != null ? Double.parseDouble(String.valueOf(temp.get("saldoInicio"))) : null);
          obj.setInteres(temp.get("interes") != null ?  Double.parseDouble(String.valueOf(temp.get("interes"))) : null);
          obj.setAmortizacion(temp.get("amortizacion") != null ? Double.parseDouble(String.valueOf(temp.get("amortizacion"))) : null);
          obj.setMontoCuota(temp.get("montoCuota") != null ? Double.parseDouble(String.valueOf(temp.get("montoCuota"))) : null);
          obj.setMontoPagado(temp.get("montoPagado") != null ? Double.parseDouble(String.valueOf(temp.get("montoPagado"))) : null);
          obj.setPagado(temp.get("pagado") != null ? Boolean.parseBoolean(String.valueOf(temp.get("pagado"))) : null);
          obj.setNumeroPago(temp.get("numeroPago") != null ? Integer.parseInt(String.valueOf(temp.get("numeroPago"))) : null);
          obj.setFechaPago(temp.get("fechaPago") != null ?
                                     Date.valueOf(String.valueOf(temp.get("fechaPago"))) : null);
          obj.setFechaVencimiento(temp.get("fechaVencimiento") != null ?
                                          Date.valueOf(String.valueOf(temp.get(
                  "fechaVencimiento"))) : null);

          return obj;
        }).toList();
      }
      return lista;


    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
  }

  @Override
  public List<CronogramaBean> listarCronogramaContri(Integer codContribuyente) throws Exception {


    List<CronogramaBean> lista = new ArrayList<CronogramaBean>();
    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_fraccionamiento")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("TipoResolucion", Types.VARCHAR),
                                            new SqlParameter("DeudaInsoluta", Types.DOUBLE),
                                            new SqlParameter("CuotaInicial", Types.DOUBLE),
                                            new SqlParameter("NumeroCuotas", Types.INTEGER),
                                            new SqlParameter("AnioDeudaInicio", Types.INTEGER),
                                            new SqlParameter("PeriodoInicio", Types.INTEGER),
                                            new SqlParameter("AnioDeudaFin", Types.INTEGER),
                                            new SqlParameter("PeriodoFin", Types.INTEGER),
                                            new SqlParameter("Solicitante", Types.VARCHAR),
                                            new SqlParameter("TipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumDocumento", Types.VARCHAR),
                                            new SqlParameter("Cargo", Types.VARCHAR),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlParameter("AnioResoAnterior", Types.INTEGER),
                                            new SqlParameter("CodResoAnterior", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodResolucion", Types.INTEGER),
                                            //  new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // Tipo 4 es para listar por contribuyente
      inParams.put("CodContribuyente", codContribuyente);
      inParams.put("TipoResolucion", null);
      inParams.put("DeudaInsoluta", null);
      inParams.put("CuotaInicial", null);
      inParams.put("NumeroCuotas", null);
      inParams.put("AnioDeudaInicio", null);
      inParams.put("PeriodoInicio", null);
      inParams.put("AnioDeudaFin", null);
      inParams.put("PeriodoFin", null);
      inParams.put("Solicitante", null);
      inParams.put("TipoDocumento", null);
      inParams.put("NumDocumento", null);
      inParams.put("Cargo", null);
      inParams.put("CodUsuario", null);
      inParams.put("AnioResoAnterior", null);
      inParams.put("CodResoAnterior", null);
      inParams.put("Anio", null);
      inParams.put("CodResolucion", null);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String, Object>>) result.get("#result-set-1");

      if (listaBd != null && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          CronogramaBean obj = new CronogramaBean();

          obj.setAnio(temp.get("anio") != null ? Integer.parseInt(String.valueOf(temp.get("anio"))) : null);
          obj.setCodResolucion(temp.get("codResolucion") != null ?  Integer.parseInt(String.valueOf(temp.get("codResolucion"))) : null);
          obj.setNumeroCuota(temp.get("numeroCuota") != null ?  Integer.parseInt(String.valueOf(temp.get("numeroCuota"))) : null);
          obj.setSaldoInicio(temp.get("saldoInicio") != null ? Double.parseDouble(String.valueOf(temp.get("saldoInicio"))) : null);
          obj.setInteres(temp.get("interes") != null ?  Double.parseDouble(String.valueOf(temp.get("interes"))) : null);
          obj.setAmortizacion(temp.get("amortizacion") != null ? Double.parseDouble(String.valueOf(temp.get("amortizacion"))) : null);
          obj.setMontoCuota(temp.get("montoCuota") != null ? Double.parseDouble(String.valueOf(temp.get("montoCuota"))) : null);
          obj.setMontoPagado(temp.get("montoPagado") != null ? Double.parseDouble(String.valueOf(temp.get("montoPagado"))) : null);
          obj.setPagado(temp.get("pagado") != null ? Boolean.parseBoolean(String.valueOf(temp.get("pagado"))) : null);
          obj.setNumeroPago(temp.get("numeroPago") != null ? Integer.parseInt(String.valueOf(temp.get("numeroPago"))) : null);
          obj.setFechaPago(temp.get("fechaPago") != null ?
                                   Date.valueOf(String.valueOf(temp.get("fechaPago"))) : null);
          obj.setFechaVencimiento(temp.get("fechaVencimiento") != null ?
                                          Date.valueOf(String.valueOf(temp.get(
                                                  "fechaVencimiento"))) : null);
          obj.setCodContribuyente(temp.get("codContribuyente") != null ?
                                                Integer.parseInt(String.valueOf(temp.get("codContribuyente"))) : null);


          return obj;
        }).toList();
      }
      return lista;


    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
  }



}
