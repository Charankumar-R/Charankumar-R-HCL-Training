package Utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Excelreader {

    public static String[][] readData() {

        String filePath = "src/test/resources/testdata/BookList.xlsx";
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;

        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet("ProductDetails");

            int rowCount = sheet.getLastRowNum();          
            int colCount = sheet.getRow(0).getLastCellNum();

            System.out.println("No of Rows " + rowCount);

            String[][] data = new String[rowCount][colCount];
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    Cell cell = sheet.getRow(i).getCell(j);
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }
            return data;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data", e);

        }
    }
}