package presontation.lowerAdmine;

import javax.swing.*;

import dao.Model;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class SearchInformationLower {
	
	Button search ;
	Button returning ;
	BufferedImage b1;
	TextArea textaffiche;
	JLabel label;
	JLabel labelAdd;
	private TextField SetWeb;
	Model conx=new Model();
	
	public SearchInformationLower(){
		super();
		  JFrame frame = new JFrame("SEARCH INFORMATION");
		  frame.setPreferredSize(new Dimension(440, 490));
	      frame.pack();
	      frame.setVisible(true);
	      frame.setResizable(false);
	      frame.setSize(1000,550);
	      frame.setLocation(250,100);
	      
	      
	      JPanel pane = new JPanel();
	      JPanel pane2 = new JPanel();
	      pane.setBackground(new Color(45,69,82));
	      pane2.setBackground(new Color(45,69,82));
	      label = new JLabel  ("                                                              searchInformation                                         ");
	      SetWeb =new TextField(25);
	      labelAdd = new JLabel  ("Add WebSite please                       ");
	      
	
	      
		 search = new Button (" search  ");
		 returning = new Button("returning");
		 label.setForeground(Color.white);
		 labelAdd.setForeground(Color.white);
		 SetWeb.setBackground(new Color(193,219,227));
		 SetWeb.setForeground(new Color(19,44,61));
		 search.setBackground(new Color(40,92,52));
		 search.setForeground(Color.white);
		 returning.setBackground(new Color(122,23,66));
		 returning.setForeground(Color.white);
		 
		 search.addActionListener(new MyActionListener ());
		 returning.addActionListener(new MyActionListener ());
		 frame.addWindowListener(new MyWindowListener());
		
		 textaffiche=new  TextArea(30,65);
		 textaffiche.setEnabled(false);
	      pane.add(label);
		  pane.add(pane2);

	      
		  pane2.add(labelAdd);
		  pane2.add(SetWeb);
		  pane2.add(search);

	      pane.add(textaffiche,BorderLayout.WEST);
	      pane2.add(returning);
		 frame.getContentPane().add(pane,BorderLayout.CENTER);
		 frame.show();
		
		
	}

	private class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == search) {
			conx.SelectSetWeb(SetWeb);
			textaffiche.setText(conx.getAddrOut());
		}
		if(e.getSource() == returning) {
			InformationLower information = new InformationLower(null, null, false);
		}
	}	
	}

	private class MyWindowListener implements WindowListener {
		@Override
		public void windowClosing(WindowEvent event) {
		}

		@Override
		public void windowOpened(WindowEvent e) {
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
}
