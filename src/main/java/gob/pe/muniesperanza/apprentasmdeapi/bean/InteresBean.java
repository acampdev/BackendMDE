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
public class InteresBean  implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codInteres;
  private Integer anio;
  private Double tasa;
  private String codTipo; // -- renombrado: era @Tipo (colisión)
  private String codClase; // -- renombrado: era @Clase
  private String codEstado;
}
