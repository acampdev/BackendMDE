package gob.pe.muniesperanza.apprentasmdeapi.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UitEpaBean  implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer codUit ;
  private Integer anio ;
  private Double valor ;
  private Double  valorUit;
  private Double alicuota;
  private Double rangoInicial;
  private Double rangoFinal;
  private Double impuestoParcial;
  private Double impuestoAcumulado;
  private Integer codEpa ;
}
