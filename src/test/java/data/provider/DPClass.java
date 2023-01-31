package data.provider;

import org.testng.annotations.DataProvider;

public class DPClass {
    static String path = System.getProperty("user.dir")+"\\" + "util\\data.xlsx";
    static String nameSheet = "Sheet1";
    @DataProvider(name = "data-provider")
    public static Object[][] getDataProvider() throws Exception {
        Object[][] testObjArray = ReadExcelFile.readDataArray(path, "Sheet2");
        return testObjArray;
    }
}