package com.example.duckdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public ResponseEntity<List<Duck>> getAllDucks() {
		
		// Response has headers, a body and a status code
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "1442");
		
		List<Duck> data = duckService.readAllDucks();
		
		// ResponseEntity(Body, Headers, HttpStatus)
		return new ResponseEntity<List<Duck>>(data, httpHeaders, HttpStatus.OK);
	}
	
	// @GetMapping (retrieving something)
	// @PostMapping (creating something)
	// @PutMapping (generalised update)
	// @PatchMapping (specific update)
	// @DeleteMapping (deleting something)
}
