package com.example.duckdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.duckdemo.data.model.Duck;

@Service // labelled as a bean (managed by Spring)
public class DuckService {
	
	private List<Duck> ducks = new ArrayList<Duck>(
					List.of(new Duck(0, "Bob", "Red", "Pond", 3),
							new Duck(1, "Fred", "Green", "Pond", 5)));

	public List<Duck> readAllDucks() {
		return ducks;
	}
	
	public Duck readById(int id) {
		return ducks.get(id);
	}
	
	public Duck createDuck(Duck duck) {
		duck.setId(ducks.size());
		ducks.add(duck);
		return duck;
	}
	
	// Update duck
	
	
	// Delete duck
}
