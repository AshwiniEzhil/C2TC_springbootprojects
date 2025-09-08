package com.tnsif.springioc_scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value= "prototype")
public class Product {

	private int id;
	private String p_name;
	
	public Product() {
		System.out.println("Product class object has been created");
	}
}
