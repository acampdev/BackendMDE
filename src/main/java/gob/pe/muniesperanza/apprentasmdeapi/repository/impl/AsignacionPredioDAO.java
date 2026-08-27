package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ConstanteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArancelIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AsignacionPredioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
public class AsignacionPredioDAO  extends SimpleJdbcDaoBase implements AsignacionPredioIDAO {

  private static final String LISTAR_ASIGNACION_PREDIO = "SELECT * FROM vw_asignacionPredios WHERE 1=1 ";


  public AsignacionPredioDAO(DataSource dataSource) {
    super(dataSource);
  }



  @Override
  public ClsResultDAO insertarAsignacionPredio(AsignacionPredioBean asignacionPredioBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_asignacionPredio")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                             new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodAsignacion", Types.INTEGER),
                                            new SqlParameter("PorcentajeCondomino", Types.DOUBLE),
                                            new SqlParameter("FechaDeclaracion", Types.DATE),
                                            new SqlParameter("FechaVenta", Types.DATE),
                                            new SqlParameter("CodModoDeclaracion", Types.VARCHAR),
                                          //  new SqlParameter("CodEstado", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("Anio", asignacionPredioBean.getAnio());
      inParams.put("CodPredio", asignacionPredioBean.getCodPredio());
      inParams.put("CodContribuyente", asignacionPredioBean.getCodContribuyente());
      inParams.put("CodAsignacion", asignacionPredioBean.getCodAsignacion());
      inParams.put("PorcentajeCondomino", asignacionPredioBean.getPorcentajeCondomino());
      inParams.put("FechaDeclaracion", asignacionPredioBean.getFechaDeclaracion());
      inParams.put("FechaVenta", asignacionPredioBean.getFechaVenta());
      inParams.put("CodModoDeclaracion", asignacionPredioBean.getCodModoDeclaracion());
    //  inParams.put("CodEstado", asignacionPredioBean.getCodEstado());
      inParams.put("Usuario", 1);

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

@Override
  public ClsResultDAO actualizarAsignacionPredio(AsignacionPredioBean asignacionPredioBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_asignacionPredio")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodAsignacion", Types.INTEGER),
                                            new SqlParameter("PorcentajeCondomino", Types.DOUBLE),
                                            new SqlParameter("FechaDeclaracion", Types.DATE),
                                            new SqlParameter("FechaVenta", Types.DATE),
                                            new SqlParameter("CodModoDeclaracion", Types.VARCHAR),
                                      //      new SqlParameter("CodEstado", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("Anio", asignacionPredioBean.getAnio());
      inParams.put("CodPredio", asignacionPredioBean.getCodPredio());
      inParams.put("CodContribuyente", asignacionPredioBean.getCodContribuyente());
      inParams.put("CodAsignacion", asignacionPredioBean.getCodAsignacion());
      inParams.put("PorcentajeCondomino", asignacionPredioBean.getPorcentajeCondomino());
      inParams.put("FechaDeclaracion", asignacionPredioBean.getFechaDeclaracion());
      inParams.put("FechaVenta", asignacionPredioBean.getFechaVenta());
      inParams.put("CodModoDeclaracion", asignacionPredioBean.getCodModoDeclaracion());
   //   inParams.put("CodEstado", asignacionPredioBean.getCodEstado());
      inParams.put("Usuario", 1);

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


  @Override
  public List<AsignacionPredioBean> listarAsignacionPredio(Integer anio, Integer codContribuyente) throws Exception   {

    List<AsignacionPredioBean> lista = new ArrayList<AsignacionPredioBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_asignacionPredio").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodAsignacion", Types.INTEGER),
                                            new SqlParameter("PorcentajeCondomino", Types.DOUBLE),
                                            new SqlParameter("FechaDeclaracion", Types.DATE),
                                            new SqlParameter("FechaVenta", Types.DATE),
                                            new SqlParameter("CodModoDeclaracion", Types.VARCHAR),

