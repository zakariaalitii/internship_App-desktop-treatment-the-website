package metier;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dao.ModelUpdate;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RetrieveData {
	
	ModelUpdate conx=new ModelUpdate();
	
     private Map<String ,String> itemsFixe;
     private Map<String ,String> itemsMobile;
     //private Map<String ,String> itemsemail;
     Set<String> printTeleFixe = new HashSet<String>();
     Set<String> printTeleMobile = new HashSet<String>();
    // Set<String> printemail = new HashSet<String>();

     String emialtets;
     
	 
     
     public RetrieveData() {
    	 itemsFixe = new  HashMap();
    	 itemsMobile = new  HashMap();
    	// itemsemail = new  HashMap();
    	 //scanItems();
     }
     
     public void scanItems(String WEBSITE) {
    	 Document  document;
    	 try {
    		 document = Jsoup.connect(WEBSITE).get();
    	 }catch(IOException ignored){
    		 System.out.println("");
    		 return ;
    	 }
    	 String title = document.title();
  		 conx.updateTeleTitle(WEBSITE,title);
    	 //tele
    	 String regex_num = "^\\+?[0-9. ()-]{10,25}$";//"^\\+?[0-9. ()-]{10,25}$"
    	 Pattern pattern = Pattern.compile(regex_num);
		 Elements Phone_Num = document.getElementsMatchingOwnText(pattern);
		 if(!Phone_Num.isEmpty()) {
		    for(Element e : Phone_Num)
		    {
		    	if(FixTele(e.text().toString())) {
		    		String teleprint = e.text().toString();
		    		itemsFixe.put(teleprint, e.text().toString());
		    	}
		    	else {
		    		String teleprint = e.text().toString();
		    		itemsMobile.put(teleprint, e.text().toString());
		    	}
		    }
		 }
		
		String regex_num2 = "^\\+?[0-9. (+)-]{10,25}$";//"^\\+?[0-9. ()-]{10,25}$"
		Pattern pattern2 = Pattern.compile(regex_num2);
		Elements Phone_Num2=document.getElementsMatchingOwnText(pattern2);
		
		if(!Phone_Num2.isEmpty()) 
		{
			for(Element e : Phone_Num2)
		    {
				if(FixTele(e.text().toString())) {
		    		String teleprint = e.text().toString();
		    		itemsFixe.put(teleprint, e.text().toString());
		    	}
		    	else {
		    		String teleprint = e.text().toString();
		    		itemsMobile.put(teleprint, e.text().toString());
		    	}
		    }
		 }

    	 
    	//email
		Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
        Matcher matcher = p.matcher(document.text());
        Set<String> emails = new HashSet<String>();
        while (matcher.find()) {
        	 emialtets = matcher.group();
            //emails.add(matcher.group());
            //itemsemail.put(emialtets, matcher.group());
        }
        
    	Elements links = document.select("a[href]");
    	for (Element link: links)
 		{
    		 String linkString = link.attr("href");
    		 String text = link.text();
 			 if(charAtlinkHttps(linkString)) {
 				findPrice(linkString);
 			 }
 			 if(charAtlink(linkString)) {
 				findPrice2(linkString , WEBSITE );
 			 }
 			 if(charAtlinknull(linkString)) {
 			 }
 			 else {
 			 }
 		}
    	
     }
     
     private void findPrice(String link2) {
    	 Document  document;
    	 try {
    		 document = Jsoup.connect(link2).get();
    	 }catch(IOException ignored){
    		 System.out.println("");
    		 return ;
    	 }
    	//tele
    	 String regex_num = "^\\+?[0-9. ()-]{10,25}$";//"^\\+?[0-9. ()-]{10,25}$"
    	 Pattern pattern = Pattern.compile(regex_num);
			Elements Phone_Num = document.getElementsMatchingOwnText(pattern);
			if(!Phone_Num.isEmpty()) // if phone number exist
			{
			    for(Element e : Phone_Num)
			    {
			    	if(FixTele(e.text().toString())) {
			    		String teleprint = e.text().toString();
			    		itemsFixe.put(teleprint, e.text().toString());
			    	}
			    	else {
			    		String teleprint = e.text().toString();
			    		itemsMobile.put(teleprint, e.text().toString());
			    	}
			    }

			}
		//tele2
		String regex_num2 = "^\\+?[0-9. (+)-]{10,25}$";//"^\\+?[0-9. ()-]{10,25}$"
		Pattern pattern2 = Pattern.compile(regex_num2);
		Elements Phone_Num2=document.getElementsMatchingOwnText(pattern2);
		if(!Phone_Num2.isEmpty()) // if phone number exist
		{
		    for(Element e : Phone_Num2)
		    {
		    	if(FixTele(e.text().toString())) {
		    		String teleprint = e.text().toString();
		    		itemsFixe.put(teleprint, e.text().toString());
		    	}
		    	else {
		    		String teleprint = e.text().toString();
		    		itemsMobile.put(teleprint, e.text().toString());
		    	}
		    }

		}
    	 
    	//email
			Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
	        Matcher matcher = p.matcher(document.text());
	        Set<String> emails = new HashSet<String>();
	        while (matcher.find()) {
	           // emails.add(matcher.group());
	             emialtets = matcher.group();
	           // itemsemail.put(emialtets, matcher.group());
	        }
	        
    	 
    	 Elements links = document.select("a[href]");
    	 for (Element link: links)
 			{
    		 String linkString = link.attr("href");
 			
 			}
     }
     
     private void findPrice2(String link2, String WEBSITE) {
    	 Document  document;
    	 try {
    		 document = Jsoup.connect(WEBSITE+link2).get();
    	 }catch(IOException ignored){
    		 System.out.println("");
    		 return ;
    	 }
    	//tele
    	 String regex_num = "^\\+?[0-9. ()-]{10,25}$";//"^\\+?[0-9. ()-]{10,25}$"
    	 Pattern pattern = Pattern.compile(regex_num);
			Elements Phone_Num = document.getElementsMatchingOwnText(pattern);
			if(!Phone_Num.isEmpty()) // if phone number exist
			{
			    for(Element e : Phone_Num)
			    {
			    	if(FixTele(e.text().toString())) {
			    		String teleprint = e.text().toString();
			    		itemsFixe.put(teleprint, e.text().toString());
			    	}
			    	else {
			    		String teleprint = e.text().toString();
			    		itemsMobile.put(teleprint, e.text().toString());
			    	}
			    }
			}
		//tele2
		String regex_num2 = "^\\+?[0-9. (+)-]{10,25}$";//"^\\+?[0-9. ()-]{10,25}$"
		Pattern pattern2 = Pattern.compile(regex_num2);
		Elements Phone_Num2=document.getElementsMatchingOwnText(pattern2);
		if(!Phone_Num2.isEmpty()) // if phone number exist
		{
		    for(Element e : Phone_Num2)
		    {
		    	if(FixTele(e.text().toString())) {
		    		String teleprint = e.text().toString();
		    		itemsFixe.put(teleprint, e.text().toString());
		    	}
		    	else {
		    		String teleprint = e.text().toString();
		    		itemsMobile.put(teleprint, e.text().toString());
		    	}
		    }

		}
    	 
    	//email
			Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
	        Matcher matcher = p.matcher(document.text());
	        Set<String> emails = new HashSet<String>();
	        while (matcher.find()) {
	           // emails.add(matcher.group());
	             emialtets = matcher.group();
	          //  itemsemail.put(emialtets, matcher.group());
	        }
	        Elements links = document.select("a[href]");
	        for (Element link: links)
	        {
	    		 String linkString = link.attr("href");
	 			
 			}
     }
    
     public void printItems(String WEBSITE) {
    	 scanItems(WEBSITE);
    	 conx.updateEmail(WEBSITE, emialtets);
    	// itemsemail.clear();
    	 conx.updateTeleFixe(WEBSITE, itemsFixe);
    	 itemsFixe.clear();
    	 conx.updateTeleMobile(WEBSITE, itemsMobile);
    	 itemsMobile.clear();
     }
     
     
     public static boolean charAtlink(String input) {
 		return     (input.charAt(0) == '/') 
 				|| (input.charAt(0) == '#')
 				;
 	 }
     public static boolean charAtlinkHttps(String input) {
  		return     (input.charAt(0) == 'h');
  	 }
     public static boolean charAtlinknull(String input) {
   		return      (input.charAt(0) == ' ');
   	 }
      
     public static boolean FixTele(String input) {
  		return     (input.charAt(0) == '0' && input.charAt(1) == '5') 
  				|| (input.charAt(0) == '(' && input.charAt(1) == '+' && input.charAt(2) == '2' && input.charAt(3) == '1' && input.charAt(4) == '2' && input.charAt(5) == ')' && input.charAt(6) == ' ' && input.charAt(7) == '5' )
  				|| (input.charAt(0) == '+' && input.charAt(1) == '2' && input.charAt(2) == '1' && input.charAt(3) == '2' && input.charAt(4) == ' ' && input.charAt(7) == '5' );
  	 }
     public static boolean FixeTele(String input) {
  		return     (input.charAt(0) == '0' && input.charAt(1) == '6');
  	 }
 
    
}

