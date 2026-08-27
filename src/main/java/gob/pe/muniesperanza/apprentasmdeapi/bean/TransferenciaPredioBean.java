package gob.pe.muniesperanza.apprentasmdeapi.bean;

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
public class TransferenciaPredioBean   implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codTransferencia;
  private Integer anio;
  private String codPredio;
  private Integer codContribuyenteVenta;
  private Integer codContribuyenteCompra;
  private Double porcentajeTransferencia;
  private Date fechaMinuta;
  private String documento;
  private String codModoTransferencia;
  private Double valorTransferencia;
  private Boolean esConstructor;

  private Integer codAlcabala;
  private Date fechaTransferencia;
  private String modoTransferencia;
  private Double valorUit;
  private Double baseImponibleAlcabala;
  private Double montoAlcabala;
  private Boolean inafecta;
  private Double tasaAlcabala;
}
