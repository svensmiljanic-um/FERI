package zabava;

public class Stevec {


	int vrednost;
	
	public void povecajNesinhronizirano() {
			vrednost++;
    }

	public void povecaj() {
		synchronized (this) {
			vrednost++;
			
		}
    }
	
	
}
