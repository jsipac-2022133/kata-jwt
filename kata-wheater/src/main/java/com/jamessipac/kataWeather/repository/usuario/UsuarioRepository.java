package com.jamessipac.kataWeather.repository.usuario;

import com.jamessipac.kataWeather.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository; // o JpaRepository si usas JPA
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByEmail(String email);

    Optional<Usuario> findById(String id);
}
