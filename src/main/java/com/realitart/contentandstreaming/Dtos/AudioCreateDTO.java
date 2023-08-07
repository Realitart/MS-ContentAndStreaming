package com.realitart.contentandstreaming.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AudioCreateDTO {
    @NotNull(message = "El campo 'artworkId' no puede estar vacío o ser nulo.")
    private Long artworkId;
    @NotBlank(message = "El campo 'url' no puede estar vacío o ser nulo.")
    private String url;
    @NotBlank(message = "El campo 'narration' no puede estar vacío o ser nulo.")
    private String narration;
}
