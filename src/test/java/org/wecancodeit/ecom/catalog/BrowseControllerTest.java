package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.ecom.catalog.BrowseController;
import org.wecancodeit.ecom.catalog.BrowseController.ProductNotFoundException;
import org.wecancodeit.ecom.catalog.Product;

public class BrowseControllerTest {
	
	@InjectMocks
	private BrowseController underTest; 
	
	@Mock //creates mock for repository
	private CrudRepository<Product, Long> productRepo; 
	
	@Mock
	private Product product; 
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGetProducts() {		
		when(productRepo.findAll()).thenReturn(Collections.singleton(product)); 
		Iterable<Product> result = underTest.getProducts();
		assertThat(result, contains(any(Product.class)));
	}
	
	@Test
	public void shouldGetAnIndividualProduct() {
		long id = 42L; 
		when(productRepo.findOne(id)).thenReturn(product); 
	
		Product result = underTest.getProduct(42L); 
		
		assertThat(result,is(not(nullValue())));
	}
	
	@Test
	public void shouldGetProductsFromDb() {
		when(productRepo.findAll()).thenReturn(Collections.singleton(product)); 
		Iterable<Product> result = underTest.getProducts();
		assertThat(result, contains(product)); 
	}
	
	@Test
	public void shouldRetrieveAnIndividualProduct() {
		long id = 42L;
		when(productRepo.findOne(id)).thenReturn(product); 
		
		Product result = underTest.getProduct(id); 
		
		assertThat(result, is(product)); 
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void shouldReturnNotfoundForBadProductId() {
		long invalidProductId = 42L; 
		underTest.getProduct(invalidProductId); 
		
	}
	
}
