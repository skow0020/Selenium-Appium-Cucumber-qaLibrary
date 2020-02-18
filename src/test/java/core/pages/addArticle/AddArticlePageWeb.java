package core.pages.addArticle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddArticlePageWeb extends AddArticlePage {
    @FindBy(id = "title")
    private WebElement title;

    @FindBy(id = "author")
    private WebElement author;

    @FindBy(id = "category")
    private WebElement category;

    @FindBy(id = "url")
    private WebElement url;

    @FindBy(id = "backgroundImage")
    private WebElement backgroundImage;

    @FindBy(id = "body")
    private WebElement description;

    @FindBy(id = "submit-button")
    private WebElement submit;

    public AddArticlePageWeb() {
        super();
    }

    @Override
    public AddArticlePageWeb assertPagePresent() {
        assertDisplayed(title, 5);
        return this;
    }

    @Override
    public AddArticlePageWeb completeFields() {
        title.sendKeys("HERE IS MY TITLE");
        author.sendKeys("Boris Tanning");
        selectDropdownItem(category, "UI Automation");
        url.sendKeys("url.com");
        backgroundImage.sendKeys("background.png");
        description.sendKeys("The many ways to jump a horse");

        return this;
    }

    @Override
    public AddArticlePageWeb submit() {
        submit.click();
        return this;
    }
}
