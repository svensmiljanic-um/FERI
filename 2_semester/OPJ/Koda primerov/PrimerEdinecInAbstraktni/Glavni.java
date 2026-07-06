import java.time.*;

public class Glavni {
	
	public static void main(String[] args) {
		
		LocalDate.now();
		LocalDate danes = LocalDate.of(2026,3,9);
		
		
		
	    Lik l; //  = new Lik(10,10);   ne za abstraktne razrede in vmesnike
		
		Pravokotnik p = new Pravokotnik(0, 0, 10, 30);
		Krog k = new Krog(1, 1, 10);

		k.predstaviSe();
		
		l = p;
		l = k;
		
		Lik[] liki;
		
		liki = new Lik[3];
		liki[0] = k;
		liki[1] = p;
		liki[2] = new Pravokotnik(0,0,10,50);
		
		// enotna obravnava 
		for (int i=0; i<liki.length; i++)
			System.out.println(liki[i].izracunajPloscino());
			
			
			
		
	}

}
