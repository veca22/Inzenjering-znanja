package view.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

import cbr.ProceduresCbrApplication;
import cbr.PrologEngine;
import model.Patient;
import model.PhysicalExamination;
import model.Table.PatientBase;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import util.StringListMapper;
import view.MainFrame;


public class NovaProceduraDijalog extends JDialog{
	
	private JPanel contentPanel = new JPanel();
	
	private JPanel panel;
	private JLabel label_1;
	private JComboBox<String> combo;
	private JButton button;
	private JPanel panel_1;
	private JLabel label_2;
	private JButton btnUradi;
	private PhysicalExamination physicalExamination;
	private Collection<RetrievalResult> results = new ArrayList<RetrievalResult>();
	private JIPTerm solution;
	
	private JList<String> proceduresList;
	private DefaultListModel<String> proceduresListModel;
	
	public NovaProceduraDijalog(PhysicalExamination p) {
		this.physicalExamination = p;
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Dodavanje preventivnog pregleda");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(1000,500);
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
			panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{30, 30, 0, 30, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{50, 50, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			label_1 = new JLabel("Zakljucivanje:");
			label_1.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 0, 5);
			gbc_label_1.gridx = 2;
			gbc_label_1.gridy = 1;
			panel.add(label_1, gbc_label_1);
			
			combo = new JComboBox<String>();
			combo.addItem("Rule based");
			combo.addItem("Case based");
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.insets = new Insets(0, 0, 0, 5);
			gbc_comboBox.gridx = 4;
			gbc_comboBox.gridy = 1;
			panel.add(combo, gbc_comboBox);
			
			panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.gridheight = 4;
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 1;
			contentPanel.add(panel_1, gbc_panel_1);
			
			label_2 = new JLabel("Preporucena dopunska ispitivanja su:");
			label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			panel_1.add(label_2);
			
			
			//dugme pogledaj
			button = new JButton("Pogledaj");
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.gridx = 5;
			gbc_button.gridy = 1;
			panel.add(button, gbc_button);
			button.addActionListener(new ActionListener() {
				
				
				List<String> solutionList = new ArrayList<String>();
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String reasoning = (String) combo.getSelectedItem();
					System.out.println(reasoning);
					if(reasoning.equals("Case based")) {

						ProceduresCbrApplication pcbr = new ProceduresCbrApplication();
						pcbr.run(physicalExamination.getSimptomi());
						results = MainFrame.getInstance().getRet();
						System.out.println(results.size());
						initList();
						JScrollPane scrollPane = new JScrollPane(proceduresList);
						panel_1.add(scrollPane, BorderLayout.CENTER);
						revalidate();
						repaint();
					
					} else if(reasoning.equals("Rule based")) {
						System.out.println("Usao u rule based");
						PrologEngine prologEngine = new PrologEngine();
						prologEngine.run_procedures(physicalExamination.getSimptomi());
						solution = MainFrame.getInstance().getSolution();
						initList1();
						JScrollPane scrollPane = new JScrollPane(proceduresList);
						panel_1.add(scrollPane, BorderLayout.CENTER);
						revalidate();
						repaint();
					}
				}
			});
		}
		
		{
			//dugme uradi
			btnUradi = new JButton("Uradi");
			GridBagConstraints gbc_btnUradi = new GridBagConstraints();
			gbc_btnUradi.insets = new Insets(0, 0, 0, 5);
			gbc_btnUradi.gridx = 0;
			gbc_btnUradi.gridy = 11;
			contentPanel.add(btnUradi, gbc_btnUradi);
			btnUradi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String selectedValue = proceduresList.getSelectedValue();
					if(selectedValue == null) {
						return;
					} else {
						if(!results.isEmpty()) {
							String[] parts = selectedValue.split("=>");
							String retValue = parts[1];
							physicalExamination.setProcedura(retValue);
							Patient patient = MainFrame.getInstance().getCurrent();	
							for(PhysicalExamination pe : patient.getPregledi())  {
								if(pe.getId() == physicalExamination.getId()) {
									pe = physicalExamination;
									break;
								}
							}
							
							PatientBase.getInstance().editPatient(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber(),patient.getMr(), patient.getAnamnesis(), patient.getPregledi());
							PatientBase.getInstance().writeToBaseProcedures(StringListMapper.toString(physicalExamination.getSimptomi()) + ";" + physicalExamination.getProcedura());
							dispose();
						} else {
							String ret = selectedValue;
							physicalExamination.setProcedura(ret);
							Patient patient = MainFrame.getInstance().getCurrent();	
							for(PhysicalExamination pe : patient.getPregledi())  {
								if(pe.getId() == physicalExamination.getId()) {
									pe = physicalExamination;
									break;
								}
							}
							
							PatientBase.getInstance().editPatient(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getAddress(), patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber(),patient.getMr(), patient.getAnamnesis(), patient.getPregledi());
							PatientBase.getInstance().writeToBaseProcedures(StringListMapper.toString(physicalExamination.getSimptomi()) + ";" + physicalExamination.getProcedura());
							dispose();
							
						}
					}
										
				}
			});
		}
	}
	
	public void initList() {
	
		proceduresListModel = new DefaultListModel<String>();
		
		
		for (RetrievalResult nse : results)
			proceduresListModel.addElement(nse.get_case().getDescription() + "=>" + nse.getEval());
		
		proceduresList = new JList<String>(proceduresListModel);
	}
	
	public void initList1() {
		
		proceduresListModel = new DefaultListModel<String>();
		
		
		System.out.println("solution: " + solution);
		  if(solution != null) {
			for (JIPVariable var: solution.getVariables()) {
				System.out.println("Ispod variable");
				System.out.println(var.getValue());
				String tmp = var.getValue().toString();
				if(tmp.equals("-(plain_x,ray)")) {
					tmp = "plain_x-ray";
				}
				proceduresListModel.addElement(tmp);
			}
		  } else {
			  String tmp = "Nemamo zakljucivanje po Rule based, molimo vas izaberite Case-based nacin";
			  proceduresListModel.addElement(tmp);
		  }
		
		
		
		proceduresList = new JList<String>(proceduresListModel);
	}
}
