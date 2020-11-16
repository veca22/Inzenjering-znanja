package view.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import model.PhysicalExamination;

public class NextDialog extends JDialog{
	
	private JPanel contentPane;
	private JToolBar toolBar;
	private JButton dodajProceduruButton;
	private JButton dodajDijagnozuButton;
	private JButton dodajTerapijuButton;
	private PhysicalExamination p;
	
	public NextDialog (PhysicalExamination physicalExamination) {
		p = physicalExamination;
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Procedure pregleda");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(440,400);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		dodajProceduruButton = new JButton("Dodaj dopunsko ispitivanje");
		dodajProceduruButton.setIcon(new ImageIcon("images/arrow_top_right_icon&24.png"));
		dodajProceduruButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NovaProceduraDijalog d = new NovaProceduraDijalog(p);
				d.setVisible(true);
			}
		});
		
		dodajDijagnozuButton = new JButton("Dodaj dijagnozu");
		dodajDijagnozuButton.setIcon(new ImageIcon("images/round_and_up_icon&24.png"));
		dodajDijagnozuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NovaDijagnozaDijalog d2 = new NovaDijagnozaDijalog(p);
				d2.setVisible(true);
			}
		});
		
		dodajTerapijuButton = new JButton("Dodaj terapiju");
		dodajTerapijuButton.setIcon(new ImageIcon("images/db_icon&24.png"));
		dodajTerapijuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NovaTerapijaDijalog d3 = new NovaTerapijaDijalog(p);
				d3.setVisible(true);
			}
		});
		
		toolBar.add(dodajProceduruButton);
		toolBar.add(dodajDijagnozuButton);
		toolBar.add(dodajTerapijuButton);
	}

}
