package Tests;

import Pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HomePageTest {

    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        open("https://demoqa.com");
        homePage = new HomePage();
    }

    @Test
    public void testClickElementsButton() {
        homePage.clickElementsButton();

        String currentUrl = url();

        assertTrue(currentUrl.equals("https://demoqa.com/elements"));

        System.out.print("Мы там где хотели быть!");
    }

}