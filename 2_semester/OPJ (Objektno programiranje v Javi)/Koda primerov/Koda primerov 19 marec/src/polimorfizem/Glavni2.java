package polimorfizem;

import vmesniki.*;

public class Glavni2 {
	
	public static void main(String[] args) {
		
		Sklad<Nepremicnina> hiske = new Sklad<Nepremicnina>(new Nepremicnina[100]);
		hiske.push(new Nepremicnina("Vila", 2000000));
		hiske.push(new Nepremicnina("Vikend", 20000));
			
		System.out.println(hiske.pop().vrniTrenutnoVrednost());
		System.out.println(hiske.pop().vrniTrenutnoVrednost());
		
		Sklad<Kripto> kriptoSklad = new Sklad<Kripto>(new Kripto[10]);
		kriptoSklad.push(new Kripto("BTC"));
		kriptoSklad.push(new Kripto("ETH"));
        
		System.out.println(kriptoSklad.pop());
		System.out.println(kriptoSklad.pop());
			
		
		Oseba stara = new Oseba("Marjan", 22);
		Oseba mlada = new Oseba("Lucija", 22);
		
		System.out.println(stara.compareTo(mlada));
		
		
	
	}

}
