package gob.pe.muniesperanza.apprentasmdeapi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaldoDeudaBean   implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codContribuyente;
      private  Integer codTributo;
      private Integer anio;
      private Integer periodo;
      private Double cargo;
      private Double abono;
      private Double saldo;
      private String codEstado;
      private Integer anioResolucion;
      private Integer codResolucion;
      private Integer numeroCuota;
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "es-PE", timezone = "America/Lima")
      private Timestamp fechaUltMovimiento;
}
