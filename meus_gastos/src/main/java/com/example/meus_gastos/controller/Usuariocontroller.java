package com.example.meus_gastos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meus_gastos.domain.dto.UsuarioRequestDto;
import com.example.meus_gastos.domain.dto.UsuarioResponseDto;
import com.example.meus_gastos.domain.service.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuarios")
public class Usuariocontroller {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> obterTodos(){
        return ResponseEntity.ok(usuarioService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> cadastrar(@RequestBody UsuarioRequestDto dto){
        UsuarioResponseDto usuario = usuarioService.cadastrar(dto);
        return new ResponseEntity<UsuarioResponseDto>(usuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atuaizar(@PathVariable Long id, @RequestBody UsuarioRequestDto dto){
        UsuarioResponseDto usuario = usuarioService.atualizar(id, dto);
        return new ResponseEntity<UsuarioResponseDto>(usuario, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
