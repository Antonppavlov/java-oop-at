package ru.geekbrains.java.oop.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.java.oop.at.base.BeforeAndAfterStep;
import ru.geekbrains.java.oop.at.block.SearchTabsBlock;
import ru.geekbrains.java.oop.at.page.content.TestPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

@Feature("Поиск")
@Story("Проверка отображения блоков")
@DisplayName("Проверка отображения блоков")
@Execution(ExecutionMode.CONCURRENT)
public class SearchWebTest extends BeforeAndAfterStep {

    @BeforeEach
    void beforeSearchTest() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @DisplayName("Проверка количества контента")
    @Test
    void searchTest() {
        new TestPage(driver)
                .openUrl()
                .getHeaderBlock()
                .searchText("java")
                .getSearchTabsBlock()
                .checkCount(SearchTabsBlock.Tab.PROFESSIONS, greaterThanOrEqualTo(2))
                .checkCount(SearchTabsBlock.Tab.COURSES, greaterThan(15))
                .checkCount(SearchTabsBlock.Tab.WEBINARS, allOf(greaterThan(180), lessThan(300)))
                .checkCount(SearchTabsBlock.Tab.BLOGS, greaterThan(300))
                .checkCount(SearchTabsBlock.Tab.FORUMS, not(350))
                .checkCount(SearchTabsBlock.Tab.TESTS, not(0));
    }
}
