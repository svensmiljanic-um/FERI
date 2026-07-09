package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OkenskiPoslusalec implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println(" opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println(" closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println(" iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	    System.out.println("deiconified");	
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
