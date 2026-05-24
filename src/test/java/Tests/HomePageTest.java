package Tests;

import Pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    @DisplayName("Переход на Elements")
    public void testClickElementsButton() {
        homePage.getElementsButton().scrollIntoView(true);
        homePage.getElementsButton().shouldBe(visible, Duration.ofSeconds(10));
        homePage.getElementsButton().click();

        String currentUrl = url();

        assertThat(currentUrl).isEqualTo("https://demoqa.com/elements");
    }

    @Test
    @DisplayName("Переход на Form")
    public void testClickFormBotton() {
        homePage.getFormsButton().scrollIntoView(true);//скролю до элемента пока он не станет видим
        homePage.getFormsButton().click();

        String curentUrl = url();

        assertThat(curentUrl).isEqualTo("https://demoqa.com/forms");
    }

}