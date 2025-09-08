package com.tnsif.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Shop {

	@Autowired
	private Customer1  customer1;
	@Autowired
	private Customer2  customer2;
	@Autowired
	private Customer3  customer3;
	
	public void ordering() {
		customer1.order();
        customer2.order();
        customer3.order();
	}
}
