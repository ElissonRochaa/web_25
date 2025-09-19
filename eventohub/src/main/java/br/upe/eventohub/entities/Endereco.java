package br.upe.eventohub.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;
    private String rua;
    private String numero;
    private String complemento;
    private String pontoReferencia;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String observacao;

}
