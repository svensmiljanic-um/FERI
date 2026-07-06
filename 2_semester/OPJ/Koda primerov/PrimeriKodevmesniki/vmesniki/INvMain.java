package vmesniki;

import java.io.Serializable;

public class INvMain {
	
	public static void main(String[] args) {
		
		INalozba nalozbica;
		
		
		Nepremicnina vikend = new Nepremicnina("Vila Pag", 5000000);
		VarcevalniRacun moj = new VarcevalniRacun("Marjan", 10000, ObdobjeVezave.LETNA);
		
		nalozbica = moj;
				
		System.out.println(nalozbica.vrniDonosnost());
		 System.out.println(nalozbica.vrniTveganje());
		
		nalozbica = new Kripto("Bitcoin");

		System.out.println(nalozbica.vrniDonosnost());
		 System.out.println(nalozbica.vrniTveganje());
		 System.out.println(nalozbica.vrniTrenutnoVrednost());
	
		 INalozba[] mojeNalozbe = new INalozba[4];
		 
		 mojeNalozbe[0] = new Kripto("Bitcoin");
		 mojeNalozbe[1] = new Kripto("ETH");
		 mojeNalozbe[2] = moj;
		 mojeNalozbe[3] = new Nepremicnina("Stanovanje v Novi vrtovi", 650000);
		 
		 double skupneNalozbe = 0;
		 
		 for (int i=0; i<mojeNalozbe.length; i++)
			skupneNalozbe += mojeNalozbe[i].vrniTrenutnoVrednost();
		 
		 System.out.println(skupneNalozbe);

		 
		 
		 if (nalozbica instanceof Serializable)
			 System.out.println(" Lahko serializiram");
		 else
			 System.out.println("ni seralilizable");
		 
		 nalozbica = vikend;
		 
		 if (nalozbica instanceof Nepremicnina) {
			 Nepremicnina hiska = (Nepremicnina)nalozbica;
			 hiska.izpisiLokacijo();
		 }  else
			 System.out.println("ni nepremicnina in nima smisla castat");
		 
		 
		 
	}
	

}
