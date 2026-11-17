package gob.pe.muniesperanza.apprentasmdeapi.Jwt;

import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTests {

    private static final String SECRET = "MDEyMzQ1Njc4OWFiY2RlZjAxMjM0NTY3ODlhYmNkZWY=";
    private static final String OTHER_SECRET = "YWJjZGVmMDEyMzQ1Njc4OWFiY2RlZjAxMjM0NTY3ODlhYg==";

    @Test
    void generatedTokenContainsUsernameAndIsValid() {
        JwtService service = new JwtService(SECRET, 60_000);
        var user = User.withUsername("operador").password("ignored").authorities("USER").build();

        String token = service.getToken(user);

        assertEquals("operador", service.getUsernameFromToken(token));
        assertTrue(service.isTokenValid(token, user));
    }

    @Test
    void tokenIsRejectedForAnotherUser() {
        JwtService service = new JwtService(SECRET, 60_000);
        var owner = User.withUsername("owner").password("ignored").authorities("USER").build();
        var other = User.withUsername("other").password("ignored").authorities("USER").build();

        assertFalse(service.isTokenValid(service.getToken(owner), other));
    }

    @Test
    void expiredTokenIsRejected() {
        JwtService service = new JwtService(SECRET, -1);
        var user = User.withUsername("expired").password("ignored").authorities("USER").build();

        assertThrows(JwtException.class, () -> service.isTokenValid(service.getToken(user), user));
    }

    @Test
    void tokenSignedWithAnotherKeyIsRejected() {
        JwtService issuer = new JwtService(SECRET, 60_000);
        JwtService verifier = new JwtService(OTHER_SECRET, 60_000);
        var user = User.withUsername("operador").password("ignored").authorities("USER").build();

        assertThrows(JwtException.class, () -> verifier.getUsernameFromToken(issuer.getToken(user)));
    }
}
