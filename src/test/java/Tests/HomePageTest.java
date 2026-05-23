package Tests;

import Pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HomePageTest {

    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        open(homePage.getUrl());
        homePage = new HomePage();
    }

    @Test
    public void testClickElementsButton() {
        homePage.clickElementsButton();

        String currentUrl = url();

        assertThat(currentUrl).isEqualTo(homePage.getUrl());
        System.out.print("Мы там где хотели быть!");
    }

}