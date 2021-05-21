package updateFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
 
public class Exel_Main{
    private HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    
    public static void main(String[] args) throws IOException {
    	Exel_DAO ed = new Exel_DAO();
    	GetTime gt = new GetTime();
    	Exel_Main em = new Exel_Main();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Data sheet");
 
        List<Exel_Data> list = ed.listTest_Exel_Datas();

        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = em.createStyleForTitle(workbook);
 
        row = sheet.createRow(rownum);
 

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("So thu tu");
        cell.setCellStyle(style);
        
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("URL");
        cell.setCellStyle(style);

 
        for (Exel_Data emp : list) {
            rownum++;
            row = sheet.createRow(rownum);
 
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(emp.getId());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.getUrlName());

        }
        String check = gt.getYearNow()+"/"+gt.getMonthNow()+"-"+gt.getYearNow();
        File file = new File("C:/"+check);
        if(file.exists()) {
        	String addData = check+ "/"+gt.getDayNow()+"-"+gt.getMonthNow()+".xls";
        	File makeFile = new File("C:/"+ addData);
        	makeFile.getParentFile().mkdirs();
        	
	        FileOutputStream outFile = new FileOutputStream(makeFile);
	        workbook.write(outFile);
        	System.out.println("Created file: " + makeFile.getAbsolutePath());
        }
    }
}
