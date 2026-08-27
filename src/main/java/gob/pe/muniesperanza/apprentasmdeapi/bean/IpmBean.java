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
public class IpmBean  implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer anio;
  private String codMes;
  private String mes;
  private Double indice;
  private Double variacionMensual;
  private Double variacionAcumulada;
  private Integer usuario;
}
