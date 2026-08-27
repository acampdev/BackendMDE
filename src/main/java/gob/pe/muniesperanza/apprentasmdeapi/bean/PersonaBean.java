package gob.pe.muniesperanza.apprentasmdeapi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jdi.IntegerValue;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaBean  implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codPersona;
  private String codTipopersona;
  private String codTipoDocumento;
  private String numerodocumento;
  private String nombres;
  private String apellidomaterno;
  private String apellidopaterno;
  private String direccion;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechanacimiento;
  private String codestadocivil;
  private String codsexo;
  private String telefono;
  private Integer codDireccion;
  private Integer lote;
  private String otros;
  private String parametroBusqueda;
  private Integer codUsuario;
  private String nombrePersona;
}
