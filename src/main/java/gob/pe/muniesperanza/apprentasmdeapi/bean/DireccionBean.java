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
public class DireccionBean   implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer codDireccion;
  private Integer codBarrioVia;
  private Integer codSectorVia;
  private Integer cuadra;
  private String codLado;
  private Integer loteInicial;
  private Integer loteFinal;
  private Integer codZona;
  private Integer codRuta;
  private Integer codUbicacionAreaVerde;
  private Integer codVia;
  private Integer codBarrio;
  private Integer codSector;
  private String parametroBusqueda;
  private Integer usuario;
  private String  nombreBarrio;
  private String nombreSector;
  private Integer  codTipoVia;
  private String  nombreVia;
  private String nombreTipoVia;
  private String direccionCompleta;
  private String ruta;
  private String zona;
  private String manzana;
  private String ubicacionAreaVerde;
  private String nombreSectorCompleto;
}
