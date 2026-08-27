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
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VencimientoBean  implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer anio;
  private String mes;
  private String tipoImpuesto;
  private String diaSemana;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date ultimoDiaHabil;
  @Transient
  private String ultimoDiaHabilStr;

  public String getUltimoDiaHabilStr() {
    if (ultimoDiaHabil == null) {
      return ultimoDiaHabilStr;
    } else {
      String temp = Utils.doConvertDateToString(ultimoDiaHabil);
      return temp;
    }
  }
}
