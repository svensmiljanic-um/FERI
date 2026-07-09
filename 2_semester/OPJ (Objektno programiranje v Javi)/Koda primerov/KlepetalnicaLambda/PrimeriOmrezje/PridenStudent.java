package PrimeriOmrezje;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class PridenStudent {

	public static void main(String[] args) {
		
		try {
			
			Socket vrataNaOdjemalcu = new Socket("localhost",4444);
		
			BufferedReader vhod = new BufferedReader(new InputStreamReader(vrataNaOdjemalcu.getInputStream()));
			PrintWriter izhod = new PrintWriter(new OutputStreamWriter(vrataNaOdjemalcu.getOutputStream()));
			
			System.out.println(" Kaj te zanima?");
			
			do {
			
			Scanner konzola = new Scanner(System.in);
			
			String vprasanje = konzola.nextLine();
			
			izhod.println(vprasanje);
			izhod.flush();
			
			if (vprasanje.equalsIgnoreCase("konec"))
				break;
			else	   
			    System.out.println("Odgovor:" + vhod.readLine());
			
			} while (true);
		
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
}
