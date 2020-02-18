package core.pages.headerModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderModuleWeb extends HeaderModule{
    @FindBy(id = "search-button")
    private WebElement searchButton;

    @FindBy(id = "user-avatar")
    private WebElement personIcon;

    @Override
    public void assertPagePresent() {
        assertDisplayed(searchButton, 5);
    }
}
