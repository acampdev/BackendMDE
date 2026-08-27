package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.IpmBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.InteresIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.IpmIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class IpmDAO extends SimpleJdbcDaoBase implements IpmIDAO {



  public IpmDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public List<IpmBean> listar(Integer anio) throws Exception {
    List<IpmBean> lista = new ArrayList<IpmBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_ipm")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Mes", Types.VARCHAR),
                                            new SqlParameter("Indice", Types.DOUBLE),
                                            new SqlParameter("VariacionMensual", Types.DOUBLE),
                                            new SqlParameter("VariacionAcumulada", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // listar
      inParams.put("Anio", anio);
      inParams.put("Mes", null);
      inParams.put("Indice", null);
      inParams.put("VariacionMensual", null);
      inParams.put("VariacionAcumulada", null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          IpmBean obj = new IpmBean();

          obj.setAnio(temp.get("Anio")!= null ? Integer.parseInt(String.valueOf(temp.get("Anio"))) : null);
          obj.setCodMes(temp.get("CodMes")!= null ? String.valueOf(temp.get("CodMes")) : null);

          obj.setMes(temp.get("Mes")!= null ? String.valueOf(temp.get("Mes")) : null);
          obj.setIndice(temp.get("IndiceIPM")!= null ? Double.parseDouble(String.valueOf(temp.get("IndiceIPM"))) :
                                null);
          obj.setVariacionMensual(temp.get("VariacionMensual")!= null ? Double.parseDouble(String.valueOf(temp.get("VariacionMensual"))) : null);
          obj.setVariacionAcumulada(temp.get("VariacionAcumulada")!= null ? Double.parseDouble(String.valueOf(temp.get("VariacionAcumulada"))) : null);

          return obj;
        }).toList();
      }
      return lista;

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar sp_ipm: " + e.getMessage(), e);
    }
    // return null;
  }

  @Override
  public ClsResultDAO insertar(IpmBean ipmBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_ipm")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Mes", Types.VARCHAR),
                                            new SqlParameter("Indice", Types.DOUBLE),
                                            new SqlParameter("VariacionMensual", Types.DOUBLE),
                                            new SqlParameter("VariacionAcumulada", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("Anio", ipmBean.getAnio());
      inParams.put("Mes", ipmBean.getMes());
      inParams.put("Indice",  ipmBean.getIndice());
      inParams.put("VariacionMensual",  ipmBean.getVariacionMensual());
      inParams.put("VariacionAcumulada",  ipmBean.getVariacionAcumulada());
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
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

  @Override
  public ClsResultDAO actualizar(IpmBean ipmBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_ipm")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Mes", Types.VARCHAR),
                                            new SqlParameter("Indice", Types.DOUBLE),
                                            new SqlParameter("VariacionMensual", Types.DOUBLE),
                                            new SqlParameter("VariacionAcumulada", Types.DOUBLE),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("Anio", ipmBean.getAnio());
      inParams.put("Mes", ipmBean.getMes());
      inParams.put("Indice",  ipmBean.getIndice());
      inParams.put("VariacionMensual",  ipmBean.getVariacionMensual());
      inParams.put("VariacionAcumulada",  ipmBean.getVariacionAcumulada());
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
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
}
