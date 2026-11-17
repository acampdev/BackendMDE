package gob.pe.muniesperanza.apprentasmdeapi.Auth;

import gob.pe.muniesperanza.apprentasmdeapi.Jwt.JwtService;
import gob.pe.muniesperanza.apprentasmdeapi.model.Usuario;
import gob.pe.muniesperanza.apprentasmdeapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTests {

    @Mock UserRepository repository;
    @Mock JwtService jwtService;
    @Mock PasswordEncoder passwordEncoder;
    @Mock AuthenticationManager authenticationManager;

    @Test
    void loginAuthenticatesAndReturnsUserData() {
        Usuario user = Usuario.builder().id(7).username("cajero").password("hash").codRol(3).build();
        when(repository.findByUsername("cajero")).thenReturn(Optional.of(user));
        when(jwtService.getToken(user)).thenReturn("jwt");
        AuthService service = new AuthService(repository, jwtService, passwordEncoder, authenticationManager);

        AuthResponse response = service.login(LoginRequest.builder().username("cajero").password("clave").build());

        verify(authenticationManager).authenticate(any());
        assertEquals("jwt", response.getToken());
        assertEquals(7, response.getCodUsuario());
        assertEquals(3, response.getCodRol());
    }

    @Test
    void invalidCredentialsStopLogin() {
        doThrow(new BadCredentialsException("invalid")).when(authenticationManager).authenticate(any());
        AuthService service = new AuthService(repository, jwtService, passwordEncoder, authenticationManager);

        assertThrows(BadCredentialsException.class,
                () -> service.login(LoginRequest.builder().username("x").password("bad").build()));
        verifyNoInteractions(repository, jwtService);
    }

    @Test
    void registerHashesPasswordBeforeSaving() {
        when(passwordEncoder.encode("plain")).thenReturn("bcrypt");
        when(jwtService.getToken(any())).thenReturn("jwt");
        AuthService service = new AuthService(repository, jwtService, passwordEncoder, authenticationManager);
        RegisterRequest request = RegisterRequest.builder()
                .username("nuevo").password("plain").codRole(2).build();

        AuthResponse response = service.register(request);

        ArgumentCaptor<Usuario> captor = ArgumentCaptor.forClass(Usuario.class);
        verify(repository).save(captor.capture());
        assertEquals("bcrypt", captor.getValue().getPassword());
        assertEquals(2, captor.getValue().getCodRol());
        assertEquals("jwt", response.getToken());
    }
}
