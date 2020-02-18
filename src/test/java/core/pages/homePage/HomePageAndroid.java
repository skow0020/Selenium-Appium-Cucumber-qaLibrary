package core.pages.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAndroid extends HomePage {
    @FindBy(id = "welcomeDash")
    private WebElement dashboard;

    public HomePageAndroid() {
        super();
    }

    @Override
    public void assertPagePresent() {
        assertDisplayed(dashboard, 5);
    }
}
