package com.seveneleven.minishop.minishop.api.exception_handlers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.seveneleven.minishop.minishop.domain.exceptions.product_exceptions.ProductDataNotFoundException;
import com.seveneleven.minishop.minishop.domain.exceptions.product_exceptions.ProductNotFoundException;

@ControllerAdvice
public class ProductControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ProductDataNotFoundException.class)
	ResponseEntity<?> handleDataNotFound(ProductDataNotFoundException ex, WebRequest request) {
		HashMap<String, Object> response = new LinkedHashMap<>();
		response.put("message", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	ResponseEntity<?> handleProductNotFound(ProductNotFoundException ex, WebRequest request) {
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<?> handleMethodArgumentNotInvalid(MethodArgumentNotValidException ex, WebRequest request) {
		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(err -> err.getDefaultMessage())
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("errors", errors));
	}

}
