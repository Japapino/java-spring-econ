package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CatalogJpaTest {
	
	@Resource
	private CrudRepository<Product, Long> productRepo; //until we create a product repository later, 
														//this will cause the first test to fail since there is no crud repo to inject
	
	@Test
	public void shouldPass() {} 
	
	@Test
	public void shouldInitializeProductRepository() {}; 
	
	
	
	
	

}
