package kolekcije;

import java.util.Comparator;

public class PrimerjalnikNajprejVisina implements Comparator<Kosarkas>{

	@Override
	public int compare(Kosarkas prvi, Kosarkas drugi) {
		if (prvi.visina()>drugi.visina())
			   return 1;
	       else
	          if (prvi.visina()<drugi.visina())
	        	 return -1;
	        else
		      if (prvi.starost()>drugi.starost())
			   return 1;
			 else
				if (prvi.starost()<drugi.starost())
				   return -1;
			else 
			  return prvi.ime().compareTo(drugi.ime());
}

}
