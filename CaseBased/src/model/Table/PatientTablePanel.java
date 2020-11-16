package model.Table;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.Patient;
import view.PatientFrame;

public class PatientTablePanel extends JScrollPane {

	private JTable patientsTable;
	
	public PatientTablePanel() {
		
		this.setAll();
	}
	
	public void setAll() {
		PatientTable tableModel = new PatientTable();
		patientsTable = new JTable(tableModel);
		patientsTable.setPreferredScrollableViewportSize(new Dimension(500, 400));
		patientsTable.setFillsViewportHeight(true);
		patientsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		setViewportView(patientsTable);
		
		this.getViewport().add(patientsTable);
		
		addListeners();
	}
	
	public void refreshData() {
		PatientTable tableModel = (PatientTable) patientsTable.getModel();
		tableModel.refreshData();
	
	}

	public JTable getTable() {
		return patientsTable;
	}
	
	public void addListeners() {
		
		patientsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
					try {
						int selectedRowIndex = patientsTable.getSelectedRow();
						if(selectedRowIndex > -1){
							PatientTable model = (PatientTable) patientsTable.getModel();
							Patient p = model.getSelectedRow(selectedRowIndex).getPatient();
							System.out.println(p);
							
							//dispose();
							PatientFrame patientFrame = new PatientFrame(p);
							patientFrame.setVisible(true);
						}
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
			}
		});
		
	}

	public JTable getPatientsTable() {
		return patientsTable;
	}

	public void setPatientsTable(JTable patientsTable) {
		this.patientsTable = patientsTable;
	}
	
	
	
}
