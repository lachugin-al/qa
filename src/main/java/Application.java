import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Application {
    private static Application application;
    private static Properties properties;
    private DriversFactory driversFactory;

    private Application() {
    }

    public static Application getApplication() {
        if (application == null) {
            application = new Application();
        }
        return application;
    }

    public DriversFactory driversFactory() {
        if (driversFactory == null) {
            driversFactory = new DriversFactory();
        }
        return driversFactory;
    }

    public void setApplicationProperties() {
        if(properties == null) {
            try {
                properties = new Properties();
                properties.load(new FileReader(new File("src/test/resources/config/application.properties")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getApplicationProperties(String arg0) {
        String property = properties.getProperty(arg0);
        if (property != null) {
            return property;
        } else {
            throw new Error("application.properties " + arg0 + " not found");
        }
    }

}
