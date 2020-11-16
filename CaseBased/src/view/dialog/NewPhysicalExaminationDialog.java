package view.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Patient;
import model.PhysicalExamination;
import model.Table.PatientBase;
import view.MainFrame;

public class NewPhysicalExaminationDialog extends JDialog{
	
	private JPanel contentPanel = new JPanel();
	
	private JLabel patientIdLabel;
	private JTextField patientIdTextField;
	private JLabel patientFirstNameLabel;
	private JTextField patientFirstNameTextField;
	private JLabel patientLastNameLabel;
	private JTextField patientLastNameTextField;
	private JLabel vidljivPrelomLabela;
	private JPanel vidljivPrelomPanel;
	private ButtonGroup bg;
	private JRadioButton imaVidljivPrelomRadioButton;
	private JRadioButton nemaVidljivPrelomRadioButton;
	private JLabel vidljivOtokLabela;
	private JPanel vidljivOtokPanel;
	private ButtonGroup bg2;
	private JRadioButton velikiOtokRadioButton;
	private JRadioButton maliOtokRadioButton;
	private JRadioButton nemaOtokRadioButton;
	private JPanel buttonPane;
	private JButton addPhysicalExamanationButton;
	private JButton cancelButton;
	private JButton symptomButton;
	private JLabel pokretLabela;
	private JPanel pokretPanel;
	private ButtonGroup bg3;
	private JRadioButton dobarPokretRadioButton;
	private JRadioButton slabPokretRadioButton;
	private JRadioButton nemaPokretRadioButton;
	private PhysicalExamination p;
	
