package polimorfizem;

public class Oseba implements Comparable<Oseba> {
	
	private String ime;
	private int starost;

	public Oseba(String ime, int starost) {
		this.ime = ime;
		this.starost = starost;
	}
	
	@Override
	public String toString() {
		return "Oseba [ime=" + ime + ", starost=" + starost + "]";
	}

	@Override
	public int compareTo(Oseba o) {
		// TODO Auto-generated method stub
		return starost-o.starost;
	}


}
