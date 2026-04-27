package Pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement elementsButton = $("h5:first-of-type");
    private final SelenideElement formsButton = $("h5:nth-child(2)");
    private final SelenideElement alertsFrameWindowsButton = $x("//h5[text()='Alerts, Frame & Windows']");
    private final SelenideElement widgetsButton = $("h5:contains('Widgets')");
    private final SelenideElement interactionsButton = $("h5:contains('Interactions')");
    private final SelenideElement bookStoreApplicationButton = $("h5:contains('Book Store Application')");

    public void clickElementsButton () {
        executeJavaScript("arguments[0].click();", elementsButton);
    }

}