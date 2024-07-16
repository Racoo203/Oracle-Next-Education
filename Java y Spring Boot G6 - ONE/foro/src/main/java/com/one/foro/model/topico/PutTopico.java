package com.one.foro.model.topico;

import jakarta.validation.constraints.NotNull;

public record PutTopico(
        @NotNull
        Long Id,
        String titulo,
        String mensaje,
        String curso
) {
}
