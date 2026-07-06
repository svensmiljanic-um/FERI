package SinhronizacijaNiti;

public class BlejskaRestavracija {

	public static void main(String[] args) {
	
		MizicaObOknu table = new MizicaObOknu();
		
		new Gost(table).start();
		new Natakar(table).start();
		
    }
}
