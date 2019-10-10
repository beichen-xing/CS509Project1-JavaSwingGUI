package boundry;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;

public class frontpage extends JPanel {
	
	frontpage fp;
	
	public frontpage(CardGUI g) {
		fp = g.getFront();
	}
	
	public void frontpagebirth() {
		JLabel label = new JLabel();
		EventQueue.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		    	ImageIcon img = new ImageIcon("./src/entity/birthday.jpg");
		    	img.setImage(img.getImage().getScaledInstance(fp.getWidth(), fp.getHeight(),Image.SCALE_DEFAULT));
		    	label.setIcon(img);
		    }
		});

		label.setVisible(true);
		fp.add(label);
		fp.setVisible(true);
	}
	
	
}
