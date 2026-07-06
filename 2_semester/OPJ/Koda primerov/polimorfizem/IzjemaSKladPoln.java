package polimorfizem;

public class IzjemaSKladPoln extends Exception {

	private int max;
	
	public IzjemaSKladPoln(String opis, int max) {
		super(opis);
		this.max = max;
	}

	public int vrniMaxElementov() {
		return max;
	}
	
}
