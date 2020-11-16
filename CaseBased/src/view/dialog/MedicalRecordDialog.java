package view.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Gender;
import model.MedicalRecord;
import model.Patient;
import model.Table.PatientBase;
import view.MainFrame;
import view.PatientFrame;

public class MedicalRecordDialog extends JDialog {
	
	private Patient patient;
	private MedicalRecord mr;
	
	private JPanel contentPanel = new JPanel();
	protected JTextField firstNameTextField;
	protected JTextField lastNameTextField;
	protected JTextField jmbgTextField;
	protected JTextField brKnjiziceTextField;
	protected JTextField imeOsiguranikaTextField;
	protected JTextField prezimeOsiguranikaTextField;
	protected JTextField jmbgOsiguranikaTextField;
	protected JTextField visinaTextField;
	protected JTextField tezinaTextField;
	protected JTextField krvnaGrupaTextField;
	protected JRadioButton zaposlenRadioBDa;
	protected JRadioButton zaposlenRadioBNe;
	
	protected JRadioButton polMusko;
	protected JRadioButton polZensko;
	
	protected JRadioButton pusenjeDa;
	protected JRadioButton pusenjeNe;
	
	protected JRadioButton gojaznostDa;
	protected JRadioButton gojaznostNe;
	
	protected JRadioButton dijabetesDa;
	protected JRadioButton dijabetesNe;
	
	protected JRadioButton alkoholDa;
	protected JRadioButton alkoholNe;
	
	protected JRadioButton aktivnostDa;
	protected JRadioButton aktivnostNe;
	
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel jmbgLabel;
	private JLabel brKnjiziceLabel;
	private JLabel imeOsiguranikaLabel;
	private JLabel prezimeOsiguranikaLabel;
	private JLabel jmbgOsiguranikaLabel;
	private JLabel visinaLabel;
	private JLabel tezinaLabel;
	private JLabel zaposlenLabel;
	private JLabel polLabel;
	private JLabel pusenjeLabel;
	private JLabel gojaznostLabel;
	private JLabel dijabetesLabel;
	private JLabel alkoholizamLabel;
	private JLabel fizickaAktLabel;
	private JLabel krvnaGrupaLabel;
	
	private JButton addMr;
	private JButton cancelButton;
	
	private JButton addAnamnesis;
	
