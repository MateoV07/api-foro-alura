package alura.foro.challenge.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	@CreationTimestamp
	private Instant fecha_creacion;

	public Topico(DatosRegistroTopico datosRegistroTopico){
		this.mensaje = datosRegistroTopico.mensaje();
		this.titulo = datosRegistroTopico.titulo();
	}

	public void actualizarDatos(DatosActualizarTopico datosActualizarTopico){
		if (datosActualizarTopico.titulo() != null){
			this.titulo = datosActualizarTopico.titulo();
		}
		if (datosActualizarTopico.mensaje() != null){
			this.mensaje = datosActualizarTopico.mensaje();
		}

	}
}
