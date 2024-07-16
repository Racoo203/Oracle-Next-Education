package com.one.foro.model.topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    private String status;
    private String autor;
    private String curso;

    public void actualizarTopico(PutTopico putTopico) {
        if (putTopico.titulo() != null && !putTopico.titulo().isEmpty()) {
            System.out.println(putTopico.titulo());
            this.titulo = putTopico.titulo();
        }
        if (putTopico.mensaje() != null && !putTopico.mensaje().isEmpty()) {
            System.out.println(putTopico.mensaje());
            this.mensaje = putTopico.mensaje();
        }
        if (putTopico.curso() != null && !putTopico.curso().isEmpty()) {
            System.out.println(putTopico.curso());
            this.curso = putTopico.curso();
        }
    }

    public Topico(PostTopico postTopico) {
        this.titulo = postTopico.titulo();
        this.curso = postTopico.curso();
        this.mensaje = postTopico.mensaje();
        this.fechaCreacion = LocalDate.now();
        this.status = "Sin Respuestas";
        this.autor = "Other";
    }

}
