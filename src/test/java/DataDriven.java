import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DataDriven {
	
	public ArrayList<String> getData(String testcasename) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Desktop\\Book1.xlsx");
		
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		
		int sheets= workbook.getNumberOfSheets();	
		System.out.println(sheets);
		
	for(int i=0;i<sheets;i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
		XSSFSheet sheet=workbook.getSheetAt(i);
		
		// 1.Identify Tescases column by scanning the entire first row
		Iterator<Row> rows=sheet.iterator();//sheet is collection of rows
		Row firstrow=rows.next();
		Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cell
		int k=0;
		int column =0;;
		while(ce.hasNext()) {
			Cell value=ce.next();		
		if(value.getStringCellValue().equals("TestCases")) {
			//desired column
			column=k;
		}
		
		k++;
		}
		System.out.println(column);
		
	// 2.	once column is identified then scan entire test column to identify purchase tescase row
		while(rows.hasNext()) {
			Row r=rows.next();
			if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
				// 3.after you grab purchase row get value of that row
			Iterator<Cell> cv=r.cellIterator();
			while(cv.hasNext()) {
				Cell c= cv.next();
				if(c.getCellTypeEnum()==CellType.STRING) {
				a.add(c.getStringCellValue());
				}
				else {
					a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					
				}
			} 
			}
		}
	
		}
		
	}
	return a;
	}

	public static void main(String[] args) throws IOException {
		
		
		
	}

}
