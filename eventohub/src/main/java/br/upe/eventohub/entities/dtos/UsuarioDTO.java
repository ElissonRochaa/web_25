package br.upe.eventohub.entities.dtos;

import br.upe.eventohub.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioDTO {

    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public UsuarioDTO(UUID id, String nome, String email, String telefone, String cpf) {
       this.id = id;
       this.nome = nome;
       this.email = email;
       this.telefone = telefone;
       this.cpf = cpf;
    }

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getID();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
        this.cpf = usuario.getCpf();
    }

}
