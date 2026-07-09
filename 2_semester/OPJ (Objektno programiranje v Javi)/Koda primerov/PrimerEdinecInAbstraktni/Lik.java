
public abstract class Lik {

	private int x;
	private int y;
	
	public Lik(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void narisiSe();

	public void predstaviSe() {
		System.out.println(getClass() + " obsegam " + izracunajPloscino());
	}
	
	public abstract double izracunajPloscino();
	
}
