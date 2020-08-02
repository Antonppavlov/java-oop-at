package ru.geekbrains.java.oop.at.page.content;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.java.oop.at.page.content.base.ContentBasePage;

public class HomePage extends ContentBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openUrl() {
        super.openUrl("https://geekbrains.ru/");
        return this;
    }
}
