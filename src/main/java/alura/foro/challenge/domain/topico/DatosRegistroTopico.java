package alura.foro.challenge.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(

		@NotBlank
		String titulo,
		@NotBlank
		String mensaje) {
}
