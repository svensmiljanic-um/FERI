package izjeme;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Izjeme {

	public static void main(String[] args) {
		
	  try {	
		int i = 8;
		int j = 2;
		System.out.println(i/j);
		
		String janez =  "Janez";
		
		System.out.println(janez.toString());
		
		System.out.println(args[0]);
		
		System.out.println(args[1]);

		FileReader vhodna = new FileReader("a.txt");
		
		System.out.println(" Nasvidenje");

		
		
	  }  catch (ArithmeticException e) {
		  System.out.println(" Najbrz delis z 0");
	  }  catch (NullPointerException e) {
		  System.out.println(" Sorry, trenutno ne deluje.");
	  } catch (IndexOutOfBoundsException e) {
		  System.out.println("najbr ni bilo dovolj argumentov");
		 e.printStackTrace();
	  } catch (FileNotFoundException e) {
		   System.out.println("Očitno datoteka ne obstaja");
		   System.out.println(e.getMessage());
		   System.out.println(e.toString());
		   
	} finally {
		System.out.println(" V vsakem primeru grem na kavico ");
	}
	  
	  System.out.println(" -- in normalno nadaljujem");
		
	}
	
	
}
