package core.pages.sideBar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarModuleWeb extends SideBarModule {
    @FindBy(id = "main-logo")
    private WebElement qaLibraryLogo;

    @FindBy(id = "qa-dashboard")
    private WebElement qaDashboard;

    @FindBy(id = "articles")
    private WebElement articles;

    @FindBy(id = "resource-links")
    private WebElement resourceLinks;

    @FindBy(id = "books")
    private WebElement books;

    @FindBy(id = "tutorials")
    private WebElement tutorials;

    @FindBy(id = "example-repos")
    private WebElement exampleRepos;

    @FindBy(id = "library-dashboard")
    private WebElement inOfficeLibrary;

    public void clickArticles(){
        articles.click();
    }
}
