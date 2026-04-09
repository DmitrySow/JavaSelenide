package Tests;

import Pages.HomePage;
import Pages.ElementsPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ElementsPageTest {

    private HomePage homePage;
    private ElementsPage elementsPage;

    @BeforeEach
    public void clickTextBoxTab() {
        open("https://demoqa.com");
        homePage = new HomePage();
        elementsPage = new ElementsPage();
    }

    @Test
    public void openTextBoxTab() {
        homePage.clickElementsButton();

        String currentUrl = url();
        assertTrue(currentUrl.equals("https://demoqa.com/elements"));
        System.out.print("Мы в элемент проникли!");

        elementsPage.clickTextBoxTab();

        currentUrl = url();
        assertTrue(currentUrl.equals("https://demoqa.com/text-box"));
        System.out.print("Мы в TextBox!");
    }

}
