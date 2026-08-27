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
public class CronogramaBean   implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer  anio;
  private Integer  codResolucion;
  private Integer  numeroCuota;
  private Double  saldoInicio;
  private Double  interes;
  private Double  amortizacion;
  private Double  montoCuota;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaVencimiento;
  private Boolean pagado;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date  fechaPago;
  private Double   montoPagado;
  private Integer numeroPago;
  private Integer codContribuyente;
}
