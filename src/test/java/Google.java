import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google implements IProfile {

    public WebDriver driver;

    public Google(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    public WebElement getSearchBox() {
        return searchBox;
    }

}
