package com.jamessipac.kataWeather.dto;

import com.jamessipac.kataWeather.model.Usuario;

public class LocationResponseDto {
    private String id;
    private Usuario usuario;

    public LocationResponseDto(String id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
