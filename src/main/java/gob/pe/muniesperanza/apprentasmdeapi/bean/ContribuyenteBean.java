package gob.pe.muniesperanza.apprentasmdeapi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import gob.pe.muniesperanza.apprentasmdeapi.util.Utils;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
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
public class ContribuyenteBean  implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codPersona;
  private String codTipoContribuyente;
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
  @Transient
  private String fechanacimientoStr;
  private String codestadocivil;
  private String codsexo;
  private String telefono;
  private String lote;
  private String otros;
  private String codestado;
  private Integer codDireccion;
  private Integer codContribuyente;
  private Integer codConyuge;
  private String  conyugeTipoDocumento;
  private String conyugeNumeroDocumento;
  private String conyugeNombres;
  private String conyugeApellidopaterno;
  private String conyugeApellidomaterno;
  private String conyugeEstadocivil;
  private String conyugeSexo;
  private String conyugeTelefono;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date conyugeFechanacimiento;
  @Transient
  private String conyugeFechanacimientoStr;
  private String conyugeDireccion;
  private Integer conyugeCoddireccion;
  private String conyugeLote;
  private String conyugeOtros;
  private Integer codRepresentanteLegal;
  private String repreTipoDocumento;
  private String repreNumeroDocumento;
  private String repreNombres;
  private String repreApellidopaterno;
  private String repreApellidomaterno;
  private String repreEstadocivil;
  private String repreSexo;
  private String repreTelefono;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date repreFechanacimiento;
  @Transient
  private String repreFechanacimientoStr;
  private String repreDireccion;
  private Integer repreCoddireccion;
  private String repreLote;
  private String repreOtros;
  private String tipoContribuyente;
  private Boolean esExonerado;
  private Boolean esPensionista;
  public String getFechaNacimientoStr() {
    if (fechanacimiento == null) {
      return fechanacimientoStr;
    } else {
      String temp = Utils.doConvertDateToString(fechanacimiento);
      return temp;
    }
  }

  public String getConyugeFechanacimientoStr() {
    if (conyugeFechanacimiento == null) {
      return conyugeFechanacimientoStr;
    } else {
      String temp = Utils.doConvertDateToString(conyugeFechanacimiento);
      return temp;
    }
  }

  public String getRepreFechanacimientoStr() {
    if (repreFechanacimiento == null) {
      return repreFechanacimientoStr;
    } else {
      String temp = Utils.doConvertDateToString(repreFechanacimiento);
      return temp;
    }
  }

}
