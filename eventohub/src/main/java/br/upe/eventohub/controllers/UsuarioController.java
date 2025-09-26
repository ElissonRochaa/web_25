package br.upe.eventohub.controllers;


import br.upe.eventohub.entities.Evento;
import br.upe.eventohub.entities.Usuario;
import br.upe.eventohub.entities.dtos.UsuarioDTO;
import br.upe.eventohub.services.UsuarioService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page<Usuario>> listar(Pageable pageable) {
        return ResponseEntity.ok(usuarioService.listarUsuarios(pageable));
    }

    @GetMapping("/{id}/eventos")
    public ResponseEntity<List<Evento>> buscarEventosDeInteresse(@PathVariable UUID id){

        Usuario usuario = usuarioService.buscarUsuario(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario.getEventosInteressados());
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){

        Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);

        if(usuarioCadastrado == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(201).body(usuarioCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorID(@PathVariable UUID id){
        Usuario usuario = usuarioService.buscarUsuario(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
            //return ResponseEntity.status(410).body(null);
        }
        //return ResponseEntity.ok(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        return ResponseEntity.status(200).body(usuarioDTO);
    }


}
