package ru.geekbrains.java.oop.at.page;

import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.java.oop.at.block.Navigation;

@Getter
public class ContentPage extends PageFactory {

    @FindBy(css = "[class*='gb-header__content']")
    private WebElement header;

    @FindBy(css = "[class='site-footer__content']")
    private WebElement footer;

    @FindBy(css = "[id=\"top-menu\"] h2")
    private WebElement namePage;

    @FindBy(css = "[class=\"gb-empopup-close\"]")
    private WebElement buttonClosePopUp1;

    @FindBy(css = "button [class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonClosePopUp2;

    private Navigation navigation;

    public ContentPage(WebDriver driver) {
        initElements(driver, this);
        navigation = new Navigation(driver);
    }

    @Step("проверка что имя страницы: {expectedNamePage}")
    public void checkNamePage(String expectedNamePage) {
        Assertions.assertEquals(expectedNamePage, namePage.getText());
    }

}
