package action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import bean.Choice;

import biz.choiceBiz;
import biz.choiceBizImpl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excel {
    public void outportExcel(List<Choice> list) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("选择题表");

        HSSFRow row = sheet.createRow((int) 0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("题目编号");
        cell = row.createCell(1);
        cell.setCellValue("题目内容");
        cell = row.createCell(2);
        cell.setCellValue("选项A");
        cell = row.createCell(3);
        cell.setCellValue("选项B");
        cell = row.createCell(4);
        cell.setCellValue("选项C");
        cell = row.createCell(5);
        cell.setCellValue("选项D");
        cell = row.createCell(6);
        cell.setCellValue("正确答案");
        cell = row.createCell(7);
        cell.setCellValue("解析");
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            Choice choice = (Choice) list.get(i);

            row.createCell(0).setCellValue(choice.getStID());
            row.createCell(1).setCellValue(choice.getStTitle());
            row.createCell(2).setCellValue(choice.getStOptionA());
            row.createCell(3).setCellValue(choice.getStOptionB());
            row.createCell(4).setCellValue(choice.getStOptionC());
            row.createCell(5).setCellValue(choice.getStOptionD());
            row.createCell(6).setCellValue(choice.getStAnswer());
            row.createCell(7).setCellValue(choice.getStParse());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("E:\\Choice.xls");
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void importExcel(File choiceExcel,String choiceExcelFileName){
        try {
            FileInputStream fileInputStream = new FileInputStream(choiceExcel);
            boolean is03Excel = choiceExcelFileName.matches("^.+\\.(?i)(xls)$");
            Workbook workbook = is03Excel ? new HSSFWorkbook(fileInputStream):new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            if(sheet.getPhysicalNumberOfRows() > 1) {
                Choice choice = null;
                for (int k = 1; k < sheet.getPhysicalNumberOfRows(); k++) {

                    Row row = sheet.getRow(k);
                    choice = new Choice();

                    int stid = 0;
                    try {
                        row.getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC);
                        Cell cell0 = row.getCell(0);
                        stid = (int) cell0.getNumericCellValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    choice.setStID(stid);

                    row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                    Cell cell1 = row.getCell(1);
                    choice.setStTitle(cell1.getStringCellValue());

                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    Cell cell2 = row.getCell(2);
                    choice.setStOptionA(cell2.getStringCellValue());

                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    Cell cell3 = row.getCell(3);
                    choice.setStOptionB(cell3.getStringCellValue());

                    row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                    Cell cell4 = row.getCell(4);
                    choice.setStOptionC(cell4.getStringCellValue());

                    row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                    Cell cell5 = row.getCell(5);
                    choice.setStOptionD(cell5.getStringCellValue());

                    row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                    Cell cell6 = row.getCell(6);
                    choice.setStAnswer(cell6.getStringCellValue());

                    row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                    Cell cell7 = row.getCell(7);
                    choice.setStParse(cell7.getStringCellValue());

                    choiceBiz choiceBiz = new choiceBizImpl();
                    choiceBiz.addChoice(choice);
                }
            }
            workbook.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
