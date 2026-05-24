package com.childrencare.service;

import com.childrencare.dto.ArticleRequestDTO;
import com.childrencare.dto.ArticleResponseDTO;
import com.childrencare.entity.Article;
import com.childrencare.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para la lógica de negocio de artículos.
 * 
 * Esta clase contiene la lógica de negocio relacionada con los artículos.
 * Actúa como intermediario entre el controller y el repository.
 * 
 * Responsabilidades:
 * - Validar y procesar los datos antes de persistirlos
 * - Transformar entidades a DTOs y viceversa
 * - Manejar excepciones de negocio
 * - Implementar reglas de negocio específicas
 */
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    /**
     * Constructor con inyección de dependencias.
     * 
     * @param articleRepository El repositorio de artículos
     */
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * Obtiene todos los artículos.
     * 
     * @return Lista de todos los artículos como DTOs
     */
    public List<ArticleResponseDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un artículo por su ID.
     * 
     * @param id El ID del artículo a buscar
     * @return El artículo como DTO
     * @throws RuntimeException si no se encuentra el artículo
     */
    public ArticleResponseDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado con ID: " + id));
        return convertToDTO(article);
    }

    /**
     * Crea un nuevo artículo.
     * 
     * @param articleRequestDTO Los datos del artículo a crear
     * @return El artículo creado como DTO
     */
    public ArticleResponseDTO createArticle(ArticleRequestDTO articleRequestDTO) {
        Article article = convertToEntity(articleRequestDTO);
        Article savedArticle = articleRepository.save(article);
        return convertToDTO(savedArticle);
    }

    /**
     * Actualiza un artículo existente.
     * 
     * @param id El ID del artículo a actualizar
     * @param articleRequestDTO Los nuevos datos del artículo
     * @return El artículo actualizado como DTO
     * @throws RuntimeException si no se encuentra el artículo
     */
    public ArticleResponseDTO updateArticle(Long id, ArticleRequestDTO articleRequestDTO) {
        Article existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado con ID: " + id));

        // Actualizar los campos del artículo
        existingArticle.setTitle(articleRequestDTO.getTitle());
        existingArticle.setSummary(articleRequestDTO.getSummary());
        existingArticle.setContent(articleRequestDTO.getContent());
        existingArticle.setCategory(articleRequestDTO.getCategory());
        existingArticle.setImageUrl(articleRequestDTO.getImageUrl());

        // La fecha de creación no se modifica

        Article updatedArticle = articleRepository.save(existingArticle);
        return convertToDTO(updatedArticle);
    }

    /**
     * Elimina un artículo por su ID.
     * 
     * @param id El ID del artículo a eliminar
     * @throws RuntimeException si no se encuentra el artículo
     */
    public void deleteArticle(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new RuntimeException("Artículo no encontrado con ID: " + id);
        }
        articleRepository.deleteById(id);
    }

    /**
     * Busca artículos por categoría.
     * 
     * @param category La categoría a buscar
     * @return Lista de artículos de la categoría especificada
     */
    public List<ArticleResponseDTO> getArticlesByCategory(String category) {
        List<Article> articles = articleRepository.findByCategory(category);
        return articles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca artículos cuyo título contenga el texto especificado.
     * 
     * @param title El texto a buscar en el título
     * @return Lista de artículos que coinciden con la búsqueda
     */
    public List<ArticleResponseDTO> searchArticlesByTitle(String title) {
        List<Article> articles = articleRepository.findByTitleContainingIgnoreCase(title);
        return articles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una entidad Article a un ArticleResponseDTO.
     * 
     * @param article La entidad a convertir
     * @return El DTO resultante
     */
    private ArticleResponseDTO convertToDTO(Article article) {
        return new ArticleResponseDTO(
                article.getId(),
                article.getTitle(),
                article.getSummary(),
                article.getContent(),
                article.getCategory(),
                article.getImageUrl(),
                article.getCreatedAt()
        );
    }

    /**
     * Convierte un ArticleRequestDTO a una entidad Article.
     * 
     * @param dto El DTO a convertir
     * @return La entidad resultante
     */
    private Article convertToEntity(ArticleRequestDTO dto) {
        return new Article(
                dto.getTitle(),
                dto.getSummary(),
                dto.getContent(),
                dto.getCategory(),
                dto.getImageUrl()
        );
    }
}
