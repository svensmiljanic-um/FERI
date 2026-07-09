package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Terminator implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
