import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", tags = "@google")

public class CucumberRunTest {
    private static Application application;

    @BeforeClass
    public static void start() {
        application = Application.getApplication();
        application.setApplicationProperties();
        application.driversFactory().setDriver();
    }

    @AfterClass
    public static void finish() {
        application.driversFactory().getDriver().quit();
        application = null;
    }
}
