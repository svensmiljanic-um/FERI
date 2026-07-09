package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PoslusalecTipk implements KeyListener, ActionListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar() + ", shift: " + e.isShiftDown());
		}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar() + "  je bil released" );
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(" Poslusalec tipk lahko poslusa tudi Action Event, ker implementora ustrezni vmesnik");
	}

}
