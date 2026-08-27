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
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PisoBean  implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer anio ;
  private String  codPredio;
  private String  codPredioBase;
  private Integer codPiso ;
  private Integer numeroPiso;
  private String numeroPisoDesc;
 @Temporal(TemporalType.DATE)
 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaConstruccion;
  @Transient
  private String fechaConstruccionStr;
  private String codLetraMurosColumnas ;
  private String murosColumnas;
  private String codLetraTechos ;
  private String techos;
  private String codLetraPisos ;
  private String pisos ;
  private String codLetraPuertasVentanas ;
  private String puertasVentanas ;
  private String codLetraRevestimiento ;
  private String revestimiento ;
  private String codLetraBanios ;
  private String banios ;
  private String codLetraInstalacionesElectricas ;
  private String instalacionesElectricas ;
  private String codEstadoConservacion ;
  private String codMaterialEstructural ;
  private Double valorUnitario ;
  private Double areaConstruida ;
  private Double incremento;
  private Double depreciacion;
  private Double montoDepreciacion;
  private Double valorUnitarioDepreciado;
  private Double  valorAreaConstruida;
  private Double 	valorAreasComunes;
  private Double 	valorConstruccion;
  private Double costoTotalValorUnitario;
  private Double montoDepreciado;
  private Double incremento5;
  private Double  areaTotalConstruccion;
 public String getFechaConstruccionStr() {
  if (fechaConstruccion == null) {
   return fechaConstruccionStr;
  } else {
    String temp = Utils.doConvertDateToString(fechaConstruccion);
    return temp;
   }
 }

}