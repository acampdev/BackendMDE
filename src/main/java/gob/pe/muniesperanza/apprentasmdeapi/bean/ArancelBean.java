package gob.pe.muniesperanza.apprentasmdeapi.bean;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArancelBean  implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codArancel;
  private Integer anio;
  private Integer codDireccion;
  private Double costo;
  private Integer codUsuario;
  private Double costoArancel;
  @Transient
  private String direccionCompleta;
  @Transient
  private String sector;
  @Transient
  private String barrio;
  @Transient
  private String calle;
}
