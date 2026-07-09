package ioTokovi;

import java.io.*;

import kolekcije.Kosarkas;

public class Tokovi {

	public static void main(String[] args) throws Exception {
//		
//		byte[]  polje = {65, 66, 67, 13, 10};
//		
//		try {
//			FileOutputStream fos = new FileOutputStream("a.dat",true);
//	        PrintStream ps = new PrintStream(fos);
//			fos.write(polje);
//			fos.write(100);
//			ps.print("Metka");
//			ps.println(new Kosarkas("James", 211, 41));
//			//fos.flush();
//			fos.close();
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	String kajBoNot = "ŠČĆĐŠ";
		
//       FileWriter fw = new FileWriter("znakovni.dat");
//       PrintWriter pw = new PrintWriter(fw);
//       pw.println(kajBoNot);
//	   pw.close();
		
	   FileReader fr = new FileReader("znakovni.dat");
	   BufferedReader br = new BufferedReader(fr);
	   String vrstica;
	   while ((vrstica = br.readLine())!=null)
		System.out.println(vrstica);
	   
	
	   PrintWriter izhod = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Cp1250.txt"), "Cp1250"));
	   izhod.println(kajBoNot);
	   izhod.close();
	}
	
	
}
