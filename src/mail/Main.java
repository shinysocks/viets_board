package mail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Main entrypoint for uberjar 
 */
public class Main {

    public static void main(String[] args) throws Exception {

        final String URL = args[0] + "?download=1";
        final GetMethod get = new GetMethod(URL);

        try {
            if (HttpStatus.SC_OK == new HttpClient().executeMethod(get)) {
                File target = new File("data.xlsx");
                get.getResponseBodyAsStream().transferTo(new FileOutputStream(target));
                printData(target);
            } else {
                throw new IOException("Unable to load page, error " + get.getStatusLine());
            }
        } finally {
            get.releaseConnection();
        }
    }

    private static void printData(File file) throws InvalidFormatException, IOException {
        final XSSFWorkbook book = new XSSFWorkbook(file);
        final XSSFSheet sheet = book.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());
            }
        }

        book.close();
    }
}
