package presontation.seniorAdmine;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;

import dao.Model;
import presontation.Index;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SniorLogin extends Dialog implements WindowListener, ActionListener {	
	
		Label titleJLabel;
		Label emailJLabel;
		Label PasswordJLabel;
		TextField email;
		TextField Password;
		BufferedImage b1;
		Button ok ;
		Button cancel;
		public SniorLogin(Frame owner, String title, boolean modal) {
		super(owner, title, modal); 
		setResizable(false);
		Image icon =Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\indexCompetence.jpg");
		setIconImage(icon);
		setSize(900,500);
		setLocation(270,120);
		setLayout(null);
		
		try {
			b1= ImageIO.read(new File("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\loginbAC.png"));
		}
		catch(IOException ex) {
			
		}
		
		titleJLabel = new Label("Login");
		emailJLabel = new Label("Email");
		PasswordJLabel = new Label("Password");
		
		email = new TextField();
		Password = new TextField();
		
		 ok = new Button ("ok");
		 cancel = new Button ("cancel");
		
		ok.setBackground(new Color(40,92,52));
		ok.setForeground(new Color(19,44,61));
		cancel.setBackground(new Color(122,23,66));
		cancel.setForeground(new Color(19,44,61));
		titleJLabel.setBackground(new Color(19,44,61));
		titleJLabel.setForeground(Color.white);
		
		emailJLabel.setBackground(new Color(193,219,227));
		emailJLabel.setForeground(new Color(19,44,61));
		PasswordJLabel.setBackground(new Color(193,219,227));
		PasswordJLabel.setForeground(new Color(19,44,61));
		
		email.setBackground(new Color(193,219,227));
		email.setForeground(new Color(19,44,61));
		Password.setBackground(new Color(193,219,227));
		Password.setForeground(new Color(19,44,61));
		
		ok.setActionCommand("ok");
		cancel.setActionCommand("cancel");
		
		titleJLabel.setBounds(90,30,800,35);
		
		emailJLabel.setBounds(180,160,220,25);
		PasswordJLabel.setBounds(180,200,220,25);
		
		email.setBounds(420,160,200,25);
		Password.setBounds(420,200,200,25);
		
		ok.setBounds(180,260,100,30);
		cancel.setBounds(300,260,100,30);
		
		add(titleJLabel);
		add(emailJLabel);
		add(PasswordJLabel);
		
		add(email);
		add(Password);
		
		add(ok);
		add(cancel);
		
		addWindowListener(this);
		cancel.addActionListener(this);
		ok.addActionListener( this);
	}
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(b1,0,0,getWidth(),getHeight(),null);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Model conx =new Model();
		if(e.getSource() == ok ) {
			conx.selectAdminSenior( email, Password);
			if(conx.getSelectemailSenior() != null &&  conx.getSelectpasswordSenior() != null) {
				//System.out.println("email>>>"+conx.getSelectemailSenior());
				//System.out.println("email>>>"+conx.getSelectpasswordSenior());
				InformationSeniorAdmin informationSeniorAdmin =new InformationSeniorAdmin(null, null, true);
				
			}
			else {
				JOptionPane.showMessageDialog(null,"The information is incorrect");
				Index index = new Index(null, null, false);
			}
			
		}
		
		if(e.getSource() == cancel){
			Index index= new Index(null, null, false);
		}
		setVisible(false);	
	}
	@Override
	public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
	}
	@Override
	public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	
	}
	@Override
	public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
	}
	@Override
	public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
	}
	@Override
	public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
	}
	static boolean isValid(String email) {
	  String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	  return email.matches(regex);
	}
}

