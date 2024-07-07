package alura.foro.challenge.topico;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	@CreatedDate
	private Date fecha_creacion;
}
