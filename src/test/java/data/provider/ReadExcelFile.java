package data.provider;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcelFile {
    private static XSSFSheet WorkSheet;
    private static XSSFWorkbook Workbook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    static String path = System.getProperty("user.dir")+"\\" + "util\\data.xlsx";

    public static void readExcel() throws IOException {
        try {
            File file = new File(path);   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:    //field that represents string cell type
                            System.out.print(cell.getStringCellValue() + "\t\t\t");
                            break;
                        case NUMERIC:    //field that represents number cell type
                            System.out.print(cell.getNumericCellValue() + "\t\t\t");
                            break;
                        default:
                    }
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <Cells> Object[][] readDataArray(String FilePath, String SheetName) throws Exception {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            Workbook = new XSSFWorkbook(ExcelFile);
            WorkSheet = Workbook.getSheet(SheetName);
            Row row = WorkSheet.getRow(1);
            int physicalRows = WorkSheet.getPhysicalNumberOfRows();
            int startRow = 1;
            int startCol = 1;
            int ci,cj;
            int totalRows = WorkSheet.getLastRowNum();
            System.out.println("physical: " + physicalRows);
            System.out.println("row: " + totalRows);
            // you can write a function as well to get Column count
            // Cell trong excel bắt đầu từ [0][0]
            int totalCols = row.getLastCellNum()-1; // cell thì đi từ 1, row thì đi từ 0
            System.out.println("col: " + totalCols);// tính tổng số cột
            tabArray= new String[totalRows][totalCols];
            System.out.println(tabArray[0].length);//tao mang dua vao tong so cot va hang
            ci=0;
            for (int i=startRow;i<=totalRows;i++, ci++) { //đi từ 1 ô trong 1 hàng đến hết hàng tồn tại trong excel
                cj=0;
                for (int j=startCol;j<=totalCols;j++, cj++){
                    tabArray[ci][cj]=getCellData(i,j);
                    System.out.println("array[" + ci + "][" + cj + "]: " + tabArray[ci][cj]);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return(tabArray);
    }
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        Cell = WorkSheet.getRow(RowNum).getCell(ColNum);
        String CellData = "";
        switch (Cell.getCellType()) {
            case STRING:    //field that represents string cell type
                String CellString = Cell.getStringCellValue();
                CellData = CellString;
                break;
            case NUMERIC:    //field that represents number cell type
                Number CellNumeric = Cell.getNumericCellValue();
                CellData = CellNumeric.toString();
                break;
            default:
        }
        return CellData;
    }

    public static void main(String[] args) throws Exception {
        readDataArray(path, "Sheet3");
    }
}