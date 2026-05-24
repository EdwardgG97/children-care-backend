package com.childrencare.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) para recibir datos de creación/actualización de artículos.
 * 
 * Esta clase se utiliza para validar y transferir los datos enviados desde el frontend
 * al backend al crear o actualizar un artículo.
 * 
 * Las anotaciones de validación aseguran que los datos cumplan con los requisitos
 * antes de ser procesados.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para crear o actualizar artículos educativos")
public class ArticleRequestDTO {

    /**
     * Título del artículo.
     * No puede estar vacío o ser nulo.
     * Máximo 200 caracteres.
     */
    @Schema(description = "Título del artículo", example = "Seguridad Digital para Niños", required = true)
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 200, message = "El título no puede exceder 200 caracteres")
    private String title;

    /**
     * Resumen breve del artículo.
     * No puede estar vacío o ser nulo.
     * Máximo 500 caracteres.
     */
    @Schema(description = "Resumen breve del artículo", example = "Guía básica sobre seguridad digital para niños", required = true)
    @NotBlank(message = "El resumen es obligatorio")
    @Size(max = 500, message = "El resumen no puede exceder 500 caracteres")
    private String summary;

    /**
     * Contenido completo del artículo.
     * No puede estar vacío o ser nulo.
     * Máximo 5000 caracteres.
     */
    @Schema(description = "Contenido completo del artículo", example = "El contenido completo del artículo sobre seguridad digital...", required = true)
    @NotBlank(message = "El contenido es obligatorio")
    @Size(max = 5000, message = "El contenido no puede exceder 5000 caracteres")
    private String content;

    /**
     * Categoría del artículo.
     * No puede estar vacío o ser nulo.
     * Máximo 100 caracteres.
     * Ejemplos: "Seguridad Digital", "Ciberacoso", "Privacidad", "Redes Sociales", etc.
     */
    @Schema(description = "Categoría del artículo", example = "Seguridad Digital", required = true)
    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 100, message = "La categoría no puede exceder 100 caracteres")
    private String category;

    /**
     * URL de la imagen asociada al artículo.
     * Es opcional, puede ser nula.
     * Máximo 500 caracteres.
     */
    @Schema(description = "URL de la imagen asociada al artículo", example = "https://example.com/image.jpg")
    @Size(max = 500, message = "La URL de la imagen no puede exceder 500 caracteres")
    private String imageUrl;
}
