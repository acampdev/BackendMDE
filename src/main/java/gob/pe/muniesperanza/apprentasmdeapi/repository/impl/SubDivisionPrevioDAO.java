package gob.pe.muniesperanza.apprentasmdeapi.repository.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.SubDivisionPrevioBean;
import gob.pe.muniesperanza.apprentasmdeapi.jdbc.SimpleJdbcDaoBase;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SubDivisionPrevioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SubDivisionPrevioDAO extends SimpleJdbcDaoBase implements SubDivisionPrevioIDAO {

    public SubDivisionPrevioDAO(DataSource dataSource) { super(dataSource);
    }

    @Override
    public ClsResultDAO subDivisionPrevio(SubDivisionPrevioBean bean) throws Exception{
        ClsResultDAO response = new ClsResultDAO();

        try {

            SimpleJdbcCall stmt = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("dbo")
                    .withProcedureName("sp_subdivisionPredio")
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            // ── Datos de la matriz ──────────────────────────────
                            new SqlParameter("Anio", Types.SMALLINT),
                            new SqlParameter("CodPredioMatriz", Types.NCHAR),
                            new SqlParameter("AreaTerrenoNuevaMatriz", Types.DECIMAL),
                            new SqlParameter("ValorTerrenoNuevoMatriz", Types.DECIMAL),

                            // ── Datos del predio nuevo ──────────────────────────
                            new SqlParameter("CodDireccionNuevo", Types.INTEGER),
                            new SqlParameter("NumeroFincaNuevo", Types.SMALLINT),
                            new SqlParameter("OtroNumeroNuevo", Types.NVARCHAR),
                            new SqlParameter("CodClasificacionNuevo", Types.NCHAR),
                            new SqlParameter("EstPredioNuevo", Types.NCHAR),
                            new SqlParameter("CodTipoPredioNuevo", Types.NCHAR),
                            new SqlParameter("CodCondicionPropiedadNuevo", Types.NCHAR),
                            new SqlParameter("CodUsoNuevo", Types.SMALLINT),
                            new SqlParameter("FechaAdquisicionNuevo", Types.DATE),
                            new SqlParameter("CodListaConductorNuevo", Types.NCHAR),
                            new SqlParameter("AreaTerrenoNuevo", Types.DECIMAL),
                            new SqlParameter("ValorOtrasInstalacionesNuevo", Types.DECIMAL),

                            // ── Datos de la subdivisión ─────────────────────────
                            new SqlParameter("FechaSubdivision", Types.DATE),
                            new SqlParameter("PeriodoEfectivoArbitrios", Types.INTEGER),
                            new SqlParameter("Usuario", Types.INTEGER),

                            // ── Salida ───────────────────────────────────────────
                            new SqlOutParameter("CodPredioNuevo", Types.CHAR),
                            new SqlOutParameter("Mensaje", Types.VARCHAR),
                            new SqlOutParameter("Respuesta", Types.INTEGER)
                    );
                            Map<String, Object> inParams = new HashMap<>();
            inParams.put("Anio", bean.getAnio());
            inParams.put("CodPredioMatriz", bean.getCodPredioMatriz());
            inParams.put("AreaTerrenoNuevaMatriz", bean.getAreaTerrenoNuevaMatriz());
            inParams.put("ValorTerrenoNuevoMatriz", bean.getValorTerrenoNuevoMatriz());
            inParams.put("CodDireccionNuevo", bean.getCodDireccionNuevo());
            inParams.put("NumeroFincaNuevo", bean.getNumeroFincaNuevo());
                    inParams.put("OtroNumeroNuevo", bean.getOtroNumeroNuevo());
                    inParams.put("CodClasificacionNuevo", bean.getCodClasificacionNuevo());
            inParams.put("EstPredioNuevo", bean.getEstPredioNuevo());
            inParams.put("CodTipoPredioNuevo", bean.getCodTipoPredioNuevo());
            inParams.put("CodCondicionPropiedadNuevo", bean.getCodCondicionPropiedadNuevo());
            inParams.put("CodUsoNuevo", bean.getCodUsoNuevo());
            inParams.put("FechaAdquisicionNuevo", bean.getFechaAdquisicionNuevo());
            inParams.put("CodListaConductorNuevo", bean.getCodListaConductorNuevo());
            inParams.put("AreaTerrenoNuevo", bean.getAreaTerrenoNuevo());
            inParams.put("ValorOtrasInstalacionesNuevo", bean.getValorOtrasInstalacionesNuevo());
            inParams.put("FechaSubdivision", bean.getFechaSubdivision());
            inParams.put("PeriodoEfectivoArbitrios", bean.getPeriodoEfectivoArbitrios());
            inParams.put("Usuario", bean.getUsuario());

         Map<String, Object> result = stmt.execute(inParams);
            Integer respuesta = (Integer) result.get("Respuesta");
            String mensaje = (String) result.get("Mensaje");
            String codPredioNuevo =  ((String) result.get("CodPredioNuevo"));
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