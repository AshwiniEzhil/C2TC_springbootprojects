package com.tnsif.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerExample {

	@RequestMapping("/hello")
	public String show() {
		return "example of the rest api program";
	}
	@GetMapping("/hello")
	public String greetings(@RequestParam String name) {
		return "welcome "+ name;
	}
	@GetMapping("/hello/{name}")
	public String message (@PathVariable String name)
	{
		return "Welcome"+name;
	}
}
