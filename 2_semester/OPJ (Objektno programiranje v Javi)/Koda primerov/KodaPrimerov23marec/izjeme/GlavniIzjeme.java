package izjeme;

public class GlavniIzjeme  {
	
	
	static void problematicna(boolean forsirano) throws NasaIzjema {
		
		System.out.println("Zacetek problematicne");
		if (forsirano) {
			throw new NasaIzjema("Nasa OPJ izjema");
		}
		else
		   System.out.println("Problematicna ni problem!");	
		
		System.out.println("Normalni zakljucek");
		
	}
	

	
	
	static void druga() throws NasaIzjema {
		
		try {
			problematicna(true);
		} catch (NasaIzjema e) {
		   System.out.println("Ujamem v druga - delno saniram");
		   e.fillInStackTrace(); // reset sklada sklicev
		   throw e;   // rethrowing
		}
	}
	
	
	static void prva() throws NasaIzjema {
		druga();
	}
	
	
	public static void main(String[] args)  {
		
		try {
			prva();
				problematicna(false);
			problematicna(true);
			System.out.println("tega ne bo");
	    	} catch (NasaIzjema e) {
		    	e.printStackTrace();
		}
    
        System.out.println(" konec main");;
      
	}
	

}
