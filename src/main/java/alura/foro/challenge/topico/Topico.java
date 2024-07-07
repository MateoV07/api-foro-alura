package alura.foro.challenge.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;

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
}
