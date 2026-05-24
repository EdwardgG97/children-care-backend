package com.childrencare.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones.
 * 
 * Esta clase captura las excepciones que ocurren en la aplicación
 * y devuelve respuestas JSON estructuradas y amigables para el cliente.
 * 
 * Anotación @RestControllerAdvice:
 * - Combina @ControllerAdvice y @ResponseBody
 * - Permite manejar excepciones globalmente en todos los controladores
 * - Las respuestas se convierten automáticamente a JSON
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones de validación (@Valid).
     * 
     * Esta excepción ocurre cuando los datos enviados en una petición
     * no cumplen con las reglas de validación definidas en los DTOs.
     * 
     * @param ex La excepción de validación
     * @return ResponseEntity con los errores de validación
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();
        
        // Extraer los errores de validación de cada campo
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Error");
        response.put("message", "Error de validación en los datos enviados");
        response.put("errors", errors);
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Maneja excepciones generales (RuntimeException).
     * 
     * Esta excepción ocurre cuando se produce un error en la lógica de negocio,
     * como intentar acceder a un recurso que no existe.
     * 
     * @param ex La excepción runtime
     * @return ResponseEntity con el mensaje de error
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        
        Map<String, Object> response = new HashMap<>();
        
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", "Resource Not Found");
        response.put("message", ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Maneja excepciones no esperadas.
     * 
     * Este método captura cualquier excepción que no haya sido manejada
     * por los métodos anteriores.
     * 
     * @param ex La excepción
     * @return ResponseEntity con el mensaje de error genérico
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        
        Map<String, Object> response = new HashMap<>();
        
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", "Internal Server Error");
        response.put("message", "Ocurrió un error inesperado en el servidor");
        
        // En desarrollo, puedes incluir el stack trace para debugging
        // response.put("details", ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
