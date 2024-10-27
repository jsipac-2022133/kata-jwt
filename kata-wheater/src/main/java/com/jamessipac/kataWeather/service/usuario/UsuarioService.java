package com.jamessipac.kataWeather.service.usuario;

import com.jamessipac.kataWeather.model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(String id);
    Usuario save(Usuario usuario);
}
