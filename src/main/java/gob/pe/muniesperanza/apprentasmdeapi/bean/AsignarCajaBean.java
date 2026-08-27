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
public class AsignarCajaBean   implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer codAsignacionCaja;
  private Integer codUsuario;
  private Integer codCaja;
  private Integer codTurno;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fecha;
  private String terminoBusqueda;
  private String numCaja;
  private String nombreUsuario;
  private String turno;
  private String estado;
  private String usuario;
  @Transient
  private String fechaStr;

  public String getFechaStr() {
    if (fecha == null) {
      return fechaStr;
    } else {
      String temp = Utils.doConvertDateToString(fecha);
      return temp;
    }
  }
}
