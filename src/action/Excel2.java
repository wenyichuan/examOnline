package action;

import bean.User;
import biz.userBiz;
import biz.userBizImpl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class Excel2 {

	public void outportExcel2(List<User> list){

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("学生成绩表");

		HSSFRow row = sheet.createRow(( int ) 0);  

		HSSFCell cell = row.createCell(0);
		cell.setCellValue( "系统编号" );
		cell = row.createCell(1);
		cell.setCellValue( "学号" );
		cell = row.createCell(2);
		cell.setCellValue( "密码（手机号）" );
		cell = row.createCell(3);
		cell.setCellValue( "姓名" );
        cell = row.createCell(4);
        cell.setCellValue( "成绩" );
        cell = row.createCell(5);
        cell.setCellValue( "专业方向" );
		for(int i = 0;i < list.size();i++){
			row = sheet.createRow(( int ) i + 1);  
			User u = (User) list.get(i);

            row.createCell(0).setCellValue(u.getSysid());
            row.createCell(1).setCellValue(u.getStudentID());
            row.createCell(2).setCellValue( u.getPassword());
            row.createCell(3).setCellValue(u.getStudentName());
            row.createCell(4).setCellValue(u.getResult());
            row.createCell(5).setCellValue(u.getSclass());
		}
		try {
			FileOutputStream outputStream = new FileOutputStream("E:\\1234.xls");
			workbook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void importExcel(File userExcel, String userExcelFileName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(userExcel);
			boolean is03Excel = userExcelFileName.matches("^.+\\.(?i)(xls)$");

			Workbook workbook = is03Excel ? new HSSFWorkbook(fileInputStream):new XSSFWorkbook(fileInputStream);

			Sheet sheet = workbook.getSheetAt(0);

			if(sheet.getPhysicalNumberOfRows() > 1){
				User u = null;
				for(int k = 1; k < sheet.getPhysicalNumberOfRows(); k++){

					Row row = sheet.getRow(k);
					u = new User();




                    int sysid = 0;
                    try {
                        row.getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC);
                        Cell cell0 = row.getCell(0);
                        sysid = (int) cell0.getNumericCellValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    u.setSysid(sysid);

                    row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					Cell cell1 = row.getCell(1);
					u.setStudentID(cell1.getStringCellValue());

                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					Cell cell2 = row.getCell(2);
					u.setPassword(cell2.getStringCellValue());

                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
					Cell cell3 = row.getCell(3);
					u.setStudentName(cell3.getStringCellValue());

                    int result = 0;


                    try {
                        row.getCell(4).setCellType(Cell.CELL_TYPE_NUMERIC);
                        Cell cell4 = row.getCell(4);
                        result = (int) cell4.getNumericCellValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    u.setResult(result);

                    Cell cell5 = row.getCell(5);
                    u.setSclass(cell5.getStringCellValue());

					userBiz user=new userBizImpl();
					user.addUser(u);
				}
			}
			workbook.close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
