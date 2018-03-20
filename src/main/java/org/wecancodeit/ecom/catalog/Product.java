package org.wecancodeit.ecom.catalog;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private Long id; 

	private String name;

	private Product() {}
	
	public Product(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
