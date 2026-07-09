package GUISwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Samostojni implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	     System.out.println("Samostojni");	
	}
	
}

public class NaseOkno extends JFrame implements ActionListener {

	class Notranji implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		     System.out.println("Notranji");	
		}
		
	}
	
	
	
	public NaseOkno () {
	  
		 setTitle("Swing aplikacija");
		 
		 JTextField ime = new JTextField("Vnesi ime",40);
		 JButton exit = new JButton("exit"); 
		 JButton lepi = new JButton("prelepi"); 
		 
		 lepi.addActionListener(new Samostojni());
		 lepi.addActionListener(new Notranji());
		 lepi.addActionListener(this);
		 lepi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		         System.out.println("anonimni notranji");	
		         tascina();
			}
			
			public void tascina() {System.out.println("MArica");} 
		});
		 
		 Container osrednji = getContentPane();
		 osrednji.setLayout(new FlowLayout());
		 
		 osrednji.add(ime);
		 osrednji.add(lepi);
		 osrednji.add(exit);
		 
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setSize(500,200);
		 setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		new NaseOkno();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Kar Nase okno - vsebnik sam");
	}
	
	
}
