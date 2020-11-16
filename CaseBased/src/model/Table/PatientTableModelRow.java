package model.Table;

import java.util.Vector;

import model.Patient;

public class PatientTableModelRow {
	private Patient patient;
	
	public PatientTableModelRow(Patient patient) {
		this.patient = patient;
	}
	
	public Vector<Object> addRowToTable(){
		return getPatient().getStructuredData();
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
