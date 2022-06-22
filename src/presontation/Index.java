package presontation;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presontation.lowerAdmine.LowerLogin;
import presontation.seniorAdmine.SniorLogin;


public class Index extends Dialog implements WindowListener, ActionListener {

  BufferedImage b1;
  Button administrator_registration ;
  Button login ;

   public Index(Frame owner, String title, boolean modal){
	   super(owner, title, modal);
       prepareGUI();
   }

   private void prepareGUI(){
      Image icon =Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\indexCompetence.jpg");
      setIconImage(icon);
      setSize(1000,550);
      setLocation(250,100);
      setLayout(null);
      try{
			b1= ImageIO.read(new File("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\indexCompetence.jpg"));
	  }
	  catch(IOException ex) {}
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      
      administrator_registration = new Button("SENIOR ADMINISTRATOR");
      login = new Button ("LOWER ADMINISTRATOR");
      
	  administrator_registration.setBackground(new Color(13,108,140));
      administrator_registration.setForeground(Color.white);
      
      
      login.setBackground(new Color(13,108,140));
      login.setForeground(Color.white);
      
	  administrator_registration.setActionCommand("administrator_registration");
	  login.setActionCommand("login");
	
	  administrator_registration.setBounds(270,300,500,40);
	  login.setBounds(270,350,500,40);
	  
      add(administrator_registration);
      
	  add(login);
	  addWindowListener(this);
	  login.addActionListener(this);
	  administrator_registration.addActionListener( this);
	  setVisible(true);
    }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == administrator_registration) {
				SniorLogin  sniorLogin = new SniorLogin(null,"Competence Center",true);
				sniorLogin.setVisible(true);
			}
			
			if(e.getSource() == login){
				LowerLogin LowerLogin =new LowerLogin(null,"Competence Center",true);
				LowerLogin.setVisible(true);
			}
			setVisible(false);
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(b1,0,0,getWidth(),getHeight(),null);
			
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
		}