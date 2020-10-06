import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CucumberStepsTest {
    private final WebDriver driver = Application.getApplication().driversFactory().getDriver();
    public static IProfile iProfile;

    @Given("Choose {string} profile")
    public void chooseProfile(String arg0) {
        switch (arg0) {
            case "Google": {
                iProfile = new Google(driver);
                break;
            }
            case "Yandex": {
                iProfile = new Yandex(driver);
                break;
            }
            default:
                break;
        }
    }

    @Given("Open {string} page")
    public void openPage(final String arg0) {
        driver.get(arg0);
    }

    @Then("Find {string}")
    public void find(final String arg0) {
        iProfile.getSearchBox().sendKeys(arg0);
        iProfile.getSearchBox().submit();
    }
}
