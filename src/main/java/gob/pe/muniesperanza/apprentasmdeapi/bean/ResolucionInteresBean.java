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
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResolucionInteresBean implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer codResolucionInteres;
  private String descripcion;
  private Integer anioFiscal;
  private Double tasa;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaInicio;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaFin;
  private String codEstado;
  private String estado;
  @Transient
  private String fechaInicioStr;
  @Transient
  private String fechaFinStr;

  public String getFechaInicioStr() {
    if (fechaInicio == null) {
      return fechaInicioStr;
    } else {
      String temp = Utils.doConvertDateToString(fechaInicio);
      return temp;
    }
  }


  public String getFechaFinStr() {
    if (fechaFin == null) {
      return fechaFinStr;
    } else {
      String temp = Utils.doConvertDateToString(fechaFin);
      return temp;
    }
  }
}
