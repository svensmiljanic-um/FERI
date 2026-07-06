package SinhronizacijaNiti;

public class Stevec {

	int vrednost;
	
	
	public void povecaj() {
		synchronized (this) {
		   vrednost++;
			
	}
		}
	
	public int getVrednost() {
		return vrednost;
	}
	
}
