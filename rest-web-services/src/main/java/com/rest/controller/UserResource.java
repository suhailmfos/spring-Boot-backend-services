package com.rest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.dao.UserDaoService;
import com.rest.exception.UserNotFoundException;
import com.rest.model.User;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

@RestController
//@RequestMapping("/api/v1")
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user =  service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	// create user resource
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		// CREATED
		// user/{id}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	// create delete user by id
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		User user = service.deleteById(id);
		if(user == null)
			throw new UserNotFoundException("id-" + id);
		
		
		
	}
}