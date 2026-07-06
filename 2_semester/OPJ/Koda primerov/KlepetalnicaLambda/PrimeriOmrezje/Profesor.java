package PrimeriOmrezje;

import java.net.*;
import java.io.*;

public class Profesor {

	public static void main(String[] args) {
	
		try {
			
			ServerSocket streznik = new ServerSocket(4444);
			
			System.out.println(" Cakam na stranko!");
			
			Socket kanal = streznik.accept();
			
			System.out.println(" sedaj pa sva povezana");
			
			BufferedReader vhod = new BufferedReader(new InputStreamReader(kanal.getInputStream()));
			PrintWriter izhod = new PrintWriter(new OutputStreamWriter(kanal.getOutputStream()));
			
	   
			
			String poizvedba;
			
			while (true) {
				
				poizvedba = vhod.readLine();
				
				switch (poizvedba) {
				
				case "vreme": izhod.println(" Slabo kaze danes...");
				              break;
				case "kdaj pisemo kolokvij":
				    	      izhod.println(" v cetrtek, 23. 4. ob 13:15");
				              break;
				case "konec": System.exit(0);
				default:  izhod.println(" Te ne razumem, oprosti");
				
				}
				
				izhod.flush();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
