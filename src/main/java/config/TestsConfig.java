package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestsConfig {
    private static TestsConfig config;
    private static final String PROP_PATH = "src/main/resources/config.properties";
    private Properties property;

    private TestsConfig () {
        try {
            property = new Properties();
            FileInputStream fis = new FileInputStream(PROP_PATH);
            property.load(fis);
        } catch (IOException e){
            System.out.println("Ошибка файла конфигурации");
        }
    }

    public static TestsConfig getConfig() {
        if(config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public String getProperty (String propName) {
        return property.getProperty(propName);
    }

}
