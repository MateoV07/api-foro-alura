package alura.foro.challenge.domain.topico;

import java.time.Instant;

public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensjae,
                                   Instant fechaCreacion) {
}
