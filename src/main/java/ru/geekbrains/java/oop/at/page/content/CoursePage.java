package ru.geekbrains.java.oop.at.page.content;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.block.ContentNavigationCourseBlock;
import ru.geekbrains.java.oop.at.page.content.base.ContentBasePage;

import java.util.List;
public class CoursePage extends ContentBasePage {

    @Getter
    private ContentNavigationCourseBlock contentNavigationCourseBlock;

    @FindBy(xpath = "//form/ul//label")
    private List<WebElement> filterList;

    @FindBy(xpath = "//a/div/div/span")
    private List<WebElement> courseList;

    public CoursePage(WebDriver driver) {
        super(driver);
        this.contentNavigationCourseBlock = new ContentNavigationCourseBlock(driver);
    }

    @Step("Настройка фильтра курсов: {args}")
    public CoursePage configFilter(String... args) {
        for (String text : args) {
            WebElement element = findElement(filterList, text);
            element.click();
        }
        return this;
    }

    @Step("Проверка отображения курсов: {args}")
    public CoursePage checkingDisplayedCourses(String... args) {
        for (String text : args) {
            WebElement element = findElement(courseList, text);
            wait10second.until(ExpectedConditions.visibilityOf(element));
        }
        return this;
    }

    public ContentNavigationCourseBlock getContentNavigationCourseBlock() {
        return contentNavigationCourseBlock;
    }

    @Override
    public CoursePage openUrl() {
        super.openUrl("https://geekbrains.ru/courses");
        return this;
    }
}
