package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AboutFrame extends JFrame {

	private JPanel contentPane;
	
	public AboutFrame() {
		setIconImage(new ImageIcon("images/medCareLogo.png").getImage());
		setTitle("O aplikaciji medCare!");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/4 + 300, screenHeight/4 + 300);
        setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel imagePanel = new JPanel();
		mainPanel.add(imagePanel);
		
		
		
		ImageIcon logoIcon = new ImageIcon ("images/medCareLogo.png");
		Image image = logoIcon.getImage();
		Image newImg = image.getScaledInstance(screenWidth/6, screenWidth/6, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(newImg);
		
		JLabel imageLabel = new JLabel("");
		imagePanel.add(imageLabel);
		
		imageLabel.setIcon(logoIcon);
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setVerticalAlignment(JLabel.CENTER);
		
		JPanel aboutPanel = new JPanel();
		mainPanel.add(aboutPanel);
		
		String text = "<html>Medcare aplikacija namenjena je podrsci lekarima specijalistima iz oblasti ortopedije.<br>"
				+ "Aplikacija osim što omogucava evidenciju pregleda i pracenje <br> stanje pacijenta, pruza i pomoc u predvidjanju narednih koraka "
				+ "u postupku lecenja <br> pacijenta. Odabir odgovarajuceg dopunskog ispitivanja,  pomoc u dijagnostici,  izboru <br> terapija i odgovarajucih preventivnih pregleda "
				+ "zasniva se cinjenicama i pravilama <br> koja postoje u relevantnim naucnim radovima i koja su prikupljena na osnovu iskustva lekara. <html>";
		aboutPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel textPanel = new JPanel();
		aboutPanel.add(textPanel, BorderLayout.CENTER);
		JLabel textLabel = new JLabel(text);
		textLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		textPanel.add(textLabel);
		
		JPanel authorsPanel = new JPanel();
		aboutPanel.add(authorsPanel, BorderLayout.SOUTH);
		authorsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		authorsPanel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Veljko Vukovic RA52/2016");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		authorsPanel.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Nikola Zejak RA53/2016");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		authorsPanel.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Nemanja Mirkovic RA216/2016");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_3);
	}
}
