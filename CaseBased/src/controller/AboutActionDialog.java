package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import view.AboutFrame;

public class AboutActionDialog extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		AboutFrame frame = new AboutFrame();
		frame.setVisible(true);
	}
	
	public AboutActionDialog() {
		// TODO Auto-generated constructor stub
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
		putValue(SHORT_DESCRIPTION, "Dodaj novog pacijenta");
		putValue(LONG_DESCRIPTION, "Dodaj novog pacijenta");
	}
	
	public AboutActionDialog(String name) {
		// TODO Auto-generated constructor stub
		AboutFrame frame = new AboutFrame();
		frame.setVisible(true);
	}

	
}
