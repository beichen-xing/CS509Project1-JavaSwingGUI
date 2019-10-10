package boundry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import entity.Model;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class FrontPageDisplay extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	static Model model;
	private JPanel panel;
	
	public FrontPageDisplay() {
		setTitle("Frontpage");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(315, 0, 300, 300);
		contentPane.add(panel);
		
		textArea = new JTextArea();
		textArea.setBounds(25, 40, 273, 80);
		contentPane.add(textArea);
		
		JButton btnChangeLocation = new JButton("change location");
		btnChangeLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setBounds(450, 250, 300, 300);
			}
		});
		btnChangeLocation.setBounds(25, 496, 210, 25);
		contentPane.add(btnChangeLocation);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
		public String getwords() {
		return textArea.getText();
		
	}
		public JTextArea getarea() {
			return textArea;
		}
		public JPanel getpanel() {
			return contentPane;
		}
		public JPanel getjp() {
			return panel;
			
		}
}




