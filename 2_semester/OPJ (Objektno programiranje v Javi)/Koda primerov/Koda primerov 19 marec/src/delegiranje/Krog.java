package delegiranje;

public class Krog  {
	
	private int r;
	private Tocka sredisce;
	
	public Krog(int x, int y, int polmer) {
		sredisce = new Tocka(x,y);
		r = polmer;
	}

	public double izracunajPloscino() {
		return r*r*Math.PI;
	}
	
}
