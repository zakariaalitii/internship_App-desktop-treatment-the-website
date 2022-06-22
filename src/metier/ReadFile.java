package metier;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.Model;

public class ReadFile {
	
	
	Model conx=new Model();
	 
	public ReadFile() {}
    
    public void ReadInvoices(String NAME,String option) {
    	
    	try {
    		FileInputStream file = new FileInputStream(new File(NAME));
    		Workbook workbook = new XSSFWorkbook(file);
    		DataFormatter dataFormatter =  new DataFormatter();
    		Iterator<Sheet> sheets = workbook.sheetIterator();
    		
    		Sheet sh0 = workbook.getSheetAt(0);
    		Row row0 = sh0.getRow(0);
    		Cell cell0 = row0.getCell(0);
    		
    		while(sheets.hasNext()) {
    			Sheet sh = sheets.next();
    			Iterator<Row> iterator = sh.iterator();
    			while(iterator.hasNext()) {
        			Row row = iterator.next();
        			Iterator<Cell> cellIterator = row.iterator();
        			while(cellIterator.hasNext()) {
        				Cell cell = cellIterator.next();
        				if(cell != cell0) {
        					String cellValue = dataFormatter.formatCellValue(cell);
            				conx.insertSite(cellValue,option);
        				}
        			}
        		}
    		}
    		workbook.close();
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null,"please take the file");
    	}
    }
    
}
