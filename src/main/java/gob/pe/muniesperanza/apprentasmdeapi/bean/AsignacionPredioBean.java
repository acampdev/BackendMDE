package gob.pe.muniesperanza.apprentasmdeapi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import gob.pe.muniesperanza.apprentasmdeapi.util.Utils;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
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
public class AsignacionPredioBean   implements Serializable {

  private static final long serialVersionUID = 1L;


  private Integer anio;
  private String codPredio;
  private Integer codPredioBase;
  @Transient
  private String direccionCompleta;
  @Transient
  private Double  autoavaluo;
  @Transient
  private Double baseImponible;
  @Transient
  private Double impuestoAnual;
  private Integer codContribuyente;
  private Integer codAsignacion;
  private Double porcentajeCondomino;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaDeclaracion;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaVenta;
  @Transient
  private String fechaDeclaracionStr;
  @Transient
  private String fechaVentaStr;
  private String codModoDeclaracion;
  private Integer pensionista;
 // private String codEstado;
  private Integer codUsuario;
  @Transient
  private String nombreContribuyente;
  @Transient
  private Integer codPredioContribuyente;
  private String porcentajeCondominoDesc;
  private String modoDeclaracion;
  private String pensionistaDesc;
  private String estado;
  public String getFechaVentaStr() {
    if (fechaVenta == null) {
      return fechaVentaStr;
    } else {
      String temp = Utils.doConvertDateToString(fechaVenta);
      return temp;
    }
  }

  public String getFechaDeclaracionStr() {
    if (fechaDeclaracion == null) {
      return fechaDeclaracionStr;
    } else {
      String temp = Utils.doConvertDateToString(fechaDeclaracion);
      return temp;
    }
  }
}
