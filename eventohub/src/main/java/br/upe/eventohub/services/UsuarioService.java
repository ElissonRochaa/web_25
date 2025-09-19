package br.upe.eventohub.services;

import br.upe.eventohub.entities.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    public Usuario cadastrarUsuario(Usuario usuario);
    public Usuario atualizarUsuario(Usuario usuario);
    public boolean removerUsuario(Usuario usuario);
    public boolean removerUsuario(UUID id);
    public Usuario buscarUsuario(UUID id);
    public List<Usuario> listarUsuarios();
    public List<Usuario> buscarUsuarioPorNome(String nome);
    //public boolean validarUsuario(Usuario usuario, String codigo);

}
