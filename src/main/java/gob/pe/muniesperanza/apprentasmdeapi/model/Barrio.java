package gob.pe.muniesperanza.apprentasmdeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Barrio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codBarrio;
  private String nombreBarrio;
  private Integer  codSector;
  private String nombreSector;
}
