package core.pages.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageWeb extends HomePage {
    @FindBy(id = "main-logo")
    private WebElement logo;

    @FindBy(id = "qa-dashboard")
    private WebElement qaDashboard;

    @FindBy(id = "search-button")
    private WebElement searchButton;

    public HomePageWeb() {
        super();
    }

    @Override
    public void assertPagePresent() {
        assertDisplayed(searchButton, 5);
    }
}
