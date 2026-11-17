package gob.pe.muniesperanza.apprentasmdeapi.Auth;

import gob.pe.muniesperanza.apprentasmdeapi.Jwt.JwtService;
import gob.pe.muniesperanza.apprentasmdeapi.model.Role;
import gob.pe.muniesperanza.apprentasmdeapi.model.Usuario;
import gob.pe.muniesperanza.apprentasmdeapi.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

import java.util.Optional;
import gob.pe.muniesperanza.apprentasmdeapi.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                 request.getPassword()));
        Usuario usuario = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        UserDetails user = usuario;
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .codUsuario(usuario.getId())
            .username(usuario.getUsername())
            .codRol(usuario.getCodRol())
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
     // Role roleUsu =   Role.valueOf(request.getRole());

      Usuario user = Usuario.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .documento(request.getDocumento())
            .nombrePersona(request.getNombrePersona())
            .codEstado(request.getCodEstado())
            .codRol(request.getCodRole())
            .id(request.id)
            .build();
        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }



}
