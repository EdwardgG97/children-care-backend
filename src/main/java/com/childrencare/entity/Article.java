package com.childrencare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidad que representa un artículo educativo en la plataforma Children-Care.
 * 
 * Esta entidad mapea a la tabla "articles" en la base de datos H2.
 * Contiene la información básica de los artículos sobre seguridad digital,
 * ciberacoso, privacidad en internet, redes sociales, etc.
 */
@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    /**
     * Identificador único del artículo.
     * Se genera automáticamente como un valor secuencial.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título del artículo.
     * Es obligatorio y no puede ser nulo.
     */
    @Column(nullable = false, length = 200)
    private String title;

    /**
     * Resumen breve del artículo.
     * Es obligatorio y no puede ser nulo.
     */
    @Column(nullable = false, length = 500)
    private String summary;

    /**
     * Contenido completo del artículo.
     * Puede tener hasta 5000 caracteres.
     * Es obligatorio y no puede ser nulo.
     */
    @Column(nullable = false, length = 5000)
    private String content;

    /**
     * Categoría del artículo.
     * Ejemplos: "Seguridad Digital", "Ciberacoso", "Privacidad", "Redes Sociales", etc.
     * Es obligatorio y no puede ser nulo.
     */
    @Column(nullable = false, length = 100)
    private String category;

    /**
     * URL de la imagen asociada al artículo.
     * Es opcional y puede ser nula.
     */
    @Column(length = 500)
    private String imageUrl;

    /**
     * Fecha y hora de creación del artículo.
     * Se establece automáticamente al crear el artículo.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Constructor que inicializa la fecha de creación automáticamente.
     * 
     * @param title Título del artículo
     * @param summary Resumen del artículo
     * @param content Contenido del artículo
     * @param category Categoría del artículo
     * @param imageUrl URL de la imagen (opcional)
     */
    public Article(String title, String summary, String content, String category, String imageUrl) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.category = category;
        this.imageUrl = imageUrl;
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Hook de JPA que se ejecuta antes de persistir la entidad.
     * Establece la fecha de creación si no ha sido definida.
     */
    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
