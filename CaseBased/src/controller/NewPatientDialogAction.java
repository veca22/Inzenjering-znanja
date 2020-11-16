package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import view.dialog.NewPatientDialog;

public class NewPatientDialogAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NewPatientDialog newPatientDialog = new NewPatientDialog();
		newPatientDialog.addActionListeners();
		newPatientDialog.setLocationRelativeTo(null);
		newPatientDialog.setVisible(true);
		
	}
	
	public NewPatientDialogAction() {
		// TODO Auto-generated constructor stub
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
		putValue(SHORT_DESCRIPTION, "Dodaj novog pacijenta");
		putValue(LONG_DESCRIPTION, "Dodaj novog pacijenta");
	}
	
	public NewPatientDialogAction(String name) {
		// TODO Auto-generated constructor stub
		this();
		putValue(NAME, name);
	}

}
