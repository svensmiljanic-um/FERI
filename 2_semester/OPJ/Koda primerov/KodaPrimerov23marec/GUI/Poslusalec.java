package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Poslusalec implements ActionListener{

	private String ime;
	
	public Poslusalec(String ime) {
       this.ime = ime;		
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println(ime + " je  obvescen o dogodku " + e.getSource());	
	}

}
