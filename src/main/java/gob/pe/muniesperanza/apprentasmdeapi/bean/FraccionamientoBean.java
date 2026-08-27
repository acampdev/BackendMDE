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
public class FraccionamientoBean  implements Serializable {

  private static final long serialVersionUID = 1L;


  private Integer codContribuyente  ;
  private String tipo; // 'FRAC' = nuevo  |  'REFI' = refinanciamiento ──────
  private String tipoResolucion   ;

   // -- ── Montos ───────────────────────────────────────────────────
  private Double deudaInsoluta; //      -- deuda total a fraccionar
  private Double cuotaInicial;  //  -- enganche (puede ser 0)
  private Integer numeroCuotas;  //           -- número de cuotas (1–60)


   // -- ── Rango de períodos de deuda a fraccionar ──────────────────
    private Integer anioDeudaInicio;
    private Integer periodoInicio;
    private Integer  anioDeudaFin;
    private Integer periodoFin;

       //                                -- ── Solicitante (puede diferir del contribuyente) ────────────
  private String solicitante  ;
  private String tipoDocumento ;
  private String numDocumento;
  private String cargo    ;    //      NVARCHAR(60) = NULL, -- "Titular", "Rep. Legal", etc.

  private Integer codUsuario;

  private Integer anioResoAnterior;
  private Integer codResoAnterior;

  private Integer anio;
  private Double capitalNeto;
  private Double tasaMensual;
  private Double montoCuota;
  private Double totalInteres;
  private Double totalFraccionado;

}
