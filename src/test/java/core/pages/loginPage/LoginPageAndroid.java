package core.pages.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageAndroid extends LoginPage {
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "registration-link")
    private WebElement registrationLink;

    @FindBy(id = "submit-button")
    private WebElement submit;

    public LoginPageAndroid() {
        super();
    }

    public void assertPagePresent() {
        assertDisplayed(email, 5);
    }

    public void login() {
        driver.get("https://qa-library-dev.herokuapp.com/");
        email.sendKeys("cskow@tapqa.com");
        password.sendKeys("password");
        submit.click();
    }
}
