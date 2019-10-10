package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import boundry.CardGUI;
import boundry.FrontPageDisplay;
import boundry.InnerLeftPageDisplay;
import boundry.InnerRightPageDisplay;
import entity.Model;

public class LoadCard {
	
	CardGUI cgui;
	Model mod;
	WriteAndReadcsv wr = new WriteAndReadcsv();
	InnerLeftPageDisplay lpd;
	InnerRightPageDisplay rpd;
	FrontPageDisplay fpd;
	
	public Hashtable<String, String> getmsg() {
		return wr.gettable();
	}
	
	public LoadCard(CardGUI g, Model m) {
		this.cgui = g;
		this.mod = m;
	}
	
	
	public LoadCard(CardGUI g, Model m, InnerLeftPageDisplay l, InnerRightPageDisplay r, FrontPageDisplay f) {
		
		this.cgui = g;
		this.mod = m;
		this.lpd = l;
		this.rpd = r;
		this.fpd = f;
	}

	public void addmsg() {
		
		String key = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		String value = cgui.getTextArea().getText();
		wr.writeRecord(key,value,"cardRecord.csv");
		
		

	}
	
	public void addleft() {
		String key = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		String value = cgui.getTextArea().getText();
		wr.writeRecord(key,value,"leftRecord.csv");
	}
	public void addright() {
		String key = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		String value = cgui.getTextArea().getText();
		wr.writeRecord(key,value,"rightRecord.csv");
	}
	
	public void load() {
		String Term = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		boolean found = wr.checkreadRecord(Term); 
		if(found) {
			System.out.println("fount IT");
			cgui.getTextArea().setText(wr.getvalue(Term));	
			System.out.println("exist");
			}
	}
	
	public void loadfront() {
		String Term = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		boolean found = wr.checkreadRecord(Term);
		if(found) {
			fpd.getarea().setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			fpd.getarea().setText(wr.getvalue(Term));
			fpd.setVisible(true);
			}
	}
	public void loadleft() {

		String Term = cgui.getTextField_2().getText()+cgui.getTextField().getText();

		boolean foundleft = wr.checkreadleftRecord(Term);
		if(foundleft) {
			
			lpd.getarea().setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
			lpd.getarea().setText(wr.getleftvalue(Term));
			lpd.setVisible(true);
		}

	}
	public void loadright() {
		String Term = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		boolean foundright = wr.checkreadrightRecord(Term);
		if(foundright) {
			rpd.getarea().setFont(new Font("Times New Roman", Font.PLAIN, 24));
			rpd.getarea().setText(wr.getrightvalue(Term));
			rpd.setVisible(true);
		}
	}
	
	public void del() {
		Hashtable<String, String> hsb = wr.readRecord();
		hsb.remove(cgui.getTextField_2().getText()+cgui.getTextField().getText());
		System.out.println(hsb);
		String keys;
		String values;
		String filepath = "cardRecord.csv";

		if(hsb.isEmpty()) {
			wr.writeRecordnew("", "", filepath);
		}
		hsb.forEach((k,v) ->
			wr.writeRecordnew(k, v, filepath)
				);
		
	}
	public void delmsg() {
		Hashtable<String, String> hsb = wr.readRecord();
		hsb.put(cgui.getTextField_2().getText()+cgui.getTextField().getText(),"");
		System.out.println(hsb);
		String keys;
		String values;
		String filepath = "cardRecord.csv";

		if(hsb.isEmpty()) {
			wr.writeRecordnew("", "", filepath);
		}
		hsb.forEach((k,v) ->
			wr.writeRecordnew(k, v, filepath)
				);
		
	}

	public void delright() {
		Hashtable<String, String> hsb = wr.readrightRecord();
		hsb.put(cgui.getTextField_2().getText()+cgui.getTextField().getText(),"");
		System.out.println(hsb);
		String keys;
		String values;
		String filepath = "rightRecord.csv";

		if(hsb.isEmpty()) {
			wr.writeRecordnew("", "", filepath);
		}
		hsb.forEach((k,v) ->
			wr.writeRecordnew(k, v, filepath)
				);
		
	}

	public void addphoto() {
		String key = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		String value = "./src/entity/birthday.jpg";
		wr.writeRecord(key,value,"photoRecord.csv");
		
	}
	public void changephoto() {
		String key = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		String value = "./src/entity/change.png";
		wr.writeRecord(key,value,"photoRecord.csv");
	}
	public void loadphoto() {
		String Term = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		boolean foundright = wr.checkreadphotoRecord(Term);
		if(foundright) {
			JPanel jp = fpd.getjp();

			System.out.println("underGoing");
			JLabel labelnew = new JLabel();
				
				
			EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	System.out.println(wr.getphotoaddress(Term));
				    	ImageIcon img = new ImageIcon(wr.getphotoaddress(Term));
				    	
				    	img.setImage(img.getImage().getScaledInstance(jp.getWidth(), jp.getHeight(),Image.SCALE_DEFAULT));
				    	labelnew.setIcon(img);
				    }
				});
			labelnew.setVisible(true);
			jp.add(labelnew);
			jp.setVisible(true);
		
			fpd.getpanel().add(jp);
		}
	
	}

	public void copy() {
		String key = cgui.getTextField_2().getText()+cgui.getTextField().getText();
		System.out.print("running");
		String value = "./src/entity/birthday.jpg";
	
		wr.writeRecord("copyitem",value,"copyRecord.csv");
		
		
	}

	public void paste() {
		
		
		String path = wr.readcopyRecord();
			JPanel jp = fpd.getjp();

			System.out.println("undergoing");
			JLabel labelnew = new JLabel();
				
				
			EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	ImageIcon img = new ImageIcon(path);
				    	img.setImage(img.getImage().getScaledInstance(jp.getWidth(), jp.getHeight(),Image.SCALE_DEFAULT));
				    	labelnew.setIcon(img);
				    }
				});
			labelnew.setVisible(true);
			jp.add(labelnew);
			jp.setVisible(true);
		
			fpd.getpanel().add(jp);
			fpd.setVisible(true);
			String key = cgui.getTextField_2().getText()+cgui.getTextField().getText();
			String value = "./src/entity/birthday.jpg";
			wr.writeRecord(key,value,"photoRecord.csv");
		
	}


}
