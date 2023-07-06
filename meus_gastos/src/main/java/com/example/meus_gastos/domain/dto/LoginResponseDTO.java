package com.example.meus_gastos.domain.dto;

public class LoginResponseDTO {
    private String token;
    private UsuarioResponseDto usuario;
    
    public UsuarioResponseDto getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioResponseDto usuario) {
        this.usuario = usuario;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
     
}
