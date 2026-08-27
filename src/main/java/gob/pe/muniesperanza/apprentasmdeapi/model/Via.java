package gob.pe.muniesperanza.apprentasmdeapi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "VIA")
public class Via {
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codVia;
    private String codTipoVia;
    private Integer codBarrio;
    private String nombreVia;
    @Transient
    private String descTipoVia;
    @Transient
    private String nombreBarrio;
    @Transient
    private String nombreSector;
    @Transient
    private String nombreViaCompleto;
    @Transient
    private Integer codSector;

}