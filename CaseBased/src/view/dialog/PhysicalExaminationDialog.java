package view.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import model.Patient;
import model.PhysicalExamination;
import view.MainFrame;

public class PhysicalExaminationDialog extends JDialog{
	
	private JPanel contentPane;
	private JToolBar toolBar;
	private JButton dodajPregledButton;
	private JList<PhysicalExamination> patientPhysicalExaminatonList;
	private DefaultListModel<PhysicalExamination> physicalExaminatinoListModel;
	
	
	public PhysicalExaminationDialog() {
		initComponents();
		
	}
	
	private void initComponents() {
		setTitle("Pregledi pacijenta");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(1000,450);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		dodajPregledButton = new JButton("Novi pregled");
		dodajPregledButton.setIcon(new ImageIcon("images/create_icon&24.png"));
		dodajPregledButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewPhysicalExaminationDialog d = new NewPhysicalExaminationDialog();
				d.setVisible(true);
				
			}
		});
		
		toolBar.add(dodajPregledButton);
		
		initList();
		
		JScrollPane scrollPane = new JScrollPane(patientPhysicalExaminatonList);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void initList() {
		
		Patient p = MainFrame.getInstance().getCurrent();
		physicalExaminatinoListModel = new DefaultListModel<PhysicalExamination>();
		ArrayList<PhysicalExamination> tmp = p.getPregledi();
		
		for(PhysicalExamination p1 : tmp) {
			physicalExaminatinoListModel.addElement(p1);
			
		}
		
		patientPhysicalExaminatonList = new JList<PhysicalExamination>(physicalExaminatinoListModel);
		
		patientPhysicalExaminatonList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e)  {check(e);}
			public void mouseReleased(MouseEvent e) {check(e);}

			public void check(MouseEvent e) {
			    if (e.isPopupTrigger()) { //if the event shows the menu
			    	patientPhysicalExaminatonList.setSelectedIndex(patientPhysicalExaminatonList.locationToIndex(e.getPoint())); //select the item
			        //p.show(patientTherapyList, e.getX(), e.getY()); //and show the menu
			    }
			}
			
			public void mouseClicked(MouseEvent e) {
			           if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {    	  
			        	   PhysicalExamination t = patientPhysicalExaminatonList.getSelectedValue();
			        	   System.out.println(t.toString());
							if(t != null){
								System.out.println("usao enter");
								// SelectSymptomsForPhysicalExaminationDialog d = new SelectSymptomsForPhysicalExaminationDialog(t);
								// d.setVisible(true);
								NextDialog d = new NextDialog(t);
								d.setVisible(true);
								
							}
			           }
			       }
		});
	}
}
