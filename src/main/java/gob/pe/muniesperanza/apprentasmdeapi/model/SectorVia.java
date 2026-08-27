package gob.pe.muniesperanza.apprentasmdeapi.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "SectorVia")
public class SectorVia {
@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codSectorVia;
  private int codSector;
  private int codVia;
}
