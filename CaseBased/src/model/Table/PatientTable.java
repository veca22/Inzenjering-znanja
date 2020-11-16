package model.Table;

import java.util.ArrayList;

import java.util.List;


import javax.swing.table.DefaultTableModel;


import model.Patient;

public class PatientTable extends DefaultTableModel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PatientTableModelRow> rowsData; 

	public PatientTable(){
		this.rowsData = new ArrayList<PatientTableModelRow>();
		initTableHeader();
		collectData();
	}
	
	private void initTableHeader(){
		//Inicijalizacija kolona
		addColumn("Id");
		addColumn("Ime");
		addColumn("Prezime");
		addColumn("Datum rodjenja");
		addColumn("Jmbg");
		addColumn("Adresa");
		addColumn("Broj telefona");
	}
	
	public void collectData() {
		setRowCount(0);
		List<Patient> patients = PatientBase.getInstance().getPatients();
		for(Patient p: patients) {
			PatientTableModelRow ptr = new PatientTableModelRow(p);
			rowsData.add(ptr);
			addRow(ptr.addRowToTable());
		}
	}
	
	public void refreshData() {
		this.rowsData = new ArrayList<PatientTableModelRow>();
		collectData();
	}
	
	
	public PatientTableModelRow getSelectedRow(int selectedIndex) {
		return rowsData.get(selectedIndex);
	}
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;	
	}
	
}
