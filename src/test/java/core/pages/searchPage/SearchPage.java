package core.pages.searchPage;

import core.base.PageObjectBase;

public abstract class SearchPage extends PageObjectBase {
    public abstract void assertPagePresent();

    public abstract void search(String searchText);

    public abstract void navigate();
}
