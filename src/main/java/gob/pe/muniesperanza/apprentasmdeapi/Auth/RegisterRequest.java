package gob.pe.muniesperanza.apprentasmdeapi.Auth;

import gob.pe.muniesperanza.apprentasmdeapi.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String nombrePersona;
    String documento;
    String password;
    String codEstado;
    Integer id;
    Integer codRole;
}
