package config;

import java.util.Properties;

public class ConfigLoader {

    private static Properties properties = new Properties();

    public static void load() {
        try {
            // لاحقًا يمكن تحميل ملف config.properties
            System.out.println("Config Loaded Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}