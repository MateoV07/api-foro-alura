package alura.foro.challenge.controller;

import alura.foro.challenge.topico.DatosRegistroTopico;
import alura.foro.challenge.topico.Topico;
import alura.foro.challenge.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;

	@PostMapping
	public void registrarTopic(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
		topicoRepository.save(new Topico(datosRegistroTopico));
	}
}
