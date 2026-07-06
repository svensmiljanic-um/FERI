package Klepetalnica;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Uporabnik implements Runnable {
	
	public BufferedReader vhod;
	public PrintWriter izhod;
	public ChatStreznik streznik;
	
	Uporabnik(BufferedReader vhod, PrintWriter izhod, ChatStreznik streznik){
	  this.vhod=vhod;
	  this.izhod=izhod;
	  this.streznik=streznik;
	}

	
	
	public void run() {

		
		String sporocilo;
		
		
		try {
			while(!(sporocilo=vhod.readLine()).equals("null")) {
				
			   streznik.poslji(sporocilo);	
				
			}
		
		
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
