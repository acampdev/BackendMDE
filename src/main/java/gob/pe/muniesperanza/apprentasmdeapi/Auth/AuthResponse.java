package gob.pe.muniesperanza.apprentasmdeapi.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;
    Integer codUsuario;
    String username;
    Integer codRol;
}
