package primerCL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WindowAgent extends WindowAdapter implements ActionListener {

	
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println(" iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	    System.out.println("deiconified");	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("poslusa tudi Action event " + e.getSource());
	}
	
}


public class PrimerCardLayout extends JFrame implements ActionListener{

    class Notranji implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			cl.show(karte, "gumb");
		}
    	
		public void kakJefajn() {}
		
    }
	
	private CardLayout cl;
	private JPanel karte;
	
	public PrimerCardLayout() {

		
		 addWindowListener(new WindowAgent());
		  
		 setTitle(" Preprost primer uporabe Card ALyoiut ");
	     setSize(500,200);
	
	     Container c = getContentPane();
	     c.setLayout(new BorderLayout());
	     
	     karte = new JPanel();
	     cl = new CardLayout();
	     karte.setLayout(cl);
	     
	     JPanel vnosni = new JPanel();
	     vnosni.add(new JTextField("Ime ",10));
	     vnosni.add(new JTextField("Priimek ",10));
	     vnosni.add(new JTextField("Mesto ",20));
	     
	     JPanel pregled = new JPanel();
	     pregled.setBorder(BorderFactory.createTitledBorder(" Pregled"));
	     pregled.add(new JLabel(" Name"));
	     pregled.add(new JLabel(" Surname"));
	     pregled.add(new JLabel(" City"));
	     
	     karte.add(vnosni,"vnos");
	     karte.add(pregled,"pregled");
	     karte.add(new JButton("VELIK"),"gumb");
	     
	     c.add(karte);
	     
	     JPanel spodnji = new JPanel();
	     
	     JButton naslednji = new JButton("next");
	     JButton gumb = new JButton("Idi na veliki gumb");
	     JButton prejsnji = new JButton("previous");
		 
	     naslednji.setToolTipText("klikni ce si vpuples");
	     
	     spodnji.add(prejsnji);
	     spodnji.add(gumb);
	     spodnji.add(naslednji);
	     
	     gumb.addActionListener(new Notranji());
	     
	     naslednji.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		       cl.next(karte);		
			}
		});
	     
	     prejsnji.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.previous(karte);
			}
		});
	    

		  addWindowListener(new WindowAdapter() {
			   
			  @Override
			public void windowIconified(WindowEvent e) {
			      System.out.println(" anonimni inner poslusa");;
			}
			  public void sploNiFajn() {}
		   });
		
	     prejsnji.addActionListener(new WindowAgent());
	     
	     c.add(BorderLayout.SOUTH,spodnji);
	     
	     JMenuBar vrsticaMenu = new JMenuBar();
	     JMenu menu = new JMenu("Karte");
	     JMenuItem m1 = new JMenuItem("Pregled");
	     m1.addActionListener(e->{cl.show(karte, "pregled");});
	     JMenuItem m2 = new JMenuItem("Vnos");
	     
	     JMenuItem m3 = new JMenuItem("Gumb");
	     menu.add(m1);
	     menu.add(m2);
	     menu.add(m3);
		 vrsticaMenu.add(menu);
	     m3.addActionListener(this);
		 
		 setJMenuBar(vrsticaMenu);
		 
	     
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	     setVisible(true);
	     
	
	}
	
	public static void main(String[] args) {
		
		new PrimerCardLayout();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(" Glavno okno");
	}
	
}
