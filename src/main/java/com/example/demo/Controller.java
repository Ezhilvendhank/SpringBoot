package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	Repository repo;
	
	@GetMapping("hello")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	@GetMapping("getDbValues")
	public List<Entity> getDbValues(){
		List<Entity> valueStrings = repo.findAll();
		return valueStrings;
	}
}
