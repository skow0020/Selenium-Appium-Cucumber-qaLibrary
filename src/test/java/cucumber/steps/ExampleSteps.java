package cucumber.steps;

import core.pages.addArticle.AddArticlePage;
import core.pages.addArticle.AddArticlePageAndroid;
import core.pages.addArticle.AddArticlePageWeb;
import core.pages.articles.ArticlesPage;
import core.pages.articles.ArticlesPageAndroid;
import core.pages.articles.ArticlesPageWeb;
import core.pages.common.CommonElements;
import core.pages.common.CommonElementsAndroid;
import core.pages.common.CommonElementsWeb;
import core.pages.homePage.HomePage;
import core.pages.homePage.HomePageAndroid;
import core.pages.homePage.HomePageWeb;
import core.pages.loginPage.LoginPage;
import core.pages.loginPage.LoginPageAndroid;
import core.pages.loginPage.LoginPageWeb;
import core.pages.searchPage.SearchPage;
import core.pages.searchPage.SearchPageAndroid;
import core.pages.searchPage.SearchPageWeb;
import core.pages.sideBar.SideBarModule;
import core.pages.sideBar.SideBarModuleAndroid;
import core.pages.sideBar.SideBarModuleWeb;
import core.utilities.setup.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExampleSteps {
    private LoginPage loginPage;
    private SearchPage searchPage;
    private HomePage homePage;
    private ArticlesPage articlesPage;
    private AddArticlePage addArticlePage;
    private SideBarModule sideBarModule;
    private CommonElements commonElements;

    public ExampleSteps() {
        if (Hooks.getConfigInfo().isWeb()) {
            loginPage = new LoginPageWeb();
            searchPage = new SearchPageWeb();
            homePage = new HomePageWeb();
            articlesPage = new ArticlesPageWeb();
            addArticlePage = new AddArticlePageWeb();
            sideBarModule = new SideBarModuleWeb();
            commonElements = new CommonElementsWeb();
        } else if (Hooks.getConfigInfo().isAndroid()) {
            loginPage = new LoginPageAndroid();
            homePage = new HomePageAndroid();
            sideBarModule = new SideBarModuleAndroid();
            articlesPage = new ArticlesPageAndroid();
            addArticlePage = new AddArticlePageAndroid();
            searchPage = new SearchPageAndroid();
            commonElements = new CommonElementsAndroid();
        } else if (Hooks.getConfigInfo().isIos()) {
        }
    }

    @Given("I log in to the website")
    public void iLogInToTheWebsite() {
        loginPage.login();
        homePage.assertPagePresent();
    }

    @When("I navigate to the search page")
    public void iNavigateToTheSearchPage() {
        searchPage.navigate();
    }

    @Then("I can search for {string}")
    public void iCanSearchForStuff(String searchText) {
        searchPage.search(searchText);
    }

    @When("I navigate to the article page")
    public void i_navigate_to_the_article_page() {
        sideBarModule.clickArticles();
        articlesPage.assertPagePresent();
    }

    @Then("I can add an article")
    public void i_can_add_an_article() {
        articlesPage.clickAddArticle();
        addArticlePage.completeFields()
                        .submit();
        commonElements.verifyPopupIndicates("Article added successfully");
    }
}
