package PrimeriOmrezje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Primer {

	
	public static void main(String[] args) {
		
		try {
		
			
			InetAddress inet = InetAddress.getByName("www.um.si");
			System.out.println(inet.getHostAddress());
			InetAddress inet2 = InetAddress.getByAddress(new byte[] {(byte)164,8,100,100});
			System.out.println(inet2.getHostName());
			
			System.out.println(inet.getLocalHost());
		    System.out.println("-----------------------");
		    URL naslov = new URL("https://www.um.si");
		    System.out.println(naslov.getContent());	
		    System.out.println(naslov.getProtocol());	
		    System.out.println(naslov.getPort());	
		    System.out.println(naslov.getUserInfo());	
	   	
		    URLConnection povezava = naslov.openConnection();
		    BufferedReader vhod = new BufferedReader(new InputStreamReader(povezava.getInputStream()));
		    String vrstica;
		    
		    while ((vrstica = vhod.readLine())!=null)
		    		System.out.println(vrstica);
		
		} catch (UnknownHostException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
