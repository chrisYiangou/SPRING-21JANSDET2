package com.example.duckdemo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.duckdemo.data.model.Duck;
import com.example.duckdemo.service.DuckService;

@RestController
//@Controller // Returns a view unless @ResponseBody is specified
//@ResponseBody
@RequestMapping(path = "/duck")
public class DuckController {

	// localhost:8080/
//	@RequestMapping(method = RequestMethod.GET)
	
//	@Autowired // field injection
	private DuckService duckService;
	
	@Autowired // constructor injection
	public DuckController(DuckService duckService) {
		this.duckService = duckService;
	}
	
	// localhost:8080/duck
	@GetMapping
	public ResponseEntity<List<Duck>> getAllDucks() {
		
		// Response has headers, a body and a status code
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "1442");
		
		List<Duck> data = duckService.readAllDucks();
		
		// ResponseEntity(Body, Headers, HttpStatus)
		return new ResponseEntity<List<Duck>>(data, httpHeaders, HttpStatus.OK);
	}
	
	// localhost:8080/duck/3
	@GetMapping("/{id}")
	public ResponseEntity<Duck> getDuckById(@PathVariable("id") int id) {
		Duck duck = duckService.readById(id);
		
		return new ResponseEntity<Duck>(duck, HttpStatus.OK);
	}
	
	// localhost:8080/duck/alt?id=1
	@GetMapping("/alt")
	public ResponseEntity<Duck> getDuckByIdAlt(@PathParam("id") int id) {
		Duck duck = duckService.readById(id);
		
		return new ResponseEntity<Duck>(duck, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Duck> createDuck(@RequestBody Duck duck) {
		Duck newDuck = duckService.createDuck(duck);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newDuck.getId()));
	
		return new ResponseEntity<Duck>(duck, headers, HttpStatus.CREATED);
	}
	
	// Update duck method
	
	
	// Delete duck method
	
	// @GetMapping (retrieving something)
	// @PostMapping (creating something)
	// @PutMapping (generalised update)
	// @PatchMapping (specific update)
	// @DeleteMapping (deleting something)
}
