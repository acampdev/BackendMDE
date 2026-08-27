package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ContribuyenteBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ContribuyenteIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
public class ContribuyenteDAO extends SimpleJdbcDaoBase implements ContribuyenteIDAO {

  private static final String LISTAR_CONTRIBUYENTE = "SELECT * FROM vw_contribuyente";

  //  Constructor
  public ContribuyenteDAO(DataSource dataSource) {
    super(dataSource);
  }

  //  Metodo para insertar nuevo contribuyente
  @Override
  public ClsResultDAO insertarContribuyente(ContribuyenteBean contribuyenteBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_contribuyente")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodPersona", Types.INTEGER),
                                            new SqlParameter("CodTipoContribuyente", Types.VARCHAR),
                                            new SqlParameter("CodTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("ApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("Telefono", Types.VARCHAR),
                                            new SqlParameter("CodSexo", Types.VARCHAR),
                                            new SqlParameter("CodEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("FechaNacimiento", Types.DATE),
                                            new SqlParameter("Direccion", Types.VARCHAR),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Exonerado", Types.INTEGER),
                                            new SqlParameter("Pensionista", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlParameter("CodConyuge", Types.INTEGER),
                                            new SqlParameter("ConyugeTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNombres", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("ConyugeSexo", Types.VARCHAR),
                                            new SqlParameter("ConyugeTelefono", Types.VARCHAR),
                                            new SqlParameter("ConyugeFechaNacimiento", Types.DATE),
                                            new SqlParameter("ConyugeCodDireccion", Types.INTEGER),
                                            new SqlParameter("ConyugeLote", Types.INTEGER),
                                            new SqlParameter("ConyugeOtros", Types.VARCHAR),
                                            new SqlParameter("CodRepresentanteLegal", Types.INTEGER),
                                            new SqlParameter("RepreTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNombres", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("RepreEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("RepreSexo", Types.VARCHAR),
                                            new SqlParameter("RepreTelefono", Types.VARCHAR),
                                            new SqlParameter("RepreFechaNacimiento", Types.DATE),
                                            new SqlParameter("RepreCodDireccion", Types.INTEGER),
                                            new SqlParameter("RepreLote", Types.INTEGER),
                                            new SqlParameter("RepreOtros", Types.VARCHAR),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 1); // insertar
      inParams.put("CodContribuyente", contribuyenteBean.getCodContribuyente());
      inParams.put("CodPersona", contribuyenteBean.getCodPersona());
      inParams.put("CodTipoContribuyente", contribuyenteBean.getCodTipoContribuyente());
      inParams.put("CodTipoDocumento", contribuyenteBean.getCodTipoDocumento());
      inParams.put("NumeroDocumento", contribuyenteBean.getNumerodocumento());
      inParams.put("Nombres", contribuyenteBean.getNombres());
      inParams.put("ApellidoPaterno", contribuyenteBean.getApellidopaterno());
      inParams.put("ApellidoMaterno", contribuyenteBean.getApellidomaterno());
      inParams.put("Telefono", contribuyenteBean.getTelefono());
      inParams.put("CodSexo", contribuyenteBean.getCodsexo());
      inParams.put("CodEstadoCivil", contribuyenteBean.getCodestadocivil());
      inParams.put("FechaNacimiento", contribuyenteBean.getFechanacimiento());
      inParams.put("Direccion", contribuyenteBean.getDireccion());
      inParams.put("CodDireccion", contribuyenteBean.getCodDireccion());
      inParams.put("Lote", contribuyenteBean.getLote());
      inParams.put("Otros", contribuyenteBean.getOtros());
      inParams.put("Exonerado", contribuyenteBean.getEsExonerado());
      inParams.put("Pensionista", contribuyenteBean.getEsPensionista());
      inParams.put("Usuario", 1);
      inParams.put("CodConyuge", contribuyenteBean.getCodConyuge());
      inParams.put("ConyugeTipoDocumento", contribuyenteBean.getConyugeTipoDocumento());
      inParams.put("ConyugeNumeroDocumento", contribuyenteBean.getConyugeNumeroDocumento());
      inParams.put("ConyugeNombres", contribuyenteBean.getConyugeNombres());
      inParams.put("ConyugeApellidoPaterno", contribuyenteBean.getConyugeApellidopaterno());
      inParams.put("ConyugeApellidoMaterno", contribuyenteBean.getConyugeApellidomaterno());
      inParams.put("ConyugeEstadoCivil", contribuyenteBean.getConyugeEstadocivil());
      inParams.put("ConyugeSexo", contribuyenteBean.getConyugeSexo());
      inParams.put("ConyugeTelefono", contribuyenteBean.getConyugeTelefono());
      inParams.put("ConyugeFechaNacimiento", contribuyenteBean.getConyugeFechanacimiento());
       inParams.put("ConyugeCodDireccion", contribuyenteBean.getConyugeCoddireccion());
      inParams.put("ConyugeLote", contribuyenteBean.getConyugeLote());
      inParams.put("ConyugeOtros", contribuyenteBean.getConyugeOtros());
      inParams.put("CodRepresentanteLegal", contribuyenteBean.getCodRepresentanteLegal());
      inParams.put("RepreTipoDocumento", contribuyenteBean.getRepreTipoDocumento());
      inParams.put("RepreNumeroDocumento", contribuyenteBean.getRepreNumeroDocumento());
      inParams.put("RepreNombres", contribuyenteBean.getRepreNombres());
      inParams.put("RepreApellidoPaterno", contribuyenteBean.getRepreApellidopaterno());
      inParams.put("RepreApellidoMaterno", contribuyenteBean.getRepreApellidomaterno());
      inParams.put("RepreEstadoCivil", contribuyenteBean.getRepreEstadocivil());
      inParams.put("RepreSexo", contribuyenteBean.getRepreSexo());
      inParams.put("RepreTelefono", contribuyenteBean.getRepreTelefono());
      inParams.put("RepreFechaNacimiento", contribuyenteBean.getRepreFechanacimiento());
      inParams.put("RepreCodDireccion", contribuyenteBean.getRepreCoddireccion());
      inParams.put("RepreLote", contribuyenteBean.getRepreLote());
      inParams.put("RepreOtros", contribuyenteBean.getRepreOtros());
      inParams.put("ParametroBusqueda", null);
      Map<String, Object> result = stmt.execute(inParams);

      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");

      System.out.println("Respuesta: " + respuesta);
      System.out.println("Mensaje: " + mensaje);

      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar : " + e.getMessage(), e);
    }
    return response;
  }


  @Override
  public ClsResultDAO actualizarContribuyente(ContribuyenteBean contribuyenteBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_contribuyente")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodPersona", Types.INTEGER),
                                            new SqlParameter("CodTipoContribuyente", Types.VARCHAR),
                                            new SqlParameter("CodTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("ApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("Telefono", Types.VARCHAR),
                                            new SqlParameter("CodSexo", Types.VARCHAR),
                                            new SqlParameter("CodEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("FechaNacimiento", Types.DATE),
                                            new SqlParameter("Direccion", Types.VARCHAR),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Exonerado", Types.INTEGER),
                                            new SqlParameter("Pensionista", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlParameter("CodConyuge", Types.INTEGER),
                                            new SqlParameter("ConyugeTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNombres", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("ConyugeSexo", Types.VARCHAR),
                                            new SqlParameter("ConyugeTelefono", Types.VARCHAR),
                                            new SqlParameter("ConyugeFechaNacimiento", Types.DATE),
                                            new SqlParameter("ConyugeCodDireccion", Types.INTEGER),
                                            new SqlParameter("ConyugeLote", Types.INTEGER),
                                            new SqlParameter("ConyugeOtros", Types.VARCHAR),
                                            new SqlParameter("CodRepresentanteLegal", Types.INTEGER),
                                            new SqlParameter("RepreTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNombres", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("RepreEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("RepreSexo", Types.VARCHAR),
                                            new SqlParameter("RepreTelefono", Types.VARCHAR),
                                            new SqlParameter("RepreFechaNacimiento", Types.DATE),
                                            new SqlParameter("RepreCodDireccion", Types.INTEGER),
                                            new SqlParameter("RepreLote", Types.INTEGER),
                                            new SqlParameter("RepreOtros", Types.VARCHAR),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 2); // actualizar
      inParams.put("CodContribuyente", contribuyenteBean.getCodContribuyente());
      inParams.put("CodPersona", contribuyenteBean.getCodPersona());
      inParams.put("CodTipoContribuyente", contribuyenteBean.getCodTipoContribuyente());
      inParams.put("CodTipoDocumento", contribuyenteBean.getCodTipoDocumento());
      inParams.put("NumeroDocumento", contribuyenteBean.getNumerodocumento());
      inParams.put("Nombres", contribuyenteBean.getNombres());
      inParams.put("ApellidoPaterno", contribuyenteBean.getApellidopaterno());
      inParams.put("ApellidoMaterno", contribuyenteBean.getApellidomaterno());
      inParams.put("Telefono", contribuyenteBean.getTelefono());
      inParams.put("CodSexo", contribuyenteBean.getCodsexo());
      inParams.put("CodEstadoCivil", contribuyenteBean.getCodestadocivil());
      inParams.put("FechaNacimiento", contribuyenteBean.getFechanacimiento());
      inParams.put("Direccion", contribuyenteBean.getDireccion());
      inParams.put("CodDireccion", contribuyenteBean.getCodDireccion());
      inParams.put("Lote", contribuyenteBean.getLote());
      inParams.put("Otros", contribuyenteBean.getOtros());
      inParams.put("Exonerado", contribuyenteBean.getEsExonerado());
      inParams.put("Pensionista", contribuyenteBean.getEsPensionista());
      inParams.put("Usuario", 1);
      inParams.put("CodConyuge", contribuyenteBean.getCodConyuge());

      inParams.put("ConyugeTipoDocumento", contribuyenteBean.getConyugeTipoDocumento());
      inParams.put("ConyugeNumeroDocumento", contribuyenteBean.getConyugeNumeroDocumento());
      inParams.put("ConyugeNombres", contribuyenteBean.getConyugeNombres());
      inParams.put("ConyugeApellidoPaterno", contribuyenteBean.getConyugeApellidopaterno());
      inParams.put("ConyugeApellidoMaterno", contribuyenteBean.getConyugeApellidomaterno());
      inParams.put("ConyugeEstadoCivil", contribuyenteBean.getConyugeEstadocivil());
      inParams.put("ConyugeSexo", contribuyenteBean.getConyugeSexo());
      inParams.put("ConyugeTelefono", contribuyenteBean.getConyugeTelefono());
      inParams.put("ConyugeFechaNacimiento", contribuyenteBean.getConyugeFechanacimiento());
       inParams.put("ConyugeCodDireccion", contribuyenteBean.getConyugeCoddireccion());
      inParams.put("ConyugeLote", contribuyenteBean.getConyugeLote());
      inParams.put("ConyugeOtros", contribuyenteBean.getConyugeOtros());
      inParams.put("CodRepresentanteLegal", contribuyenteBean.getCodRepresentanteLegal());
      inParams.put("RepreTipoDocumento", contribuyenteBean.getRepreTipoDocumento());
      inParams.put("RepreNumeroDocumento", contribuyenteBean.getRepreNumeroDocumento());
      inParams.put("RepreNombres", contribuyenteBean.getRepreNombres());
      inParams.put("RepreApellidoPaterno", contribuyenteBean.getRepreApellidopaterno());
      inParams.put("RepreApellidoMaterno", contribuyenteBean.getRepreApellidomaterno());
      inParams.put("RepreEstadoCivil", contribuyenteBean.getRepreEstadocivil());
      inParams.put("RepreSexo", contribuyenteBean.getRepreSexo());
      inParams.put("RepreTelefono", contribuyenteBean.getRepreTelefono());
      inParams.put("RepreFechaNacimiento", contribuyenteBean.getRepreFechanacimiento());
      inParams.put("RepreCodDireccion", contribuyenteBean.getRepreCoddireccion());
      inParams.put("RepreLote", contribuyenteBean.getRepreLote());
      inParams.put("RepreOtros", contribuyenteBean.getRepreOtros());
      inParams.put("ParametroBusqueda", null);

      Map<String, Object> result = stmt.execute(inParams);

      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");

      System.out.println("Respuesta: " + respuesta);
      System.out.println("Mensaje: " + mensaje);

      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar : " + e.getMessage(), e);
    }
    return response;
  }

  @Override
  public ClsResultDAO asignarConyugeRepresentante(ContribuyenteBean contribuyenteBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_contribuyente")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodPersona", Types.INTEGER),
                                            new SqlParameter("CodTipoContribuyente", Types.VARCHAR),
                                            new SqlParameter("CodTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("ApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("Telefono", Types.VARCHAR),
                                            new SqlParameter("CodSexo", Types.VARCHAR),
                                            new SqlParameter("CodEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("FechaNacimiento", Types.DATE),
                                            new SqlParameter("Direccion", Types.VARCHAR),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Exonerado", Types.INTEGER),
                                            new SqlParameter("Pensionista", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlParameter("CodConyuge", Types.INTEGER),
                                            new SqlParameter("ConyugeTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNombres", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("ConyugeSexo", Types.VARCHAR),
                                            new SqlParameter("ConyugeTelefono", Types.VARCHAR),
                                            new SqlParameter("ConyugeFechaNacimiento", Types.DATE),
                                            new SqlParameter("ConyugeCodDireccion", Types.INTEGER),
                                            new SqlParameter("ConyugeLote", Types.INTEGER),
                                            new SqlParameter("ConyugeOtros", Types.VARCHAR),
                                            new SqlParameter("CodRepresentanteLegal", Types.INTEGER),
                                            new SqlParameter("RepreTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNombres", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("RepreEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("RepreSexo", Types.VARCHAR),
                                            new SqlParameter("RepreTelefono", Types.VARCHAR),
                                            new SqlParameter("RepreFechaNacimiento", Types.DATE),
                                            new SqlParameter("RepreCodDireccion", Types.INTEGER),
                                            new SqlParameter("RepreLote", Types.INTEGER),
                                            new SqlParameter("RepreOtros", Types.VARCHAR),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 3); // agregarConyugeRepresentante
      inParams.put("CodContribuyente", contribuyenteBean.getCodContribuyente());
      inParams.put("CodPersona", contribuyenteBean.getCodPersona());
      inParams.put("CodTipoContribuyente", contribuyenteBean.getCodTipoContribuyente());
      inParams.put("CodTipoDocumento", contribuyenteBean.getCodTipoDocumento());
      inParams.put("NumeroDocumento", contribuyenteBean.getNumerodocumento());
      inParams.put("Nombres", contribuyenteBean.getNombres());
      inParams.put("ApellidoPaterno", contribuyenteBean.getApellidopaterno());
      inParams.put("ApellidoMaterno", contribuyenteBean.getApellidomaterno());
      inParams.put("Telefono", contribuyenteBean.getTelefono());
      inParams.put("CodSexo", contribuyenteBean.getCodsexo());
      inParams.put("CodEstadoCivil", contribuyenteBean.getCodestadocivil());
      inParams.put("FechaNacimiento", contribuyenteBean.getFechanacimiento());
      inParams.put("Direccion", contribuyenteBean.getDireccion());
      inParams.put("CodDireccion", contribuyenteBean.getCodDireccion());
      inParams.put("Lote", contribuyenteBean.getLote());
      inParams.put("Otros", contribuyenteBean.getOtros());
      inParams.put("Exonerado", contribuyenteBean.getEsExonerado());
      inParams.put("Pensionista", contribuyenteBean.getEsPensionista());
      inParams.put("Usuario", 1);
      inParams.put("CodConyuge", contribuyenteBean.getCodConyuge());

      inParams.put("ConyugeTipoDocumento", contribuyenteBean.getConyugeTipoDocumento());
      inParams.put("ConyugeNumeroDocumento", contribuyenteBean.getConyugeNumeroDocumento());
      inParams.put("ConyugeNombres", contribuyenteBean.getConyugeNombres());
      inParams.put("ConyugeApellidoPaterno", contribuyenteBean.getConyugeApellidopaterno());
      inParams.put("ConyugeApellidoMaterno", contribuyenteBean.getConyugeApellidomaterno());
      inParams.put("ConyugeEstadoCivil", contribuyenteBean.getConyugeEstadocivil());
      inParams.put("ConyugeSexo", contribuyenteBean.getConyugeSexo());
      inParams.put("ConyugeTelefono", contribuyenteBean.getConyugeTelefono());
      inParams.put("ConyugeFechaNacimiento", contribuyenteBean.getConyugeFechanacimiento());
      inParams.put("ConyugeCodDireccion", contribuyenteBean.getConyugeCoddireccion());
      inParams.put("ConyugeLote", contribuyenteBean.getConyugeLote());
      inParams.put("ConyugeOtros", contribuyenteBean.getConyugeOtros());
      inParams.put("CodRepresentanteLegal", contribuyenteBean.getCodRepresentanteLegal());
      inParams.put("RepreTipoDocumento", contribuyenteBean.getRepreTipoDocumento());
      inParams.put("RepreNumeroDocumento", contribuyenteBean.getRepreNumeroDocumento());
      inParams.put("RepreNombres", contribuyenteBean.getRepreNombres());
      inParams.put("RepreApellidoPaterno", contribuyenteBean.getRepreApellidopaterno());
      inParams.put("RepreApellidoMaterno", contribuyenteBean.getRepreApellidomaterno());
      inParams.put("RepreEstadoCivil", contribuyenteBean.getRepreEstadocivil());
      inParams.put("RepreSexo", contribuyenteBean.getRepreSexo());
      inParams.put("RepreTelefono", contribuyenteBean.getRepreTelefono());
      inParams.put("RepreFechaNacimiento", contribuyenteBean.getRepreFechanacimiento());
      inParams.put("RepreCodDireccion", contribuyenteBean.getRepreCoddireccion());
      inParams.put("RepreLote", contribuyenteBean.getRepreLote());
      inParams.put("RepreOtros", contribuyenteBean.getRepreOtros());
      inParams.put("ParametroBusqueda", null);

      Map<String, Object> result = stmt.execute(inParams);

      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");

      System.out.println("Respuesta: " + respuesta);
      System.out.println("Mensaje: " + mensaje);

      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar : " + e.getMessage(), e);
    }
    return response;
  }

  @Override
  public ClsResultDAO quitarConyugeRepresentante(ContribuyenteBean contribuyenteBean) throws Exception {
    ClsResultDAO response = new ClsResultDAO();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_contribuyente")
                                    .withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodPersona", Types.INTEGER),
                                            new SqlParameter("CodTipoContribuyente", Types.VARCHAR),
                                            new SqlParameter("CodTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("ApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("Telefono", Types.VARCHAR),
                                            new SqlParameter("CodSexo", Types.VARCHAR),
                                            new SqlParameter("CodEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("FechaNacimiento", Types.DATE),
                                            new SqlParameter("Direccion", Types.VARCHAR),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Exonerado", Types.INTEGER),
                                            new SqlParameter("Pensionista", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlParameter("CodConyuge", Types.INTEGER),
                                            new SqlParameter("ConyugeTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNombres", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("ConyugeSexo", Types.VARCHAR),
                                            new SqlParameter("ConyugeTelefono", Types.VARCHAR),
                                            new SqlParameter("ConyugeFechaNacimiento", Types.DATE),
                                            new SqlParameter("ConyugeCodDireccion", Types.INTEGER),
                                            new SqlParameter("ConyugeLote", Types.INTEGER),
                                            new SqlParameter("ConyugeOtros", Types.VARCHAR),
                                            new SqlParameter("CodRepresentanteLegal", Types.INTEGER),
                                            new SqlParameter("RepreTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNombres", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("RepreEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("RepreSexo", Types.VARCHAR),
                                            new SqlParameter("RepreTelefono", Types.VARCHAR),
                                            new SqlParameter("RepreFechaNacimiento", Types.DATE),
                                            new SqlParameter("RepreCodDireccion", Types.INTEGER),
                                            new SqlParameter("RepreLote", Types.INTEGER),
                                            new SqlParameter("RepreOtros", Types.VARCHAR),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)

                                    );
      Map<String, Object> inParams = new HashMap<>();
      inParams.put("Tipo", 4); // quitarConyugeRepresentante
      inParams.put("CodContribuyente", contribuyenteBean.getCodContribuyente());
      inParams.put("CodPersona", contribuyenteBean.getCodPersona());
      inParams.put("CodTipoContribuyente", contribuyenteBean.getCodTipoContribuyente());
      inParams.put("CodTipoDocumento", contribuyenteBean.getCodTipoDocumento());
      inParams.put("NumeroDocumento", contribuyenteBean.getNumerodocumento());
      inParams.put("Nombres", contribuyenteBean.getNombres());
      inParams.put("ApellidoPaterno", contribuyenteBean.getApellidopaterno());
      inParams.put("ApellidoMaterno", contribuyenteBean.getApellidomaterno());
      inParams.put("Telefono", contribuyenteBean.getTelefono());
      inParams.put("CodSexo", contribuyenteBean.getCodsexo());
      inParams.put("CodEstadoCivil", contribuyenteBean.getCodestadocivil());
      inParams.put("FechaNacimiento", contribuyenteBean.getFechanacimiento());
      inParams.put("Direccion", contribuyenteBean.getDireccion());
      inParams.put("CodDireccion", contribuyenteBean.getCodDireccion());
      inParams.put("Lote", contribuyenteBean.getLote());
      inParams.put("Otros", contribuyenteBean.getOtros());
      inParams.put("Exonerado", contribuyenteBean.getEsExonerado());
      inParams.put("Pensionista", contribuyenteBean.getEsPensionista());
      inParams.put("Usuario", 1);
      inParams.put("CodConyuge", contribuyenteBean.getCodConyuge());

      inParams.put("ConyugeTipoDocumento", contribuyenteBean.getConyugeTipoDocumento());
      inParams.put("ConyugeNumeroDocumento", contribuyenteBean.getConyugeNumeroDocumento());
      inParams.put("ConyugeNombres", contribuyenteBean.getConyugeNombres());
      inParams.put("ConyugeApellidoPaterno", contribuyenteBean.getConyugeApellidopaterno());
      inParams.put("ConyugeApellidoMaterno", contribuyenteBean.getConyugeApellidomaterno());
      inParams.put("ConyugeEstadoCivil", contribuyenteBean.getConyugeEstadocivil());
      inParams.put("ConyugeSexo", contribuyenteBean.getConyugeSexo());
      inParams.put("ConyugeTelefono", contribuyenteBean.getConyugeTelefono());
      inParams.put("ConyugeFechaNacimiento", contribuyenteBean.getConyugeFechanacimiento());
      inParams.put("ConyugeCodDireccion", contribuyenteBean.getConyugeCoddireccion());
      inParams.put("ConyugeLote", contribuyenteBean.getConyugeLote());
      inParams.put("ConyugeOtros", contribuyenteBean.getConyugeOtros());
      inParams.put("CodRepresentanteLegal", contribuyenteBean.getCodRepresentanteLegal());
      inParams.put("RepreTipoDocumento", contribuyenteBean.getRepreTipoDocumento());
      inParams.put("RepreNumeroDocumento", contribuyenteBean.getRepreNumeroDocumento());
      inParams.put("RepreNombres", contribuyenteBean.getRepreNombres());
      inParams.put("RepreApellidoPaterno", contribuyenteBean.getRepreApellidopaterno());
      inParams.put("RepreApellidoMaterno", contribuyenteBean.getRepreApellidomaterno());
      inParams.put("RepreEstadoCivil", contribuyenteBean.getRepreEstadocivil());
      inParams.put("RepreSexo", contribuyenteBean.getRepreSexo());
      inParams.put("RepreTelefono", contribuyenteBean.getRepreTelefono());
      inParams.put("RepreFechaNacimiento", contribuyenteBean.getRepreFechanacimiento());
      inParams.put("RepreCodDireccion", contribuyenteBean.getRepreCoddireccion());
      inParams.put("RepreLote", contribuyenteBean.getRepreLote());
      inParams.put("RepreOtros", contribuyenteBean.getRepreOtros());
      inParams.put("ParametroBusqueda", null);

      Map<String, Object> result = stmt.execute(inParams);

      Integer respuesta = (Integer) result.get("Respuesta");
      String mensaje = (String) result.get("Mensaje");

      System.out.println("Respuesta: " + respuesta);
      System.out.println("Mensaje: " + mensaje);

      if (respuesta == 0) {
        response.put(response.CODIGO_RESPUESTA, response.ERROR_THROW);
        response.put(response.MENSAJE_RESPUESTA, mensaje);
        return response;
      }
      response.put(response.CODIGO_RESPUESTA, 1);
      response.put(response.MENSAJE_RESPUESTA, mensaje);

    } catch (Exception e) {
      throw new RuntimeException("Error al ejecutar : " + e.getMessage(), e);
    }
    return response;
  }

  @Override
  public List<ContribuyenteBean> listarContribuyente(Integer codigoContribuyente, Integer codigoPersona) throws Exception {

    String sql = LISTAR_CONTRIBUYENTE;
    if (codigoContribuyente > 0 && codigoPersona == 0) {
      sql = sql + " WHERE codContribuyente = "+ codigoContribuyente;
    }
    if (codigoContribuyente > 0 && codigoPersona > 0) {
      sql = sql + " WHERE codPersona = "+ codigoPersona + " AND codContribuyente = "+ codigoContribuyente;
    }
    if (codigoContribuyente == 0 && codigoPersona > 0) {
      sql = sql + " WHERE codPersona = "+ codigoPersona ;
    }

    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContribuyenteBean.class));
  }
// TIPO 5: Búsqueda general por contribuyente (nombres, apellidos, documento, dirección), cónyuge o representante legal
  @Override
  public List<ContribuyenteBean> listarGeneral(String parametroBusqueda, Integer codigoContribuyente,String codTipoContribuyente,
                                               Boolean esExonerado,Boolean esPensionista) throws Exception   {

    List<ContribuyenteBean> lista = new ArrayList<ContribuyenteBean>();
    try {
      SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                                    .withCatalogName("dbo")
                                    .withProcedureName("sp_contribuyente").withoutProcedureColumnMetaDataAccess()
                                    .declareParameters(
                                            new SqlParameter("Tipo", Types.INTEGER),
                                            new SqlParameter("CodContribuyente", Types.INTEGER),
                                            new SqlParameter("CodPersona", Types.INTEGER),
                                            new SqlParameter("CodTipoContribuyente", Types.VARCHAR),
                                            new SqlParameter("CodTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("NumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("Nombres", Types.VARCHAR),
                                            new SqlParameter("ApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("Telefono", Types.VARCHAR),
                                            new SqlParameter("CodSexo", Types.VARCHAR),
                                            new SqlParameter("CodEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("FechaNacimiento", Types.DATE),
                                            new SqlParameter("Direccion", Types.VARCHAR),
                                            new SqlParameter("CodDireccion", Types.INTEGER),
                                            new SqlParameter("Lote", Types.INTEGER),
                                            new SqlParameter("Otros", Types.VARCHAR),
                                            new SqlParameter("Exonerado", Types.INTEGER),
                                            new SqlParameter("Pensionista", Types.INTEGER),
                                            new SqlParameter("Usuario", Types.INTEGER),
                                            new SqlParameter("CodConyuge", Types.INTEGER),
                                            new SqlParameter("ConyugeTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("ConyugeNombres", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("ConyugeEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("ConyugeSexo", Types.VARCHAR),
                                            new SqlParameter("ConyugeTelefono", Types.VARCHAR),
                                            new SqlParameter("ConyugeFechaNacimiento", Types.DATE),
                                            new SqlParameter("ConyugeCodDireccion", Types.INTEGER),
                                            new SqlParameter("ConyugeLote", Types.INTEGER),
                                            new SqlParameter("ConyugeOtros", Types.VARCHAR),
                                            new SqlParameter("CodRepresentanteLegal", Types.INTEGER),
                                            new SqlParameter("RepreTipoDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNumeroDocumento", Types.VARCHAR),
                                            new SqlParameter("RepreNombres", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoPaterno", Types.VARCHAR),
                                            new SqlParameter("RepreApellidoMaterno", Types.VARCHAR),
                                            new SqlParameter("RepreEstadoCivil", Types.VARCHAR),
                                            new SqlParameter("RepreSexo", Types.VARCHAR),
                                            new SqlParameter("RepreTelefono", Types.VARCHAR),
                                            new SqlParameter("RepreFechaNacimiento", Types.DATE),
                                            new SqlParameter("RepreCodDireccion", Types.INTEGER),
                                            new SqlParameter("RepreLote", Types.INTEGER),
                                            new SqlParameter("RepreOtros", Types.VARCHAR),
                                            new SqlParameter("ParametroBusqueda", Types.VARCHAR),
                                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                                            new SqlOutParameter("Respuesta", Types.INTEGER)
                                    ) ;
      Map<String, Object> inParams = new HashMap<>();

      inParams.put("Tipo", 5); // Tipo 5 es para listar general
      inParams.put("CodContribuyente",  codigoContribuyente);
      inParams.put("CodPersona",  null);
      inParams.put("CodTipoContribuyente",  codTipoContribuyente);
      inParams.put("CodTipoDocumento",  null);
      inParams.put("NumeroDocumento",  null);
      inParams.put("Nombres",  null);
      inParams.put("ApellidoPaterno",  null);
      inParams.put("ApellidoMaterno", null);
      inParams.put("Telefono",  null);
      inParams.put("CodSexo", null);
      inParams.put("CodEstadoCivil",  null);
      inParams.put("FechaNacimiento",  null);
      inParams.put("Direccion",  null);
      inParams.put("CodDireccion",  null);
      inParams.put("Lote",  null);
      inParams.put("Otros",  null);
      inParams.put("Exonerado",  esExonerado);
      inParams.put("Pensionista",  esPensionista);
      inParams.put("Usuario", null);
      inParams.put("CodConyuge",  null);
      inParams.put("ConyugeTipoDocumento",  null);
      inParams.put("ConyugeNumeroDocumento",  null);
      inParams.put("ConyugeNombres",  null);
      inParams.put("ConyugeApellidoPaterno",  null);
      inParams.put("ConyugeApellidoMaterno",  null);
      inParams.put("ConyugeEstadoCivil",  null);
      inParams.put("ConyugeSexo",  null);
      inParams.put("ConyugeTelefono",  null);
      inParams.put("ConyugeFechaNacimiento",  null);
      inParams.put("ConyugeCodDireccion",  null);
      inParams.put("ConyugeLote",  null);
      inParams.put("ConyugeOtros",  null);
      inParams.put("CodRepresentanteLegal",  null);
      inParams.put("RepreTipoDocumento",  null);
      inParams.put("RepreNumeroDocumento",  null);
      inParams.put("RepreNombres",  null);
      inParams.put("RepreApellidoPaterno",  null);
      inParams.put("RepreApellidoMaterno", null);
      inParams.put("RepreEstadoCivil",  null);
      inParams.put("RepreSexo",  null);
      inParams.put("RepreTelefono",  null);
      inParams.put("RepreFechaNacimiento", null);
      inParams.put("RepreCodDireccion",  null);
      inParams.put("RepreLote", null);
      inParams.put("RepreOtros", null);
      inParams.put("ParametroBusqueda", parametroBusqueda);
      Map<String, Object> result = stmt.execute(inParams);
      // Map<?, ?> result = stmt.execute();
      List<Map<String, Object>> listaBd = (ArrayList<Map<String,Object>>)result.get("#result-set-1");

      if(listaBd!=null  && !CollectionUtils.isEmpty(listaBd)) {

        lista = listaBd.stream().map(temp -> {
          ContribuyenteBean obj = new ContribuyenteBean();
          obj.setCodContribuyente(temp.get("codContribuyente")!= null ? Integer.parseInt(String.valueOf(temp.get(     "codContribuyente"))) : null);
          obj.setCodPersona(temp.get("codPersona")!= null ? Integer.parseInt(String.valueOf(temp.get(     "codPersona"))) : null);
          obj.setEsExonerado(temp.get("esExonerado")!= null ?
                                     Boolean.parseBoolean(String.valueOf(temp.get("esExonerado"))) :
                            null);
          obj.setEsPensionista(temp.get("esPensionista")!= null ?
                                     Boolean.parseBoolean(String.valueOf(temp.get("esPensionista"))) :
                                     null);
          obj.setNombres(temp.get("nombreContribuyente")!= null ? String.valueOf(temp.get("nombreContribuyente")) : null);
          obj.setNumerodocumento(temp.get("documentoContribuyente")!= null ? String.valueOf(temp.get("documentoContribuyente")) : null);
          obj.setDireccion(temp.get("direccionContribuyente")!= null ? String.valueOf(temp.get("direccionContribuyente")) : null);
          obj.setTipoContribuyente(temp.get("tipoContribuyente")!= null ? String.valueOf(temp.get("tipoContribuyente")) :
                           null);
          obj.setCodTipopersona(temp.get("codTipoPersona")!= null ?
                                        String.valueOf(temp.get("codTipoPersona")) :
                                           null);



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
