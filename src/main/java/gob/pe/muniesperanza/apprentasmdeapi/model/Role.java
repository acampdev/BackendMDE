package gob.pe.muniesperanza.apprentasmdeapi.model;

public enum Role {


  ADMIN("Administrador",1), USER("Usuario",2),
  CAJERO("Cajero",3), RESPCAJERO("RespCajero",4);


  private String nombre;
  private int codigo;

  private Role (String nombre, int codigo){
    this.nombre = nombre;
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public int getCodigo() {
    return codigo;
  }

  public static Role fromCodigo(Integer codigo) {
    for (Role e : Role.values()) {
      if (e.codigo == codigo) {
        return e;
      }
    }
    return null; // O lanza una excepción
  }

  }
