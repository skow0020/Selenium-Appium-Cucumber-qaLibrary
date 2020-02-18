package core.pages.addArticle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddArticlePageAndroid extends AddArticlePage {
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

    public AddArticlePageAndroid() {
        super();
    }

    @Override
    public AddArticlePageAndroid assertPagePresent() {
        assertDisplayed(title, 5);
        return this;
    }

    @Override
    public AddArticlePageAndroid completeFields() {
        title.sendKeys("HERE IS MY TITLE");
        author.sendKeys("Boris Tanning");

        url.sendKeys("url.com");
        backgroundImage.sendKeys("background.png");
        description.sendKeys("The many ways to jump a horse");
        selectDropdownItem(category, "UI Automation");
        return this;
    }

    @Override
    public AddArticlePageAndroid submit() {
        submit.click();
        return this;
    }
}
