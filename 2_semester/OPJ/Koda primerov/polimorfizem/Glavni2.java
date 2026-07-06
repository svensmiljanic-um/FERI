package polimorfizem;

import vmesniki.*;

public class Glavni2 {
	
	public static void main(String[] args) {
		
		Sklad<Nepremicnina> hiske = new Sklad<Nepremicnina>(new Nepremicnina[2]);
		try {
			int i=0;
			int j = 10/i;
			hiske.push(new Nepremicnina("Vila", 2000000));
			hiske.push(new Nepremicnina("Vikend", 20000));
			System.out.println(" po drugi");
	   	}   catch (ArithmeticException e ) {
	   		System.out.println(" ujel 0");
	   	} 
		catch (IzjemaSKladPoln e) {
        System.out.println(" Ujel sem izjemo sklada");
        System.out.println(e.getMessage());
        System.out.println(e.toString());
        System.out.println(e.vrniMaxElementov());
}    finally {
	    System.out.println(" vedno");
}
//			
//		System.out.println(hiske.pop().vrniTrenutnoVrednost());
//		System.out.println(hiske.pop().vrniTrenutnoVrednost());
//		
//		Sklad<Kripto> kriptoSklad = new Sklad<Kripto>(new Kripto[10]);
//		kriptoSklad.push(new Kripto("BTC"));
//		kriptoSklad.push(new Kripto("ETH"));
//        
//		System.out.println(kriptoSklad.pop());
//		System.out.println(kriptoSklad.pop());
//			
//		
//		Oseba stara = new Oseba("Marjan", 22);
//		Oseba mlada = new Oseba("Lucija", 22);
//		
//		System.out.println(stara.compareTo(mlada));
//		
		
	
	}

}
