package Tests;

import Pages.HomePage;
import Pages.ElementsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ElementsPageTest {

    private HomePage homePage;
    private ElementsPage elementsPage;

    @BeforeEach
    public void openHomePage() {
        open("https://demoqa.com");
        homePage = new HomePage();
        elementsPage = new ElementsPage();
    }

    @Test
    @DisplayName("Открытие страницы")
    public void openTextBoxTab() {
        homePage.clickElementsButton();

        String currentUrl = url();
        assertTrue(currentUrl.equals("https://demoqa.com/elements"));
        System.out.println("Открыта страница Elements");

        elementsPage.clickTextBoxTab();

        currentUrl = url();
        assertTrue(currentUrl.equals("https://demoqa.com/text-box"));
        System.out.println("Открыта страница TextBox!");
    }

    @Test
    @DisplayName("Заполнение формы валидными данными")
    public void fillingForm() {
        homePage.clickElementsButton();

        String currentUrl = url();
        assertTrue(currentUrl.equals("https://demoqa.com/elements"));
        System.out.println("Открыта страница Elements");

        elementsPage.clickTextBoxTab();

        currentUrl = url();
        assertTrue(currentUrl.equals("https://demoqa.com/text-box"));
        System.out.println("Открыта страница TextBox!");

        elementsPage.insertFullName("Бориска Барсук");
        elementsPage.getFullName();

        elementsPage.insertEmail("pochta@mail.ru");
        elementsPage.getEmail();

        elementsPage.insertCurrentAddress("Сельская местность");
        elementsPage.getCurrentAddress();

        elementsPage.insertPermanentAddress("Городская местность");
        elementsPage.getPermanentAddress();

        elementsPage.clickSubmit();
        System.out.print("Нажали на кнопку");

    }

    @Test
    @DisplayName("Тест на таблицу")
    public void tableTest() {
        homePage.clickElementsButton();

        String currentUrl = url();
        assertTrue(currentUrl.equals("https://demoqa.com/elements"));
        System.out.println("Открыта страница Elements");

        elementsPage.clickWebTablesTab();

        currentUrl = url();
        assertTrue(currentUrl.equals("https://demoqa.com/webtables"));
        System.out.println("Открыта страница Web Tables!");

        ArrayList<String> tableElements = elementsPage.getTableValues();
        System.out.println("Данные из таблицы получены");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "Cierra", "Vega", "39", "cierra@example.com", "10000", "Insurance", "",
                "Alden", "Cantrell", "45", "alden@example.com", "12000", "Compliance", "",
                "Kierra", "Gentry", "29", "kierra@example.com", "2000", "Legal", ""
        ));

        assertThat(tableElements).isEqualTo(list);
        System.out.println("Списки совпадают!");

    }

}
