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
public class ReportePUBean  implements Serializable {

  private static final long serialVersionUID = 1L;
  private String codPredio;
  private String codContribuyente;
  private String nombreContribuyenteCompleto;
  private String numeroDocumento;
  private String nombreRepresentanteOConyuge;
  private String numeroDocumentoRepresentanteOConyuge;
  private String conjuntoUrbano;
  private String direccion;
  private String manzana;
  private String lote;
  private String otroNumero;
  private String porcentajeCondomino;
  private String fechaAdquisicion;
  private String clasificacionPredio;
  private String estadoPredio;
  private String tipoPredio;
  private String condicionPropiedad;
  private String nivelPiso;
  private String fechaConstruccion;
  private String incremento5;
  private String estadoConservacion;
  private String material;
  private String areaConstruida;
  private String letraMuros;
  private String letraTechos;
  private String letraPisos;
  private String letraPuertas;
  private String letraRevestimiento;
  private String letraBanios;
  private String letraInstElect;
  private String valorUnitario;
  private String depreciacion;
  private String valorUnitarioDepreciado;
  private String valorAreaConstruida;
  private String valorConstruccion;
  private String arancel;
  private String areaTerreno;
  private String areaTotalConstruida;
  private String valorTotalConstruccion;
  private String valorTerreno;
  private String valorOtrasInstalaciones;
  private String autoavaluo;
}
