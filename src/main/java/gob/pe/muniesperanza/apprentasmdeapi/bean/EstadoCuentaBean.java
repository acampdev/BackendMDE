package gob.pe.muniesperanza.apprentasmdeapi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCuentaBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codContribuyente;
  private Integer anio;

  private Double totalPredial;
  private Double  totalArbitrial;



  private String tributo;
  private String grupoTributo;
  private Double totalCargos;
  private Double totalPagado;
  private Double saldoNeto;
  private Double cargo1;
  private Double abono1;
  private Double cargo2;
  private Double abono2;
  private Double cargo3;
  private Double abono3;
  private Double cargo4;
  private Double abono4;
  private Double cargo5;
  private Double abono5;
  private Double cargo6;
  private Double abono6;
  private Double cargo7;
  private Double abono7;
  private Double cargo8;
  private Double abono8;
  private Double cargo9;
  private Double abono9;
  private Double cargo10;
  private Double abono10;
  private Double cargo11;
  private Double abono11;
  private Double cargo12;
  private Double abono12;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_ene;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_feb;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_mar;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_abr;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_may;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_jun;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_jul;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_ago;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_sep;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_oct;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_nov;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date venc_dic;

}