package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.DireccionBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.DireccionIDAO;
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
public class DireccionDAO extends SimpleJdbcDaoBase implements DireccionIDAO {

  public DireccionDAO(DataSource dataSource) {
    super(dataSource);
  }
  @Override
  public ClsResultDAO insertar(DireccionBean direccionBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_direcciones")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("CodBarrioVia", Types.INTEGER),
                                            new SqlParameter("CodSectorVia", Types.INTEGER),
                                            new SqlParameter("Cuadra", Types.INTEGER),
                                            new SqlParameter("Manzana", Types.VARCHAR),
                                            new SqlParameter("CodLado", Types.VARCHAR),
                                            new SqlParameter("LoteInicial", Types.INTEGER),
                                            new SqlParameter("LoteFinal", Types.INTEGER),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodRuta", Types.INTEGER),
                                            new SqlParameter("CodUbicacionAreaVerde", Types.INTEGER),
                                            new SqlParameter("CodVia", Types.INTEGER),
                                            new SqlParameter("CodBarrio", Types.INTEGER),
                                            new SqlParameter("CodSector", Types.INTEGER),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodDireccion", null);
      inParams.put("CodBarrioVia", direccionBean.getCodBarrioVia());
      inParams.put("CodSectorVia", direccionBean.getCodSectorVia());
      inParams.put("Cuadra", direccionBean.getCuadra());
      inParams.put("Manzana", direccionBean.getManzana());
      inParams.put("CodLado", direccionBean.getCodLado());
      inParams.put("LoteInicial", direccionBean.getLoteInicial());
      inParams.put("LoteFinal", direccionBean.getLoteFinal());
      inParams.put("CodZona", direccionBean.getCodZona());
      inParams.put("CodRuta", direccionBean.getCodRuta());
      inParams.put("CodUbicacionAreaVerde", direccionBean.getCodUbicacionAreaVerde());
      inParams.put("CodVia", direccionBean.getCodVia());
      inParams.put("CodBarrio", direccionBean.getCodBarrio());
      inParams.put("CodSector", direccionBean.getCodSector());
      inParams.put("ParametroBusqueda", null);
      inParams.put("Usuario", direccionBean.getUsuario());

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
  public ClsResultDAO actualizar(DireccionBean direccionBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_direcciones")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("CodBarrioVia", Types.INTEGER),
                                            new SqlParameter("CodSectorVia", Types.INTEGER),
                                            new SqlParameter("Cuadra", Types.INTEGER),
                                            new SqlParameter("Manzana", Types.VARCHAR),
                                            new SqlParameter("CodLado", Types.VARCHAR),
                                            new SqlParameter("LoteInicial", Types.INTEGER),
                                            new SqlParameter("LoteFinal", Types.INTEGER),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodRuta", Types.INTEGER),
                                            new SqlParameter("CodUbicacionAreaVerde", Types.INTEGER),
                                            new SqlParameter("CodVia", Types.INTEGER),
                                            new SqlParameter("CodBarrio", Types.INTEGER),
                                            new SqlParameter("CodSector", Types.INTEGER),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("CodDireccion", direccionBean.getCodDireccion());
      inParams.put("CodBarrioVia", direccionBean.getCodBarrioVia());
      inParams.put("CodSectorVia", direccionBean.getCodSectorVia());
      inParams.put("Cuadra", direccionBean.getCuadra());
      inParams.put("Manzana", direccionBean.getManzana());
      inParams.put("CodLado", direccionBean.getCodLado());
      inParams.put("LoteInicial", direccionBean.getLoteInicial());
      inParams.put("LoteFinal", direccionBean.getLoteFinal());
      inParams.put("CodZona", direccionBean.getCodZona());
      inParams.put("CodRuta", direccionBean.getCodRuta());
      inParams.put("CodUbicacionAreaVerde", direccionBean.getCodUbicacionAreaVerde());
      inParams.put("CodVia", direccionBean.getCodVia());
      inParams.put("CodBarrio", direccionBean.getCodBarrio());
      inParams.put("CodSector", direccionBean.getCodSector());
      inParams.put("ParametroBusqueda", null);
      inParams.put("Usuario", direccionBean.getUsuario());
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
  public List<DireccionBean> listar(String parametroBusqueda,  Integer codUsuario) throws Exception   {

    List<DireccionBean> lista = new ArrayList<DireccionBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_direcciones").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("CodBarrioVia", Types.INTEGER),
                                            new SqlParameter("CodSectorVia", Types.INTEGER),
                                            new SqlParameter("Cuadra", Types.INTEGER),
                                            new SqlParameter("Manzana", Types.VARCHAR),
                                            new SqlParameter("CodLado", Types.VARCHAR),
                                            new SqlParameter("LoteInicial", Types.INTEGER),
                                            new SqlParameter("LoteFinal", Types.INTEGER),
                                            new SqlParameter("CodZona", Types.INTEGER),
                                            new SqlParameter("CodRuta", Types.INTEGER),
                                            new SqlParameter("CodUbicacionAreaVerde", Types.INTEGER),
                                            new SqlParameter("CodVia", Types.INTEGER),
                                            new SqlParameter("CodBarrio", Types.INTEGER),
                                            new SqlParameter("CodSector", Types.INTEGER),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("CodDireccion", null);
      inParams.put("CodBarrioVia",  null);
      inParams.put("CodSectorVia",  null);
      inParams.put("Cuadra",  null);
      inParams.put("Manzana", null);
      inParams.put("CodLado",  null);
      inParams.put("LoteInicial", null);
      inParams.put("LoteFinal",  null);
      inParams.put("CodZona",  null);
      inParams.put("CodRuta", null);
      inParams.put("CodUbicacionAreaVerde",  null);
      inParams.put("CodVia",  null);
      inParams.put("CodBarrio",  null);
      inParams.put("CodSector",  null);
      inParams.put("ParametroBusqueda", parametroBusqueda);
      inParams.put("Usuario", codUsuario);

      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          DireccionBean obj = new DireccionBean();
          obj.setCodDireccion(temp.get("codDireccion")!= null ? Integer.parseInt(String.valueOf(temp.get(     "codDireccion"))) : null);
          obj.setDireccionCompleta(temp.get("direccionCompleta")!= null ? String.valueOf(temp.get("direccionCompleta")) :
                                           null);
          obj.setRuta(temp.get("ruta")!= null ? String.valueOf(temp.get("ruta")) : null);
          obj.setZona(temp.get("zona")!= null ? String.valueOf(temp.get("zona")) : null);
          obj.setUbicacionAreaVerde(temp.get("ubicacionAreaVerde")!= null ? String.valueOf(temp.get("ubicacionAreaVerde")) :
                                            null);
          obj.setNombreSectorCompleto(temp.get("nombreSectorCompleto")!= null ?
                                              String.valueOf(temp.get("nombreSectorCompleto")) :
                                              null);

          obj.setManzana(temp.get("manzana")!= null ? String.valueOf(temp.get("manzana")) : null);

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


