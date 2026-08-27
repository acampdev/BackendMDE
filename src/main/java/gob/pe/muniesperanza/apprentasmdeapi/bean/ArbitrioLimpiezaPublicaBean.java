package gob.pe.muniesperanza.apprentasmdeapi.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArbitrioLimpiezaPublicaBean   implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codigo;
  private Integer anio;
  private Double tasaMensual;
  private Integer codZona;
  private Integer codCriterio;
  private String nombreZona;
  private Double tasaAnual;
  private String criterioUso;
}