	protected JPanel buttonPane;
	
	
	public MedicalRecordDialog(Patient p, PatientFrame pf) {
		this.mr = new MedicalRecord();
		this.patient = p;
		
		
		setModal(true);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("images/medCareLogo.png").getImage());
		setTitle("Zdravstveni karton pacijenta");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800,650);
		setLocationRelativeTo(null);
		
		initComponents();
		firstNameTextField.setText(this.patient.getFirstName());
		firstNameTextField.setEditable(false);
		lastNameTextField.setText(this.patient.getLastName());
		lastNameTextField.setEditable(false);
		jmbgTextField.setText(this.patient.getJmbg());
		jmbgTextField.setEditable(false);
		if(patient.getMr().getBrKnjizice() != null) {
			mr = patient.getMr();
			brKnjiziceTextField.setText(mr.getBrKnjizice());
			imeOsiguranikaTextField.setText(mr.getImeOsiguranika());
			prezimeOsiguranikaTextField.setText(mr.getPrezimeOsiguranika());
			jmbgOsiguranikaTextField.setText(mr.getJmbgOsiguranika());
			visinaTextField.setText(Integer.toString(mr.getVisina()));
			tezinaTextField.setText(Integer.toString(mr.getTezina()));
			if(mr.isZaposlen() == true) {
				zaposlenRadioBDa.setSelected(true);
			} else {
				zaposlenRadioBNe.setSelected(true);
			}
			
			if(mr.getPol() == Gender.MAN) {
				polMusko.setSelected(true);
			}
			else {
				polZensko.setSelected(true);
			}
			
			krvnaGrupaTextField.setText(mr.getKrvnaGrupa());
			
			if(mr.isPusenje() == true) {
				pusenjeDa.setSelected(true);
			} else {
				pusenjeNe.setSelected(true);
			}
			
			if(mr.isGojaznost() == true) {
				gojaznostDa.setSelected(true);
			} else {
				gojaznostNe.setSelected(true);
			}
			
			if(mr.isDijabetes() == true) {
				dijabetesDa.setSelected(true);
			} else {
				dijabetesNe.setSelected(true);
			}
			
			if(mr.isAlkoholizam() == true) {
				alkoholDa.setSelected(true);
			} else {
				alkoholNe.setSelected(true);
			}
			
			if(mr.isNedovoljnaFizickaAktivnost() == true) {
				aktivnostDa.setSelected(true);
			} else {
				aktivnostNe.setSelected(true);
			}
		}
		
	}
	
	public void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {45, 45, 45, 45, 45, 45, 0, 0};
		gbl_contentPanel.rowHeights = new int[] {30, 0, 30, 0, 50, 0, 30, 0, 30, 0, 30, 0, 30, 30};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		
		
		firstNameLabel = new JLabel("Ime pacijenta:");
		firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
		gbc_firstNameLabel.anchor = GridBagConstraints.WEST;
		gbc_firstNameLabel.insets = new Insets(5, 5, 5, 5);
		gbc_firstNameLabel.gridx = 2;
		gbc_firstNameLabel.gridy = 1;
		contentPanel.add(firstNameLabel, gbc_firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameLabel.setLabelFor(firstNameTextField);
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameTextField.gridx = 6;
		gbc_firstNameTextField.gridy = 1;
		contentPanel.add(firstNameTextField, gbc_firstNameTextField);
		firstNameTextField.setColumns(10);
		
		
		lastNameLabel = new JLabel("Prezime pacijenta:");
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.WEST;
		gbc_lastNameLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lastNameLabel.gridx = 2;
		gbc_lastNameLabel.gridy = 2;
		contentPanel.add(lastNameLabel, gbc_lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameLabel.setLabelFor(lastNameTextField);
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameTextField.gridx = 6;
		gbc_lastNameTextField.gridy = 2;
		contentPanel.add(lastNameTextField, gbc_lastNameTextField);
		lastNameTextField.setColumns(10);
		
		jmbgLabel = new JLabel("Jmbg pacijenta:");
		GridBagConstraints gbc_jmbgLabel = new GridBagConstraints();
		gbc_jmbgLabel.anchor = GridBagConstraints.WEST;
		gbc_jmbgLabel.insets = new Insets(5, 5, 5, 5);
		gbc_jmbgLabel.gridx = 2;
		gbc_jmbgLabel.gridy = 3;
		contentPanel.add(jmbgLabel, gbc_jmbgLabel);
		
		jmbgTextField = new JTextField();
		jmbgLabel.setLabelFor(jmbgTextField);
		GridBagConstraints gbc_jmbgTextField = new GridBagConstraints();
		gbc_jmbgTextField.insets = new Insets(0, 0, 5, 0);
		gbc_jmbgTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_jmbgTextField.gridx = 6;
		gbc_jmbgTextField.gridy = 3;
		contentPanel.add(jmbgTextField, gbc_jmbgTextField);
		jmbgTextField.setColumns(10);
		
		brKnjiziceLabel = new JLabel("Broj knjizice pacijenta:");
		GridBagConstraints gbc_brKnjiziceLabel = new GridBagConstraints();
		gbc_brKnjiziceLabel.anchor = GridBagConstraints.WEST;
		gbc_brKnjiziceLabel.insets = new Insets(5, 5, 5, 5);
		gbc_brKnjiziceLabel.gridx = 2;
		gbc_brKnjiziceLabel.gridy = 4;
		contentPanel.add(brKnjiziceLabel, gbc_brKnjiziceLabel);
		
		brKnjiziceTextField = new JTextField();
		brKnjiziceLabel.setLabelFor(brKnjiziceTextField);
		GridBagConstraints gbc_brKnjizice = new GridBagConstraints();
		gbc_brKnjizice.insets = new Insets(0, 0, 5, 0);
		gbc_brKnjizice.fill = GridBagConstraints.HORIZONTAL;
		gbc_brKnjizice.gridx = 6;
		gbc_brKnjizice.gridy = 4;
		contentPanel.add(brKnjiziceTextField, gbc_brKnjizice);
		brKnjiziceTextField.setColumns(10);
		
		imeOsiguranikaLabel = new JLabel("Ime osiguranika:");
		GridBagConstraints gbc_imeOsiguranika = new GridBagConstraints();
		gbc_imeOsiguranika.anchor = GridBagConstraints.WEST;
		gbc_imeOsiguranika.insets = new Insets(5, 5, 5, 5);
		gbc_imeOsiguranika.gridx = 2;
		gbc_imeOsiguranika.gridy = 5;
		contentPanel.add(imeOsiguranikaLabel, gbc_imeOsiguranika);
		
		imeOsiguranikaTextField = new JTextField();
		imeOsiguranikaLabel.setLabelFor(imeOsiguranikaTextField);
		GridBagConstraints gbc_imeOsiguranikaText = new GridBagConstraints();
		gbc_imeOsiguranikaText.insets = new Insets(0, 0, 5, 0);
		gbc_imeOsiguranikaText.fill = GridBagConstraints.HORIZONTAL;
		gbc_imeOsiguranikaText.gridx = 6;
		gbc_imeOsiguranikaText.gridy = 5;
		contentPanel.add(imeOsiguranikaTextField, gbc_imeOsiguranikaText);
		imeOsiguranikaTextField.setColumns(10);
		
		prezimeOsiguranikaLabel = new JLabel("Prezime osiguranika:");
		GridBagConstraints gbc_prezimeOsiguranikaLabel= new GridBagConstraints();
		gbc_prezimeOsiguranikaLabel.anchor = GridBagConstraints.WEST;
		gbc_prezimeOsiguranikaLabel.insets = new Insets(5, 5, 5, 5);
		gbc_prezimeOsiguranikaLabel.gridx = 2;
		gbc_prezimeOsiguranikaLabel.gridy = 7;
		contentPanel.add(prezimeOsiguranikaLabel, gbc_prezimeOsiguranikaLabel);
		
		prezimeOsiguranikaTextField = new JTextField();
		prezimeOsiguranikaLabel.setLabelFor(prezimeOsiguranikaTextField);
		GridBagConstraints gbc_prezimeOsiguranikaText = new GridBagConstraints();
		gbc_prezimeOsiguranikaText.insets = new Insets(0, 0, 5, 0);
		gbc_prezimeOsiguranikaText.fill = GridBagConstraints.HORIZONTAL;
		gbc_prezimeOsiguranikaText.gridx = 6;
		gbc_prezimeOsiguranikaText.gridy = 7;
		contentPanel.add(prezimeOsiguranikaTextField, gbc_prezimeOsiguranikaText);
		prezimeOsiguranikaTextField.setColumns(10);
		
		jmbgOsiguranikaLabel = new JLabel("Jmbg osiguranika:");
		GridBagConstraints gbc_jmbgOsiguranikaLabel= new GridBagConstraints();
		gbc_jmbgOsiguranikaLabel.anchor = GridBagConstraints.WEST;
		gbc_jmbgOsiguranikaLabel.insets = new Insets(5, 5, 5, 5);
		gbc_jmbgOsiguranikaLabel.gridx = 2;
		gbc_jmbgOsiguranikaLabel.gridy = 8;
		contentPanel.add(jmbgOsiguranikaLabel, gbc_jmbgOsiguranikaLabel);
		
		jmbgOsiguranikaTextField = new JTextField();
		jmbgOsiguranikaLabel.setLabelFor(jmbgOsiguranikaTextField);
		GridBagConstraints gbc_jmbgOsiguranikaText = new GridBagConstraints();
		gbc_jmbgOsiguranikaText.insets = new Insets(0, 0, 5, 0);
		gbc_jmbgOsiguranikaText.fill = GridBagConstraints.HORIZONTAL;
		gbc_jmbgOsiguranikaText.gridx = 6;
		gbc_jmbgOsiguranikaText.gridy = 8;
		contentPanel.add(jmbgOsiguranikaTextField, gbc_jmbgOsiguranikaText);
		jmbgOsiguranikaTextField.setColumns(10);
		
		visinaLabel = new JLabel("Visina pacijenta:");
		GridBagConstraints gbc_visinaLabel= new GridBagConstraints();
		gbc_visinaLabel.anchor = GridBagConstraints.WEST;
		gbc_visinaLabel.insets = new Insets(5, 5, 5, 5);
		gbc_visinaLabel.gridx = 2;
		gbc_visinaLabel.gridy = 9;
		contentPanel.add(visinaLabel, gbc_visinaLabel);
		
		visinaTextField = new JTextField();
		visinaLabel.setLabelFor(visinaTextField);
		GridBagConstraints gbc_visinaText = new GridBagConstraints();
		gbc_visinaText.insets = new Insets(0, 0, 5, 0);
		gbc_visinaText.fill = GridBagConstraints.HORIZONTAL;
		gbc_visinaText.gridx = 6;
		gbc_visinaText.gridy = 9;
		contentPanel.add(visinaTextField, gbc_visinaText);
		visinaTextField.setColumns(10);
		
		tezinaLabel = new JLabel("Tezina pacijenta:");
		GridBagConstraints gbc_tezinaLabel= new GridBagConstraints();
		gbc_tezinaLabel.anchor = GridBagConstraints.WEST;
		gbc_tezinaLabel.insets = new Insets(5, 5, 5, 5);
		gbc_tezinaLabel.gridx = 2;
		gbc_tezinaLabel.gridy = 10;
		contentPanel.add(tezinaLabel, gbc_tezinaLabel);
		
		tezinaTextField = new JTextField();
		tezinaLabel.setLabelFor(tezinaTextField);
		GridBagConstraints gbc_tezinaText = new GridBagConstraints();
		gbc_tezinaText.insets = new Insets(0, 0, 5, 0);
		gbc_tezinaText.fill = GridBagConstraints.HORIZONTAL;
		gbc_tezinaText.gridx = 6;
		gbc_tezinaText.gridy = 10;
		contentPanel.add(tezinaTextField, gbc_tezinaText);
		tezinaTextField.setColumns(10);
		
		zaposlenLabel = new JLabel("Zaposlen:");
		GridBagConstraints gbc_zaposlenLabel= new GridBagConstraints();
		gbc_zaposlenLabel.anchor = GridBagConstraints.WEST;
		gbc_zaposlenLabel.insets = new Insets(5, 5, 5, 5);
		gbc_zaposlenLabel.gridx = 2;
		gbc_zaposlenLabel.gridy = 11;
		contentPanel.add(zaposlenLabel, gbc_zaposlenLabel);
		
		zaposlenRadioBDa = new JRadioButton("Da");
		GridBagConstraints gbc_zaposlenRadioDa = new GridBagConstraints();
		gbc_zaposlenRadioDa.insets = new Insets(0, 0, 5, 0);
		gbc_zaposlenRadioDa.fill = GridBagConstraints.HORIZONTAL;
		gbc_zaposlenRadioDa.gridx = 5;
		gbc_zaposlenRadioDa.gridy = 11;
		contentPanel.add(zaposlenRadioBDa, gbc_zaposlenRadioDa);
		
		zaposlenRadioBNe = new JRadioButton("Ne");
		GridBagConstraints gbc_zaposlenRadioNe = new GridBagConstraints();
		gbc_zaposlenRadioNe.insets = new Insets(0, 0, 5, 0);
		gbc_zaposlenRadioNe.fill = GridBagConstraints.HORIZONTAL;
		gbc_zaposlenRadioNe.gridx = 6;
		gbc_zaposlenRadioNe.gridy = 11;
		contentPanel.add(zaposlenRadioBNe, gbc_zaposlenRadioNe);
		
		polLabel = new JLabel("Pol:");
		GridBagConstraints gbc_polLabel= new GridBagConstraints();
		gbc_polLabel.anchor = GridBagConstraints.WEST;
		gbc_polLabel.insets = new Insets(5, 5, 5, 5);
		gbc_polLabel.gridx = 2;
		gbc_polLabel.gridy = 12;
		contentPanel.add(polLabel, gbc_polLabel);
		
		polMusko = new JRadioButton("Musko");
		GridBagConstraints gbc_polMusko = new GridBagConstraints();
		gbc_polMusko.insets = new Insets(0, 0, 5, 0);
		gbc_polMusko.fill = GridBagConstraints.HORIZONTAL;
		gbc_polMusko.gridx = 5;
		gbc_polMusko.gridy = 12;
		contentPanel.add(polMusko, gbc_polMusko);
		
		polZensko = new JRadioButton("Zensko");
		GridBagConstraints gbc_polZensko = new GridBagConstraints();
		gbc_polZensko.insets = new Insets(0, 0, 5, 0);
		gbc_polZensko.fill = GridBagConstraints.HORIZONTAL;
		gbc_polZensko.gridx = 6;
		gbc_polZensko.gridy = 12;
		contentPanel.add(polZensko, gbc_polZensko);
		
		krvnaGrupaLabel = new JLabel("Krvna grupa pacijenta:");
		GridBagConstraints gbc_krvnaGrupaLabel= new GridBagConstraints();
		gbc_krvnaGrupaLabel.anchor = GridBagConstraints.WEST;
		gbc_krvnaGrupaLabel.insets = new Insets(5, 5, 5, 5);
		gbc_krvnaGrupaLabel.gridx = 2;
		gbc_krvnaGrupaLabel.gridy = 13;
		contentPanel.add(krvnaGrupaLabel, gbc_krvnaGrupaLabel);
		
		krvnaGrupaTextField = new JTextField();
		krvnaGrupaLabel.setLabelFor(krvnaGrupaTextField);
		GridBagConstraints gbc_krvnaGrupaText = new GridBagConstraints();
		gbc_krvnaGrupaText.insets = new Insets(0, 0, 5, 0);
		gbc_krvnaGrupaText.fill = GridBagConstraints.HORIZONTAL;
		gbc_krvnaGrupaText.gridx = 6;
		gbc_krvnaGrupaText.gridy = 13;
		contentPanel.add(krvnaGrupaTextField, gbc_krvnaGrupaText);
		krvnaGrupaTextField.setColumns(10);
		
		pusenjeLabel = new JLabel("Pusac:");
		GridBagConstraints gbc_pusenjeLabel= new GridBagConstraints();
		gbc_pusenjeLabel.anchor = GridBagConstraints.WEST;
		gbc_pusenjeLabel.insets = new Insets(5, 5, 5, 5);
		gbc_pusenjeLabel.gridx = 2;
		gbc_pusenjeLabel.gridy = 14;
		contentPanel.add(pusenjeLabel, gbc_pusenjeLabel);
		
		pusenjeDa = new JRadioButton("Da");
		GridBagConstraints gbc_pusenjeDa = new GridBagConstraints();
		gbc_pusenjeDa.insets = new Insets(0, 0, 5, 0);
		gbc_pusenjeDa.fill = GridBagConstraints.HORIZONTAL;
		gbc_pusenjeDa.gridx = 5;
		gbc_pusenjeDa.gridy = 14;
		contentPanel.add(pusenjeDa, gbc_pusenjeDa);
		
		pusenjeNe = new JRadioButton("Ne");
		GridBagConstraints gbc_pusenjeNe = new GridBagConstraints();
		gbc_pusenjeNe.insets = new Insets(0, 0, 5, 0);
		gbc_pusenjeNe.fill = GridBagConstraints.HORIZONTAL;
		gbc_pusenjeNe.gridx = 6;
		gbc_pusenjeNe.gridy = 14;
		contentPanel.add(pusenjeNe, gbc_pusenjeNe);
		
		gojaznostLabel = new JLabel("Gojaznost:");
		GridBagConstraints gbc_gojaznostLabel= new GridBagConstraints();
		gbc_gojaznostLabel.anchor = GridBagConstraints.WEST;
		gbc_gojaznostLabel.insets = new Insets(5, 5, 5, 5);
		gbc_gojaznostLabel.gridx = 2;
		gbc_gojaznostLabel.gridy = 15;
		contentPanel.add(gojaznostLabel, gbc_gojaznostLabel);
		
		gojaznostDa = new JRadioButton("Da");
		GridBagConstraints gbc_gojaznostDa = new GridBagConstraints();
		gbc_gojaznostDa.insets = new Insets(0, 0, 5, 0);
		gbc_gojaznostDa.fill = GridBagConstraints.HORIZONTAL;
		gbc_gojaznostDa.gridx = 5;
		gbc_gojaznostDa.gridy = 15;
		contentPanel.add(gojaznostDa, gbc_gojaznostDa);
		
		gojaznostNe = new JRadioButton("Ne");
		GridBagConstraints gbc_gojaznostNe = new GridBagConstraints();
		gbc_gojaznostNe.insets = new Insets(0, 0, 5, 0);
		gbc_gojaznostNe.fill = GridBagConstraints.HORIZONTAL;
		gbc_gojaznostNe.gridx = 6;
		gbc_gojaznostNe.gridy = 15;
		contentPanel.add(gojaznostNe, gbc_gojaznostNe);
		
		dijabetesLabel = new JLabel("Dijabetes:");
		GridBagConstraints gbc_dijabetesLabel= new GridBagConstraints();
		gbc_dijabetesLabel.anchor = GridBagConstraints.WEST;
		gbc_dijabetesLabel.insets = new Insets(5, 5, 5, 5);
		gbc_dijabetesLabel.gridx = 2;
		gbc_dijabetesLabel.gridy = 16;
		contentPanel.add(dijabetesLabel, gbc_dijabetesLabel);
		
		dijabetesDa = new JRadioButton("Da");
		GridBagConstraints gbc_dijabetesDa = new GridBagConstraints();
		gbc_dijabetesDa.insets = new Insets(0, 0, 5, 0);
		gbc_dijabetesDa.fill = GridBagConstraints.HORIZONTAL;
		gbc_dijabetesDa.gridx = 5;
		gbc_dijabetesDa.gridy = 16;
		contentPanel.add(dijabetesDa, gbc_dijabetesDa);
		
		dijabetesNe = new JRadioButton("Ne");
		GridBagConstraints gbc_dijabetesNe = new GridBagConstraints();
		gbc_dijabetesNe.insets = new Insets(0, 0, 5, 0);
		gbc_dijabetesNe.fill = GridBagConstraints.HORIZONTAL;
		gbc_dijabetesNe.gridx = 6;
		gbc_dijabetesNe.gridy = 16;
		contentPanel.add(dijabetesNe, gbc_dijabetesNe);
		
		alkoholizamLabel = new JLabel("Alkoholizam:");
		GridBagConstraints gbc_alkoholizamLabel= new GridBagConstraints();
		gbc_alkoholizamLabel.anchor = GridBagConstraints.WEST;
		gbc_alkoholizamLabel.insets = new Insets(5, 5, 5, 5);
		gbc_alkoholizamLabel.gridx = 2;
		gbc_alkoholizamLabel.gridy = 17;
		contentPanel.add(alkoholizamLabel, gbc_alkoholizamLabel);
		
		alkoholDa = new JRadioButton("Da");
		GridBagConstraints gbc_alkoholDa = new GridBagConstraints();
		gbc_alkoholDa.insets = new Insets(0, 0, 5, 0);
		gbc_alkoholDa.fill = GridBagConstraints.HORIZONTAL;
		gbc_alkoholDa.gridx = 5;
		gbc_alkoholDa.gridy = 17;
		contentPanel.add(alkoholDa, gbc_alkoholDa);
		
		alkoholNe = new JRadioButton("Ne");
		GridBagConstraints gbc_alkoholNe = new GridBagConstraints();
		gbc_alkoholNe.insets = new Insets(0, 0, 5, 0);
		gbc_alkoholNe.fill = GridBagConstraints.HORIZONTAL;
		gbc_alkoholNe.gridx = 6;
		gbc_alkoholNe.gridy = 17;
		contentPanel.add(alkoholNe, gbc_alkoholNe);
		
		fizickaAktLabel = new JLabel("Nedovoljna fizicka aktivnost:");
		GridBagConstraints gbc_fizickaAktlabel= new GridBagConstraints();
		gbc_fizickaAktlabel.anchor = GridBagConstraints.WEST;
		gbc_fizickaAktlabel.insets = new Insets(5, 5, 5, 5);
		gbc_fizickaAktlabel.gridx = 2;
		gbc_fizickaAktlabel.gridy = 18;
		contentPanel.add(fizickaAktLabel, gbc_fizickaAktlabel);
		
		aktivnostDa = new JRadioButton("Da");
		GridBagConstraints gbc_aktivnostDa = new GridBagConstraints();
		gbc_aktivnostDa.insets = new Insets(0, 0, 5, 0);
		gbc_aktivnostDa.fill = GridBagConstraints.HORIZONTAL;
		gbc_aktivnostDa.gridx = 5;
		gbc_aktivnostDa.gridy = 18;
		contentPanel.add(aktivnostDa, gbc_aktivnostDa);
		
		aktivnostNe = new JRadioButton("Ne");
		GridBagConstraints gbc_aktivnostNe = new GridBagConstraints();
		gbc_aktivnostNe.insets = new Insets(0, 0, 5, 0);
		gbc_aktivnostNe.fill = GridBagConstraints.HORIZONTAL;
		gbc_aktivnostNe.gridx = 6;
		gbc_aktivnostNe.gridy = 18;
		contentPanel.add(aktivnostNe, gbc_aktivnostNe);
		
		buttonPane = new JPanel();
		FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
		fl_buttonPane.setHgap(25);
		buttonPane.setLayout(fl_buttonPane);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		addMr = new JButton("Update");
		addMr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addMr.setActionCommand("OK");
		addMr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String firstName = firstNameTextField.getText().trim();
				String lastName = lastNameTextField.getText().trim();
				String jmbgPat = jmbgTextField.getText().trim();
				String brKnjizice = brKnjiziceTextField.getText().trim();
				String imeOsigranika = imeOsiguranikaTextField.getText().trim();
				String prezimeOsiguranika = prezimeOsiguranikaTextField.getText().trim();
				String jmbgOsiguranika = jmbgOsiguranikaTextField.getText().trim();
				int visina = 0;
				int tezina = 0;
				if(!visinaTextField.getText().equals("") || !tezinaTextField.getText().equals("")) {
					visina = Integer.parseInt(visinaTextField.getText().trim());
					tezina = Integer.parseInt(tezinaTextField.getText().trim());
				}
				
				boolean zaposlen;
				if(zaposlenRadioBDa.isSelected()) {
					zaposlen = true;
				} else if (zaposlenRadioBNe.isSelected()) {
					zaposlen = false;
				} else {
					return;
				}
				
				Gender pol;
				if(polMusko.isSelected()) {
					pol = Gender.MAN;
				} else if (polZensko.isSelected()) {
					pol = Gender.WOMAN;
				} else {
					return;
				}
				
				String krvaGrupa = krvnaGrupaTextField.getText().trim();
				
				boolean pusenje;
				if(pusenjeDa.isSelected()) {
					pusenje = true;
				} else if (pusenjeNe.isSelected()) {
					pusenje = false;
				} else {
					return;
				}
				
				boolean gojaznost;
				if(gojaznostDa.isSelected()) {
					gojaznost = true;
				} else if (gojaznostNe.isSelected()) {
					gojaznost = false;
				} else {
					return;
				}
				
				boolean dijabetes;
				if(dijabetesDa.isSelected()) {
					dijabetes = true;
				} else if (dijabetesNe.isSelected()) {
					dijabetes = false;
				} else {
					return;
				}
				
				boolean alkoholizam;
				if(alkoholDa.isSelected()) {
					alkoholizam = true;
				} else if (alkoholNe.isSelected()) {
					alkoholizam = false;
				} else {
					return;
				}
				
				boolean aktivnost;
				if(aktivnostDa.isSelected()) {
					aktivnost = true;
				} else if (aktivnostNe.isSelected()) {
					aktivnost = false;
				} else {
					return;
				}
				
				mr.setBrKnjizice(brKnjizice);
				mr.setImeOsiguranika(imeOsigranika);
				mr.setPrezimeOsiguranika(prezimeOsiguranika);
				mr.setJmbgOsiguranika(jmbgOsiguranika);
				mr.setVisina(visina);
				mr.setTezina(tezina);
				mr.setZaposlen(zaposlen);
				mr.setPol(pol);
				mr.setKrvnaGrupa(krvaGrupa);
				mr.setPusenje(pusenje);
				mr.setGojaznost(gojaznost);
				mr.setDijabetes(dijabetes);
				mr.setAlkoholizam(alkoholizam);
				mr.setNedovoljnaFizickaAktivnost(aktivnost);
				
				System.out.println(mr.toString());
				ArrayList<String> tmp = new ArrayList<String>();
				PatientBase.getInstance().editPatient(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getJmbg(), patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber(), mr, patient.getAnamnesis(), patient.getPregledi());
				MainFrame.getInstance().updateMainPanelPatientsTable();
				dispose();
				
			}
		});
		buttonPane.add(addMr);
		
		cancelButton = new JButton("Odustani");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		
		addAnamnesis = new JButton("Anamneze");
		addAnamnesis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addAnamnesis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelectAnamnesisDialog d = new SelectAnamnesisDialog();
				d.setVisible(true);
			}
		});
		buttonPane.add(addAnamnesis);
	}
	
}
