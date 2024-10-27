package temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIAPIDemo {

	public static void main(String[] args) throws IOException {
		
		File employeeDetailsFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\temp\\EmployeesDetails.xlsx");
		FileInputStream fis = new FileInputStream(employeeDetailsFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("employees");
		
		int rowsCount = sheet.getLastRowNum()+1;
		int cellsCount = sheet.getRow(0).getLastCellNum();
	
		for(int r=0;r<rowsCount;r++) {
			
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0;c<cellsCount;c++) {
				
				XSSFCell cell = row.getCell(c);
				
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
					case NUMERIC:
						System.out.print((int)cell.getNumericCellValue()+"---");
						break;
						
					case STRING:
						System.out.print(cell.getStringCellValue()+"---");
						break;
						
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue()+"---");
						break;
					
					default:
						break;
				
				}
				
			}
			
			System.out.println();
			
			
		}
		
		workbook.close();

	}

}
