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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AperturaCajaBean   implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer codAperturaCaja;
  private Integer codAsignacionCaja;
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "es-PE", timezone = "America/Lima")
  private Timestamp fechaApertura;
  private Double montoApertura;
  private Double montoCierre;
  private String observacion;
  @Transient
  private String fechaStr;
  private Integer codUsuario;
  private String numeroApertura;
  private String caja;
  private String turno;
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "es-PE", timezone = "America/Lima")
  private Timestamp fechaCierre;
  private Double diferencia;
  private String tipoDiferencia;
  private String estado;
/*
  public String getFechaStr() {
    if (fechaApertura == null) {
      return fechaStr;
    } else {
      String temp = Utils.doConvertDateToString(/*fechaApertura);
      return temp;
    }
  }*/
}
