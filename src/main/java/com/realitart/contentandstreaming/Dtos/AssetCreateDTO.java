package com.realitart.contentandstreaming.Dtos;

import jakarta.validation.Valid;
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
public class AssetCreateDTO {
    @NotNull(message = "El campo 'artworkId' no puede estar vacío o ser nulo.")
    private Long artworkId;
    @NotBlank(message = "El campo 'url' no puede estar vacío o ser nulo.")
    private String url;
    @NotNull(message = "El campo 'positionX' no puede estar vacío o ser nulo.")
    private Double positionX;
    @NotNull(message = "El campo 'positionY' no puede estar vacío o ser nulo.")
    private Double positionY;
    @NotNull(message = "El campo 'positionZ' no puede estar vacío o ser nulo.")
    private Double positionZ;
    @NotNull(message = "El campo 'scaleX' no puede estar vacío o ser nulo.")
    private Double scaleX;
    @NotNull(message = "El campo 'scaleY' no puede estar vacío o ser nulo.")
    private Double scaleY;
    @NotNull(message = "El campo 'scaleZ' no puede estar vacío o ser nulo.")
    private Double scaleZ;
    @NotNull(message = "El campo 'rotationX' no puede estar vacío o ser nulo.")
    private Double rotationX;
    @NotNull(message = "El campo 'rotationY' no puede estar vacío o ser nulo.")
    private Double rotationY;
    @NotNull(message = "El campo 'rotationZ' no puede estar vacío o ser nulo.")
    private Double rotationZ;
}
