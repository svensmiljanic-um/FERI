package PrimerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Radovednez {
	
	public static void main(String[] args) throws Exception  {
		
		Socket vrata = new Socket("localhost",4444);
		
		BufferedReader vhod = 
				new BufferedReader(new InputStreamReader(vrata.getInputStream()));
	
		PrintWriter izhod = 
				new PrintWriter(new OutputStreamWriter(vrata.getOutputStream()));
		
		Scanner konzola = new Scanner(System.in);
		
		System.out.println("Kaj te zanima?");
		
		while (true)  {
			
			String vprasanje = konzola.nextLine();
			izhod.println(vprasanje);
			izhod.flush();
			if (vprasanje.equalsIgnoreCase("konec"))
				break;
			System.out.println(vhod.readLine());
			
	}

}
}