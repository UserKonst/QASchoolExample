package da.qa.shool.core;

public class Config {

    public static String get(String propertyKey) {
        return ConfigReader.getInstance().getProperty(propertyKey);
    }
}
