package GUI;
import java.awt.*;
import java.awt.event.*;


public class GUIGlavni {

	public static void main(String[] args) {
		
		Frame okno = new Frame(" Materinski dan ");

		Button exit = new Button(" Konec ");
		Button cestitke = new Button(" Cestitaj ");
        TextField tf = new TextField("Vnesi nekaj");
        
        PoslusalecTipk multi = new PoslusalecTipk();
        
        tf.addKeyListener(multi);
        exit.addActionListener(multi);
        
		okno.setLayout(new FlowLayout());
		
		okno.add(tf);
		okno.add(exit);
		okno.add(cestitke);
		
		okno.addWindowListener(new OkenskiPoslusalec());
		
		ActionListener poslusalec = new Poslusalec("Prvi");
		
		
		Terminator arni = new Terminator();
		exit.addActionListener(poslusalec);
		exit.removeActionListener(poslusalec);
		
		exit.addActionListener(new Poslusalec("Drugi"));
		exit.addActionListener(arni);
		
		
		okno.setSize(600,300);
		okno.setVisible(true);
		
	}
	
}

//Panel p = new Panel();
//Panel osrednjiPanel = new Panel();
//
//okno.setLayout(new BorderLayout());
//
//Button exit = new Button("Klikne me");
//
//TextField tf = new TextField("Vnesi ime tascice");
//
//Label l = new Label("Tekst");
//
//for (int i = 1; i<10; i++)
//   osrednjiPanel.add(new Button("Gumb st" + i));
//
//osrednjiPanel.setLayout(new GridLayout(2,4));
//okno.add(osrednjiPanel);
//
//okno.add("South",p);
//p.add(exit);
//p.add(new Button("klikni me"));
//okno.add("North",tf);
//okno.add("West", new Button("West"));
//okno.add("East", new Button("East"));
//
////	okno.add(l);

