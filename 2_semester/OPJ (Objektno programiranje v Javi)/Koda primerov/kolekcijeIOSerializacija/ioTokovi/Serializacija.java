package ioTokovi;

import kolekcije.Kosarkas;

import java.io.*;
import java.util.zip.GZIPOutputStream;


public class Serializacija {
	
	public static void main(String[] args) {
		
		Kosarkas lukec = new Kosarkas("Luka MalI", 203, 27);
		
        try {
        	
			ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("lukec.ser")));
		    oos.writeObject(lukec);
		    lukec.setIme("Luka Veliki");
		    System.out.println(lukec);
		    oos.close();
        
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		
		
		
	}

}
