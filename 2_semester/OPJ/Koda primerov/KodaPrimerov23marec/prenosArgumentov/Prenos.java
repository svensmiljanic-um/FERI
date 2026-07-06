package prenosArgumentov;

public class Prenos {

static void zamenjaj(int prvi, int drugi) {
		
		int temp;
		
		temp = prvi;
		prvi = drugi;
		drugi = temp;
		
		System.out.println(" prvi " + prvi + " drugi " + drugi);
		
	}

static void zamenjajOsebi(Oseba prva, Oseba druga) {
	
	Oseba temp;
	
	//prva.setStarost(100);
	
	temp = prva;
	prva = druga;
	druga = temp;
	

	
}

	
   static Oseba novaPunca() {
	   
	   return new Oseba("Marica",85);
   }

	
	public static void main(String[] args) {
		
		int i = 10;
		int j = 20;
		
		zamenjaj(9, 10);
		zamenjaj(i, j);

		System.out.println("i = " + i + " , j: "+j);
		
		
		Oseba janez = new Oseba("Janez", 18);
		Oseba metka = new Oseba("Metka", 50);
		
			
		zamenjajOsebi(janez, metka);
		
		System.out.println("Janez:" + janez + " Metka: " + metka.toString());
		
		metka = novaPunca();
		System.out.println(metka);
		
	}
}
