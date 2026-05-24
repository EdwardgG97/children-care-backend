package com.childrencare.repository;

import com.childrencare.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad Article.
 * 
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD
 * básicos automáticamente sin necesidad de implementarlos manualmente.
 * 
 * JpaRepository<Article, Long> significa:
 * - Article: el tipo de entidad que se gestiona
 * - Long: el tipo del identificador (ID) de la entidad
 * 
 * Spring Data JPA genera automáticamente la implementación de esta interfaz
 * en tiempo de ejecución, incluyendo operaciones como save, findAll, findById,
 * deleteById, etc.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * Busca artículos por categoría.
     * 
     * @param category La categoría a buscar
     * @return Lista de artículos que pertenecen a la categoría especificada
     */
    List<Article> findByCategory(String category);

    /**
     * Busca artículos cuyo título contenga el texto especificado.
     * La búsqueda es case-insensitive (no distingue mayúsculas de minúsculas).
     * 
     * @param title El texto a buscar en el título
     * @return Lista de artículos cuyo título contiene el texto especificado
     */
    List<Article> findByTitleContainingIgnoreCase(String title);
}
