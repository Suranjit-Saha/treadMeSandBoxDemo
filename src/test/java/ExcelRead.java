import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelRead {

    public String readFromExcel (int rowIndex, int columnIndex) {
        XSSFWorkbook excelWorkbook;
        XSSFSheet sheet;
        XSSFCell cell;
        String directory = System.getProperty("user.dir") + "//ExcelSheet//";
        String path = directory+"MyExcel.xlsx";
        String sheetName = "Sheet1";
        String cellValue = null;

        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWorkbook = new XSSFWorkbook(excelFile);
            sheet = excelWorkbook.getSheet(sheetName);
            cell = sheet.getRow(rowIndex).getCell(columnIndex);

            cellValue = cell.getStringCellValue();
            System.out.println("Cell Data: " + cellValue);

        } catch (Exception e) {
            System.out.println("Couldn't read data");
            e.printStackTrace();
        }
        return cellValue;

    }


}
