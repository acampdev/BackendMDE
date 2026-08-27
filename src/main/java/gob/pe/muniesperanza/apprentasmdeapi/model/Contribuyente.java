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
public class Contribuyente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codContribuyente;
  private int codConyuge;
  private int codRepresentanteLegal;
  @ManyToOne
  private Persona persona;

  @ManyToOne
  private Persona contribuyente;

  @ManyToOne
  private Persona conyuge;

  @ManyToOne
  private Persona representanteLegal;

}
