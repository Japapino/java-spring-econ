package org.wecancodeit.ecom.catalog;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private Long id;
	
	private String name;

	@SuppressWarnings("unused") // needed for JSON/JPA
	private Product() {}
	
	public Product(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}