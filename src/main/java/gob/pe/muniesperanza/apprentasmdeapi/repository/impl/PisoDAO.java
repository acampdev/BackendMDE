package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.ArbitrioLimpiezaPublicaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PisoBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.PisoIDAO;
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
public class PisoDAO  extends SimpleJdbcDaoBase implements PisoIDAO {

  private static final String LISTAR_PISO = "SELECT * FROM vw_pisos where 1=1 ";


  public PisoDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public ClsResultDAO insertarPiso(PisoBean pisoBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {


      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_piso")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodPredioBase", Types.VARCHAR),
                                            new SqlParameter("CodPiso", Types.INTEGER),
                                            new SqlParameter("NumeroPiso", Types.INTEGER),
                                            new SqlParameter("FechaConstruccion", Types.DATE),
                                            new SqlParameter("MurosColumnas", Types.VARCHAR),
                                            new SqlParameter("Techos", Types.VARCHAR),
                                            new SqlParameter("Pisos", Types.VARCHAR),
                                            new SqlParameter("PuertasVentanas", Types.VARCHAR),
                                            new SqlParameter("Revestimiento", Types.VARCHAR),
                                            new SqlParameter("Banios", Types.VARCHAR),
                                            new SqlParameter("InstalacionesElectricas", Types.VARCHAR),
                                            new SqlParameter("CodLetraMurosColumnas", Types.VARCHAR),
                                            new SqlParameter("CodLetraTechos", Types.VARCHAR),
                                            new SqlParameter("CodLetraPisos", Types.VARCHAR),
                                            new SqlParameter("CodLetraPuertasVentanas", Types.VARCHAR),
                                            new SqlParameter("CodLetraRevestimiento", Types.VARCHAR),
                                            new SqlParameter("CodLetraBanios", Types.VARCHAR),
                                            new SqlParameter("CodLetraInstalacionesElectricas", Types.VARCHAR),
                                            new SqlParameter("CodEstadoConservacion", Types.VARCHAR),
                                            new SqlParameter("CodMaterialEstructural", Types.VARCHAR),
                                            new SqlParameter("AreaConstruida", Types.DECIMAL),
                                            new SqlParameter("ValorAreasComunes", Types.DECIMAL),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("Anio", pisoBean.getAnio());
      inParams.put("CodPredio", pisoBean.getCodPredio());
      inParams.put("CodPredioBase", pisoBean.getCodPredio());
      inParams.put("CodPiso", pisoBean.getCodPiso());
      inParams.put("NumeroPiso", pisoBean.getNumeroPiso());
      inParams.put("FechaConstruccion", pisoBean.getFechaConstruccion());
      inParams.put("MurosColumnas", pisoBean.getMurosColumnas());
      inParams.put("Techos", pisoBean.getTechos());
      inParams.put("Pisos", pisoBean.getPisos());
      inParams.put("PuertasVentanas", pisoBean.getPuertasVentanas());
      inParams.put("Revestimiento", pisoBean.getRevestimiento());
      inParams.put("Banios", pisoBean.getBanios());
      inParams.put("InstalacionesElectricas", pisoBean.getInstalacionesElectricas());
      inParams.put("CodLetraMurosColumnas", pisoBean.getCodLetraMurosColumnas());
      inParams.put("CodLetraTechos", pisoBean.getCodLetraTechos());
      inParams.put("CodLetraPisos", pisoBean.getCodLetraPisos());
      inParams.put("CodLetraPuertasVentanas", pisoBean.getCodLetraPuertasVentanas());
      inParams.put("CodLetraRevestimiento", pisoBean.getCodLetraRevestimiento());
      inParams.put("CodLetraBanios", pisoBean.getCodLetraBanios());
      inParams.put("CodLetraInstalacionesElectricas", pisoBean.getCodLetraInstalacionesElectricas());
      inParams.put("CodEstadoConservacion", pisoBean.getCodEstadoConservacion());
      inParams.put("CodMaterialEstructural", pisoBean.getCodMaterialEstructural());
      inParams.put("AreaConstruida", pisoBean.getAreaConstruida());
      inParams.put("ValorAreasComunes", pisoBean.getValorAreasComunes());
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
  public ClsResultDAO actualizarPiso(PisoBean pisoBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_piso")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodPredioBase", Types.VARCHAR),
                                            new SqlParameter("CodPiso", Types.INTEGER),
                                            new SqlParameter("NumeroPiso", Types.INTEGER),
                                            new SqlParameter("FechaConstruccion", Types.DATE),
                                            new SqlParameter("MurosColumnas", Types.VARCHAR),
                                            new SqlParameter("Techos", Types.VARCHAR),
                                            new SqlParameter("Pisos", Types.VARCHAR),
                                            new SqlParameter("PuertasVentanas", Types.VARCHAR),
                                            new SqlParameter("Revestimiento", Types.VARCHAR),
                                            new SqlParameter("Banios", Types.VARCHAR),
                                            new SqlParameter("InstalacionesElectricas", Types.VARCHAR),
                                            new SqlParameter("CodLetraMurosColumnas", Types.VARCHAR),
                                            new SqlParameter("CodLetraTechos", Types.VARCHAR),
                                            new SqlParameter("CodLetraPisos", Types.VARCHAR),
                                            new SqlParameter("CodLetraPuertasVentanas", Types.VARCHAR),
                                            new SqlParameter("CodLetraRevestimiento", Types.VARCHAR),
                                            new SqlParameter("CodLetraBanios", Types.VARCHAR),
                                            new SqlParameter("CodLetraInstalacionesElectricas", Types.VARCHAR),
                                            new SqlParameter("CodEstadoConservacion", Types.VARCHAR),
                                            new SqlParameter("CodMaterialEstructural", Types.VARCHAR),
                                            new SqlParameter("AreaConstruida", Types.DECIMAL),
                                            new SqlParameter("ValorAreasComunes", Types.DECIMAL),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("Anio", pisoBean.getAnio());
      inParams.put("CodPredio", pisoBean.getCodPredio());
      inParams.put("CodPredioBase", pisoBean.getCodPredio());

      inParams.put("CodPiso", pisoBean.getCodPiso());
      inParams.put("NumeroPiso", pisoBean.getNumeroPiso());
      inParams.put("FechaConstruccion", pisoBean.getFechaConstruccion());
      inParams.put("MurosColumnas", pisoBean.getMurosColumnas());
      inParams.put("Techos", pisoBean.getTechos());
      inParams.put("Pisos", pisoBean.getPisos());
      inParams.put("PuertasVentanas", pisoBean.getPuertasVentanas());
      inParams.put("Revestimiento", pisoBean.getRevestimiento());
      inParams.put("Banios", pisoBean.getBanios());
      inParams.put("InstalacionesElectricas", pisoBean.getInstalacionesElectricas());
      inParams.put("CodLetraMurosColumnas", pisoBean.getCodLetraMurosColumnas());
      inParams.put("CodLetraTechos", pisoBean.getCodLetraTechos());
      inParams.put("CodLetraPisos", pisoBean.getCodLetraPisos());
      inParams.put("CodLetraPuertasVentanas", pisoBean.getCodLetraPuertasVentanas());
      inParams.put("CodLetraRevestimiento", pisoBean.getCodLetraRevestimiento());
      inParams.put("CodLetraBanios", pisoBean.getCodLetraBanios());
      inParams.put("CodLetraInstalacionesElectricas", pisoBean.getCodLetraInstalacionesElectricas());
      inParams.put("CodEstadoConservacion", pisoBean.getCodEstadoConservacion());
      inParams.put("CodMaterialEstructural", pisoBean.getCodMaterialEstructural());
      inParams.put("AreaConstruida", pisoBean.getAreaConstruida());
      inParams.put("ValorAreasComunes", pisoBean.getValorAreasComunes());
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

  public ClsResultDAO eliminarPiso(PisoBean pisoBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_piso")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodPredioBase", Types.VARCHAR),
                                            new SqlParameter("CodPiso", Types.INTEGER),
                                            new SqlParameter("NumeroPiso", Types.INTEGER),
                                            new SqlParameter("FechaConstruccion", Types.DATE),
                                            new SqlParameter("MurosColumnas", Types.VARCHAR),
                                            new SqlParameter("Techos", Types.VARCHAR),
                                            new SqlParameter("Pisos", Types.VARCHAR),
                                            new SqlParameter("PuertasVentanas", Types.VARCHAR),
                                            new SqlParameter("Revestimiento", Types.VARCHAR),
                                            new SqlParameter("Banios", Types.VARCHAR),
                                            new SqlParameter("InstalacionesElectricas", Types.VARCHAR),
                                            new SqlParameter("CodLetraMurosColumnas", Types.VARCHAR),
                                            new SqlParameter("CodLetraTechos", Types.VARCHAR),
                                            new SqlParameter("CodLetraPisos", Types.VARCHAR),
                                            new SqlParameter("CodLetraPuertasVentanas", Types.VARCHAR),
                                            new SqlParameter("CodLetraRevestimiento", Types.VARCHAR),
                                            new SqlParameter("CodLetraBanios", Types.VARCHAR),
                                            new SqlParameter("CodLetraInstalacionesElectricas", Types.VARCHAR),
                                            new SqlParameter("CodEstadoConservacion", Types.VARCHAR),
                                            new SqlParameter("CodMaterialEstructural", Types.VARCHAR),
                                            new SqlParameter("AreaConstruida", Types.DECIMAL),
                                            new SqlParameter("ValorAreasComunes", Types.DECIMAL),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // Tipo 3 es para eliminar
      inParams.put("Anio", pisoBean.getAnio());
      inParams.put("CodPredio", pisoBean.getCodPredio());
      inParams.put("CodPredioBase", null);
      inParams.put("CodPiso", pisoBean.getCodPiso());
      inParams.put("NumeroPiso", pisoBean.getNumeroPiso());
      inParams.put("FechaConstruccion", null);
      inParams.put("MurosColumnas", null);
      inParams.put("Techos", null);
      inParams.put("Pisos", null);
      inParams.put("PuertasVentanas",null);
      inParams.put("Revestimiento", null);
      inParams.put("Banios", null);
      inParams.put("InstalacionesElectricas", null);
      inParams.put("CodLetraMurosColumnas", null);
      inParams.put("CodLetraTechos", null);
      inParams.put("CodLetraPisos", null);
      inParams.put("CodLetraPuertasVentanas", null);
      inParams.put("CodLetraRevestimiento",null);
      inParams.put("CodLetraBanios", null);
      inParams.put("CodLetraInstalacionesElectricas", null);
      inParams.put("CodEstadoConservacion", null);
      inParams.put("CodMaterialEstructural", null);
      inParams.put("AreaConstruida", null);
      inParams.put("ValorAreasComunes", null);
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
  public List<PisoBean> listarPiso( Integer anio, String codPredioBase) throws Exception {


    List<PisoBean> lista = new ArrayList<PisoBean>();
    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_piso")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodPredioBase", Types.VARCHAR),
                                            new SqlParameter("CodPiso", Types.INTEGER),
                                            new SqlParameter("NumeroPiso", Types.INTEGER),
                                            new SqlParameter("FechaConstruccion", Types.DATE),
                                            new SqlParameter("MurosColumnas", Types.VARCHAR),
                                            new SqlParameter("Techos", Types.VARCHAR),
                                            new SqlParameter("Pisos", Types.VARCHAR),
                                            new SqlParameter("PuertasVentanas", Types.VARCHAR),
                                            new SqlParameter("Revestimiento", Types.VARCHAR),
                                            new SqlParameter("Banios", Types.VARCHAR),
                                            new SqlParameter("InstalacionesElectricas", Types.VARCHAR),
                                            new SqlParameter("CodLetraMurosColumnas", Types.VARCHAR),
                                            new SqlParameter("CodLetraTechos", Types.VARCHAR),
                                            new SqlParameter("CodLetraPisos", Types.VARCHAR),
                                            new SqlParameter("CodLetraPuertasVentanas", Types.VARCHAR),
                                            new SqlParameter("CodLetraRevestimiento", Types.VARCHAR),
                                            new SqlParameter("CodLetraBanios", Types.VARCHAR),
                                            new SqlParameter("CodLetraInstalacionesElectricas", Types.VARCHAR),
                                            new SqlParameter("CodEstadoConservacion", Types.VARCHAR),
                                            new SqlParameter("CodMaterialEstructural", Types.VARCHAR),
                                            new SqlParameter("AreaConstruida", Types.DECIMAL),
                                            new SqlParameter("ValorAreasComunes", Types.DECIMAL),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // Tipo 4 es para listar
      inParams.put("Anio", anio);
      inParams.put("CodPredio", null);
      inParams.put("CodPredioBase", codPredioBase);
      inParams.put("CodPiso", null);
      inParams.put("NumeroPiso", null);
      inParams.put("FechaConstruccion", null);
      inParams.put("MurosColumnas",  null);
      inParams.put("Techos",  null);
      inParams.put("Pisos",  null);
      inParams.put("PuertasVentanas",  null);
      inParams.put("Revestimiento",  null);
      inParams.put("Banios",  null);
      inParams.put("InstalacionesElectricas", null);
      inParams.put("CodLetraMurosColumnas",  null);
      inParams.put("CodLetraTechos",  null);
      inParams.put("CodLetraPisos",  null);
      inParams.put("CodLetraPuertasVentanas", null);
      inParams.put("CodLetraRevestimiento",  null);
      inParams.put("CodLetraBanios",  null);
      inParams.put("CodLetraInstalacionesElectricas", null);
      inParams.put("CodEstadoConservacion",  null);
      inParams.put("CodMaterialEstructural", null);
      inParams.put("AreaConstruida", null);
      inParams.put("ValorAreasComunes", null);
      inParams.put("Usuario", 1);
    Map<String, Object> result = stmt.execute(inParams);
    // Map<?, ?> result = stmt.execute();
    List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

    if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

      lista = listaBd.stream().map(temp -> {
        PisoBean obj = new PisoBean();
        obj.setAnio(temp.get("anio")!= null ? Integer.valueOf(String.valueOf(temp.get(
                "anio"))):  null);
        obj.setCodPredioBase(temp.get("codPredioBase")!= null ? String.valueOf(temp.get(
                "codPredioBase")):  null);
        obj.setCodPiso(temp.get("codPiso")!= null ? Integer.valueOf(String.valueOf(temp.get("codPiso"))) :
                                   null);

        obj.setCodPredio(temp.get("codPredio")!= null ? String.valueOf(temp.get(
                "codPredio")):  null);
        obj.setNumeroPisoDesc(temp.get("numeroPisoDesc")!= null ?
                                  String.valueOf(temp.get("numeroPisoDesc")) :
                               null);
        obj.setNumeroPiso(temp.get("numeroPiso")!= null ? Integer.valueOf(String.valueOf(temp.get("numeroPiso"))) :
                               null);
        obj.setFechaConstruccion(temp.get("fechaConstruccion")!= null ? Date.valueOf(String.valueOf(temp.get(
                "fechaConstruccion"))):  null);

        obj.setValorUnitario(temp.get("valorUnitario")!= null ? Double.valueOf(String.valueOf(temp.get(
                "valorUnitario"))):  null);

        obj.setIncremento(temp.get("incremento")!= null ? Double.valueOf(String.valueOf(temp.get(
                "incremento"))):  null);

        obj.setDepreciacion(temp.get("depreciacion")!= null ? Double.valueOf(String.valueOf(temp.get(
                "depreciacion"))):  null);

        obj.setValorUnitarioDepreciado(temp.get("valorUnitarioDepreciado")!= null ?
                                               Double.valueOf(String.valueOf(temp.get(
                "valorUnitarioDepreciado"))):  null);
        obj.setValorAreaConstruida(temp.get("valorAreaConstruida")!= null ?
                                               Double.valueOf(String.valueOf(temp.get(
                                                       "valorAreaConstruida"))):  null);
        obj.setValorConstruccion(temp.get("valorConstruccion")!= null ?
                                               Double.valueOf(String.valueOf(temp.get(
                                                       "valorConstruccion"))):  null);
        obj.setAreaConstruida(temp.get("areaContruida")!= null ?
                                         Double.valueOf(String.valueOf(temp.get(
                                                 "areaContruida"))):  null);
        obj.setAreaConstruida(temp.get("areaContruida")!= null ?
                                      Double.valueOf(String.valueOf(temp.get(
                                              "areaContruida"))):  null);

        obj.setAreaTotalConstruccion(temp.get("areaTotalConstruccion")!= null ?
                                      Double.valueOf(String.valueOf(temp.get(
                                              "areaTotalConstruccion"))):  null);
        obj.setCodLetraMurosColumnas(temp.get("codLetraMurosColumnas")!= null ?
                                             String.valueOf(temp.get("codLetraMurosColumnas")):  null);
        obj.setMurosColumnas(temp.get("murosColumnas")!= null ?
                                             String.valueOf(temp.get("murosColumnas")):  null);
        obj.setCodLetraTechos(temp.get("codLetraTechos")!= null ?
                                     String.valueOf(temp.get("codLetraTechos")):  null);
        obj.setTechos(temp.get("techos")!= null ?  String.valueOf(temp.get("techos")):  null);
        obj.setCodLetraPisos(temp.get("codLetraPisos")!= null ?  String.valueOf(temp.get("codLetraPisos")):  null);
        obj.setPisos(temp.get("pisos")!= null ?  String.valueOf(temp.get("pisos")):  null);
        obj.setCodLetraPuertasVentanas(temp.get("codLetraPuertasVentanas")!= null ?  String.valueOf(temp.get("codLetraPuertasVentanas")):  null);
        obj.setPuertasVentanas(temp.get("puertasVentanas")!= null ?  String.valueOf(temp.get(
                "puertasVentanas")):  null);
        obj.setCodLetraRevestimiento(temp.get("codLetraRevestimiento")!= null ?  String.valueOf(temp.get(
                "codLetraRevestimiento")):  null);
        obj.setRevestimiento(temp.get("revestimiento")!= null ?  String.valueOf(temp.get(
                "revestimiento")):  null);
        obj.setCodLetraBanios(temp.get("codLetraBanios")!= null ?  String.valueOf(temp.get(
                "codLetraBanios")):  null);
        obj.setBanios(temp.get("banios")!= null ?  String.valueOf(temp.get("banios")):  null);
        obj.setCodLetraInstalacionesElectricas(temp.get("codLetraInstalacionesElectricas")!= null ?  String.valueOf(temp.get("codLetraInstalacionesElectricas")):  null);
        obj.setInstalacionesElectricas(temp.get("instalacionesElectricas")!= null ?
                                                        String.valueOf(temp.get("instalacionesElectricas")):  null);
        obj.setCodEstadoConservacion(temp.get("codEstadoConservacion")!= null ?
                                               String.valueOf(temp.get("codEstadoConservacion")):  null);
        obj.setCodMaterialEstructural(temp.get("codMaterialEstructural")!= null ?
                                             String.valueOf(temp.get("codMaterialEstructural")):  null);
        obj.setIncremento5(temp.get("incremento5")!= null ?
                                             Double.valueOf(String.valueOf(temp.get(
                                                     "incremento5"))):  null);

        obj.setCostoTotalValorUnitario(temp.get("costoTotalValorUnitario")!= null ?
                                  Double.valueOf(String.valueOf(temp.get(
                                          "costoTotalValorUnitario"))):  null);

                      obj.setMontoDepreciado(temp.get("montoDepreciado")!= null ?
                                                    Double.valueOf(String.valueOf(temp.get(
                                                            "montoDepreciado"))):  null);
                      obj.setAreaConstruida(temp.get("areaConstruida")!= null ?
                                                       Double.valueOf(String.valueOf(temp.get(
                                                               "areaConstruida"))):  null);
        obj.setValorAreasComunes(temp.get("valorAreasComunes")!= null ?
                                         Double.valueOf(String.valueOf(temp.get(
                                                 "valorAreasComunes"))):  null);
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
  public List<PisoBean> listarPisoAll(String codPredioBase, Integer anio, Integer numeroPiso) throws Exception   {


    String sql = LISTAR_PISO;

    if(codPredioBase!=null){
      sql = sql + " AND codPredioBase = '" + codPredioBase + "'";
    }
    if(anio!=null){
      sql = sql + " AND anio = '" + anio + "'";
    }
    if(numeroPiso!=null){
      sql = sql + " AND numeroPiso = '" + numeroPiso + "'";
    }

    sql = sql + " ORDER BY codPredioBase desc ";


    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PisoBean.class));
  }
}

