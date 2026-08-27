package gob.pe.muniesperanza.apprentasmdeapi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class TimBean  implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codTIM; //INT = NULL, -- usado solo para Tipo 3 puntual o referencia en auditoría
  private Integer anio;// SMALLINT = NULL,
  private Integer codTributo;// SMALLINT = NULL,
  private Integer periodo; // TINYINT = NULL,
  private Double tasa; // DECIMAL(10, 5) = NULL,
  private Integer codResolucionInteres; // INT = NULL,

  private String mes;
  private String tributo;
  private String resolucion;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaInicio;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaFin;
  private String estadoResolucion;
}
