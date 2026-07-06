
public class Pravokotnik extends Lik {

	private int v;
	private int dolzina;
	
	public Pravokotnik(int x, int y, int dolzina, int visina) {
		super(x,y);
        this.dolzina = dolzina;
        v = visina;
	}

	
	@Override
	public double izracunajPloscino() {
			return v*dolzina;
	}


	@Override
	public void narisiSe() {
		// TODO Auto-generated method stub
		
	}
	
}
