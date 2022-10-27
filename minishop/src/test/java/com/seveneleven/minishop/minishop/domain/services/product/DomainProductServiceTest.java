package com.seveneleven.minishop.minishop.domain.services.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.seveneleven.minishop.minishop.domain.exceptions.product_exceptions.ProductDataNotFoundException;
import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DomainProductServiceTest {
	@InjectMocks
	private DomainProductService productService;

	@Mock
	private ProductRepository productRepository;

	@Test
	void withProductId_findProduct_returnProductWithGivenId() {
		Product expectedProduct = Product.builder()
				.id(0)
				.title("Title")
				.description("Description of product 0")
				.imageUrl("This is image URL")
				.price(BigDecimal.valueOf(10000))
				.inStock(true).build();

		when(productRepository.findProductById(0)).thenReturn(expectedProduct);

		Product actualProduct = productRepository.findProductById(0);

		assertEquals(actualProduct, expectedProduct);

		verify(productRepository, times(1)).findProductById(0);
	}

	@Test
	void nothing_findAllProducts_returnAllProducts() {
		Product product1 = Product.builder().id(0).title("title").description("This is description")
				.imageUrl("https://image.jpg").price(BigDecimal.valueOf(10000)).inStock(true).build();
		Product product2 = Product.builder().id(0).title("title").description("This is description")
				.imageUrl("https://image.jpg").price(BigDecimal.valueOf(10000)).inStock(true).build();
		List<Product> expectedProducts = Arrays.asList(
				product1, product2);

		when(productRepository.getAllProducts()).thenReturn(expectedProducts);

		List<Product> actualProducts = productService.getAllProducts();

		assertEquals(actualProducts, expectedProducts);

		verify(productRepository, times(1)).getAllProducts();

		verifyNoMoreInteractions(productRepository);
	}

	@Test
	void nothing_findNoProducts_throwDataNotFoundException() {
		List<Product> expectedProducts = new ArrayList<>();

		when(productRepository.getAllProducts()).thenReturn(expectedProducts);

		assertThrows(ProductDataNotFoundException.class, () -> productService.getAllProducts());

		verify(productRepository, times(1)).getAllProducts();
	}
}
