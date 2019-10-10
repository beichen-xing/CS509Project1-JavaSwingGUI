package entity;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import boundry.CardGUI;
import boundry.FrontPageDisplay;
import boundry.InnerLeftPageDisplay;
import boundry.InnerRightPageDisplay;
import boundry.frontpage;
import controller.LoadCard;
import controller.ShowFrontpage;


public class Model {
	
	Model model;
	CardGUI cgui;
	ShowFrontpage sfp;
	LoadCard lc;
	String s;
	FrontPageDisplay fpd;
	InnerLeftPageDisplay lpd;
	InnerRightPageDisplay rpd;
	
	public Model(CardGUI g, Model m) {
		this.model = m;
		this.cgui = g;
		this.sfp = new ShowFrontpage(g);
		this.lc = new LoadCard(g,m);
	}
	public Model(CardGUI g,FrontPageDisplay f, Model m) {
		this.model = m;
		this.cgui = g;
		this.fpd = f;
	}
	public Model(FrontPageDisplay f, Model m) {
		this.fpd = f;
		this.model = m;
	}
	
	public Model(CardGUI g, InnerLeftPageDisplay l, Model m) {
		this.model = m;
		this.cgui = g;
		this.lpd = l;
	}
	public Model(CardGUI g, InnerRightPageDisplay r, Model m) {
		this.model = m;
		this.cgui = g;
		this.rpd = r;
	}
	public Model(CardGUI g, Model m, InnerLeftPageDisplay l, InnerRightPageDisplay r, FrontPageDisplay f) {
		this.cgui = g;
		this.rpd = r;
		this.lpd = l;
		this.fpd = f;
		this.model = m;
		this.sfp = new ShowFrontpage(g);
		this.lc = new LoadCard(g,m,l,r,f);
	}
	public void process() {
		sfp.choosephoto();
	}
	
	public void del() {
		cgui.getFront().removeAll();
		cgui.getTextArea().setText("");
		cgui.repaint();
		lc.del();
		cgui.getTextArea().setEditable(true);
	}

	public void back() {
		rpd.getarea().setText("");
		lc.delright();
	}
	

	public void loadcard() {
		this.process();
		lc.load();
	}
	public void addcard() {
		this.process();
		lc.addmsg();
	}
	
	public void addleftcard() {
		lc.addleft();
	}
	
	public void addrightcard() {
		lc.addright();
	}
	
	public void copy() {
		String newrecp = JOptionPane.showInputDialog(null, "Please enter a new Recipient");
		cgui.getTextField_2().setText(newrecp);
		JOptionPane.showConfirmDialog(cgui, "Please recreate");
	}
	
	public void deletemessage() {
		cgui.getTextArea().setText("");
		lc.delmsg();
	}
	
	public void pastemessage() {
		cgui.getTextArea().setText(s);
	}
	
	public void addmessage() {
		String t = cgui.getTextArea().getText();
		System.out.println(t);
		fpd.getarea().setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		fpd.getarea().setText(t);
	}
	
	
	public void addmessageleft() {
		String t = cgui.getTextArea().getText();
		System.out.println(t);
		lpd.getarea().setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
		lpd.getarea().setText(t);
		
	}
	public void addmessageright() {
		
		String t = cgui.getTextArea().getText();
		System.out.println(t);
		rpd.getarea().setFont(new Font("Times New Roman", Font.PLAIN, 24));
		rpd.getarea().setText(t);
	}
	public void loadcardfront() {
		lc.loadfront();
	}
	public void loadcardleft() {
		lc.loadleft();
		
	}
	public void loadcardright() {
		lc.loadright();
		
	}
	public void checkcard() {
		lc.load();
		
	}
	public void addphoto() {
		JPanel jp = fpd.getjp();
		if(cgui.getTextField().getText().equals("Birthday")) {
			System.out.println("undergoing");
			JLabel labelnew = new JLabel();
			
			
			EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	ImageIcon img = new ImageIcon("./src/entity/birthday.jpg");
				    	img.setImage(img.getImage().getScaledInstance(jp.getWidth(), jp.getHeight(),Image.SCALE_DEFAULT));
				    	labelnew.setIcon(img);
				    }
				});
			labelnew.setVisible(true);
			jp.add(labelnew);
			jp.setVisible(true);
		}
		
		fpd.getpanel().add(jp);
		fpd.setVisible(true);
		
	}
	public void addphotocard() {
		lc.addphoto();
		
	}
	public void loadcardphoto() {
		lc.loadphoto();
		
	}
	public void changephoto() {
		JPanel jp = fpd.getjp();
		if(cgui.getTextField().getText().equals("Birthday")) {
			System.out.println("undergoing");
			JLabel labelnew = new JLabel();
			EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	ImageIcon img = new ImageIcon("./src/entity/change.png");
				    	img.setImage(img.getImage().getScaledInstance(jp.getWidth(), jp.getHeight(),Image.SCALE_DEFAULT));
				    	labelnew.setIcon(img);
				    }
				});
			labelnew.setVisible(true);
			jp.add(labelnew);
			jp.setVisible(true);
		}
		fpd.getpanel().add(jp);
	}
	public void changephotocard() {
		lc.changephoto();
	}
	public void copyphoto() {
		lc.copy();

	}
	public void pastephoto() {
		lc.paste();
	}
	

}
