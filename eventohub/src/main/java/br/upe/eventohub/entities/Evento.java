package br.upe.eventohub.entities;

import br.upe.eventohub.entities.Enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    @Column(length = 512)
    private String descricao;
    private int capacidade;
    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_endereco")
    private Endereco endereco;
    private Timestamp data;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @ManyToOne
    //@JoinColumn(name="id_admin")
    private Usuario admin;
    @ManyToMany
//    @JoinTable(
//            name = "Interesse",
//            joinColumns = @JoinColumn(name = "id_usuario"),
//            inverseJoinColumns = @JoinColumn(name = "id_evento")
//    )
    private List<Usuario> usuariosInteressados;

}
