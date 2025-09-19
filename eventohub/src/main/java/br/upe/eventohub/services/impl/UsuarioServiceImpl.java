package br.upe.eventohub.services.impl;

import br.upe.eventohub.entities.Usuario;
import br.upe.eventohub.repositories.UsuarioRepository;
import br.upe.eventohub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean validarEmail(String email) {
        if (usuarioRepository.findByEmail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {

        if(usuarioRepository.findByEmail(usuario.getEmail()) != null){
            return null;
        }
        if(usuario.getNome() == null || usuario.getNome().isEmpty()){
            return null;
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {

        Usuario usuarioBanco = usuarioRepository.findById(usuario.getID()).orElse(null);
        if(usuarioBanco == null){
            return null;
        }

        usuarioBanco.setNome(usuario.getNome());
        usuarioBanco.setTelefone(usuario.getTelefone());

        return usuarioRepository.save(usuarioBanco);
    }

    @Override
    public boolean removerUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);

        if(usuarioRepository.findByEmail(usuario.getEmail()) == null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean removerUsuario(UUID id) {
        usuarioRepository.deleteById(id);

        if(usuarioRepository.findById(id) == null) {
            return true;
        }
        return false;
    }

    @Override
    public Usuario buscarUsuario(UUID id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> buscarUsuarioPorNome(String nome) {
        return usuarioRepository.findByNomeContaining(nome);
    }

}
