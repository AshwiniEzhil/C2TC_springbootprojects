package com.tnsif.springq;

import org.springframework.stereotype.Component;

@Component
public class Clothes implements ShoppingMall{

	public void purchase() {
		System.out.println("Im going to order some dress");
	}
}
