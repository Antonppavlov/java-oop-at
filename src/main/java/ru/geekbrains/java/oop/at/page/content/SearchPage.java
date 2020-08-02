package ru.geekbrains.java.oop.at.page.content;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import ru.geekbrains.java.oop.at.block.SearchTabsBlock;
import ru.geekbrains.java.oop.at.page.content.base.ContentBasePage;

public class SearchPage extends ContentBasePage {

    @Getter
    private SearchTabsBlock searchTabsBlock;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.searchTabsBlock = new SearchTabsBlock(driver);
    }

    @Override
    public SearchPage openUrl() {
        super.openUrl("https://geekbrains.ru/search");
        return this;
    }
}
