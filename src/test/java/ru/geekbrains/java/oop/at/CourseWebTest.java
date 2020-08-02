package ru.geekbrains.java.oop.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.java.oop.at.base.BeforeAndAfterStep;
import ru.geekbrains.java.oop.at.block.ContentNavigationCourseBlock;
import ru.geekbrains.java.oop.at.block.LeftNavigation;
import ru.geekbrains.java.oop.at.page.content.CoursePage;

@Feature("Поиск")
@Story("Проверка отображения блоков")
@DisplayName("Страница Курсы")
@Execution(ExecutionMode.CONCURRENT)
public class CourseWebTest extends BeforeAndAfterStep {

    @DisplayName("Проверка работы фильтров")
    @Test
    void checkSingInValidLogin() {
        CoursePage coursePage = ((CoursePage)
                new CoursePage(driver)
                        .openUrl()
                        .closedPopUp()
                        .getLeftNavigation()
                        .clickButton(LeftNavigation.Button.COURSES)
        );


        coursePage.getContentNavigationCourseBlock().clickTab(ContentNavigationCourseBlock.Tab.COURSES)
                .configFilter("Бесплатные", "Тестирование")
                .checkingDisplayedCourses(
                        "Тестирование ПО. Уровень 1",
                        "Тестирование ПО. Уровень 2"
                )
        ;

    }
}
