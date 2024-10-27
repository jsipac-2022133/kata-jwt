package com.jamessipac.kataWeather.controller.usuario;

import com.jamessipac.kataWeather.model.Usuario;
import com.jamessipac.kataWeather.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public Usuario findById(@PathVariable String idUsuario) {
        return usuarioService.findById(idUsuario);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }


}