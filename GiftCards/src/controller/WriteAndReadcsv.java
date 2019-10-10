package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class WriteAndReadcsv {

	String key = "";
	String value = "";
	String res = "";
	Hashtable<String, String> message;
	Hashtable<String, String> leftmessage;
	Hashtable<String, String> rightmessage;
	Hashtable<String, String> photomessage;
	Hashtable<String, String> copymessage;
	public void writeRecord(String key, String value, String filepath)
	{
		try {
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(key+","+value);
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void writeRecordnew(String key, String value, String filepath)
	{
		try {
			FileWriter fw = new FileWriter(filepath,false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			if(key != null)
				pw.println(key+","+value);
			if(key == null)
				pw.println("");
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public Hashtable<String,String> readRecord() {
		message = new Hashtable<>();
		try {
			Scanner x = new Scanner(new File("cardRecord.csv"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				key = x.next();
				value = x.next();
				message.put(key, value);
			}}catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		return message;
	}
	
	public Hashtable<String,String> readleftRecord() {
		leftmessage = new Hashtable<>();
		try {
			Scanner x = new Scanner(new File("leftRecord.csv"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				key = x.next();
				value = x.next();
				leftmessage.put(key, value);
			}}catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		return leftmessage;
	}
	
	public Hashtable<String,String> readrightRecord() {
		rightmessage = new Hashtable<>();
		try {
			Scanner x = new Scanner(new File("rightRecord.csv"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				key = x.next();
				value = x.next();
				rightmessage.put(key, value);
			}}catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		return rightmessage;
	}
	
	public boolean checkreadRecord(String searchTerm) {
		
		boolean found = false;
		message = new Hashtable<>();
		try {
			Scanner x = new Scanner(new File("cardRecord.csv"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				key = x.next();
				value = x.next();
				message.put(key, value);
			}
			found = message.containsKey(searchTerm);

			if(!found) {
				JOptionPane.showConfirmDialog(null, "No Record");
			}	
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return found;
				
	}
	
	public boolean checkreadleftRecord(String searchTerm) {

		boolean foundleft = false;
		leftmessage = new Hashtable<>();
		try {
			Scanner x = new Scanner(new File("leftRecord.csv"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				key = x.next();
				value = x.next();
				leftmessage.put(key, value);
			}
			foundleft = leftmessage.containsKey(searchTerm);
			
			if(!foundleft) {
				JOptionPane.showConfirmDialog(null, "No Record");
			}	
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return foundleft;
				
	}
	public boolean checkreadrightRecord(String searchTerm) {
		boolean foundright = false;
		rightmessage = new Hashtable<>();
		try {
			Scanner x = new Scanner(new File("rightRecord.csv"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				key = x.next();
				value = x.next();
				rightmessage.put(key, value);
			}
			foundright = rightmessage.containsKey(searchTerm);

			if(!foundright) {
				JOptionPane.showConfirmDialog(null, "No Record");
			}	
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return foundright;
	}
	
	
	
	public String getvalue(String k) {
		return message.get(k);
	}
	
	public String getleftvalue(String k) {
		System.out.println(leftmessage);
		System.out.println(leftmessage.get(k));
		return leftmessage.get(k);
		
	}
	public String getrightvalue(String k) {
		return rightmessage.get(k);
	}
	public Hashtable<String, String> gettable(){
		this.readRecord();
		System.out.println(message);
		return message;
		
	}
	public boolean checkreadphotoRecord(String term) {
		boolean foundright = false;
		photomessage = new Hashtable<>();
		try {
			Scanner x = new Scanner(new File("photoRecord.csv"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				key = x.next();
				value = x.next();
				photomessage.put(key, value);
			}
			foundright = photomessage.containsKey(term);

			if(!foundright) {
				JOptionPane.showConfirmDialog(null, "No Record");
			}	
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return foundright;
	}
	public String readcopyRecord() {
		copymessage = new Hashtable<>();
		try {
			Scanner x = new Scanner(new File("copyRecord.csv"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				key = x.next();
				value = x.next();
				copymessage.put(key, value);
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return copymessage.get(key);
	}
	public String getphotoaddress(String term) {
		return photomessage.get(term);
	}

	
}
