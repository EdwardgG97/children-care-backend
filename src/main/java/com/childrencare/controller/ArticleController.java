package com.childrencare.controller;

import com.childrencare.dto.ArticleRequestDTO;
import com.childrencare.dto.ArticleResponseDTO;
import com.childrencare.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de artículos.
 * 
 * Esta clase expone los endpoints de la API REST para operaciones CRUD
 * sobre artículos educativos.
 * 
 * Todos los endpoints están bajo la ruta base /api/articles.
 * 
 * Anotaciones principales:
 * - @RestController: Indica que esta clase es un controlador REST
 * - @RequestMapping: Define la ruta base para todos los endpoints
 * - @CrossOrigin: Habilita CORS para permitir peticiones desde el frontend
 */
@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ArticleController {

    private final ArticleService articleService;

    /**
     * Constructor con inyección de dependencias.
     * 
     * @param articleService El servicio de artículos
     */
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Obtiene todos los artículos.
     * 
     * Endpoint: GET /api/articles
     * 
     * @return Lista de todos los artículos con código de estado 200 OK
     */
    @GetMapping
    public ResponseEntity<List<ArticleResponseDTO>> getAllArticles() {
        List<ArticleResponseDTO> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    /**
     * Obtiene un artículo por su ID.
     * 
     * Endpoint: GET /api/articles/{id}
     * 
     * @param id El ID del artículo a buscar
     * @return El artículo encontrado con código de estado 200 OK
     *         o 404 Not Found si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDTO> getArticleById(@PathVariable Long id) {
        try {
            ArticleResponseDTO article = articleService.getArticleById(id);
            return ResponseEntity.ok(article);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo artículo.
     * 
     * Endpoint: POST /api/articles
     * 
     * @param articleRequestDTO Los datos del artículo a crear
     * @return El artículo creado con código de estado 201 Created
     */
    @PostMapping
    public ResponseEntity<ArticleResponseDTO> createArticle(
            @Valid @RequestBody ArticleRequestDTO articleRequestDTO) {
        ArticleResponseDTO createdArticle = articleService.createArticle(articleRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
    }

    /**
     * Actualiza un artículo existente.
     * 
     * Endpoint: PUT /api/articles/{id}
     * 
     * @param id El ID del artículo a actualizar
     * @param articleRequestDTO Los nuevos datos del artículo
     * @return El artículo actualizado con código de estado 200 OK
     *         o 404 Not Found si no existe
     */
    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponseDTO> updateArticle(
            @PathVariable Long id,
            @Valid @RequestBody ArticleRequestDTO articleRequestDTO) {
        try {
            ArticleResponseDTO updatedArticle = articleService.updateArticle(id, articleRequestDTO);
            return ResponseEntity.ok(updatedArticle);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un artículo por su ID.
     * 
     * Endpoint: DELETE /api/articles/{id}
     * 
     * @param id El ID del artículo a eliminar
     * @return Código de estado 204 No Content si se eliminó correctamente
     *         o 404 Not Found si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        try {
            articleService.deleteArticle(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Busca artículos por categoría.
     * 
     * Endpoint: GET /api/articles/category/{category}
     * 
     * @param category La categoría a buscar
     * @return Lista de artículos de la categoría especificada
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ArticleResponseDTO>> getArticlesByCategory(@PathVariable String category) {
        List<ArticleResponseDTO> articles = articleService.getArticlesByCategory(category);
        return ResponseEntity.ok(articles);
    }

    /**
     * Busca artículos cuyo título contenga el texto especificado.
     * 
     * Endpoint: GET /api/articles/search?title={texto}
     * 
     * @param title El texto a buscar en el título
     * @return Lista de artículos que coinciden con la búsqueda
     */
    @GetMapping("/search")
    public ResponseEntity<List<ArticleResponseDTO>> searchArticlesByTitle(
            @RequestParam String title) {
        List<ArticleResponseDTO> articles = articleService.searchArticlesByTitle(title);
        return ResponseEntity.ok(articles);
    }
}
