package alura.foro.challenge.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(

		@NotBlank
		String titulo,
		@NotBlank
		String mensaje) {
}
