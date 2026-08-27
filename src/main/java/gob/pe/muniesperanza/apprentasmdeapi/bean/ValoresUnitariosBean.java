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
public class ValoresUnitariosBean  implements Serializable{

  private static final long serialVersionUID = 1L;

  private String codigoValorUnitario;
  private String codigoValorUnitarioAnterior;
  private Integer anio;
  private String codLetra;
  private String codCategoria;
  private String codSubcategoria;
  private Double costo;
}
