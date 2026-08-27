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
public class UsuarioBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codUsuario;
  private String nombrePersona;
  private String documento;
  private String username;
  private String password;
  private Integer codRol;
  private String parametroBusqueda;
  private String rol;
  private String estado;
  private Integer usuario; // Usuario que realiza la operación
}
