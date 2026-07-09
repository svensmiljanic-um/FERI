
public class Tasca {

	private String ime;
	private static Tasca enaInEdina;
	
	private Tasca(String ime) {
		this.ime = ime;
	}

	public static Tasca vrniTasco() {
	  if (enaInEdina==null)
		enaInEdina = new Tasca("Marica");
	  return enaInEdina;
	}
	
	public void sprejmeSopek() {
		System.out.println("Tasca " + ime + " sprejme sopek in se zahvali:");
		kuhajKosilo();
		
	}
	
	private void kuhajKosilo() {
		System.out.println("Tasca " + ime + " skuha kosilo: juhica, zrezek, prazen krompir, solata, gibanica");
	}
	
	
}
