package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import model.Patient;
import view.dialog.MedicalRecordDialog;
import view.dialog.NewPhysicalExaminationDialog;
import view.dialog.PatientDialog;
import view.dialog.PhysicalExaminationDialog;
import view.dialog.SelectSymptomsForPhysicalExaminationDialog;

public class PatientFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField patientIdtextField;

	private Patient patient;
	private JLabel patientInfoLabel;
	private JSplitPane splitPane;
	private JPanel rightPanel;
	private JPanel leftPanel;

	public PatientFrame(Patient patient) {
		
		MainFrame.getInstance().setCurrent(patient);
		setPatient(patient);
		setTitle("Profil pacijenta");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2 + 400, screenHeight/2 + 250);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// podesavanja toolbara prozora
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton pinfoB = new JButton("Osnovni podaci");
		pinfoB.setToolTipText("Osnovni podaci pacijenta");
		pinfoB.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PatientDialog p = new PatientDialog(patient, PatientFrame.this);
				p.setVisible(true);
				
			}
		});
		toolBar.add(pinfoB);
		
		JButton medicalRecord = new JButton("Zdravstveni karton");
		medicalRecord.setToolTipText("Zdravstveni karton pacijenta");
		medicalRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MedicalRecordDialog mrd = new MedicalRecordDialog(patient, PatientFrame.this);
				mrd.setVisible(true);				
			}
		});
		toolBar.add(medicalRecord);
		
		
		
		
		JButton examinationB = new JButton("Pregledi");
		examinationB.setToolTipText("Svi pregledi pacijenta");
		examinationB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhysicalExaminationDialog d = new PhysicalExaminationDialog();
				d.setVisible(true);
			}
		});
		toolBar.add(examinationB);
		/*
		
		JButton preventiveB = new JButton("Preventivni");
		preventiveB.setToolTipText("Preporuka preventivnog pregleda za pacijenta");
		toolBar.add(preventiveB);
		
		JButton diagnosisB = new JButton("Dijagnoze");
		diagnosisB.setToolTipText("Sve dijagnoze pacijenta");
		toolBar.add(diagnosisB);
		
		JButton theraphyB = new JButton("Terapije");
		theraphyB.setToolTipText("Sve terapije pacijenta");
		toolBar.add(theraphyB); */
			
		
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
