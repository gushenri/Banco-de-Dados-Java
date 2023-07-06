package com.example.meus_gastos.domain.service;

import java.util.List;

public interface ICRUDService<Request, Response> {
    List<Response> obterTodos();
    Response obterPorId(Long Id);
    Response cadastrar(Request sto);
    Response atualizar(Long Id, Request dto);
    void deletar(Long Id);
}
