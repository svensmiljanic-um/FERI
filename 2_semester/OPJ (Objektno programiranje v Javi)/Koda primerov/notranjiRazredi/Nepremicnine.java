package notranjiRazredi;

public class Nepremicnine {
	
	public static void main(String[] args) {
		
		Hisa vila = new Hisa("Vila v Kamnici");
		
		System.out.println(vila.new Soba(" Dnevna soba"));
		System.out.println(vila.new Soba(" Spalnici"));
		System.out.println(vila.new Soba(" Otroska soba"));
		
		
		Hisa vikend = new Hisa("Hiska na Pagu");
		System.out.println(vikend.new Soba(" Dnevna soba"));
		System.out.println(vikend.new Soba(" Spalnici"));
		System.out.println(vikend.new Soba(" Otroska soba"));

		System.out.println(new Hisa.Nadstresnica());
		
	}

}
