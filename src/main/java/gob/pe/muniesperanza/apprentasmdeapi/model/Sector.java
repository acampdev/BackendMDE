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
//@Table(name = "SECTOR")
public class Sector {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codSector;
  private String nombreSector;
  private Integer codCuadrante;
  @Transient
  private String nombreCuadrante;
  private Integer codUnidadUrbana;
  @Transient
  private String unidadUrbana;
}
