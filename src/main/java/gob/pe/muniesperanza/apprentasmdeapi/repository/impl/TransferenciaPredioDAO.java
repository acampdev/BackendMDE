package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TransferenciaPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.TransferenciaPredioIDAO;
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
public class TransferenciaPredioDAO  extends SimpleJdbcDaoBase  implements TransferenciaPredioIDAO {



  public TransferenciaPredioDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public ClsResultDAO insertar(TransferenciaPredioBean transferenciaPredioBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_transferencia_predio")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodTransferencia", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodContribuyenteVenta", Types.INTEGER),
                                            new SqlParameter("CodContribuyenteCompra", Types.INTEGER),
                                            new SqlParameter("PorcentajeTransferencia", Types.DECIMAL),
                                            new SqlParameter("FechaMinuta", Types.DATE),
                                            new SqlParameter("Documento", Types.VARCHAR),
                                            new SqlParameter("CodModoTransferencia", Types.VARCHAR),
                                            new SqlParameter("ValorTransferencia", Types.DECIMAL),
                                            new SqlParameter("EsConstructor", Types.BIT),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // Tipo 1 es para insertar
      inParams.put("CodTransferencia", transferenciaPredioBean.getCodTransferencia());
      inParams.put("Anio", transferenciaPredioBean.getAnio());
      inParams.put("CodPredio", transferenciaPredioBean.getCodPredio());
      inParams.put("CodContribuyenteVenta", transferenciaPredioBean.getCodContribuyenteVenta());
      inParams.put("CodContribuyenteCompra", transferenciaPredioBean.getCodContribuyenteCompra());
      inParams.put("PorcentajeTransferencia", transferenciaPredioBean.getPorcentajeTransferencia());
      inParams.put("FechaMinuta", transferenciaPredioBean.getFechaMinuta());
      inParams.put("Documento", transferenciaPredioBean.getDocumento());
      inParams.put("CodModoTransferencia", transferenciaPredioBean.getCodModoTransferencia());
      inParams.put("ValorTransferencia", transferenciaPredioBean.getValorTransferencia());
      inParams.put("EsConstructor", transferenciaPredioBean.getEsConstructor());
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
  public ClsResultDAO actualizar(TransferenciaPredioBean transferenciaPredioBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();

    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_transferencia_predio")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodTransferencia", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodContribuyenteVenta", Types.INTEGER),
                                            new SqlParameter("CodContribuyenteCompra", Types.INTEGER),
                                            new SqlParameter("PorcentajeTransferencia", Types.DECIMAL),
                                            new SqlParameter("FechaMinuta", Types.DATE),
                                            new SqlParameter("Documento", Types.VARCHAR),
                                            new SqlParameter("CodModoTransferencia", Types.VARCHAR),
                                            new SqlParameter("ValorTransferencia", Types.DECIMAL),
                                            new SqlParameter("EsConstructor", Types.BIT),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // Tipo 2 es para actualizar
      inParams.put("CodTransferencia", transferenciaPredioBean.getCodTransferencia());
      inParams.put("Anio", transferenciaPredioBean.getAnio());
      inParams.put("CodPredio", transferenciaPredioBean.getCodPredio());
      inParams.put("CodContribuyenteVenta", transferenciaPredioBean.getCodContribuyenteVenta());
      inParams.put("CodContribuyenteCompra", transferenciaPredioBean.getCodContribuyenteCompra());
      inParams.put("PorcentajeTransferencia", transferenciaPredioBean.getPorcentajeTransferencia());
      inParams.put("FechaMinuta", transferenciaPredioBean.getFechaMinuta());
      inParams.put("Documento", transferenciaPredioBean.getDocumento());
      inParams.put("CodModoTransferencia", transferenciaPredioBean.getCodModoTransferencia());
      inParams.put("ValorTransferencia", transferenciaPredioBean.getValorTransferencia());
      inParams.put("EsConstructor", transferenciaPredioBean.getEsConstructor());
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
  public List<TransferenciaPredioBean> listaTransferenciaPredio(Integer codTransferencia, String codPredio, Integer anio
  ,Integer codContribuyenteVenta,Integer codContribuyenteCompra) throws Exception   {

    List<TransferenciaPredioBean> lista = new ArrayList<TransferenciaPredioBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_transferencia_predio").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodTransferencia", Types.INTEGER),
                                            new SqlParameter("Anio", Types.INTEGER),
                                            new SqlParameter("CodPredio", Types.VARCHAR),
                                            new SqlParameter("CodContribuyenteVenta", Types.INTEGER),
                                            new SqlParameter("CodContribuyenteCompra", Types.INTEGER),
                                            new SqlParameter("PorcentajeTransferencia", Types.DECIMAL),
                                            new SqlParameter("FechaMinuta", Types.DATE),
                                            new SqlParameter("Documento", Types.VARCHAR),
                                            new SqlParameter("CodModoTransferencia", Types.VARCHAR),
                                            new SqlParameter("ValorTransferencia", Types.DECIMAL),
                                            new SqlParameter("EsConstructor", Types.BIT),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    ) ;
      Map<String, Object> inParams = new HashMap<>();



      inParams.put("Tipo", 3); // Tipo 3 es para listar
      inParams.put("CodTransferencia", codTransferencia);
      inParams.put("Anio", anio);
      inParams.put("CodPredio", codPredio);
      inParams.put("CodContribuyenteVenta", codContribuyenteVenta);
      inParams.put("CodContribuyenteCompra", codContribuyenteCompra);
      inParams.put("PorcentajeTransferencia", null);
      inParams.put("FechaMinuta", null);
      inParams.put("Documento",  null);
      inParams.put("CodModoTransferencia", null);
      inParams.put("ValorTransferencia", null);
      inParams.put("EsConstructor",  null);
      inParams.put("Usuario", 1);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          TransferenciaPredioBean obj = new TransferenciaPredioBean();
          obj.setCodTransferencia(Integer.valueOf(String.valueOf(temp.get("codTransferencia"))));
          obj.setAnio(Integer.valueOf(String.valueOf(temp.get("anio"))));
          obj.setCodPredio(temp.get("codPredio")!= null ? String.valueOf(temp.get("codPredio")) :null);
          obj.setCodContribuyenteVenta(Integer.valueOf(String.valueOf(temp.get("codContribuyenteVenta"))));
          obj.setCodContribuyenteCompra(Integer.valueOf(String.valueOf(temp.get("codContribuyenteCompra"))));


          obj.setCodAlcabala(Integer.parseInt(String.valueOf(temp.get("codAlcabala"))));
          obj.setFechaMinuta(Date.valueOf(String.valueOf(temp.get("fechaMinuta"))));
          obj.setPorcentajeTransferencia(Double.valueOf(String.valueOf(temp.get("porcentajeTransferencia"))));
          obj.setFechaTransferencia(Date.valueOf(String.valueOf(temp.get("fechaTransferencia"))));
          obj.setDocumento(temp.get("documentoTransferencia")!= null ? String.valueOf(temp.get("documentoTransferencia")):  null);
          obj.setCodModoTransferencia(String.valueOf(temp.get("CodModoTransferencia")));
          obj.setModoTransferencia(String.valueOf(temp.get("modoTransferencia")));
          obj.setValorTransferencia(Double.valueOf(String.valueOf(temp.get("valorTransferencia"))));

          obj.setValorUit(Double.valueOf(String.valueOf(temp.get("valorUit"))));
          obj.setBaseImponibleAlcabala(Double.valueOf(String.valueOf(temp.get("baseImponibleAlcabala"))));
          obj.setMontoAlcabala(Double.valueOf(String.valueOf(temp.get("montoAlcabala"))));
          obj.setInafecta(Boolean.valueOf(String.valueOf(temp.get("inafecta"))));
          obj.setTasaAlcabala(Double.valueOf(String.valueOf(temp.get("tasaAlcabala"))));



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