         //                                   new SqlParameter("CodEstado", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("Anio", anio);
      inParams.put("CodPredio", null);
      inParams.put("CodContribuyente", codContribuyente);
      inParams.put("CodAsignacion",  null);
      inParams.put("PorcentajeCondomino",  null);
      inParams.put("FechaDeclaracion",  null);
      inParams.put("FechaVenta",  null);
      inParams.put("CodModoDeclaracion",  null);
  //    inParams.put("CodEstado",  null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          AsignacionPredioBean obj = new AsignacionPredioBean();
          obj.setAnio(Integer.valueOf(String.valueOf(temp.get("anio"))));
          obj.setCodPredio(temp.get("codPredio")!= null ? String.valueOf(temp.get("codPredio")) :null);
          obj.setCodPredioBase(Integer.valueOf(String.valueOf(temp.get("codPredioBase"))));
          obj.setDireccionCompleta(String.valueOf(temp.get("direccionCompleta")));
          obj.setAutoavaluo(Double.valueOf(String.valueOf(temp.get("autoavaluo"))));
          obj.setBaseImponible(Double.valueOf(String.valueOf(temp.get("baseImponible"))));
          obj.setImpuestoAnual(Double.valueOf(String.valueOf(temp.get("impuestoAnual"))));
          obj.setCodContribuyente(Integer.valueOf(String.valueOf(temp.get("codContribuyente"))));
          obj.setCodPredioContribuyente(Integer.valueOf(String.valueOf(temp.get("codPredioContribuyente"))));
          obj.setPorcentajeCondominoDesc(temp.get("porcentajeCondomino")!= null ? String.valueOf(temp.get("porcentajeCondomino")):  null);
          obj.setFechaDeclaracion(temp.get("fechaDeclaracion")!= null ? Date.valueOf(String.valueOf(temp.get("fechaDeclaracion"))) :  null);
          obj.setFechaVenta(temp.get("fechaVenta")!= null ? Date.valueOf(String.valueOf(temp.get("fechaVenta"))) :  null);
          obj.setCodModoDeclaracion(String.valueOf(temp.get("codModoDeclaracion")));
//          obj.setCodEstado(String.valueOf(temp.get("codEstado")));
          obj.setNombreContribuyente(String.valueOf(temp.get("nombreContribuyente")));
          obj.setModoDeclaracion(String.valueOf(temp.get("modoDeclaracion")));
          obj.setEstado(String.valueOf(temp.get("estado")));




          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      System.err.println("Error de conexión: " + e.getMessage());
    }
    return lista;
  }


  @Override
  public ClsResultDAO desasignarAsignacionPredio(AsignacionPredioBean asignacionPredioBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_asignacionPredio")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodAsignacion", Types.INTEGER),
                                            new SqlParameter("PorcentajeCondomino", Types.DOUBLE),
                                            new SqlParameter("FechaDeclaracion", Types.DATE),
                                            new SqlParameter("FechaVenta", Types.DATE),
                                            new SqlParameter("CodModoDeclaracion", Types.VARCHAR),
  //                                          new SqlParameter("CodEstado", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // Tipo 4 es para Desasignar
      inParams.put("Anio", asignacionPredioBean.getAnio());
      inParams.put("CodPredio", asignacionPredioBean.getCodPredio());
      inParams.put("CodContribuyente", asignacionPredioBean.getCodContribuyente());
      inParams.put("CodAsignacion", asignacionPredioBean.getCodAsignacion());
      inParams.put("PorcentajeCondomino", asignacionPredioBean.getPorcentajeCondomino());
      inParams.put("FechaDeclaracion", asignacionPredioBean.getFechaDeclaracion());
      inParams.put("FechaVenta", asignacionPredioBean.getFechaVenta());
      inParams.put("CodModoDeclaracion", asignacionPredioBean.getCodModoDeclaracion());
 //     inParams.put("CodEstado", asignacionPredioBean.getCodEstado());
      inParams.put("Usuario", 1);

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


  @Override
  public ClsResultDAO prevalidarBeneficioPensionista(Integer codContribuyente) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_prevalidarBeneficioPensionista")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("I_CodContribuyente", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("I_CodContribuyente", codContribuyente);
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

  @Override
  public ClsResultDAO prevalidarBeneficioAdultoMayor(Integer codContribuyente) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_prevalidarBeneficioAdultoMayor")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("CodContribuyente", codContribuyente);
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


}
