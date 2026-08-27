package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ValoresUnitariosIDAO;
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
public class ValoresUnitariosDAO   extends SimpleJdbcDaoBase implements ValoresUnitariosIDAO {

  public ValoresUnitariosDAO(DataSource dataSource) {
    super(dataSource);
  }



  @Override
  public ClsResultDAO insertarValoresUnitarios(ValoresUnitariosBean valoresUnitariosBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_valoresUnitarios")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodValoresUnitarios", Types.VARCHAR),
                                            new SqlParameter("CodValoresUnitariosAnterior", Types.VARCHAR),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodLetra", Types.VARCHAR),
                                            new SqlParameter("CodCategoria", Types.VARCHAR),
                                            new SqlParameter("CodSubCategoria", Types.VARCHAR),
                                            new SqlParameter("Costo", Types.DOUBLE),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodValoresUnitarios", valoresUnitariosBean.getCodigoValorUnitario());
      inParams.put("CodValoresUnitariosAnterior", valoresUnitariosBean.getCodigoValorUnitarioAnterior());
      inParams.put("Anio", valoresUnitariosBean.getAnio());
      inParams.put("CodLetra", valoresUnitariosBean.getCodLetra());
      inParams.put("CodCategoria", valoresUnitariosBean.getCodCategoria());
      inParams.put("CodSubCategoria", valoresUnitariosBean.getCodSubcategoria());
      inParams.put("Costo", valoresUnitariosBean.getCosto());
      inParams.put("CodUsuario", 1);

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
  public ClsResultDAO actualizarValoresUnitarios(ValoresUnitariosBean valoresUnitariosBean) throws Exception{
    ClsResultDAO response = new ClsResultDAO();

    try {

      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_valoresUnitarios")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodValoresUnitarios", Types.VARCHAR),
                                            new SqlParameter("CodValoresUnitariosAnterior", Types.VARCHAR),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodLetra", Types.VARCHAR),
                                            new SqlParameter("CodCategoria", Types.VARCHAR),
                                            new SqlParameter("CodSubCategoria", Types.VARCHAR),
                                            new SqlParameter("Costo", Types.DOUBLE),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar

      inParams.put("CodValoresUnitarios", valoresUnitariosBean.getCodigoValorUnitario());
      inParams.put("CodValoresUnitariosAnterior", valoresUnitariosBean.getCodigoValorUnitarioAnterior());
      inParams.put("Anio", valoresUnitariosBean.getAnio());
      inParams.put("CodLetra", valoresUnitariosBean.getCodLetra());
      inParams.put("CodCategoria", valoresUnitariosBean.getCodCategoria());
      inParams.put("CodSubCategoria", valoresUnitariosBean.getCodSubcategoria());
      inParams.put("Costo", valoresUnitariosBean.getCosto());
      inParams.put("CodUsuario", 1);
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
  public List<ValoresUnitariosBean> listarValoresUnitarios(Integer anio) throws Exception   {

    List<ValoresUnitariosBean> lista = new ArrayList<ValoresUnitariosBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_valoresUnitarios")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodValoresUnitarios", Types.VARCHAR),
                                            new SqlParameter("CodValoresUnitariosAnterior", Types.VARCHAR),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodLetra", Types.VARCHAR),
                                            new SqlParameter("CodCategoria", Types.VARCHAR),
                                            new SqlParameter("CodSubCategoria", Types.VARCHAR),
                                            new SqlParameter("Costo", Types.DOUBLE),
                                            new SqlParameter("CodUsuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("CodValoresUnitarios", null);
      inParams.put("CodValoresUnitariosAnterior", null);
      inParams.put("Anio", anio);
      inParams.put("CodLetra", null);
      inParams.put("CodCategoria", null);
      inParams.put("CodSubCategoria", null);
      inParams.put("Costo", null);
      inParams.put("CodUsuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          ValoresUnitariosBean obj = new ValoresUnitariosBean();
          obj.setCodigoValorUnitario(temp.get("codValorUnitario")!= null ? String.valueOf(temp.get("codValorUnitario")) :
                              null);
          obj.setCodLetra(temp.get("letra")!= null ? String.valueOf(temp.get("letra")) :
                                             null);
          obj.setCodCategoria(temp.get("categoria")!= null ? String.valueOf(temp.get("categoria")) :
                                  null);
          obj.setCodSubcategoria(temp.get("subCategoria")!= null ? String.valueOf(temp.get("subCategoria")) :
                                  null);
          obj.setCosto(Double.valueOf(String.valueOf(temp.get("costo"))));
        //  obj.setAnio(Integer.valueOf(String.valueOf(temp.get("anio"))));
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
