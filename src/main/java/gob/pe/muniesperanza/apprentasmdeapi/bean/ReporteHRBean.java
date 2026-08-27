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
public class ReporteHRBean implements Serializable {

  private static final long serialVersionUID = 1L;
  private String  codPredio;
  private String  codContribuyente;
  private String  nombreContribuyenteCompleto;
  private String  numeroDocumento;
  private String  nombreRepresentanteOConyuge;
  private String  numeroDocumentoRepresentanteOConyuge;
  private String  direccionFiscal;
  private String  tipoContribuyente;
  private String  codPredioBase;
  private String  tipoPredio;
  private String  porcentajeCondomino;
  private String  autoavaluo;
  private String  baseImponible;
  private String  impuestoPredial;
  private String  impuestoMensual;
  private String  impuestoTrimestral;
}
