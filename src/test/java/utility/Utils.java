package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public String readFromProperties(String path, String data) {
        Properties prop = null;
        try {
            InputStream input = new FileInputStream(path);
            prop = new Properties();
            prop.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(prop.getProperty(data));
    }
}
