package core.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElementsAndroid extends CommonElements{
    @FindBy(className = "page-title")
    private WebElement pageTitle;

    @FindBy(id = "submit-button")
    private WebElement submit;

    @FindBy(id = "mobile-menu")
    private WebElement navLink;

    @FindBy(id = "alert-message-id")
    private WebElement alertModal;

    @Override
    public void verifyPopupIndicates(String message) {
        assert(alertModal.getText().equals(message));
    }
}