	public NewPhysicalExaminationDialog() {
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Dodavanje novog pregleda");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(600,450);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {30, 30, 0, 30, 30, 30};
		gbl_contentPanel.rowHeights = new int[] {30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 30, 30};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			patientIdLabel = new JLabel("Br. knjizice:");
			GridBagConstraints gbc_patientIdLabel = new GridBagConstraints();
			gbc_patientIdLabel.anchor = GridBagConstraints.WEST;
			gbc_patientIdLabel.insets = new Insets(5, 5, 5, 5);
			gbc_patientIdLabel.gridx = 2;
			gbc_patientIdLabel.gridy = 1;
			contentPanel.add(patientIdLabel, gbc_patientIdLabel);
			
			patientIdTextField = new JTextField();
			patientIdLabel.setLabelFor(patientIdTextField);
			patientIdTextField.setText(MainFrame.getInstance().getCurrent().getMr().getBrKnjizice());
			patientIdTextField.setEditable(false);
			GridBagConstraints gbc_patientIdTextField = new GridBagConstraints();
			gbc_patientIdTextField.insets = new Insets(5, 5, 5, 5);
			gbc_patientIdTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_patientIdTextField.gridx = 6;
			gbc_patientIdTextField.gridy = 1;
			contentPanel.add(patientIdTextField, gbc_patientIdTextField);
			patientIdTextField.setColumns(10);
		}
		{
			patientFirstNameLabel = new JLabel("Ime pacijenta:");
			GridBagConstraints gbc_patientFirstNameLabel = new GridBagConstraints();
			gbc_patientFirstNameLabel.anchor = GridBagConstraints.WEST;
			gbc_patientFirstNameLabel.insets = new Insets(5, 5, 5, 5);
			gbc_patientFirstNameLabel.gridx = 2;
			gbc_patientFirstNameLabel.gridy = 3;
			contentPanel.add(patientFirstNameLabel, gbc_patientFirstNameLabel);
			
			patientFirstNameTextField = new JTextField();
			patientFirstNameLabel.setLabelFor(patientFirstNameTextField);
			patientFirstNameTextField.setText(MainFrame.getInstance().getCurrent().getFirstName());
			patientFirstNameTextField.setEditable(false);
			GridBagConstraints gbc_patientFirstNameTextField = new GridBagConstraints();
			gbc_patientFirstNameTextField.insets = new Insets(5, 5, 5, 5);
			gbc_patientFirstNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_patientFirstNameTextField.gridx = 6;
			gbc_patientFirstNameTextField.gridy = 3;
			contentPanel.add(patientFirstNameTextField, gbc_patientFirstNameTextField);
			patientFirstNameTextField.setColumns(10);
		}
		{
			patientLastNameLabel = new JLabel("Prezime pacijenta:");
			GridBagConstraints gbc_patientLastNameLabel = new GridBagConstraints();
			gbc_patientLastNameLabel.anchor = GridBagConstraints.WEST;
			gbc_patientLastNameLabel.insets = new Insets(5, 5, 5, 5);
			gbc_patientLastNameLabel.gridx = 2;
			gbc_patientLastNameLabel.gridy = 5;
			contentPanel.add(patientLastNameLabel, gbc_patientLastNameLabel);
			
			patientLastNameTextField = new JTextField();
			patientLastNameLabel.setLabelFor(patientLastNameTextField);
			patientLastNameTextField.setText(MainFrame.getInstance().getCurrent().getLastName());
			patientLastNameTextField.setEditable(false);
			GridBagConstraints gbc_patientLastNameTextField = new GridBagConstraints();
			gbc_patientLastNameTextField.insets = new Insets(5, 5, 5, 5);
			gbc_patientLastNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_patientLastNameTextField.gridx = 6;
			gbc_patientLastNameTextField.gridy = 5;
			contentPanel.add(patientLastNameTextField, gbc_patientLastNameTextField);
			patientLastNameTextField.setColumns(10);
		}
		{
			vidljivPrelomLabela = new JLabel("Vidljiv prelom:");
			GridBagConstraints gbc_vidljivPrelomLabela = new GridBagConstraints();
			gbc_vidljivPrelomLabela.anchor = GridBagConstraints.WEST;
			gbc_vidljivPrelomLabela.insets = new Insets(5, 5, 5, 5);
			gbc_vidljivPrelomLabela.gridx = 2;
			gbc_vidljivPrelomLabela.gridy = 7;
			contentPanel.add(vidljivPrelomLabela, gbc_vidljivPrelomLabela);
			
			vidljivPrelomPanel = new JPanel();
			bg = new ButtonGroup();
			GridBagConstraints gbc_vidljivPrelomPanel = new GridBagConstraints();
			gbc_vidljivPrelomPanel.insets = new Insets(5, 5, 5, 5);
			gbc_vidljivPrelomPanel.fill = GridBagConstraints.BOTH;
			gbc_vidljivPrelomPanel.gridx = 6;
			gbc_vidljivPrelomPanel.gridy = 7;
			contentPanel.add(vidljivPrelomPanel, gbc_vidljivPrelomPanel);
			vidljivPrelomPanel.setLayout(new GridLayout(1, 3, 5, 5));
			
			imaVidljivPrelomRadioButton = new JRadioButton("Ima");
			imaVidljivPrelomRadioButton.setSelected(true);
			imaVidljivPrelomRadioButton.setActionCommand("Ima");
			vidljivPrelomPanel.add(imaVidljivPrelomRadioButton);
			
			nemaVidljivPrelomRadioButton = new JRadioButton("Nema");
			nemaVidljivPrelomRadioButton.setActionCommand("Nema");
			vidljivPrelomPanel.add(nemaVidljivPrelomRadioButton);
			
			bg.add(imaVidljivPrelomRadioButton);
			bg.add(nemaVidljivPrelomRadioButton);
		}
		{
			vidljivOtokLabela = new JLabel("Vidljiv otok:");
			GridBagConstraints gbc_vidljivOtokLabela = new GridBagConstraints();
			gbc_vidljivOtokLabela.anchor = GridBagConstraints.WEST;
			gbc_vidljivOtokLabela.insets = new Insets(5, 5, 5, 5);
			gbc_vidljivOtokLabela.gridx = 2;
			gbc_vidljivOtokLabela.gridy = 9;
			contentPanel.add(vidljivOtokLabela, gbc_vidljivOtokLabela);
			
			vidljivOtokPanel = new JPanel();
			bg2 = new ButtonGroup();
			GridBagConstraints gbc_vidljivOtokPanel = new GridBagConstraints();
			gbc_vidljivOtokPanel.insets = new Insets(5, 5, 5, 5);
			gbc_vidljivOtokPanel.fill = GridBagConstraints.BOTH;
			gbc_vidljivOtokPanel.gridx = 6;
			gbc_vidljivOtokPanel.gridy = 9;
			contentPanel.add(vidljivOtokPanel, gbc_vidljivOtokPanel);
			vidljivOtokPanel.setLayout(new GridLayout(1, 3, 5, 5));
			
			velikiOtokRadioButton = new JRadioButton("Veliki otok");
			velikiOtokRadioButton.setSelected(true);
			velikiOtokRadioButton.setActionCommand("Veliki otok");
			vidljivOtokPanel.add(velikiOtokRadioButton);
			
			maliOtokRadioButton = new JRadioButton("Mali otok");
			maliOtokRadioButton.setActionCommand("Mali otok");
			vidljivOtokPanel.add(maliOtokRadioButton);
			
			nemaOtokRadioButton = new JRadioButton("Nema otok");
			nemaOtokRadioButton.setActionCommand("Nema otok");
			vidljivOtokPanel.add(nemaOtokRadioButton);
			
			bg2.add(velikiOtokRadioButton);
			bg2.add(maliOtokRadioButton);
			bg2.add(nemaOtokRadioButton);
		}
		{
			pokretLabela = new JLabel("Mogucnost pokreta:");
			GridBagConstraints gbc_pokretLabela = new GridBagConstraints();
			gbc_pokretLabela.anchor = GridBagConstraints.WEST;
			gbc_pokretLabela.insets = new Insets(5, 5, 5, 5);
			gbc_pokretLabela.gridx = 2;
			gbc_pokretLabela.gridy = 11;
			contentPanel.add(pokretLabela, gbc_pokretLabela);
			
			pokretPanel = new JPanel();
			bg3 = new ButtonGroup();
			GridBagConstraints gbc_pokretPanelPanel = new GridBagConstraints();
			gbc_pokretPanelPanel.insets = new Insets(5, 5, 5, 5);
			gbc_pokretPanelPanel.fill = GridBagConstraints.BOTH;
			gbc_pokretPanelPanel.gridx = 6;
			gbc_pokretPanelPanel.gridy = 11;
			contentPanel.add(pokretPanel, gbc_pokretPanelPanel);
			pokretPanel.setLayout(new GridLayout(1, 3, 5, 5));
			
			dobarPokretRadioButton = new JRadioButton("Dobra");
			dobarPokretRadioButton.setSelected(true);
			dobarPokretRadioButton.setActionCommand("Dobra");
			pokretPanel.add(dobarPokretRadioButton);
			
			slabPokretRadioButton = new JRadioButton("Slaba");
			slabPokretRadioButton.setActionCommand("Slaba");
			pokretPanel.add(slabPokretRadioButton);
			
			nemaPokretRadioButton = new JRadioButton("Nema");
			nemaPokretRadioButton.setActionCommand("Nema");
			pokretPanel.add(nemaPokretRadioButton);
			
			bg3.add(dobarPokretRadioButton);
			bg3.add(slabPokretRadioButton);
			bg3.add(nemaPokretRadioButton);
		}
		{
			//dugme dodaj
			buttonPane = new JPanel();
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
			fl_buttonPane.setHgap(25);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				addPhysicalExamanationButton = new JButton("Dodaj");
				addPhysicalExamanationButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				addPhysicalExamanationButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					    p = new PhysicalExamination();
						if(imaVidljivPrelomRadioButton.isSelected()) {
							p.setVidljivPrelom("Ima");
						} else {
							p.setVidljivPrelom("Nema");
						}
						
						if(velikiOtokRadioButton.isSelected()) {
							p.setVidljivOtok("Veliki");
						} else if(maliOtokRadioButton.isSelected()) {
							p.setVidljivOtok("Mali");
						} else {
							p.setVidljivOtok("Nema");
						}
						
						if(dobarPokretRadioButton.isSelected()) {
							p.setMogucnostPokreta("Dobra");
						} else if(slabPokretRadioButton.isSelected()) {
							p.setMogucnostPokreta("Slaba");
						} else {
							p.setMogucnostPokreta("Nema");
						}
															
						Patient patient = MainFrame.getInstance().getCurrent();
						
						ArrayList<PhysicalExamination> tmp = patient.getPregledi();
						p.setId(tmp.size() + 1);
						tmp.add(p);
						PatientBase.getInstance().editPatient(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getJmbg(), patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber(), patient.getMr(), patient.getAnamnesis(), tmp);
						System.out.println("ispod");
						
						for (PhysicalExamination physicalExamination : patient.getPregledi()) {
							System.out.println(physicalExamination.toString());
						}						
						dispose();
						
						SelectSymptomsForPhysicalExaminationDialog d = new SelectSymptomsForPhysicalExaminationDialog(p);
						d.setVisible(true);
						
						
					}
				});
				buttonPane.add(addPhysicalExamanationButton);
			}
			{
				//dugme prekini
				cancelButton = new JButton("Prekini");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
			/*
			{
				symptomButton = new JButton("Simptomi");
				symptomButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				symptomButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						SelectSymptomsForPhysicalExaminationDialog d = new SelectSymptomsForPhysicalExaminationDialog();
						d.setVisible(true);
						
					}
				});
				
				buttonPane.add(symptomButton);
			}*/
		}
		
	}

}
