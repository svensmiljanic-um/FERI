package prenosArgumentov;

public class Oseba {
	
	private String ime;
	private int starost;

	public int getStarost() {
		return starost;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	public Oseba(String ime, int starost) {
		this.ime = ime;
		this.starost = starost;
	}
	
	@Override
	public String toString() {
		return "Oseba [ime=" + ime + ", starost=" + starost + "]";
	}

	
	

}
