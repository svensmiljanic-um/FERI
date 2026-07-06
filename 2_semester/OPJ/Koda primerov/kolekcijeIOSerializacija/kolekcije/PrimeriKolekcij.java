package kolekcije;

import java.text.Collator;
import java.util.*;

public class PrimeriKolekcij {

	public static void main(String[] args) {

		Kosarkas luka = new Kosarkas("Luka", 200, 77);
		Kosarkas james = new Kosarkas("Lebron", 206,41);
		Kosarkas nikola = new Kosarkas("Nikola", 211, 31);  //15
		Kosarkas jusuf = new Kosarkas("Jusuf", 211, 31);
			
		ArrayList<Kosarkas>  zvezde = new ArrayList<Kosarkas>();
		//zvezde.add(luka);
		zvezde.add(james);
		zvezde.add(luka);
	    zvezde.add(new Kosarkas("marjancek",178,100));
		zvezde.add(nikola);
		zvezde.add(jusuf);
		
		System.out.println(zvezde);
		
		Collections.sort(zvezde);
		System.out.println();
		Collections.sort(zvezde, new PrimerjalnikNajprejVisina());
		
		System.out.println(zvezde);

		
		HashMap<Integer, Kosarkas>  majice = new HashMap<Integer, Kosarkas>();
		
		majice.put(77, luka);
		majice.put(23, james);
		majice.put(15,nikola);
		majice.put(23, jusuf);
		
		System.out.println(majice);
		
		System.out.println(majice.get(77));
		
		System.out.println(zvezde.get(2));
		
		
		TreeSet<Kosarkas> urejeni = new TreeSet<Kosarkas>();
		urejeni.add(luka);
		urejeni.add(luka);
		urejeni.add(james);
		urejeni.add(nikola);
		urejeni.add(jusuf);
		System.out.println(urejeni);
		

		
		ArrayList<Kosarkas> vzhod = new ArrayList<Kosarkas>();
		vzhod.add(new Kosarkas("Giannis Antetokounmpo", 211, 31));
		vzhod.add(new Kosarkas("Jayson Tatum", 203, 27));
		vzhod.add(new Kosarkas("Jalen Brunson", 188, 29));
		vzhod.add(new Kosarkas("Jimmy Butler", 201, 36));
		vzhod.add(new Kosarkas("Donovan Mitchell", 191, 29));
		
	
		ArrayList<List>  ekipe = new ArrayList<List>();
		ekipe.add(zvezde);
		ekipe.add(vzhod);
	
		System.out.println(ekipe);
		
		HashMap<Kosarkas, Integer> kontra = new HashMap<Kosarkas, Integer>();
		kontra.put(luka, 77);
		kontra.put(james, 23);
		
		System.out.println(kontra.get(luka));
		
		HashMap<String, List>   allStars = new HashMap<String, List>();
		allStars.put("West", zvezde);
		allStars.put("East", vzhod);
		
		System.out.println(allStars.get("West"));
		
		Comparator<Kosarkas>  absolut = new Absolutni();
		
		System.out.println(absolut.compare(nikola, luka));
		
		Collections.sort(zvezde, absolut);
		
		System.out.println();
		
		
		
//		
		
		
//		List<String> imena = new ArrayList<String>();
//		
//	//	Collection<String> kolekcija = imena;
//		
//		imena.add("Metka");
//		imena.add("Janez");
//		imena.add("Ana");
//		imena.add("Metka");
//		imena.add("Simona");
//		imena.add("Cvetka");
//		imena.add("Metka");
//        imena.add("Željko");
//        imena.add("Črt");
//        imena.add("Čvetka");
//        imena.add("Šimona");
//        imena.add("Đuro");
//        
//        imena.add("Ćmeki");
//		imena.add("Ötzi");
//        
//	//	imena.remove("Metka");
//		
//		ArrayList<String> vsiljivci = new ArrayList<String>();
//		vsiljivci.add("Metka");
//		vsiljivci.add("Janez");
//		
//	//	imena.removeAll(vsiljivci);
//		
//		System.out.println("-----  osnovna ------");
//		System.out.println(imena);
//
//		Collections.shuffle(imena);
//		
//		System.out.println("-----  premetana ------");
//		System.out.println(imena);
//		
//		Collections.sort(imena, Collator.getInstance(Locale.getDefault()));
//		Collections.sort(imena, Collator.getInstance(Locale.GERMAN));
//		System.out.println("-----  sortirana ------");
//		System.out.println(imena);
//		
//		
//		
//		
//		
		
//		for (String ime : imena)
//		     System.out.println(ime);
//		
//		Iterator<String> kazalcek = imena.iterator();
//	    while (kazalcek.hasNext())
//	    	System.out.println(kazalcek.next());
	}
	
}
 