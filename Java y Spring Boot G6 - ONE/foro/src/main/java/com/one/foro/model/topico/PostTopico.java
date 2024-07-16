package com.one.foro.model.topico;

import jakarta.validation.constraints.NotBlank;

public record PostTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String curso
) {
}
