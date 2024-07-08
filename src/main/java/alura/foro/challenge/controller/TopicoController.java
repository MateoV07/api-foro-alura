package alura.foro.challenge.controller;

import alura.foro.challenge.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;

	@PostMapping
	public ResponseEntity<DatosRespuestaTopico> registrarTopic(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
	                                     UriComponentsBuilder uriComponentsBuilder){
		Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
		DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),
				topico.getMensaje(),topico.getFecha_creacion());
		URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(url).body(datosRespuestaTopico);
	}

	@GetMapping
	public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable pageable){
		return ResponseEntity.ok(topicoRepository.findAll(pageable).map(DatosListadoTopico::new));

	}

	@PutMapping
	@Transactional
	public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
		Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
		topico.actualizarDatos(datosActualizarTopico);
		return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),
				topico.getMensaje(),topico.getFecha_creacion()));

	}

	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity elminarTopico(@PathVariable Long id){
		Topico topico = topicoRepository.getReferenceById(id);
		topicoRepository.delete(topico);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/{id}")
	public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
		Topico topico = topicoRepository.getReferenceById(id);
		var datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),
				topico.getMensaje(),topico.getFecha_creacion());
		return ResponseEntity.ok(datosTopico);

	}
}
