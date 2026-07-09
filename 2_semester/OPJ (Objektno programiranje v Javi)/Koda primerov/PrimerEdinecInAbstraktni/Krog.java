public  class Krog extends Lik {

	private int polmer;
	
	public Krog(int x, int y, int polmer) {
		super(x, y);
		this.polmer = polmer;
	}
	

	public void raztegniVElipso() {}
	

	@Override
	public void narisiSe() {
	    	
	}

	@Override
	public double izracunajPloscino() {
		return polmer*polmer*Math.PI;
	}
	}
