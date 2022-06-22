package presontation.seniorAdmine;


import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;

import dao.Model;

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

public class AdministratorRegistration extends Dialog implements WindowListener, ActionListener {
	
	BufferedImage b1;
	Label NomAJLabel;
	Label PrenomAJLabel;
	Label emailJLabel;
	Label PasswordJLabel;
	Label ConfPasswordJLabel;
	TextField NomA ;
	TextField PrenomA  ;
	TextField email ;
	TextField Password ;
	TextField ConfPassword ;
	JLabel labelt;
	Button ok ;
	Button cancel;
	
	
	public AdministratorRegistration(Frame owner, String title, boolean modal) {
		super(owner, title, modal); 
		setResizable(false);
		Image icon =Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\indexCompetence.jpg");
		setIconImage(icon);
		setSize(900,500);
		setLocation(270,120);
		setLayout(null);
		
		try {
			b1= ImageIO.read(new File("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\administratorimage.png"));
		}
		catch(IOException ex) {
			
		}
		//setVisble(true);
		   
		NomAJLabel = new Label("Name");
		PrenomAJLabel = new Label("First Name");
		emailJLabel = new Label("Email");
		PasswordJLabel = new Label("Password");
		ConfPasswordJLabel = new Label("Conformation Password");
		
		
		
		
		NomA = new TextField();
		PrenomA = new TextField();
		email = new TextField();
		Password = new TextField();
		ConfPassword = new TextField();
		
		
		
		 ok = new Button ("ok");
		 cancel = new Button ("cancel");
		
		 ok.setBackground(new Color(40,92,52));
		 ok.setForeground(new Color(19,44,61));
		 cancel.setBackground(new Color(122,23,66));
		 cancel.setForeground(new Color(19,44,61));
		 emailJLabel.setBackground(new Color(193,219,227));
		 emailJLabel.setForeground(new Color(19,44,61));
		 PasswordJLabel.setBackground(new Color(193,219,227));
		 PasswordJLabel.setForeground(new Color(19,44,61));
		 NomAJLabel.setBackground(new Color(193,219,227));
		 NomAJLabel.setForeground(new Color(19,44,61));
		 PrenomAJLabel.setBackground(new Color(193,219,227));
		 PrenomAJLabel.setForeground(new Color(19,44,61));
		 ConfPasswordJLabel.setBackground(new Color(193,219,227));
		 ConfPasswordJLabel.setForeground(new Color(19,44,61));
		
		 email.setBackground(new Color(193,219,227));
		 email.setForeground(new Color(19,44,61));
		 Password.setBackground(new Color(193,219,227));
		 Password.setForeground(new Color(19,44,61));
		 NomA.setBackground(new Color(193,219,227));
		 NomA.setForeground(new Color(19,44,61));
		 PrenomA.setBackground(new Color(193,219,227));
		 PrenomA.setForeground(new Color(19,44,61));
		 ConfPassword.setBackground(new Color(193,219,227));
		 ConfPassword.setForeground(new Color(19,44,61));
		
		ok.setActionCommand("ok");
		cancel.setActionCommand("cancel");
		
		NomAJLabel.setBounds(270,170,200,25);
		PrenomAJLabel.setBounds(270,210,200,25);
		emailJLabel.setBounds(270,250,200,25);
		PasswordJLabel.setBounds(270,290,200,25);
		ConfPasswordJLabel.setBounds(270,330,200,25);
		
		NomA.setBounds(500,170,200,25);
		PrenomA.setBounds(500,210,200,25);
		email.setBounds(500,250,200,25);
		Password.setBounds(500,290,200,25);
		ConfPassword.setBounds(500,330,200,25);
		
		ok.setBounds(270,380,90,30);
		cancel.setBounds(380,380,90,30);
		
		add(NomAJLabel); 
		add(PrenomAJLabel);
		add(emailJLabel);
		add(PasswordJLabel);
		add(ConfPasswordJLabel);
		
		add(NomA); 
		add(PrenomA);
		add(email);
		add(Password);
		add(ConfPassword);
		
		add(ok);
		add(cancel);
		addWindowListener(this);
		cancel.addActionListener(this);
		ok.addActionListener( this);
		setVisible(true);  
	}
	
	private void prepareGUI(){
	
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
		System.out.println("NomA.getText()  "+NomA.getText() );
		if(email.getText() != null && Password.getText() != null  && ConfPassword.getText() != null && NomA.getText() != null && PrenomA.getText() != null && isValid(email.getText()) && Password.getText().equals(ConfPassword.getText()) && ConfPassword.getText().equals(Password.getText())) {
			JOptionPane.showMessageDialog(null,"Add admin successfully");
			conx.insertAdmin(NomA, PrenomA, email, Password, ConfPassword);
		}
		else if( email.getText() == null && Password.getText() == null  && ConfPassword.getText() == null && NomA.getText() == null && PrenomA.getText() == null ) {
			JOptionPane.showMessageDialog(null,"Error, fill in the data");
		}
		
		else if(!isValid(email.getText())) {
			JOptionPane.showMessageDialog(null,"Error in email");
		}
		else {
			JOptionPane.showMessageDialog(null,"Error");
		}
		InformationSeniorAdmin information = new InformationSeniorAdmin(null, null, false);
	}
	
	if(e.getSource() == cancel){
		InformationSeniorAdmin information = new InformationSeniorAdmin(null, null, false);
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