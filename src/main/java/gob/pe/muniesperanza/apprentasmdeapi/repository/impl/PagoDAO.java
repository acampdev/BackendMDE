package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PagoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.SaldoDeudaBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PagoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.util.*;
@Repository
public class PagoDAO extends SimpleJdbcDaoBase implements PagoIDAO {


  public PagoDAO(DataSource dataSource) {
    super(dataSource);
  }

  public ClsResultDAO pagoOrdinario2(PagoBean pagoBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();
    String sql = "{call sp_InsertarProductos(?)}";
    try {

      jdbcTemplate.execute((Connection con) -> {

        SQLServerDataTable tvpData = new SQLServerDataTable();
        tvpData.addColumnMetadata("CodTributo", Types.INTEGER);
        tvpData.addColumnMetadata("Anio", Types.INTEGER);
        tvpData.addColumnMetadata("Periodo", Types.INTEGER);
        tvpData.addColumnMetadata("Abono", Types.DECIMAL);

        // 2. Llenar el TVP recorriendo la lista de objetos Java
        for (SaldoDeudaBean saldoDeudaBean : pagoBean.getSaldosDeuda()) {
          tvpData.addRow(saldoDeudaBean.getCodTributo(), saldoDeudaBean.getAnio(),saldoDeudaBean.getPeriodo(),
                  saldoDeudaBean.getAbono());      }

        // 3. Ejecutar de forma segura el procedimiento almacenado
        try (SQLServerCallableStatement cstmt = (SQLServerCallableStatement) con.prepareCall(sql)) {
          cstmt.setStructured(1, "TipoProducto", tvpData);
          cstmt.execute();
        }
        return null;
      });





      SQLServerDataTable tvpData = new SQLServerDataTable();
      tvpData.addColumnMetadata("CodTributo", Types.INTEGER);
      tvpData.addColumnMetadata("Anio", Types.INTEGER);
      tvpData.addColumnMetadata("Periodo", Types.INTEGER);
      tvpData.addColumnMetadata("Abono", Types.DECIMAL);

      // 2. Llenar el TVP recorriendo la lista de objetos Java
      for (SaldoDeudaBean saldoDeudaBean : pagoBean.getSaldosDeuda()) {
        tvpData.addRow(saldoDeudaBean.getCodTributo(), saldoDeudaBean.getAnio(),saldoDeudaBean.getPeriodo(),
                saldoDeudaBean.getAbono());      }

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_pago_1")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAperturaCaja", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("MontoPagoTotal", Types.DOUBLE),
                                            new SqlParameter("CodMedioPago", Types.VARCHAR),
                                            new SqlParameter("CodTipoAbono", Types.VARCHAR),
                                            new SqlParameter("CodTributo", Types.INTEGER),
                                            new SqlParameter("AnioDeuda", Types.INTEGER),
                                            new SqlParameter("PeriodoDeuda", Types.INTEGER),
                                            new SqlParameter("MontoPagado", Types.DOUBLE),
                                            new SqlParameter("AnioResolucion", Types.INTEGER),
                                            new SqlParameter("CodResolucion", Types.INTEGER),
                                            new SqlParameter("NumeroCuota", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                           // new SqlParameter("ListSaldoDeuda", Types.),
                                            new SqlParameter("ListSaldoDeuda", Types.STRUCT, "SaldoDeuda"),
                                            new SqlOutParameter("NumeroPago", Types.INTEGER),                                         //   new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para pagoOrdinario
      inParams.put("CodAperturaCaja", pagoBean.getCodAperturaCaja());
      inParams.put("CodContribuyente", pagoBean.getCodContribuyente());
      inParams.put("MontoPagoTotal", pagoBean.getMontoPagoTotal());
      inParams.put("CodMedioPago", pagoBean.getCodMedioPago());
      inParams.put("CodTipoAbono", pagoBean.getCodTipoAbono());
      inParams.put("CodTributo", pagoBean.getCodTributo());
      inParams.put("AnioDeuda", pagoBean.getAnioDeuda());
      inParams.put("PeriodoDeuda", pagoBean.getPeriodoDeuda());
      inParams.put("MontoPagado", pagoBean.getMontoPagado());
      inParams.put("AnioResolucion", pagoBean.getAnioResolucion());
      inParams.put("CodResolucion", pagoBean.getCodResolucion());
      inParams.put("NumeroCuota", pagoBean.getNumeroCuota());
      inParams.put("ListSaldoDeuda", tvpData);
      inParams.put("Anio", pagoBean.getAnio());

      // inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      Integer numeroPago = (Integer) result.get("NumeroPago");
      String mensaje = (String) result.get("Mensaje");
      Integer respuesta = (Integer) result.get("Respuesta");

      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }

      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);

    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;
  }

