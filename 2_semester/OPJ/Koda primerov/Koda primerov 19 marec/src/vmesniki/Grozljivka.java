package vmesniki;

interface Smrtonosen {
       void ubije();
}

interface Nevaren {
   	void grozi();
  }

interface Posasten {
    void unici();
}

interface NevarnoPosasten extends Nevaren, Posasten {

	
	void opozarja();

}


class Profesor implements NevarnoPosasten {

	@Override
	public void grozi() {
		System.out.println("Padel bos na izpitu ");
		}

	@Override
	public void unici() {
		System.out.println("Izpit po lampijonckih ");
			
	}
	

	public void predava() {
		System.out.println("Tri ure v ponedeljek zjutraj");
		
	}

	@Override
	public void opozarja() {
		System.out.println(" Ucite se sproti! ");	
		}
	
	
}


class Zmajcek  implements NevarnoPosasten, Smrtonosen {
  
	public void meLepoPozdravi() {}
	
	
    public void unici(){
      System.out.println("bruha ogenj"); 
    }

    public void grozi() {
      System.out.println("buuuuuu ");
    } 

    public void ubije() {
      System.out.println("zasadi zobe ...");
    }

	@Override
	public void opozarja() {
       System.out.println(" mahne z repom");		
	} 

}


interface IPrevarantski {

    void paziZeno();

}

class Sosed implements NevarnoPosasten, IPrevarantski {

    public void unici(){
      System.out.println("zastrupi Flokija"); 
    }

    public void grozi() {
      System.out.println("klice ponoci");
    } 

    
    void paziHiso() {
       System.out.println("Odganja vlomilce ");
    }

    @Override
    public void paziZeno() {
       System.out.println(" kot se spodobi, ker ga ne zanima");

    }

	@Override
	public void opozarja() {
		System.out.println(" Ne provocirat!");
	} 

}



class Sorodnik implements NevarnoPosasten {

    public void unici(){
      System.out.println("Hujska hÄ�erko!"); 
    }

    public void grozi() {
      System.out.println("Grozi, da bo prisel/prisla na obisk");
    } 
    
    void paziOtroke() {
      System.out.println(" Ko grem v Opero Balet na predstavo Cluster");
    }

    public void kuhaKosilo() {
      System.out.println("Za kosilo: goveja juha z rezanci");
    }

	@Override
	public void opozarja() {
		System.out.println(" Opozarja naj se imamo radi");
		
	} 

}

class FakinZmajcek extends Zmajcek implements IPrevarantski {

	@Override
	public void paziZeno() {
		System.out.println("Zmajcek Fakin pri zeni");
	}
	
}


public class Grozljivka {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		NevarnoPosasten hericko;
		
		hericko = new Zmajcek();
		
		
		hericko.grozi();
		hericko.unici();
		

		
		
		Zmajcek zeleni = new Zmajcek();
        Sosed janez  = new Sosed();
        IPrevarantski zigolo = janez;
        Sorodnik zlahtnik = new Sorodnik();      
		NevarnoPosasten hudic;
	 
		hudic = zlahtnik;
		
	
		zlahtnik.kuhaKosilo();
		zlahtnik.paziOtroke();
		zlahtnik.unici();
		 
		zlahtnik.grozi();
		zlahtnik.unici();
		 
		 
		Sosed joza = new Sosed();
	 
		hudic = joza;
		
		IPrevarantski casa;
		casa = joza;
	
		
		Zmajcek lj = new Zmajcek();
		
		lj = new FakinZmajcek();
		
		if (lj instanceof IPrevarantski)
			System.out.println(" je prevarant" );
		else
		   System.out.println(" ni primerek IPrevarantski");
		
			
		Zmajcek z = new Zmajcek();
		Smrtonosen x; 
		x = z;
		x.ubije();
		 
		NevarnoPosasten np;
		np = z;
		np.grozi();
		np.unici();
		 
		Sorodnik xxx = null;
		
	/*	if (xxx instanceof Zmajcek)     compilation error
			System.out.println("");
	*/		
				
	}
	
	


}
