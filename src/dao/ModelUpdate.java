package dao;
import java.awt.TextField;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class ModelUpdate {
	
	private static String  datebase ="jdbc:mysql://localhost:3306/competencecenter";
	private static String  username ="root";
	private static String  password ="";
	
     	public ModelUpdate() {}
	         
         public void updateEmail(String wEBSITE, String itemsemail) {
        	   try{
 	            	Class.forName("com.mysql.cj.jdbc.Driver");
 	            	Connection cnx = DriverManager.getConnection(datebase,username,password);
 	 		        java.sql.Statement stmt = cnx.createStatement();
            	    String sql2 ="UPDATE `informatique` SET `email`='"+itemsemail+"'  WHERE `site_web`='"+wEBSITE+"';";
 		            stmt.executeUpdate(sql2);
     		               
                 }catch(Exception e1) {
                     	System.out.println("");
          	    }
            	 
         }

		public void updateTeleFixe(String wEBSITE, Map<String, String> itemsFixe) {
		     Set<String> printTeleFixe = new HashSet<String>();
		     String TeleFixe = null;
			 for(Map.Entry<String, String> entry : itemsFixe.entrySet()) {
	    		 TeleFixe =  entry.getKey();
	    		 printTeleFixe.add(TeleFixe);
        		 try{
 	            	Class.forName("com.mysql.cj.jdbc.Driver");
 	            	Connection cnx = DriverManager.getConnection(datebase,username,password);
 	 		        java.sql.Statement stmt = cnx.createStatement();
 	 		        String sql2 ="UPDATE `informatique` SET `tele_fix`='"+printTeleFixe+"' WHERE `site_web`='"+wEBSITE+"';";
 		            stmt.executeUpdate(sql2);    
                 }catch(Exception e1) {
                 	System.out.println("");
                 }
	    	 }
		}

		public void updateTeleMobile(String wEBSITE, Map<String, String> itemsMobile) {
			Set<String> printTeleMobile = new HashSet<String>();
			String TeleMobile = null;
			for(Map.Entry<String, String> entry : itemsMobile.entrySet()) {
	    		 TeleMobile =  entry.getKey();
	    		 //System.out.println("Ke tele Mobile : "+TeleMobile);
	    		 printTeleMobile.add(TeleMobile);
	    		 //System.out.println("Add tele Mobile : "+printTeleMobile);
	    		 //TeleMobile =  null;
	    		 //System.out.println("Ke tele Mobile : "+TeleMobile);
	    		 // printTeleMobile.remove(TeleMobile);
	    		 //System.out.println("1>>>>>>>>>> : "+TeleMobile);
	    		 try{
 	            	Class.forName("com.mysql.cj.jdbc.Driver");
 	            	Connection cnx = DriverManager.getConnection(datebase,username,password);
 	 		        java.sql.Statement stmt = cnx.createStatement();
 	                String sql2 ="UPDATE `informatique` SET `tele_mobile`='"+printTeleMobile+"' WHERE `site_web`='"+wEBSITE+"';";
 		            stmt.executeUpdate(sql2);
                     }catch(Exception e1) {
                     	System.out.println("");
          	    }
	    	 }
		}
			
		public void updateTeleTitle(String wEBSITE, String title) {
			try{
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	Connection cnx = DriverManager.getConnection(datebase,username,password);
 		        java.sql.Statement stmt = cnx.createStatement();
 		        String sql2 ="UPDATE `informatique` SET `nome_entre`='"+title+"' WHERE `site_web`='"+wEBSITE+"';";
	            stmt.executeUpdate(sql2);
	         }catch(Exception e1) {
	        	 System.out.println("");
      	    }
		}
}
