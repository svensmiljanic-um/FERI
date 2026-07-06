package SinhronizacijaNiti;
public class MizicaObOknu {
	
	boolean naVoljo = false;
	private String kroznik = "(prazen)";

	public synchronized String  getKroznik()  {
		while (!naVoljo) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
		naVoljo = false;
		notify();
		
		return kroznik;
	}

	public synchronized void setKroznik(String kroznik) {
		while (naVoljo) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.kroznik = kroznik;
		naVoljo= true;
		notify();
	} 

	
	
	
	
}


