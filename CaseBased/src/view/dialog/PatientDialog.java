package view.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import model.Patient;
import model.Table.PatientBase;
import view.MainFrame;
import view.PatientFrame;

public class PatientDialog extends NewPatientDialog {
	
	private Patient patient;
	private PatientFrame pf;
	
	public PatientDialog(Patient p, PatientFrame pf) {
		this.patient = p;
		this.pf = pf;
		
		setTitle("Izmena informacija o pacijentu");
		setLocationRelativeTo(null);
		firstNameTextField.setText(patient.getFirstName());
		lastNameTextField.setText(patient.getLastName());
		addressTextField.setText(patient.getAddress());
		telephoneNumberTextField.setText(patient.getPhoneNumber());
		jmbgTextField.setText(patient.getJmbg());
		dateOfBirthDateField.setText(patient.getDateOfBirth());
		
		JButton save = new JButton();
		save = getAddPatientButton();
		save.setText("Sacuvaj");
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ArrayList<String> tmp = new ArrayList<String>();
				PatientBase.getInstance().editPatient(patient.getId(), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), dateOfBirthDateField.getText(), addressTextField.getText(), telephoneNumberTextField.getText(),patient.getMr(), patient.getAnamnesis(), patient.getPregledi());
				MainFrame.getInstance().updateMainPanelPatientsTable();
				dispose();
				
			}
		});
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public PatientFrame getPf() {
		return pf;
	}

	public void setPf(PatientFrame pf) {
		this.pf = pf;
	}
	
	
	
}
