package core.pages.addArticle;

import core.base.PageObjectBase;

public abstract class AddArticlePage extends PageObjectBase {
    public abstract AddArticlePage assertPagePresent();
    public abstract AddArticlePage completeFields();
    public abstract AddArticlePage submit();
}
