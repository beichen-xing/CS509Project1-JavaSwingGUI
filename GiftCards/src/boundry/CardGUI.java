package boundry;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Model;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class CardGUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private frontpage fpanel;
	static Model mod;
	private JButton DelButton;
	private JPanel rightpage;
	private JButton Addmessage;
	private JLabel lblbeichen;
	private JLabel lblbeichen_1;
	private JLabel lblRecipient;
	private JTextField textField_2;
	private JTextArea textArea;
	private JButton btnLoad;
	private JButton btnAddcard;
	private JButton btnDuplicate;
	private JButton btnBack;
	private JButton btnPastemessage;
	private FrontPageDisplay fpd;
	static InnerLeftPageDisplay lpd;
	private JButton btnNewButton_1;
	static InnerRightPageDisplay rpd;
	private JButton btnCopyimage;
	private JButton btnLoadleft;
	private JButton btnLoadright;
	private JButton btnCheck;
	private JButton btnLoadwithphoto;
	private JButton btnChangephoto;

	public JPanel getJpanel() {
		return contentPane;
	}
	public JPanel getright() {
		return rightpage;
	}
	public frontpage getFront() {
		return fpanel;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JTextField getTextField_2() {
		return textField_2;
	}
	public JButton getDelButton() {
		return DelButton;
	}
	public JButton getAddmessage() {
		return Addmessage;
	}
	public JTextArea getTextArea() {
		return textArea;
	}

	
	
	public CardGUI(Model m) {
		setTitle("Preview");
		this.mod = m;
		this.fpd = new FrontPageDisplay();
		this.lpd = new InnerLeftPageDisplay();
		this.rpd = new InnerRightPageDisplay();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		fpanel = new frontpage(CardGUI.this);
		fpanel.setBounds(30, 32, 375, 136);
		fpanel.setBorder(BorderFactory.createEtchedBorder());
		
		rightpage = new JPanel();
		rightpage.setBounds(662, 32, 345, 136);
		rightpage.setBorder(BorderFactory.createEtchedBorder());
		
		
		textField = new JTextField();
		textField.setBounds(116, 194, 110, 21);
		textField.setColumns(10);
		
		
		DelButton = new JButton("Delete");
		DelButton.setBounds(966, 193, 99, 23);
		DelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,mod).del();
			}
		});
		
		Addmessage = new JButton("AddmessageFront");
		Addmessage.setBounds(601, 193, 212, 23);
		Addmessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,fpd,mod).addmessage();
				fpd.setVisible(true);
				new Model(CardGUI.this,mod).addcard();
			}
		});
		
		JLabel lblInputtype = new JLabel("Type");
		lblInputtype.setBounds(52, 196, 54, 15);
		
		JLabel lblFrontpage = new JLabel("Preview");
		lblFrontpage.setBounds(52, 11, 84, 15);
		
		JLabel lblInnerrightPage = new JLabel("Message");
		lblInnerrightPage.setBounds(662, 11, 151, 15);
		
		JPanel LeftPage = new JPanel();
		LeftPage.setBounds(52, 296, 366, 124);
		LeftPage.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel lblBackpage = new JLabel("Backpage");
		lblBackpage.setBounds(966, 418, 72, 15);
		
		JLabel lblInnerleftPage = new JLabel("InnerRight Page");
		lblInnerleftPage.setBounds(52, 430, 136, 15);
		
		lblRecipient = new JLabel("Recipient");
		lblRecipient.setBounds(12, 242, 94, 15);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 239, 110, 21);
		textField_2.setColumns(10);
		
		btnLoad = new JButton("Loadfront");
		btnLoad.setBounds(427, 19, 194, 23);
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Model(CardGUI.this,mod,lpd,rpd,fpd).loadcardfront();
			}
		});
		
		btnAddcard = new JButton("Create");
		btnAddcard.setBounds(236, 238, 99, 23);
		btnAddcard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new Model(CardGUI.this,mod).addcard();
			}
		});
		
		btnDuplicate = new JButton("Duplicate");
		btnDuplicate.setBounds(369, 238, 141, 23);
		btnDuplicate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Model(CardGUI.this,mod).copy();
			}
		});
		
		btnBack = new JButton("delmsg");
		btnBack.setBounds(848, 193, 93, 23);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,mod,lpd,rpd,fpd).back();
			}
		});
		
		
		btnPastemessage = new JButton("PasteImage");
		btnPastemessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Model(CardGUI.this,mod,lpd,rpd,fpd).pastephoto();
			}
		});
		btnPastemessage.setBounds(457, 389, 184, 23);
		btnPastemessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,mod).pastemessage();
			}
		});
		
		
		
		JPanel BackPage = new JPanel();
		BackPage.setBounds(682, 296, 356, 124);
		BackPage.setBorder(BorderFactory.createEtchedBorder());
		
		lblbeichen = new JLabel("@beichen");
		GroupLayout gl_LeftPage = new GroupLayout(LeftPage);
		gl_LeftPage.setHorizontalGroup(
			gl_LeftPage.createParallelGroup(Alignment.LEADING)
				.addGap(0, 362, Short.MAX_VALUE)
		);
		gl_LeftPage.setVerticalGroup(
			gl_LeftPage.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 164, Short.MAX_VALUE)
		);
		LeftPage.setLayout(gl_LeftPage);
		
		textArea = new JTextArea();
	
		lblbeichen_1 = new JLabel("@beichen");
		lblbeichen_1.setBounds(148, 95, 66, 15);
		
		
		
		
		GroupLayout gl_rightpage = new GroupLayout(rightpage);
		gl_rightpage.setHorizontalGroup(
			gl_rightpage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightpage.createSequentialGroup()
					.addGap(28)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_rightpage.setVerticalGroup(
			gl_rightpage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightpage.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		rightpage.setLayout(gl_rightpage);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.setBounds(236, 193, 99, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,mod).loadcard();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(lblFrontpage);
		contentPane.add(lblInnerrightPage);
		contentPane.add(LeftPage);
		contentPane.add(lblInputtype);
		contentPane.add(textField);
		contentPane.add(lblRecipient);
		contentPane.add(textField_2);
		contentPane.add(btnAddcard);
		contentPane.add(btnLoad);
		contentPane.add(fpanel);
		contentPane.add(btnBack);
		contentPane.add(DelButton);
		contentPane.add(btnDuplicate);
		contentPane.add(Addmessage);
		contentPane.add(btnPastemessage);
		contentPane.add(rightpage);
		contentPane.add(BackPage);
		BackPage.setLayout(null);
		BackPage.add(lblbeichen_1);
		contentPane.add(lblInnerleftPage);
		contentPane.add(lblBackpage);
		
		JButton btnCreateANew = new JButton("Create A new one");
		btnCreateANew.setBounds(457, 276, 177, 23);
		btnCreateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Model(CardGUI.this,fpd,mod).addphoto();
				fpd.setVisible(true);
				new Model(CardGUI.this,mod).addphotocard();

			}
		});
		contentPane.add(btnCreateANew);
		
		JButton btnAddmessageinnerleft = new JButton("AddmessageInnerLeft");
		btnAddmessageinnerleft.setBounds(611, 238, 205, 23);
		btnAddmessageinnerleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,lpd,mod).addmessageleft();
				lpd.setVisible(true);
				new Model(CardGUI.this,mod).addleftcard();
			}
		});
		contentPane.add(btnAddmessageinnerleft);
		
		btnNewButton_1 = new JButton("AddmessageInnerRight");
		btnNewButton_1.setBounds(848, 238, 212, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,rpd,mod).addmessageright();
				rpd.setVisible(true);
				new Model(CardGUI.this,mod).addrightcard();
			}
		});
		contentPane.add(btnNewButton_1);
		
		btnCopyimage = new JButton("copyImage");
		btnCopyimage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Model(CardGUI.this,mod,lpd,rpd,fpd).copyphoto();
			}
		});
		btnCopyimage.setBounds(457, 354, 177, 23);
		contentPane.add(btnCopyimage);
		
		btnLoadleft = new JButton("Loadleft");
		btnLoadleft.setBounds(427, 54, 194, 23);

		btnLoadleft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Model(CardGUI.this,mod,lpd,rpd,fpd).loadcardleft();
			}
		});
		contentPane.add(btnLoadleft);
		
		btnLoadright = new JButton("Loadright");
		btnLoadright.setBounds(427, 89, 194, 23);
		btnLoadright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,mod,lpd,rpd,fpd).loadcardright();
				
			}
		});
		contentPane.add(btnLoadright);
		
		btnCheck = new JButton("check");
		btnCheck.setBounds(359, 193, 151, 23);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Model(CardGUI.this,mod).checkcard();
			}
		});
		contentPane.add(btnCheck);
		
		btnLoadwithphoto = new JButton("loadwithjpg");
		btnLoadwithphoto.setBounds(427, 124, 194, 23);
		btnLoadwithphoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Model(CardGUI.this,mod,lpd,rpd,fpd).loadcardphoto();
				fpd.setVisible(true);
				
			}
			
		});
		contentPane.add(btnLoadwithphoto);
		
		btnChangephoto = new JButton("changePhoto");
		btnChangephoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				new Model(CardGUI.this,fpd,mod).changephoto();
				new Model(CardGUI.this,mod).changephotocard();
			}
		});
		btnChangephoto.setBounds(457, 317, 177, 25);
		contentPane.add(btnChangephoto);
		
	}
}
