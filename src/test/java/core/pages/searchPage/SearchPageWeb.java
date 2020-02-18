package core.pages.searchPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageWeb extends SearchPage {
    @FindBy(id = "navbar-search")
    private WebElement searchField;
    @FindBy(id = "Books-list")
    private WebElement books;
    @FindBy(id = "Tutorials-list")
    private WebElement tutorials;

    @Override
    public void assertPagePresent() {
        assertDisplayed(searchField, 5);
    }

    public void search(String searchText) {
        searchField.sendKeys(searchText + Keys.ENTER);
        assertDisplayed(books);
    }

    @Override
    public void navigate() {
        navigate("search");
    }
}
