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
public class PredioBean  implements Serializable {

  private static final long serialVersionUID = 1L;

  private String codPredio;
  private String codPredioBase;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
  private Date fechaAdquisicion;
  private String codTipoPredio;
  private String codClasificacion;
  private Integer codUsoPredio;
  private Integer codUso;
  private Integer anio;
  private Integer codDireccion;
  private String direccion;
  private Integer numeroFinca;
  private String otroNumero;
  private String codListaConductor;
  private String conductor;
  private String codEstadoPredio;
  private String estadoPredio;
  private String codCondicionPropiedad;
  private String condicionPropiedad;
  private Double areaTerreno;
  private Double areaTotalConstruida;
  private Double valorTerreno;
  private Double costoArancel;
  private String nombreSectorCompleto;
  private String rutaImagenFoto;



  private String estPredio;
  @Transient
  private String fechaAdquisicionStr;
  private Integer numeroCondominos;
  private Integer codUbicacionAreaVerde;
  private Double totalAreaConstruccion;
  private Double valorTotalConstruccion;
  private Double valorOtrasInstalaciones;
  private String rutaImagenPlano;
  private Integer codUsuario;
  private String parametroBusqueda;


  public String getFechaAdquisicionStr() {
    if (fechaAdquisicion == null) {
      return fechaAdquisicionStr;
    } else {
      String temp = Utils.doConvertDateToString(fechaAdquisicion);
      return temp;
    }
  }

}
