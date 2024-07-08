package alura.foro.challenge.domain.topico;

import java.time.Instant;

public record DatosListadoTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 Instant fechaCreacion) {
	public DatosListadoTopico(Topico topico){
		this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion());
	}
}
