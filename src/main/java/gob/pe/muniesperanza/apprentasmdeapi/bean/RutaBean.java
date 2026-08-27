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
public class RutaBean  implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer codigo;
  private String descripcion;
  private String abreviatura;
}
