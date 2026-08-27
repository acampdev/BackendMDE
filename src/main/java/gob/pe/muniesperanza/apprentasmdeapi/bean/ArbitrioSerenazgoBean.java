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
public class ArbitrioSerenazgoBean   implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codigo;
  private Integer anio;
  private Integer codGrupoUso;
  private Integer codCuadrante;
  private Double tasaMensual;
  private String nombreCuadrante;
  private String grupoUso;
  private Double tasaAnual;
}