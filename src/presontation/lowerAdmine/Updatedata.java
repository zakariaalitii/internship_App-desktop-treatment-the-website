package presontation.lowerAdmine;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JComboBox;

import dao.Model;
import metier.ReadFile;

public class Updatedata extends Dialog implements WindowListener, ActionListener {

   private Frame mainFrame;
   Label titleJLabel;
   private String file;
   private String option;
   JComboBox categorie;
   FileDialog fileDialog;
   Button showFileDialogButton ;
   
   Model conx=new Model();
   Button ok ;
   Button cancel ;

   public Updatedata(Frame owner, String title, boolean modal){
	   super(owner, title, modal);
      prepareGUI();
   }

   private void prepareGUI(){
	   
      mainFrame = new Frame("Competence Center");
      Image icon =Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zakar\\eclipse-workspace\\testemail\\src\\imgs\\indexCompetence.jpg");
      mainFrame.setIconImage(icon);
      mainFrame.setSize(900,500);
      mainFrame.setLocation(270,120);
      mainFrame.setLayout(null);
      mainFrame.setBackground(new Color(45,69,82));
         
      
	  
      String[] items = { "informatique", "Economy", "Industrial", "Elecricity" };
      
      titleJLabel = new Label("Updating Data");
      categorie = new JComboBox(items);
      categorie.setActionCommand("categorie");
      categorie.addActionListener(this);


      
    ok = new Button     ("ok");
    cancel = new Button (" cancel ");
	
	ok.setActionCommand("ok");
	cancel.setActionCommand("cancel");
	
	mainFrame.add(ok);
	mainFrame.add(cancel);
	addWindowListener(this);
	cancel.addActionListener(this);
	ok.addActionListener( this);
	
    fileDialog = new FileDialog(mainFrame,"Select file");
    showFileDialogButton = new Button("Open File");
    showFileDialogButton.addActionListener(this);
   
    
	titleJLabel.setForeground(Color.white);
    ok.setBackground(new Color(40,92,52));
	ok.setForeground(Color.white);
	cancel.setBackground(new Color(122,23,66));
	cancel.setForeground(Color.white);
	showFileDialogButton.setBackground(new Color(19,44,61));
	showFileDialogButton.setForeground(Color.white);
	categorie.setBackground(new Color(19,44,61));
	categorie.setForeground(Color.white);
	
    mainFrame.setVisible(true);  
 
    titleJLabel.setBounds(220,120,100,20);
    showFileDialogButton.setBounds(220,190,250,30);
    categorie.setBounds(490,190,250,30);

    ok.setBounds(220,250,80,30);
	cancel.setBounds(320,250,80,30);
      
	mainFrame.add(titleJLabel);
    mainFrame.add(showFileDialogButton);
    mainFrame.add(categorie); 
    mainFrame.setVisible(true);  
   }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == showFileDialogButton) {
				fileDialog.setVisible(true);
			}
			if(e.getSource() == ok) {
			    file =  fileDialog.getDirectory() + fileDialog.getFile();
				option = categorie.getSelectedItem().toString();
			   // System.out.println("value :" + option);	
			    ReadFile revenge = new ReadFile();
				revenge.ReadInvoices(file,option);
				conx.SelectedIndexNom();
			}
			
			if(e.getSource() == cancel){
				InformationLower information = new InformationLower(null, null, false);
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
		public String getOption() {
			option = categorie.getSelectedItem().toString();
			return option;
		}
		}