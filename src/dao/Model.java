package dao;
import java.awt.TextField;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Set;

import javax.swing.JOptionPane;

import metier.RetrieveData;

public class Model {
	
	private static String  datebase ="jdbc:mysql://localhost:3306/competencecenter";
	private static String  username ="root";
	private static String  password ="";
	
	private String AddrOut;
	
	String selectemail;
	String selectpassword;
	
	String selectemailSenior;
	String selectpasswordSenior;
	
	RetrieveData jsoupCrwler = new RetrieveData();
	
    public Model() {}
 
    public void insertSite( String cellValue, String categorie) {
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnx = DriverManager.getConnection(datebase,username,password);
			java.sql.Statement stmt = cnx.createStatement();
			String sql2 ="Insert Into "+categorie+" (site_web, categorie, email, tele_fix, tele_mobile, nome_entre, pdf, pdfl) values ('"+cellValue+"','"+categorie+"',\"\", \"\", \"\", \"\", \"\", \"\");";
			stmt.executeUpdate(sql2);

    	}catch(Exception e1) {
    		System.out.println("");
    	}
     }
 
    public void SelectedIndexNom() {
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnx = DriverManager.getConnection(datebase,username,password);
			java.sql.Statement stmt = cnx.createStatement();
			String query = "SELECT site_web FROM informatique";
		    ResultSet rs = stmt.executeQuery(query);
			   
		     while (rs.next()) {
		    	 String SiteWeb = rs.getString("site_web");
		    	 jsoupCrwler.printItems(SiteWeb);
		     }
    	}catch(Exception e) {
    		System.out.println("");
    	}
    }
 
    public void insertAdmin( TextField nomA, TextField prenomA, TextField email, TextField password2, TextField confPassword) {
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnx = DriverManager.getConnection(datebase,username,password);
			java.sql.Statement stmt = cnx.createStatement();
			String sql2 ="Insert Into admine (NomA, PrenomA, email, Password, ConfPassword) values ('"+nomA.getText()+"','"+prenomA.getText()+"','"+email.getText()+"','"+password2.getText()+"','"+confPassword.getText()+"');";
			stmt.executeUpdate(sql2);

    	}catch(Exception e1) {
				JOptionPane.showMessageDialog(null,"Duplicate of the field for the email key");
	 	}
    }

    public void selectAdmin(TextField email, TextField password2) {
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnx = DriverManager.getConnection(datebase,username,password);
			java.sql.Statement stmt = cnx.createStatement();
			String query = "SELECT email, password FROM `admine` WHERE email='"+email.getText()+"' and password='"+password2.getText()+"';";
			ResultSet rs = stmt.executeQuery(query);
 
			while (rs.next()) {
				 selectemail = rs.getString("email");
				 selectpassword = rs.getString("password");
			}
			if(!rs.next()) {
				 if(selectemail == null || selectpassword == null) { }
		     }
	    }catch(Exception e) {
		     System.out.println("");
		}
    }
    
	public String getSelectemail() {
		return selectemail;
	}
 
	public String getSelectpassword() {
		return selectpassword;
	}
 
 
	 public void selectAdminSenior(TextField email, TextField password2) {
		try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection cnx = DriverManager.getConnection(datebase,username,password);
			 java.sql.Statement stmt = cnx.createStatement();
			 String query = "SELECT email, password FROM `senioradministrator` WHERE email='"+email.getText()+"' and password='"+password2.getText()+"';";
			 ResultSet rs = stmt.executeQuery(query);
	 
		 while (rs.next()) {
			 selectemailSenior = rs.getString("email");
			 selectpasswordSenior= rs.getString("password");
		 }
		 if(!rs.next()) {
			 if(selectemailSenior == null || selectpasswordSenior == null) { }
		     }
	     
		}catch(Exception e) {
			System.out.println("");
			}
	 }
 
 	 public String getSelectemailSenior() {
		return selectemailSenior;
     }
	 
	 public String getSelectpasswordSenior() {
			return selectpasswordSenior;
     }
 
	 public void DeleteAdmin(TextField id) {
		try{
		     Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection cnx = DriverManager.getConnection(datebase,username,password);
			 java.sql.Statement stmt = cnx.createStatement();
			 //System.out.println("a1");
			 String query = "SELECT idAdmine  FROM `admine` WHERE idAdmine ='"+id.getText()+"';";
			 ResultSet rs = stmt.executeQuery(query);
			 if(rs.next()) {
			   int idAdmine =rs.getInt("idAdmine");
			   String sql = "DELETE FROM `admine` WHERE idAdmine='"+idAdmine +"';";
			   stmt.executeUpdate(sql);
			   JOptionPane.showMessageDialog(null,"Well it was deleted");
			 }
			 else {
				JOptionPane.showMessageDialog(null,"This Id does not exist");
			    }
		 }catch(Exception e) {
		     System.out.println("");
		 }
	 }
 
	 public void SelectSetWeb(TextField setWeb) {
	     try{
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection cnx = DriverManager.getConnection(datebase,username,password);
			 java.sql.Statement stmt = cnx.createStatement(); 
			 String sql = "SELECT `id`, `site_web`, `categorie`, `email`, `tele_fix`, `tele_mobile`, `nome_entre` FROM `informatique` WHERE site_web='"+setWeb.getText()+"'";
			 ResultSet rs = stmt.executeQuery(sql);
		 
			if(rs.next()) {
			   int idSocites=rs.getInt("id");
			   String Siteweb=rs.getString("site_web");
			   String categorie=rs.getString("categorie");
			   String email=rs.getString("email");
			   String TeleFix=rs.getString("tele_fix");
			   String TeleMobile=rs.getString("tele_mobile");
			   String NomeEntre=rs.getString("nome_entre");
			  // System.out.println("hhhhh1"+NomeEntre);
			   AddrOut="\r\n"+"\r\n"+"The WebSite    :"+Siteweb+
			   "\r\n"+"\r\n"+"The category    :"+categorie+
			   "\r\n"+"\r\n"+"Email   :"+email+
			   "\r\n"+"\r\n"+"landline telephone numbers    :"+TeleFix+
			   "\r\n"+"\r\n"+"mobile phone numbers    :"+TeleMobile+
			   "\r\n"+"\r\n"+"Company name    :"+NomeEntre+"\r\n";
			 }
			 else {
				JOptionPane.showMessageDialog(null,"This WebSite does not exist ");
				AddrOut="\r\n"+"\r\n"+" This WebSite does not exist  ";
			}
	     }catch(Exception e1) {
	    	 JOptionPane.showMessageDialog(null,"errror");
         }
     }
	 public String getAddrOut() {
				return AddrOut;
     }
}
