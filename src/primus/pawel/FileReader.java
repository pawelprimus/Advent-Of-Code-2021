package primus.pawel;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    final static String FILE_PATH = System.getProperty("user.dir") + "\\src\\primus\\pawel\\DAY_";
    final static String INPUT_FILE_NAME = "input.txt";
    final static String TEST_FILE_NAME = "test.txt";



    public static String readFileAsString(String day, InputType inputType) throws Exception {
        String fileName;
        if (inputType.equals(InputType.TEST)) {
            fileName = INPUT_FILE_NAME;
        } else {
            fileName = INPUT_FILE_NAME;
        }
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(FILE_PATH + day + "\\" + fileName)));
        return data;
    }
}
