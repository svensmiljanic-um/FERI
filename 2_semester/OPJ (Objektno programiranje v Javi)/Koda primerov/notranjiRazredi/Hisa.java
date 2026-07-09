package notranjiRazredi;


public class Hisa {

	static class Nadstresnica {
		
		@Override
		public String toString() {
			return "Sem nadstresek, varujem avto " + nekaj;   // + naziv;
		}
	}
	
	private void kontrolna(Soba o) {
		o.ime = "Ni pospravljena";
	}
	
	class Soba {
		private String ime;

		public Soba(String ime) {
			this.ime = ime;
		}

		@Override
		public String toString() {
			return "Soba [ime=" + ime + "v " + naziv + "]" ;
		}
		
	}
	
	private String naziv;	
	private static int nekaj;
	
	public Hisa(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Hisa [naziv=" + naziv + "]";
	}
	
	

}
