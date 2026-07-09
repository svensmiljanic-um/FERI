package kolekcije;

import java.io.Serializable;

public class Avtomobil implements Serializable{

	private String model;

	public Avtomobil(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Avtomobil : " + model;
	}
	
	
	
}
