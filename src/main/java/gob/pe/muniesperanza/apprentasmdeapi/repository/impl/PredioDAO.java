package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioParquesJardinesBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioSerenazgoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PredioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.*;
@Repository
public class PredioDAO   extends SimpleJdbcDaoBase implements PredioIDAO {

  private static final String LISTAR_PREDIO = "SELECT * FROM vw_predios WHERE 1=1 ";
  private static final String SP_PREDIO = "sp_predios";
  private static final String LISTAR_USOS = "SELECT * FROM vw_usos";

  public PredioDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public ClsResultDAO insertarPredio(PredioBean predioBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName(SP_PREDIO)
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodPredioBase", Types.VARCHAR),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("NumeroFinca", Types.INTEGER),
                                            new SqlParameter("OtroNumero", Types.VARCHAR),
                                            new SqlParameter("CodClasificacion", Types.VARCHAR),
                                            new SqlParameter("EstPredio", Types.VARCHAR),
                                            new SqlParameter("CodTipoPredio", Types.VARCHAR),
                                            new SqlParameter("CodCondicionPropiedad", Types.VARCHAR),
                                            new SqlParameter("CodUso", Types.INTEGER),
                                            new SqlParameter("FechaAdquisicion", Types.DATE),
                                            new SqlParameter("CodListaConductor", Types.VARCHAR),
                                            new SqlParameter("AreaTerreno", Types.DECIMAL),
                                            new SqlParameter("ValorOtrasInstalaciones", Types.DECIMAL),
                                            new SqlParameter("RutaImagenFoto", Types.VARCHAR),
                                            new SqlParameter("RutaImagenPlano", Types.VARCHAR),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
//      System.out.println("DATOS ESTADO PREDIO"+predioBean.getCodEstadoPredio());
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("Anio", predioBean.getAnio());
      inParams.put("CodPredio", null);
      inParams.put("CodPredioBase", predioBean.getCodPredioBase());
      inParams.put("CodDireccion", predioBean.getCodDireccion());
      inParams.put("NumeroFinca", predioBean.getNumeroFinca());
      inParams.put("OtroNumero", predioBean.getOtroNumero());
      inParams.put("CodClasificacion", predioBean.getCodClasificacion());
      inParams.put("EstPredio", predioBean.getEstPredio());
      inParams.put("CodTipoPredio", predioBean.getCodTipoPredio());
      inParams.put("CodCondicionPropiedad", predioBean.getCodCondicionPropiedad());
      inParams.put("CodUso", predioBean.getCodUsoPredio());
      inParams.put("FechaAdquisicion", predioBean.getFechaAdquisicion());
      inParams.put("CodListaConductor", predioBean.getCodListaConductor());
      inParams.put("AreaTerreno", predioBean.getAreaTerreno());
      inParams.put("ValorOtrasInstalaciones", predioBean.getValorOtrasInstalaciones());
      inParams.put("RutaImagenFoto", predioBean.getRutaImagenFoto());
      inParams.put("RutaImagenPlano", predioBean.getRutaImagenPlano());
      inParams.put("ParametroBusqueda", predioBean.getParametroBusqueda());
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
  public ClsResultDAO actualizarPredio(PredioBean predioBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName(SP_PREDIO)
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodPredioBase", Types.VARCHAR),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("NumeroFinca", Types.INTEGER),
                                            new SqlParameter("OtroNumero", Types.VARCHAR),
                                            new SqlParameter("CodClasificacion", Types.VARCHAR),
                                            new SqlParameter("EstPredio", Types.VARCHAR),
                                            new SqlParameter("CodTipoPredio", Types.VARCHAR),
                                            new SqlParameter("CodCondicionPropiedad", Types.VARCHAR),
                                            new SqlParameter("CodUso", Types.INTEGER),
                                            new SqlParameter("FechaAdquisicion", Types.DATE),
                                            new SqlParameter("CodListaConductor", Types.VARCHAR),
                                            new SqlParameter("AreaTerreno", Types.DECIMAL),
                                            new SqlParameter("ValorOtrasInstalaciones", Types.DECIMAL),
                                            new SqlParameter("RutaImagenFoto", Types.VARCHAR),
                                            new SqlParameter("RutaImagenPlano", Types.VARCHAR),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
//      System.out.println("DATOS ESTADO PREDIO"+predioBean.getCodEstadoPredio());
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("Anio", predioBean.getAnio());
      inParams.put("CodPredio", predioBean.getCodPredio());
      inParams.put("CodPredioBase", predioBean.getCodPredioBase());
      inParams.put("CodDireccion", predioBean.getCodDireccion());
      inParams.put("NumeroFinca", predioBean.getNumeroFinca());
      inParams.put("OtroNumero", predioBean.getOtroNumero());
      inParams.put("CodClasificacion", predioBean.getCodClasificacion());
      inParams.put("EstPredio", predioBean.getEstPredio());
      inParams.put("CodTipoPredio", predioBean.getCodTipoPredio());
      inParams.put("CodCondicionPropiedad", predioBean.getCodCondicionPropiedad());
      inParams.put("CodUso", predioBean.getCodUsoPredio());
      inParams.put("FechaAdquisicion", predioBean.getFechaAdquisicion());
      inParams.put("CodListaConductor", predioBean.getCodListaConductor());
      inParams.put("AreaTerreno", predioBean.getAreaTerreno());
      inParams.put("ValorOtrasInstalaciones", predioBean.getValorOtrasInstalaciones());
      inParams.put("RutaImagenFoto", predioBean.getRutaImagenFoto());
      inParams.put("RutaImagenPlano", predioBean.getRutaImagenPlano());
      inParams.put("ParametroBusqueda", predioBean.getParametroBusqueda());
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
  public List<PredioBean> listarPredio(Integer anio,String codPredioBase, String parametroBusqueda) throws Exception   {
    List<PredioBean> lista = new ArrayList<PredioBean>();

    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName(SP_PREDIO)
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodPredioBase", Types.VARCHAR),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("NumeroFinca", Types.INTEGER),
                                            new SqlParameter("OtroNumero", Types.VARCHAR),
                                            new SqlParameter("CodClasificacion", Types.VARCHAR),
                                            new SqlParameter("EstPredio", Types.VARCHAR),
                                            new SqlParameter("CodTipoPredio", Types.VARCHAR),
                                            new SqlParameter("CodCondicionPropiedad", Types.VARCHAR),
                                            new SqlParameter("CodUso", Types.INTEGER),
                                            new SqlParameter("FechaAdquisicion", Types.DATE),
                                            new SqlParameter("CodListaConductor", Types.VARCHAR),
                                            new SqlParameter("AreaTerreno", Types.DECIMAL),
                                            new SqlParameter("ValorOtrasInstalaciones", Types.DECIMAL),
                                            new SqlParameter("RutaImagenFoto", Types.VARCHAR),
                                            new SqlParameter("RutaImagenPlano", Types.VARCHAR),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 3); // Tipo 3 es para listar

      inParams.put("Anio", anio);
      inParams.put("CodPredio", null);
      inParams.put("CodPredioBase", codPredioBase);
      inParams.put("CodDireccion", null);
      inParams.put("NumeroFinca", null);
      inParams.put("OtroNumero", null);
      inParams.put("CodClasificacion", null);
      inParams.put("EstPredio", null);
      inParams.put("CodTipoPredio", null);
      inParams.put("CodCondicionPropiedad", null);
      inParams.put("CodUso", null);
      inParams.put("FechaAdquisicion", null);
      inParams.put("CodListaConductor", null);
      inParams.put("AreaTerreno", null);
      inParams.put("ValorOtrasInstalaciones", null);
      inParams.put("RutaImagenFoto", null);
      inParams.put("RutaImagenPlano", null);
      inParams.put("ParametroBusqueda", parametroBusqueda);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String, Object>>) result.get("#result-set-1");

      if (listaBd != null && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          PredioBean obj = new PredioBean();
          obj.setCodPredio(temp.get("codPredio") != null ? String.valueOf(temp.get("codPredio")) : null);
          obj.setCodPredioBase(temp.get("codPredioBase") != null ? String.valueOf(temp.get("codPredioBase")) : null);
          obj.setAnio(Integer.valueOf(String.valueOf(temp.get("anio"))));
          obj.setDireccion(temp.get("direccion") != null ? String.valueOf(temp.get("direccion")) : null);
          obj.setConductor(temp.get("conductor") != null ? String.valueOf(temp.get("conductor")) : null);
          obj.setEstadoPredio(temp.get("estadoPredio") != null ? String.valueOf(temp.get("estadoPredio")) : null);
          obj.setCondicionPropiedad(temp.get("condicionPropiedad") != null ? String.valueOf(temp.get("condicionPropiedad")) : null);
          obj.setAreaTerreno(temp.get("areaTerreno") != null ? Double.valueOf(String.valueOf(temp.get("areaTerreno"))) :
                                null);
          obj.setAreaTotalConstruida(temp.get("areaTotalConstruida") != null ? Double.valueOf(String.valueOf(temp.get("areaTotalConstruida"))) :
                                     null);
          obj.setValorTerreno(temp.get("valorTerreno") != null ? Double.valueOf(String.valueOf(temp.get("valorTerreno"))) : null);
          obj.setNombreSectorCompleto(temp.get("nombreSectorCompleto") != null ? String.valueOf(temp.get(
                  "nombreSectorCompleto")) : null);
          obj.setValorTotalConstruccion(temp.get("valorTotalConstruccion") != null ? Double.valueOf(String.valueOf(temp.get("valorTotalConstruccion"))) : null);
          obj.setCostoArancel(temp.get("costoArancel") != null ?
                                                 Double.valueOf(String.valueOf(temp.get("costoArancel"))) : null);



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
  public List<PredioBean> listarPredioAll(String codPredioBase,Integer anio) throws Exception   {


    String sql = LISTAR_PREDIO;

    if(codPredioBase!=null){
      sql = sql + " AND codPredioBase = '" + codPredioBase + "'";
    }
    if(anio!=null){
      sql = sql + " AND anio = '" + anio + "'";
    }

    sql = sql + " ORDER BY codPredioBase desc ";


    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PredioBean.class));
  }

  @Override
  public List<PredioBean> listarUsos() throws Exception {
    return jdbcTemplate.query(LISTAR_USOS, new BeanPropertyRowMapper<>(PredioBean.class));
  }

}

