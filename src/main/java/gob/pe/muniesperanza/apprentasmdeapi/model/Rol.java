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
//@Table(name = "Rol")
public class Rol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "I_CodRol")
  private int codRol;
  @Column(name = "V_Descripcion")
  private String descripcion;

  public Rol(int codRol) {
    this.codRol = codRol;
  }
}

