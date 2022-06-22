package presontation.lowerAdmine;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;

public class InformationLower extends Dialog implements WindowListener, ActionListener {

	   BufferedImage b1;
	   Button updating_data ;
	   Button search_information ;
	   Button viewTheUsers ;
	
	   public InformationLower(Frame owner, String title, boolean modal){
		   super(owner, title, modal);
	      prepareGUI();
	   }

	   private void prepareGUI(){
		   setSize(1000,550);
		   setLocation(250,100);
		   Image icon =Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\indexCompetence.jpg");
	       setIconImage(icon);
		   setLayout(null);
		  
		   try {
				b1= ImageIO.read(new File("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\indexCompetence.jpg"));
			}
			catch(IOException ex) {
				
			}
		  
	        addWindowListener(new WindowAdapter() {
	        	public void windowClosing(WindowEvent windowEvent){
	        		System.exit(0);
	        	}        
	        });    
	     
		    updating_data = new Button     ("Updating Data");
		    search_information = new Button ("Search Information");
		    viewTheUsers = new Button ("view The Users");
		    
			updating_data.setBackground(new Color(13,108,140));
		    updating_data.setForeground(Color.white);
		    search_information.setBackground(new Color(13,108,140));
		    search_information.setForeground(Color.white);
		    viewTheUsers.setBackground(new Color(13,108,140));
		    viewTheUsers.setForeground(Color.white);
		    
			updating_data.setActionCommand("updating_data");
			search_information.setActionCommand("search_information");
			viewTheUsers.setActionCommand("viewTheUsers");
		
			updating_data.setBounds(270,250,500,40);
			search_information.setBounds(270,300,500,40);
			viewTheUsers.setBounds(270,350,500,40);
			
			add(updating_data);
			add(search_information);
			add(viewTheUsers);
			
			addWindowListener(this);
			search_information.addActionListener(this);
			updating_data.addActionListener( this);
			viewTheUsers.addActionListener( this);
			setVisible(true);  
	 
	   }
   
	   @Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(b1,0,0,getWidth(),getHeight(),null);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == updating_data) {
				Updatedata  Updatedata = new Updatedata(null, null, false);
			}
			
			if(e.getSource() == search_information){
				SearchInformationLower  SearchInformationSenior = new SearchInformationLower();
				
			}
			if(e.getSource() == viewTheUsers){
				ViewTheUsersLower  viewTheUsersSeniora = new ViewTheUsersLower();
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
		}