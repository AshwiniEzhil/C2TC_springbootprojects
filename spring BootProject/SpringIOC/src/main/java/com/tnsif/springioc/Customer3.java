package com.tnsif.springioc;

import org.springframework.stereotype.Component;

@Component
public class Customer3 {
private int cid;
private String name;
private String city;
public Customer3() {
	System.out.println("Customer1 class object has been created");
}
public void order() {
	System.out.println("Customer 3 ordering the product");
}
public int getCid() {
	return cid;
}
public void setCid(int cide) {
	this.cid = cide;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

}
