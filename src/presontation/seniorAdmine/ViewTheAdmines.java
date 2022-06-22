package presontation.seniorAdmine;


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

import dao.Model;


public class ViewTheAdmines  {
	
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
	Label EnterId;
	Button ok ;
	TextField idTextField;
	Button delete ;
    Panel p;
    Button returning ;
	TextField l1 =null,l2=null,l3=null,l4=null,l5=null,l6=null ;
	Button login ;
	JFrame frame;
	 ViewTheAdmines(){
    	frame = new JFrame("ViewTheAdmines");
        p = new Panel();
        Color c = new Color(241, 216, 252);
        frame.setSize(1000,550);
        frame.setLocation(250,100);
        frame.getContentPane().setLayout(null);
        frame.setDefaultLookAndFeelDecorated(true);
        
        
        titleL = new Label("The Admins");
        idTextField = new TextField();
        ok = new Button ("DELETE");
       
        titleJLabel1 = new Label("Id");
        titleJLabel2 = new Label("Nom Admine");
        titleJLabel3 = new Label("Prenom Admine");
        titleJLabel4 = new Label("Email");
        titleJLabel5 = new Label("Password");
        titleJLabel6 = new Label("Conf Password");
        EnterId = new Label("Enter Id");
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/competencecenter","root","");
            
            PreparedStatement ps = con.prepareStatement("select * from admine;");
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
                System.out.println(l1+""+l2+""+l3+""+l4+""+l5+""+l6);
                 login = new Button("login");
                delete = new Button("delete");   
               
                delete.setSize(70,20);
                delete.setActionCommand("delete");
                login.setActionCommand("login");
                p.add(l1);p.add(l2);p.add(l3);p.add(l4);p.add(l5);p.add(l6);
               
                p.setLayout(new GridLayout(row,8));
                row++;
            }
            
            returning = new Button("returning");
            ok.addActionListener(new MyActionListener ());
            returning.addActionListener(new MyActionListener ());
            titleL.setForeground(new Color(47,93,201));
           
            titleL.setBounds(500,60,166,20);
            frame.add(titleL);
            
            ok.setBackground(new Color(40,92,52));
   		 	ok.setForeground(new Color(19,44,61));
   		    returning.setBackground(new Color(122,23,66));
		    returning.setForeground(Color.white);
            
            titleJLabel1.setBounds(120,168,153,35);
            titleJLabel1.setBackground(new Color(13,108,140));
            titleJLabel1.setForeground(Color.white);
            
            titleJLabel2.setBounds(274,168,153,35);
            titleJLabel2.setBackground(new Color(13,108,140));
            titleJLabel2.setForeground(Color.white);
            
            titleJLabel3.setBounds(428,168,153,35);
            titleJLabel3.setBackground(new Color(13,108,140));
            titleJLabel3.setForeground(Color.white);
            
            titleJLabel4.setBounds(582,168,153,35);
            titleJLabel4.setBackground(new Color(13,108,140));
            titleJLabel4.setForeground(Color.white);
            
            titleJLabel5.setBounds(736,168,151,35);
            titleJLabel5.setBackground(new Color(13,108,140));
            titleJLabel5.setForeground(Color.white);
            
            titleJLabel6.setBounds(888,168,150,35);
            titleJLabel6.setBackground(new Color(13,108,140));
            titleJLabel6.setForeground(Color.white);
            
            EnterId.setBounds(10,110,50,35);
            EnterId.setForeground(new Color(54,32,32));
            
            idTextField.setBounds(120,110,153,35);
            idTextField.setBackground(new Color(193,219,227));
            idTextField.setForeground(new Color(19,44,61));
            
            
            
            ok.setBounds(290,110,90,35);
            returning.setBounds(390,110,90,35);
            
            frame.add(titleJLabel1);
            frame.add(titleJLabel2);
            frame.add(titleJLabel3);
            frame.add(titleJLabel4);
            frame.add(titleJLabel5);
            frame.add(titleJLabel6);
            frame.add(EnterId);
            frame.add(idTextField); 
            frame.add(ok);
            frame.add(returning);
            p.setBackground(Color.white);
            p.setBounds(120,200,920,350);
            frame.add(p);
            
            frame.setLayout(null);
            frame.setVisible(true);
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
        	if(e.getSource() == ok ) {
 				Model conx = new Model();
 				conx.DeleteAdmin(idTextField);

 			}
        	else if(e.getSource() == returning ) {
        		InformationSeniorAdmin information = new InformationSeniorAdmin(null, null, false);

 			}
        	frame.setVisible(false); 
        }
			
		}
	
}