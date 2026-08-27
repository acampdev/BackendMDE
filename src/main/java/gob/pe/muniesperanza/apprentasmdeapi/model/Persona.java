package gob.pe.muniesperanza.apprentasmdeapi.model;

import gob.pe.muniesperanza.apprentasmdeapi.util.Utils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "Persona")
public class Persona {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codPersona;
  private String codTipopersona;
  private String codTipoDocumento;
  private String numerodocumento;
  private String nombres;
  private String apellidomaterno;
  private String apellidopaterno;
  private String direccion;
  private Date fechanacimiento;
  @Transient
  private String fechanacimientoStr;
  private String codestadocivil;
  private String codsexo;
  private String telefono;
  private String codestado;

  public String getFechanacimientoStr() {
    if (fechanacimiento == null) {
      return fechanacimientoStr;
    } else {
      String temp = Utils.doConvertDateToString(fechanacimiento);
      return temp;
    }
  }

}
