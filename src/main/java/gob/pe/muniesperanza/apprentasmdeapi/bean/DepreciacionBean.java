package gob.pe.muniesperanza.apprentasmdeapi.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepreciacionBean   implements Serializable {

  private static final long serialVersionUID = 1L;

  private String codDepreciacion;
  private String  codDepreciacionAnterior;
  private Integer  anio;
  private String codTipoCasa;
  private String codNivelAntiguedad;
  private String codMaterialEstructural;
  private Double muyBueno;
  private Double bueno;
  private Double regular;
  private Double malo;
  private String nivelAntiguedad;
  private String materialEstructural;

}
