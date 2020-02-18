package core.pages.articles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ArticlesPageWeb extends ArticlesPage {
    @FindBy(id = "add-article")
    private WebElement addArticle;

    @FindBy(id = "article-card-0")
    private WebElement firstArticleCard;

    @FindBy(css = "#article-card-0 .card-title")
    private WebElement firstArticleCartTitle;

    @FindBy(css = "[id*=article-card]")
    private WebElement articleCards;

    @FindBy(id = "category")
    private WebElement category;

    @FindBy(id = "add-article")
    private WebElement language;

    @FindBy(className = "card-post")
    private List<WebElement> cardPosts;

    @Override
    public void assertPagePresent() {
        assertDisplayed(addArticle, 5);
    }

    @Override
    public void clickAddArticle() {
        addArticle.click();
    }
}
