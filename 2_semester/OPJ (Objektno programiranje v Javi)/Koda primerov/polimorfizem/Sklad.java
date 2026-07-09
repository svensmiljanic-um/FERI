package polimorfizem;
import delavski.Delavec;
import vmesniki.INalozba;

public class Sklad<Tip extends INalozba> {
	
	private int stroskiPlac;
	private Tip[]  elementi;
	private int kaz;   // prvo prazno mesto
	
	public Sklad(Tip[] polje) {
		elementi = polje;
        kaz =0;
	}
	
	
	public void push(Tip element) throws IzjemaSKladPoln {
		if (kaz<elementi.length) {
		   elementi[kaz++]=element;
		   System.out.println("Dodajamo na sklad: " + element.vrniTrenutnoVrednost());
		  }
		else
			throw new IzjemaSKladPoln("Sklad je poln",elementi.length);
		
	}

	public Tip pop() {
		if (kaz==0) {
			System.out.println("Sorry. Je prazen.");
			return null;
		}
		else
		  return elementi[--kaz];
	}
	
}
