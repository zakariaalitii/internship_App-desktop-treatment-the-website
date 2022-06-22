package presontation.lowerAdmine;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ViewTheUsersLower  {
	Label titleL;
	Label titleJLabel1;
	Label titleJLabel2;
	Label titleJLabel3;
	Label titleJLabel4;
	Label titleJLabel5;
	Label titleJLabel6;
	Label titleJLabel7;
	Label titleJLabel8;
	Label titleJLabel9;
	 Button delete ;
	 Panel p;
	 Button returning ;
	 TextField l1 =null,l2=null,l3=null,l4=null,l5=null,l6=null,l7=null ;
	 Button login ;
	 JFrame frame ;
	 
	 ViewTheUsersLower(){
        frame = new JFrame("ViewTheUsers");
        p = new Panel();
        Color c = new Color(241, 216, 252);
        frame.setSize(1000,550);
        frame.setLocation(250,100);
        frame.getContentPane().setLayout(null);
        
        
        titleL = new Label("The Users");
       
        titleJLabel1 = new Label("Id");
        titleJLabel2 = new Label("CIN");
        titleJLabel3 = new Label("CNE");
        titleJLabel4 = new Label("Email");
        titleJLabel5 = new Label("first_name");
        titleJLabel6 = new Label("last_name");
        titleJLabel7 = new Label("password");
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/competencecenter","root","");
            
            PreparedStatement ps = con.prepareStatement("select * from user;");
            ResultSet rs = ps.executeQuery();
            
            
            int row=1;
            while(rs.next()) {
                
                l1 = new TextField();
                l1.setText(rs.getString(1));
                l2 = new TextField();
                l2.setText(rs.getString(2));
                l3 = new TextField();
                l3.setText(rs.getString(3));
                l4 = new TextField();
                l4.setText(rs.getString(4));
                l5 = new TextField();
                l5.setText(rs.getString(5));
                l6 = new TextField();
                l6.setText(rs.getString(6));
                l7 = new TextField();
                l7.setText(rs.getString(7));
                System.out.println(l1+""+l2+""+l3+""+l4+""+l5+""+l6+""+l7);
                 login = new Button("login");
                delete = new Button("delete");   
               
                delete.setSize(70,20);
                delete.setActionCommand("delete");
                login.setActionCommand("login");
                p.add(l1);p.add(l2);p.add(l3);p.add(l4);p.add(l5);p.add(l6);p.add(l7);
               
                p.setLayout(new GridLayout(row,8));
                row++;
            }
            
            returning = new Button("returning");
            returning.addActionListener(new MyActionListener ());
            titleL.setForeground(new Color(47,93,201));
           
            titleL.setBounds(500,60,166,20);
            frame.add(titleL);
   		    returning.setBackground(new Color(122,23,66));
		    returning.setForeground(Color.white);
            
            titleJLabel1.setBounds(10,160,138,35);
            titleJLabel1.setBackground(new Color(13,108,140));
            titleJLabel1.setForeground(Color.white);
            
            titleJLabel2.setBounds(146,160,138,35);
            titleJLabel2.setBackground(new Color(13,108,140));
            titleJLabel2.setForeground(Color.white);
            
            titleJLabel3.setBounds(283,160,138,35);
            titleJLabel3.setBackground(new Color(13,108,140));
            titleJLabel3.setForeground(Color.white);
            
            titleJLabel4.setBounds(420,160,138,35);
            titleJLabel4.setBackground(new Color(13,108,140));
            titleJLabel4.setForeground(Color.white);
            
            titleJLabel5.setBounds(557,160,138,35);
            titleJLabel5.setBackground(new Color(13,108,140));
            titleJLabel5.setForeground(Color.white);
            
            titleJLabel6.setBounds(695,160,138,35);
            titleJLabel6.setBackground(new Color(13,108,140));
            titleJLabel6.setForeground(Color.white);
            
            titleJLabel7.setBounds(832,160,138,35);
            titleJLabel7.setBackground(new Color(13,108,140));
            titleJLabel7.setForeground(Color.white);
            
            
            
            returning.setBounds(10,110,100,35);
            
            frame.add(titleJLabel1);
            frame.add(titleJLabel2);
            frame.add(titleJLabel3);
            frame.add(titleJLabel4);
            frame.add(titleJLabel5);
            frame.add(titleJLabel6);
            frame.add(titleJLabel7);
            frame.add(returning);
            p.setBackground(Color.white);
            p.setBounds(10,194,960,350);
            frame.add(p);
            
            frame.setLayout(null);
            frame.setTitle("View The Admines");
            frame.setBackground(c);
            frame.setVisible(true); 
            frame.show();
            
        }catch(Exception e) {
            System.out.println(e);
        }   
    }
	 private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
        	 if(e.getSource() == returning ) {
        		 InformationLower information = new InformationLower(null, null, false);
 			}
        	 frame.setVisible(false); 
        }
	}
	
}
