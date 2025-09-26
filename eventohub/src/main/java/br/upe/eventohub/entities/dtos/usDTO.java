package br.upe.eventohub.entities.dtos;

import br.upe.eventohub.entities.Usuario;

import java.util.UUID;

public record usDTO(UUID id, String nome, String email, String telefone, String cpf) {
}
