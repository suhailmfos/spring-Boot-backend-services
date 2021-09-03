package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

@RestController
public class FilteringController {
	// filtering example
	// field1, field2
	
	@GetMapping("/filtering")
	public String retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//				.filterOutAllExcept(propertyArray)
//		
		return null;
	}
}
