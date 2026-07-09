package ioTokovi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

import kolekcije.Kosarkas;

public class Deserializacija {
	
	
	public static void main(String[] args) {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new GZIPInputStream(new FileInputStream("lukec.ser")));
		    Kosarkas k = (Kosarkas)ois.readObject();
	        System.out.println(k);
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
