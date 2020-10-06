import exceptions.DriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriversFactory {
    private WebDriver driver;
    protected Application application;

    public DriversFactory() {
        this.application = Application.getApplication();
    }

    public void setDriver() {
        if (driver == null) {
            System.setProperty(application.getApplicationProperties("webdriver"),
                    application.getApplicationProperties("driver_src"));
            driver = initDriver(application.getApplicationProperties("browser"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new DriverException("WebDriver not initialized, please setDriver");
        }
        return driver;
    }

    public WebDriver initDriver(String arg0) {
        switch (arg0) {
            case "Chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "InternetExplorer": {
                driver = new InternetExplorerDriver();
                break;
            }
            default:
                throw new DriverException("Driver " + arg0 + " not in application.properties");
        }
        return driver;
    }

}
