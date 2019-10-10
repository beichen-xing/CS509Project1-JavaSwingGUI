package boundry;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class InnerLeftPageDisplay extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public InnerLeftPageDisplay() {
		setTitle("LeftPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 10, 300, 300);
		contentPane.add(textArea);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public JTextArea getarea() {
		return textArea;
	}
}
