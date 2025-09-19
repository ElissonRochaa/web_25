package br.upe.eventohub.repositories;

import br.upe.eventohub.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    public Usuario findByEmail(String email);
    public Usuario findByEmailAndSenha(String email, String senha);
    public List<Usuario> findByNomeContaining(String nome);
//    @Query("Select u from Usuario u where u.email =:email")
//    public Usuario buscarUsuarioPorEmail(String email);

}
