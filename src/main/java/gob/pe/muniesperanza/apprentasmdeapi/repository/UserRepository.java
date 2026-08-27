package gob.pe.muniesperanza.apprentasmdeapi.repository;

import java.util.Optional;

import gob.pe.muniesperanza.apprentasmdeapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUsername(String username);
}
