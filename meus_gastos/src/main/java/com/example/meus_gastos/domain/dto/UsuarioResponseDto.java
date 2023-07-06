package com.example.meus_gastos.domain.dto;

import java.util.Date;

public class UsuarioResponseDto {
    private Long Id;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private Date dataCadastro;
    private Date dataInativacao;



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataInativacao() {
        return dataInativacao;
    }
    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }
    
}