package Pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement elementsButton = $x("//h5[text()='Elements']");
    private final SelenideElement formsButton = $x("//h5[text()='Forms']");
    private final SelenideElement alertsFrameWindowsButton = $x("//h5[text()='Alerts, Frame & Windows']");
    private final SelenideElement widgetsButton = $("h5:contains('Widgets')");
    private final SelenideElement interactionsButton = $("h5:contains('Interactions')");
    private final SelenideElement bookStoreApplicationButton = $("h5:contains('Book Store Application')");

    public void clickElementsButton () {
        executeJavaScript("arguments[0].click();", elementsButton);
    }

}