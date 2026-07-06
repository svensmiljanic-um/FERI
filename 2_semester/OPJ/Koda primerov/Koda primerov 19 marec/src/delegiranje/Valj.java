package delegiranje;

public class Valj  {
	
	private int visina;
	private Krog osnovnaPloskev;
	
	public Valj (int x, int y, int r, int visina) {
	   osnovnaPloskev = new Krog (x,y,r);
	   this.visina = visina;
	}

	public double izracunajProstornino() {
		return osnovnaPloskev.izracunajPloscino()*visina;
	}
	
}
