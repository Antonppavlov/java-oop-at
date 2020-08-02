package ru.geekbrains.java.oop.at.block;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.java.oop.at.page.BasePageObject;
import ru.geekbrains.java.oop.at.utils.ButtonNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTabsBlock extends BasePageObject {

    @FindBy(css = "[class='search-page-tabs'] [data-tab='all']")
    private WebElement tabEveryWhere;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='professions']")
    private WebElement tabProfessions;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='courses']")
    private WebElement tabCourses;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='webinars']")
    private WebElement tabWebinars;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='blogs']")
    private WebElement tabBlogs;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='forums']")
    private WebElement tabForums;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='tests']")
    private WebElement tabTests;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='companies']")
    private WebElement tabCompanies;

    public SearchTabsBlock(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на tab: {tab}")
    public void clickTab(Tab tab) {
        getTab(tab).click();
    }

    @Step("Проверяю {tab} на условие {matcher}")
    public SearchTabsBlock checkCount(Tab tab, Matcher<Integer> matcher) {
        String actualCount = getTab(tab).findElement(By.cssSelector("span")).getText();
        assertThat(Integer.parseInt(actualCount), matcher);
        return this;
    }

    private WebElement getTab(Tab tab) {
        switch (tab) {
            case EVERYWHERE:
                return tabEveryWhere;
            case PROFESSIONS:
                return tabProfessions;
            case COURSES:
                return tabCourses;
            case WEBINARS:
                return tabWebinars;
            case BLOGS:
                return tabBlogs;
            case FORUMS:
                return tabForums;
            case TESTS:
                return tabTests;
            case COMPANIES:
                return tabCompanies;
            default:
                throw new ButtonNotFoundException("Unexpected value: " + tab);
        }
    }


//    Enum —  класс. Список который имеет ограниченный, неизменяемый набор значений
//    Он специально «заточен» на решение задач:
//      создание некоторого ограниченного круга значений.

//    В нашем случае позволяет определив в одном месте, использовать этот список везде в проекте.
//    И не дать возможность пользователю допустить ошибку с названием кнопки

    public enum Tab {
        EVERYWHERE("Везде"),
        PROFESSIONS("Профессии"),
        COURSES("Курсы"),
        WEBINARS("Вебинары"),
        BLOGS("Блоги"),
        FORUMS("Форумы"),
        TESTS("Тесты"),
        COMPANIES("Компании");

        private String text;

        Tab(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}

