package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;

import controller.AboutActionDialog;
import controller.NewPatientDialogAction;
import model.Patient;
import model.Table.PatientBase;
import model.Table.PatientTable;
import model.Table.PatientTablePanel;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;

public class MainFrame extends JFrame {

private static MainFrame instance = null;

	
	private JPanel contentPane;
	private JLabel logoLabel;
	private JPanel mainPanel;
	private PatientTablePanel patientsTablePanel;
	Patient current;
	private Collection<RetrievalResult> ret;
	private Collection<RetrievalResult> ret2;
	private Collection<RetrievalResult> ret3;
	private JIPTerm solution;
	private JIPTerm solution2;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2 + 400, screenHeight/2 + 250);
        setLocationRelativeTo(null);
		
		setIconImage(new ImageIcon("images/medCareLogo.png").getImage());
		setTitle("Dobrodosli u medCare aplikaciju");
		//setBounds(100, 100, 550, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu patientsMenu = new JMenu("Pacijenti");
		menuBar.add(patientsMenu);
		
		JMenuItem newPatientMenuItem = new JMenuItem("Dodavanje novog pacijenta");
		newPatientMenuItem.addActionListener(new NewPatientDialogAction());
		newPatientMenuItem.setIcon(new ImageIcon("images/create_icon&24.png"));
		patientsMenu.add(newPatientMenuItem);
		
		JMenu helpMenu = new JMenu("Pomoc");
		menuBar.add(helpMenu);
		
		JMenuItem aboutMenuItem = new JMenuItem("O aplikaciji");
		aboutMenuItem.addActionListener(new AboutActionDialog());
		aboutMenuItem.setIcon(new ImageIcon("images/info_icon&24.png"));
		helpMenu.add(aboutMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton newPatientButton = new JButton(new NewPatientDialogAction());
		newPatientButton.setText("Novi pacijent");
		newPatientButton.setIcon(new ImageIcon("images/create_icon&24.png"));
		toolBar.add(newPatientButton);
					
		 mainPanel = new JPanel();
		 mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		 mainPanel.setLayout(new BorderLayout(0, 0));
		 contentPane.add(mainPanel, BorderLayout.CENTER);

		
		this.updateMainPanel();
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			
				PatientBase.getInstance().deserialize();
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				PatientBase.getInstance().serialize();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
	
		
	}
	
	public void updateMainPanel() {

		this.patientsTablePanel = new PatientTablePanel();
		// this.patientsTablePanel.refreshData();
		setContentPane(patientsTablePanel);
		
	}
	
	public void updateMainPanelPatientsTable() {
		this.patientsTablePanel.refreshData();
		
	}
	

	public PatientTablePanel getPatientsTablePanel() {
		return patientsTablePanel;
	}

	public void setPatientsTablePanel(PatientTablePanel patientsTablePanel) {
		this.patientsTablePanel = patientsTablePanel;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public Patient getCurrent() {
		return current;
	}

	public void setCurrent(Patient current) {
		this.current = current;
	}

	public Collection<RetrievalResult> getRet() {
		return ret;
	}

	public void setRet(Collection<RetrievalResult> ret) {
		this.ret = ret;
	}

	public Collection<RetrievalResult> getRet2() {
		return ret2;
	}

	public void setRet2(Collection<RetrievalResult> ret2) {
		this.ret2 = ret2;
	}

	public Collection<RetrievalResult> getRet3() {
		return ret3;
	}

	public void setRet3(Collection<RetrievalResult> ret3) {
		this.ret3 = ret3;
	}

	public JIPTerm getSolution() {
		return solution;
	}

	public void setSolution(JIPTerm solution) {
		this.solution = solution;
	}

	public JIPTerm getSolution2() {
		return solution2;
	}

	public void setSolution2(JIPTerm solution2) {
		this.solution2 = solution2;
	}

}
