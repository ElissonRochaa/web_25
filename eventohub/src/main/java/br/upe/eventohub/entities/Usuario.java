package br.upe.eventohub.entities;

import br.upe.eventohub.entities.Enums.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    private String senha;
    private String telefone;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    public Usuario(String nome, String email, String senha) {}

}
