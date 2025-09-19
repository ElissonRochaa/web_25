package br.upe.eventohub;

import br.upe.eventohub.entities.Usuario;
import br.upe.eventohub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EventohubApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventohubApplication.class, args);
	}

}
