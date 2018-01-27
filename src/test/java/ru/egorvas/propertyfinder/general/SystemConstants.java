package ru.egorvas.propertyfinder.general;

/**
 * Created by egorvas on 28.01.2018.
 */
public class SystemConstants {

    public static final int TIMEOUT = getProperty("timeout", 5000);
    public static final String BROWSER = getProperty("browser", "chrome");

    private static String getProperty(String key, String def) {
        if (System.getProperty(key) == null || "".equals(System.getProperty(key))) {
            return def;
        }
        return System.getProperty(key);
    }

    private static int getProperty(String key, int def) {
        if (System.getProperty(key) == null || "".equals(System.getProperty(key))) {
            return def;
        }
        return Integer.parseInt(System.getProperty(key));
    }

}
