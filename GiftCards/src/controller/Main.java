package controller;

import java.awt.EventQueue;

import boundry.CardGUI;
import entity.Model;


public class Main {
	
	static Model mod;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardGUI frame = new CardGUI(mod);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
