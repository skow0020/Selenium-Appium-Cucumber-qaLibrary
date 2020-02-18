package core.pages.articles;

import core.base.PageObjectBase;

public abstract class ArticlesPage extends PageObjectBase {
    public abstract void assertPagePresent();

    public abstract void clickAddArticle();
}
