package boundry;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class InnerRightPageDisplay extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public InnerRightPageDisplay() {
		setTitle("RightPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(20, 20, 400, 400);
		contentPane.add(textArea);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JTextArea getarea() {

		return textArea;
	}

}
