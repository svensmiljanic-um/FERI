import javax.swing.*;
import java.awt.event.*;



public class Main {


	static void izpisi(IOblikuj metoda) {

           System.out.println(metoda.oblikuj("Metka", "Janez"));

     }
	
	public static void main(String[] args) {


     
		IOblikuj x = (s1,s2) -> {return s1+s2 + " sem jih spravil skupaj"; };

        izpisi(x);
        
        izpisi ((s1,s)-> {return s1+ "  je locen od " + s;});
        
//		JFrame okno = new JFrame(" SAM ");
//		
//		JButton b = new JButton("Klikne me");
//		
//		okno.add(b);
//
//		b.addActionListener((e) -> {   System.out.println(" klikno me je" + e.getSource()); });
//		
//		
//		okno.setSize(200,200);
//		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		okno.setVisible(true);
//		
//		try {
//			Class.forName("Odjemalec");
//	
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
}
