package com.childrencare.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para enviar datos de artículos al frontend.
 * 
 * Esta clase se utiliza para transferir los datos de los artículos desde el backend
 * al frontend de una manera controlada y segura.
 * 
 * Solo incluye los campos necesarios para la visualización en el frontend,
 * ocultando detalles internos de la entidad.
 */
@Data
@NoArgsConstructor
@Schema(description = "DTO para representar artículos educativos en las respuestas")
public class ArticleResponseDTO {

    /**
     * Identificador único del artículo.
     */
    @Schema(description = "Identificador único del artículo", example = "1")
    private Long id;

    /**
     * Título del artículo.
     */
    @Schema(description = "Título del artículo", example = "Seguridad Digital para Niños")
    private String title;

    /**
     * Resumen breve del artículo.
     */
    @Schema(description = "Resumen breve del artículo", example = "Guía básica sobre seguridad digital")
    private String summary;

    /**
     * Contenido completo del artículo.
     */
    @Schema(description = "Contenido completo del artículo", example = "El contenido completo del artículo...")
    private String content;

    /**
     * Categoría del artículo.
     */
    @Schema(description = "Categoría del artículo", example = "Seguridad Digital")
    private String category;

    /**
     * URL de la imagen asociada al artículo.
     */
    @Schema(description = "URL de la imagen asociada al artículo", example = "https://example.com/image.jpg")
    private String imageUrl;

    /**
     * Fecha y hora de creación del artículo.
     */
    @Schema(description = "Fecha y hora de creación del artículo", example = "2025-01-15T10:30:00")
    private LocalDateTime createdAt;

    /**
     * Constructor que crea un ArticleResponseDTO a partir de un objeto Article.
     * 
     * @param article La entidad Article desde la cual se creará el DTO
     */
    public ArticleResponseDTO(Long id, String title, String summary, String content, 
                               String category, String imageUrl, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.category = category;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }
}
