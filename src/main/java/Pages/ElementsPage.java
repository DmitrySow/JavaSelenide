package Pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class ElementsPage {

    private final SelenideElement textBoxTab = $x("//span[text()='Text Box']");

    public void clickTextBoxTab() {
        textBoxTab.click();
    }
}
