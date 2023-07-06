package com.example.meus_gastos.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meus_gastos.domain.dto.UsuarioRequestDto;
import com.example.meus_gastos.domain.dto.UsuarioResponseDto;
import com.example.meus_gastos.domain.exception.BadRequestException;
import com.example.meus_gastos.domain.exception.ResourceNotFoundException;
import com.example.meus_gastos.domain.model.Usuario;
import com.example.meus_gastos.domain.repository.UsuarioRepository;

@Service
public class UsuarioService implements ICRUDService<UsuarioRequestDto, UsuarioResponseDto> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<UsuarioResponseDto> obterTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> mapper.map(usuario, UsuarioResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDto obterPorId(Long Id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(Id);
        if (optUsuario.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar usuario");
        }
        return mapper.map(optUsuario.get(), UsuarioResponseDto.class);
    }

    @Override
    public UsuarioResponseDto cadastrar(UsuarioRequestDto dto) {

        if (dto.getEmail() == null || dto.getSenha() == null){
            throw new BadRequestException("Email e senha são obrigatórios!");
        }

        Optional<Usuario> optUsuario = usuarioRepository.findByEmail(dto.getEmail());
        if(optUsuario.isPresent()){
            throw new BadRequestException("Já existe um usuário cadastrado com esse email: " + dto.getEmail());
        }

        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setDataCadastro(new Date());
        //encriptar senha 

        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDto.class);

        // a variavel usuario se transforma em usuario da request em response 
    }

    @Override
    public UsuarioResponseDto atualizar(Long Id, UsuarioRequestDto dto) {

        UsuarioResponseDto usuarioBanco = obterPorId(Id);

        if (dto.getEmail() == null || dto.getSenha() == null){
            throw new BadRequestException("Email e senha são obrigatórios!");
        }

        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setId(Id);
        usuario.setDataCadastro(usuarioBanco.getDataCadastro());
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDto.class);
    }

    @Override
    public void deletar(Long Id) {
       //APAGAR DA BASE 
        //obterPorId(Id);
        //usuarioRepository.deleteById(Id);

       //INATIVIDADE
       Optional<Usuario> optUsuario = usuarioRepository.findById(Id);
        if (optUsuario.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar usuario");
        }
        Usuario usuario = optUsuario.get();
        usuario.setDataInativacao(new Date());
        usuarioRepository.save(usuario);     
    }

}
