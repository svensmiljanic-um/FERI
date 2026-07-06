package kolekcije;

import java.util.Comparator;

public class Absolutni implements Comparator<Kosarkas> {

	@Override
	public int compare(Kosarkas prvi, Kosarkas drugi) {

		int razlika = prvi.visina()-drugi.visina();
		if (razlika!=0)
		   return razlika;
		else 
		   return prvi.compareTo(drugi);
	}

	
}
