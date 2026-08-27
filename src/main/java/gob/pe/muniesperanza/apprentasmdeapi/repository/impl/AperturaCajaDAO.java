package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.AperturaCajaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.CajaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AperturaCajaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.CajaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;

import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class AperturaCajaDAO  extends SimpleJdbcDaoBase implements AperturaCajaIDAO {

  public AperturaCajaDAO(DataSource dataSource) {
    super(dataSource);
  }

  public ClsResultDAO apertura(AperturaCajaBean aperturaCajaBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_aperturarCaja")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAsignacionCaja", Types.INTEGER),
                                            new SqlParameter("CodAperturaCaja", Types.INTEGER),
                                            new SqlParameter("MontoApertura", Types.DECIMAL),
                                            new SqlParameter("MontoCierre", Types.DECIMAL),
                                            new SqlParameter("Observacion", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para apertura
      inParams.put("CodAsignacionCaja", null);
      inParams.put("CodAperturaCaja", null);
      inParams.put("MontoApertura", aperturaCajaBean.getMontoApertura());
      inParams.put("MontoCierre", aperturaCajaBean.getMontoCierre());
      inParams.put("Observacion", aperturaCajaBean.getObservacion());
      inParams.put("Usuario", aperturaCajaBean.getCodUsuario());

      Map<String, Object> result = stmt.execute(inParams);
      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");
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

  public ClsResultDAO cierre(AperturaCajaBean aperturaCajaBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_aperturarCaja")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAsignacionCaja", Types.INTEGER),
                                            new SqlParameter("CodAperturaCaja", Types.INTEGER),
                                            new SqlParameter("MontoApertura", Types.DECIMAL),
                                            new SqlParameter("MontoCierre", Types.DECIMAL),
                                            new SqlParameter("Observacion", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para cierre
      inParams.put("CodAsignacionCaja", aperturaCajaBean.getCodAsignacionCaja());
      inParams.put("CodAperturaCaja", aperturaCajaBean.getCodAperturaCaja());
      inParams.put("MontoApertura", aperturaCajaBean.getMontoApertura());
      inParams.put("MontoCierre", aperturaCajaBean.getMontoCierre());
      inParams.put("Observacion", aperturaCajaBean.getObservacion());
      inParams.put("Usuario", aperturaCajaBean.getCodUsuario());


      Map<String, Object> result = stmt.execute(inParams);
      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");
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

  public List<AperturaCajaBean> listar(Integer codUsuario) throws Exception {
    List<AperturaCajaBean> lista = new ArrayList<AperturaCajaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_aperturarCaja")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAsignacionCaja", Types.INTEGER),
                                            new SqlParameter("CodAperturaCaja", Types.INTEGER),
                                            new SqlParameter("MontoApertura", Types.DECIMAL),
                                            new SqlParameter("MontoCierre", Types.DECIMAL),
                                            new SqlParameter("Observacion", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("CodAsignacionCaja", null);
      inParams.put("CodAperturaCaja",null);
      inParams.put("MontoApertura", null);
      inParams.put("MontoCierre", null);
      inParams.put("Observacion", null);
      inParams.put("Usuario", codUsuario);
      Map<String, Object> result = stmt.execute(inParams);
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          AperturaCajaBean obj = new AperturaCajaBean();

          obj.setCodAperturaCaja(temp.get("codApertura")!= null ?
                                         Integer.parseInt(String.valueOf(temp.get("codApertura"))) : null);
          obj.setMontoApertura(temp.get("montoInicial")!= null ?
                                       Double.parseDouble(String.valueOf(temp.get("montoInicial"))) :
                                       null);
          obj.setMontoCierre(temp.get("montoCierre")!= null ? Double.parseDouble(String.valueOf(temp.get("montoCierre"))) :
                                     null);
          obj.setDiferencia(temp.get("diferencia")!= null ?
                                    Double.parseDouble(String.valueOf(temp.get("diferencia"))) :
                                     null);
          obj.setNumeroApertura(temp.get("numeroApertura")!= null ?
                                         String.valueOf(temp.get("numeroApertura")) : null);
          obj.setCaja(temp.get("caja")!= null ?
                                        String.valueOf(temp.get("caja")) : null);
          obj.setTurno(temp.get("turno")!= null ?
                                        String.valueOf(temp.get("turno")) : null);
          obj.setFechaApertura(temp.get("fechaApertura")!= null ?
                                       Timestamp.valueOf(String.valueOf(temp.get(
                  "fechaApertura"))):  null);
          obj.setFechaCierre(temp.get("fechaCierre")!= null ?
                                     Timestamp.valueOf(String.valueOf(temp.get("fechaCierre"))) :
                                       null);
          obj.setTipoDiferencia(temp.get("tipoDiferencia")!= null ?
                                        String.valueOf(temp.get("tipoDiferencia")) : null);
          obj.setEstado(temp.get("estado")!= null ?
                                        String.valueOf(temp.get("estado")) : null);

          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar sp_aperturarCaja: " + e.getMessage(), e);
    }
    // return null;
  }


}
