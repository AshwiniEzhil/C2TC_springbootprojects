package com.tnsif.springq;

import org.springframework.stereotype.Component;

@Component
public class Electronics implements ShoppingMall {

	
	public void purchase() {
		System.out.println("I m going to purcase some widgets");
	}
}
