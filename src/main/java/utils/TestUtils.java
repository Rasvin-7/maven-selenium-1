package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class TestUtils
{
    public static FileInputStream fin;
    public static FileOutputStream fout;
    public static XSSFWorkbook workbook;

    public TestUtils()
    {
        String path = "C:\\Users\\developer\\Desktop\\PyXl\\OrangeHRM TestData.xlsx";
        try {
            fin = new FileInputStream(new File(path));

            workbook = new XSSFWorkbook(fin);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public  Object[][] getSheetData(String sheetname){

        XSSFSheet sheet = workbook.getSheet(sheetname);
        int max_row = sheet.getLastRowNum();
        int max_col = sheet.getRow(1).getLastCellNum();

        Object[][] data = new Object[max_row][max_col];

        System.out.println("Row = "+max_row+"\nCol = "+max_col);

        for(int row=0; row<max_row; row++)
        {
            for(int col=0; col<max_col; col++)
            {
                XSSFCell cell = sheet.getRow(row+1).getCell(col);
                data[row][col] = cell.getStringCellValue();
                System.out.println(data[row][col]+" ");
            }
        }


        return data;
    }



}
