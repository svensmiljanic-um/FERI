package vmesniki;

public class Kripto implements INalozba {
	
	private String k;
	
	public Kripto(String katera) {
		k = katera;
	}

	@Override
	public double vrniDonosnost() {
		return 100.00;
	}

	@Override
	public NivoTveganja vrniTveganje() {
		// TODO Auto-generated method stub
		return NivoTveganja.VISOKO;
	}

	@Override
	public double vrniTrenutnoVrednost() {
		return 60070.48;
	}

}
