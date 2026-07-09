package PrimerSocket;
import java.net.*;
import java.io.*;

public class Profesor {
	
	public static void main(String[] args) throws Exception {
		
		ServerSocket streznik = new ServerSocket(4444);
		
		Socket vrata = streznik.accept();
		
		BufferedReader vhod = 
				new BufferedReader(new InputStreamReader(vrata.getInputStream()));
		
		PrintWriter izhod = 
				new PrintWriter(new OutputStreamWriter(vrata.getOutputStream()));
		
		
			String vprasanje;
		
		while (true)  {
			
			vprasanje = vhod.readLine();
		
			String odgovor = vprasanje + ": nimam pojma";
			
			switch (vprasanje) { 
			   case "kdo si" : odgovor = "Marjan";
			                     break;
			   case "kako si" : 
			   case "kako si?":  odgovor = "Slabo";
				                 break;
			   case "kdaj kolokvij" : odgovor = "cetrtek, 23. 4. ob 13:15";
			   						  break;
			        		    
			}
			
			if (vprasanje.equalsIgnoreCase("konec"))
				System.exit(0);
          
			izhod.println(odgovor);
		    izhod.flush();
			
			
			
		}
		
		
	}

}
