package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AlcabalaBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.AlcabalaIDAO;
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
public class AlcabalaDAO  extends SimpleJdbcDaoBase implements AlcabalaIDAO {

  public AlcabalaDAO(DataSource dataSource) {
    super(dataSource);
  }


  public ClsResultDAO insertar(AlcabalaBean alcabalaBean) throws  Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_alcabala")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAlcabala", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodAlcabala", null);
      inParams.put("Anio", alcabalaBean.getAnio());
      inParams.put("Tasa", alcabalaBean.getTasa());
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

  public ClsResultDAO actualizar(AlcabalaBean alcabalaBean)  throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_alcabala")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAlcabala", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para modificar
      inParams.put("CodAlcabala", alcabalaBean.getCodAlcabala());
      inParams.put("Anio", alcabalaBean.getAnio());
      inParams.put("Tasa", alcabalaBean.getTasa());
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


  public List<AlcabalaBean> listar(Integer anio) throws Exception   {

    List<AlcabalaBean> lista = new ArrayList<AlcabalaBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_alcabala").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodAlcabala", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("Tasa", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("CodAlcabala", null);
      inParams.put("Anio", anio);
      inParams.put("Tasa", null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
        AlcabalaBean obj = new AlcabalaBean();
          obj.setCodAlcabala(temp.get("codAlcabala")!= null ? Integer.parseInt(String.valueOf(temp.get("codAlcabala"))) : null);
           obj.setTasa(temp.get("tasa")!= null ? Double.valueOf(String.valueOf(temp.get("tasa"))):  null);
          obj.setAnio(temp.get("anio")!= null ? Integer.valueOf(String.valueOf(temp.get("anio"))):  null);
          obj.setEstado(temp.get("estado")!= null ? String.valueOf(temp.get("estado")) : null);

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
