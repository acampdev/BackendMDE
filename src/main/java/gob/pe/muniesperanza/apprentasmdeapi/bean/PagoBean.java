package gob.pe.muniesperanza.apprentasmdeapi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagoBean  implements Serializable {

  private static final long serialVersionUID = 1L;


  private Integer codAperturaCaja;
  private Integer codContribuyente;
  private Double montoPagoTotal;
  private String codMedioPago;
  private String codTipoAbono;
  private Integer codTributo;
  private Integer anioDeuda;
  private Integer periodoDeuda;
  private Double montoPagado;
  private Integer anioResolucion;
  private Integer codResolucion;
  private Integer numeroCuota;
  private Integer anio;
  private Integer numeroPago;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "es-PE", timezone = "America/Lima")
  private Timestamp fechaPago;
  private List<SaldoDeudaBean> saldosDeuda;
}