  public ClsResultDAO pagoOrdinario(PagoBean pagoBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SQLServerDataTable tvpData = new SQLServerDataTable();
      tvpData.addColumnMetadata("CodTributo", Types.INTEGER);
      tvpData.addColumnMetadata("Anio", Types.INTEGER);
      tvpData.addColumnMetadata("Periodo", Types.INTEGER);
      tvpData.addColumnMetadata("Abono", Types.DECIMAL);
      tvpData.addColumnMetadata("AnioResolucion", Types.INTEGER);
      tvpData.addColumnMetadata("CodResolucion", Types.INTEGER);
      tvpData.addColumnMetadata("NumeroCuota", Types.INTEGER);

      // 2. Llenar el TVP recorriendo la lista de objetos Java
      for (SaldoDeudaBean saldoDeudaBean : pagoBean.getSaldosDeuda()) {
        tvpData.addRow(saldoDeudaBean.getCodTributo(), saldoDeudaBean.getAnio(),saldoDeudaBean.getPeriodo(),
                saldoDeudaBean.getAbono(),saldoDeudaBean.getAnioResolucion(),saldoDeudaBean.getCodResolucion(),
                saldoDeudaBean.getNumeroCuota());      }

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_pago_1")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAperturaCaja", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("MontoPagoTotal", Types.DOUBLE),
                                            new SqlParameter("CodMedioPago", Types.VARCHAR),
                                            new SqlParameter("CodTipoAbono", Types.VARCHAR),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("ListSaldoDeuda", Types.STRUCT, "ty_saldo_deuda"),
                                            new SqlOutParameter("NumeroPago", Types.INTEGER),                                         //   new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para pagoOrdinario
      inParams.put("CodAperturaCaja", pagoBean.getCodAperturaCaja());
      inParams.put("CodContribuyente", pagoBean.getCodContribuyente());
      inParams.put("MontoPagoTotal", pagoBean.getMontoPagoTotal());
      inParams.put("CodMedioPago", pagoBean.getCodMedioPago());
      inParams.put("CodTipoAbono", pagoBean.getCodTipoAbono());
      inParams.put("Anio", pagoBean.getAnio());
      inParams.put("ListSaldoDeuda", new SqlTypeValue() {
        @Override
        public void setTypeValue(PreparedStatement ps, int paramIndex, int sqlType, String typeName) throws SQLException {
          if (ps.isWrapperFor(SQLServerPreparedStatement.class)) {
            SQLServerPreparedStatement ssps = ps.unwrap(SQLServerPreparedStatement.class);
            ssps.setStructured(paramIndex, typeName, tvpData);
          } else {
            throw new SQLException("La conexión actual no soporta SQLServerPreparedStatement requerido para TVP.");
          }
        }
      });
     // inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      Integer numeroPago = (Integer) result.get("NumeroPago");
      String mensaje = (String) result.get("Mensaje");
      Integer respuesta = (Integer) result.get("Respuesta");

      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }

      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);

    } catch (Throwable e) {
      // logger.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return response;
  }

  public ClsResultDAO pagoCuotaFraccionamiento(PagoBean pagoBean) throws Exception{
    ClsResultDAO response =    new ClsResultDAO();

    try {

      SQLServerDataTable tvpData = new SQLServerDataTable();
      tvpData.addColumnMetadata("CodTributo", Types.INTEGER);
      tvpData.addColumnMetadata("Anio", Types.INTEGER);
      tvpData.addColumnMetadata("Periodo", Types.INTEGER);
      tvpData.addColumnMetadata("Abono", Types.DECIMAL);
      tvpData.addColumnMetadata("AnioResolucion", Types.INTEGER);
      tvpData.addColumnMetadata("CodResolucion", Types.INTEGER);
      tvpData.addColumnMetadata("NumeroCuota", Types.INTEGER);

      // 2. Llenar el TVP recorriendo la lista de objetos Java
      for (SaldoDeudaBean saldoDeudaBean : pagoBean.getSaldosDeuda()) {
        tvpData.addRow(saldoDeudaBean.getCodTributo(), saldoDeudaBean.getAnio(),saldoDeudaBean.getPeriodo(),
                saldoDeudaBean.getAbono(),saldoDeudaBean.getAnioResolucion(),saldoDeudaBean.getCodResolucion(),
                saldoDeudaBean.getNumeroCuota());      }

    SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                  .withCatalogName("dbo")
                                  .withProcedureName("sp_pago_1")
                                  .withoutProcedureColumnMetaDataAccess()
                                  .declareParameters(
                                          new SqlParameter("Tipo", Types.INTEGER),
                                          new SqlParameter("CodAperturaCaja", Types.INTEGER),
                                          new SqlParameter("CodContribuyente", Types.INTEGER),
                                          new SqlParameter("MontoPagoTotal", Types.DOUBLE),
                                          new SqlParameter("CodMedioPago", Types.VARCHAR),
                                          new SqlParameter("CodTipoAbono", Types.VARCHAR),
                                          new SqlParameter("Anio", Types.INTEGER),
                                          new SqlParameter("ListSaldoDeuda", Types.STRUCT, "ty_saldo_deuda"),
                                          new SqlOutParameter("NumeroPago", Types.INTEGER),                                         //   new SqlParameter("Usuario", Types.INTEGER),
                                          new SqlOutParameter("Mensaje", Types.VARCHAR),
                                          new SqlOutParameter("Respuesta", Types.INTEGER)
                                  );
    Map<String, Object> inParams = new HashMap<>();
    inParams.put("Tipo", 2); // Tipo 2 es para pagoCuotaFraccionamiento
    inParams.put("CodAperturaCaja", pagoBean.getCodAperturaCaja());
    inParams.put("CodContribuyente", pagoBean.getCodContribuyente());
    inParams.put("MontoPagoTotal", pagoBean.getMontoPagoTotal());
    inParams.put("CodMedioPago", pagoBean.getCodMedioPago());
    inParams.put("CodTipoAbono", pagoBean.getCodTipoAbono());
    inParams.put("CodTributo", pagoBean.getCodTributo());
    inParams.put("AnioDeuda", pagoBean.getAnioDeuda());
    inParams.put("PeriodoDeuda", pagoBean.getPeriodoDeuda());
    inParams.put("MontoPagado", pagoBean.getMontoPagado());
    inParams.put("AnioResolucion", pagoBean.getAnioResolucion());
    inParams.put("CodResolucion", pagoBean.getCodResolucion());
    inParams.put("NumeroCuota", pagoBean.getNumeroCuota());
    inParams.put("Anio", pagoBean.getAnio());
      inParams.put("ListSaldoDeuda", new SqlTypeValue() {
        @Override
        public void setTypeValue(PreparedStatement ps, int paramIndex, int sqlType, String typeName) throws SQLException {
          if (ps.isWrapperFor(SQLServerPreparedStatement.class)) {
            SQLServerPreparedStatement ssps = ps.unwrap(SQLServerPreparedStatement.class);
            ssps.setStructured(paramIndex, typeName, tvpData);
          } else {
            throw new SQLException("La conexión actual no soporta SQLServerPreparedStatement requerido para TVP.");
          }
        }
      });
    // inParams.put("Usuario", 1);
    Map<String, Object> result = stmt.execute(inParams);
    Integer numeroPago = (Integer) result.get("NumeroPago");
    String mensaje = (String) result.get("Mensaje");
    Integer respuesta = (Integer) result.get("Respuesta");

    if (respuesta == 0) {
      response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
      response.put(response.MENSAJE_RESPUESTA, mensaje);
      return response;
    }

    response.put(response.CODIGO_RESPUESTA, 1);
    response.put(response.MENSAJE_RESPUESTA, mensaje);
//      response.put("INSERTADO", codigoUsuario != null ? String.valueOf(codigoUsuario) : 0);

  } catch (Throwable e) {
    // logger.error(e.getMessage(), e);
    throw new Exception(e.getMessage(), e);
  }
    return response;
}


  public List<PagoBean> listarPagos(Integer codContribuyente, Integer numeroPago, Integer anio) throws Exception{
    List<PagoBean> lista = new ArrayList<PagoBean>();
    try {
    SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                  .withCatalogName("dbo")
                                  .withProcedureName("sp_pago")
                                  .withoutProcedureColumnMetaDataAccess()
                                  .declareParameters(
                                          new SqlParameter("Tipo", Types.INTEGER),
                                          new SqlParameter("CodAperturaCaja", Types.INTEGER),
                                          new SqlParameter("CodContribuyente", Types.INTEGER),
                                          new SqlParameter("MontoPagoTotal", Types.DOUBLE),
                                          new SqlParameter("CodMedioPago", Types.VARCHAR),
                                          new SqlParameter("CodTipoAbono", Types.VARCHAR),
                                          new SqlParameter("CodTributo", Types.INTEGER),
                                          new SqlParameter("AnioDeuda", Types.INTEGER),
                                          new SqlParameter("PeriodoDeuda", Types.INTEGER),
                                          new SqlParameter("MontoPagado", Types.DOUBLE),
                                          new SqlParameter("AnioResolucion", Types.INTEGER),
                                          new SqlParameter("CodResolucion", Types.INTEGER),
                                          new SqlParameter("NumeroCuota", Types.INTEGER),
                                          new SqlParameter("Anio", Types.INTEGER),
                                          new SqlOutParameter("NumeroPago", Types.INTEGER),                                         //   new SqlParameter("Usuario", Types.INTEGER),
                                          new SqlOutParameter("Mensaje", Types.VARCHAR),
                                          new SqlOutParameter("Respuesta", Types.INTEGER)
                                  );
    Map<String, Object> inParams = new HashMap<>();
    inParams.put("Tipo", 3); // listar
      inParams.put("CodAperturaCaja", null);
      inParams.put("CodContribuyente", codContribuyente);
      inParams.put("MontoPagoTotal",null);
      inParams.put("CodMedioPago",null);
      inParams.put("CodTipoAbono",null);
      inParams.put("CodTributo", null);
      inParams.put("AnioDeuda",null);
      inParams.put("PeriodoDeuda",null);
      inParams.put("MontoPagado", null);
      inParams.put("AnioResolucion", null);
      inParams.put("CodResolucion",null);
      inParams.put("NumeroCuota", null);
      inParams.put("Anio", anio);
      inParams.put("NumeroPago", numeroPago);
    Map<String, Object> result = stmt.execute(inParams);
    List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

    if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

      lista = listaBd.stream().map(temp -> {
        PagoBean obj = new PagoBean();

        obj.setNumeroPago(temp.get("numeroPago")!= null ? Integer.parseInt(String.valueOf(temp.get("numeroPago"))) :
                                  null);
        obj.setFechaPago(temp.get("fechaPago")!= null ?
                                   Timestamp.valueOf(String.valueOf(temp.get("fechaPago"))) :
                                   null);
      //  obj.setFechaPago(temp.get("fechaPago")!= null ? Date.valueOf(String.valueOf(temp.get("fechaPago"))) :
        //                         null);
        obj.setCodAperturaCaja(temp.get("codAperturaCaja")!= null ?
                                       Integer.parseInt(String.valueOf(temp.get("codAperturaCaja"))) :
                                       null);
        obj.setCodContribuyente(temp.get("CodContribuyente")!= null ?
                                        Integer.parseInt(String.valueOf(temp.get("CodContribuyente"))) : null);
        obj.setMontoPagoTotal(temp.get("montoPagoTotal")!= null ? Double.parseDouble(String.valueOf(temp.get("montoPagoTotal")))
      : null);
        obj.setCodMedioPago(temp.get("codMedioPago")!= null ? String.valueOf(temp.get("codMedioPago")) : null);
        obj.setCodTipoAbono(temp.get("codTipoAbono")!= null ? String.valueOf(temp.get("codTipoAbono")) : null);
        obj.setCodTributo(temp.get("codTributo")!= null ? Integer.parseInt(String.valueOf(temp.get("codTributo"))) :             null);
        obj.setAnio(temp.get("anio")!= null ? Integer.parseInt(String.valueOf(temp.get("anio"))) : null);
        obj.setPeriodoDeuda(temp.get("periodo")!= null ? Integer.parseInt(String.valueOf(temp.get("periodo"))) : null);
        obj.setMontoPagado(temp.get("montoPagado")!= null ? Double.parseDouble(String.valueOf(temp.get("montoPagado"))) :
                                   null);
     //   obj.setCodMedioPago(temp.get("interesMoratorio")!= null ? String.valueOf(temp.get("interesMoratorio")) :
        //   null);
      //  obj.setCodMedioPago(temp.get("anioResolucion")!= null ? String.valueOf(temp.get("anioResolucion")) : null);
      //  obj.setCodMedioPago(temp.get("codResolucion")!= null ? String.valueOf(temp.get("codResolucion")) : null);
      //  obj.setCodMedioPago(temp.get("numeroCuota")!= null ? String.valueOf(temp.get("numeroCuota")) : null);



        return obj;
      }).toList();
    }
    return lista;

  } catch (Exception e) {
    throw new RuntimeException("Error al ejecutar sp_interes: " + e.getMessage(), e);
  }
  // return null;
}

}
