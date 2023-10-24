package Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesSetUp {
    protected static final String propertiesFilePath = "src/test/resources/application.properties";
    protected static FileInputStream fileInputStream;
    protected static Properties properties;
    private static final Logger logger = LogManager.getLogger();


    static {
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(propertiesFilePath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            logger.error("Unexpected error", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}