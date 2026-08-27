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
public class UsoPredio  implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer codUso;
  private String descripcion;
  private Integer codCriterio;
  private Integer anio;
  private Integer codGrupoUso;

}
