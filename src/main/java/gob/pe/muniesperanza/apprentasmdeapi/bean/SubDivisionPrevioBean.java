package gob.pe.muniesperanza.apprentasmdeapi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubDivisionPrevioBean   implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer  anio ;
    private String codPredioMatriz;
    private Double areaTerrenoNuevaMatriz ;
    private Double valorTerrenoNuevoMatriz ;
    private Integer codDireccionNuevo ;
    private Integer numeroFincaNuevo;
    private String otroNumeroNuevo ;
    private String codClasificacionNuevo;
    private String estPredioNuevo ;
    private String codTipoPredioNuevo;
    private String codCondicionPropiedadNuevo;
    private Integer codUsoNuevo ;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
    private Date fechaAdquisicionNuevo ;
    private String codListaConductorNuevo ;
    private Double areaTerrenoNuevo ;
    private Double valorOtrasInstalacionesNuevo;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
    private Date fechaSubdivision ;
    private Integer periodoEfectivoArbitrios ;
    private Integer usuario;
    private String codPredioNuevo;
}
