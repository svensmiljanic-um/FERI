package kolekcije;

import java.io.Serializable;

public class Kosarkas implements Serializable, Comparable<Kosarkas>{
	
	private String ime;
	private transient int visina;
	private int starost;
	private Avtomobil vozilo;
	
	public String ime() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int visina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public int starost() {
		return starost;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	public Kosarkas(String ime, int visina, int starost) {
		this.ime = ime;
		this.visina = visina;
		this.starost = starost;
        vozilo = new Avtomobil("Fiat 550");
	}


	@Override
	public String toString() {
		return "Kosarkas [ime=" + ime + ", starost=" + starost + ", vozilo=" + vozilo + "]";
	}

	@Override
	public int compareTo(Kosarkas drugi) {
		if (starost>drugi.starost)
			   return 1;
			else
				if (starost<drugi.starost)
				   return -1;
				else 
				   if (visina>drugi.visina)
					   return 1;
			       else
			          if (visina<drugi.visina)
			        	 return -1;
			          else
			        	  return ime.compareTo(drugi.ime);
	}
	

}
