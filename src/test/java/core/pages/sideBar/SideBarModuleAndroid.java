package core.pages.sideBar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarModuleAndroid extends SideBarModule {
    @FindBy(css = "#right-sidebar #articles")
    private WebElement articles;

    @FindBy(css = "#right-sidebar #resource-links")
    private WebElement resourceLinks;

    @FindBy(css = "#right-sidebar #books")
    private WebElement books;

    @FindBy(css = "#right-sidebar #tutorials")
    private WebElement tutorials;

    @FindBy(css = "#right-sidebar #example-repos")
    private WebElement exampleRepos;

    @FindBy(css = "#right-sidebar #library-dashboard")
    private WebElement inOfficeLibrary;

    @FindBy(id = "mobile-menu")
    private WebElement mobileMenu;

    public void clickArticles(){
        mobileMenu.click();
        articles.click();
    }
}
