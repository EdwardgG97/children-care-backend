package com.childrencare.dto;

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
public class ArticleResponseDTO {

    /**
     * Identificador único del artículo.
     */
    private Long id;

    /**
     * Título del artículo.
     */
    private String title;

    /**
     * Resumen breve del artículo.
     */
    private String summary;

    /**
     * Contenido completo del artículo.
     */
    private String content;

    /**
     * Categoría del artículo.
     */
    private String category;

    /**
     * URL de la imagen asociada al artículo.
     */
    private String imageUrl;

    /**
     * Fecha y hora de creación del artículo.
     */
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
