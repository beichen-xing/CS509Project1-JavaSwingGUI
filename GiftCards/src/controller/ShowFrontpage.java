package controller;

import javax.swing.JPanel;

import boundry.CardGUI;
import boundry.frontpage;

public class ShowFrontpage{
	
	frontpage fp;
	CardGUI cgui;
	
	public ShowFrontpage(CardGUI g) {
		cgui = g;
		fp = new frontpage(g);
	}
	

	public void choosephoto(){
		String letter = cgui.getTextField().getText();
		System.out.println(letter);
		
		if(letter.equals("Birthday")) {
			fp.frontpagebirth();
		}
		
	}


}
