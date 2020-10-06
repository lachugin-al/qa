import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Yandex implements IProfile {

    public WebDriver driver;

    public Yandex(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "qq")
    private WebElement searchBox;

    public WebElement getSearchBox() {
        return searchBox;
    }

}
