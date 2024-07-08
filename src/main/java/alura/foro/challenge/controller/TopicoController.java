package alura.foro.challenge.controller;

import alura.foro.challenge.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;

	@PostMapping
	public void registrarTopic(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
		topicoRepository.save(new Topico(datosRegistroTopico));
	}

	@GetMapping
	public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 2) Pageable pageable){
		return topicoRepository.findAll(pageable).map(DatosListadoTopico::new);

	}

	@PutMapping
	@Transactional
	public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
		Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
		topico.actualizarDatos(datosActualizarTopico);

	}

	@Transactional
	@DeleteMapping("/{id}")
	public void elminarTopico(@PathVariable Long id){
		Topico topico = topicoRepository.getReferenceById(id);
		topicoRepository.delete(topico);

	}
}
