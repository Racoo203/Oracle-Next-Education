package com.one.foro.model.topico;

import java.time.LocalDate;

public record GetTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaCreacion
) {

    public GetTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }

}
