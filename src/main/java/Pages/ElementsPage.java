package Pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class ElementsPage {

    //Text Box Page
    private final SelenideElement textBoxTab = $("span.text");
    private final SelenideElement fullNameBox = $("input[placeholder='Full Name']");
    private final SelenideElement emailBox = $("input[placeholder='name@example.com']");
    private final SelenideElement currentAddressBox = $("textarea[placeholder='Current Address']");
    private final SelenideElement permanentAddress = $("textarea#permanentAddress");
    private final SelenideElement submitButton = $("button#submit");
    private final String url = "https://demoqa.com/elements";

    //Web Tables
    private final SelenideElement webTablesTab = $("[href='/webtables']");
    private final ElementsCollection rows = $$("tbody tr");

    public void clickTextBoxTab() {
        textBoxTab.click();
    }

    public void insertFullName(String str) {
        fullNameBox.setValue(str);
    }

    public String getFullName() {
        String str = fullNameBox.getValue();
        return str;
    }

    public void insertEmail(String str) {
        emailBox.setValue(str);
    }

    public String getEmail() {
        String str = emailBox.getValue();
        return str;
    }

    public void insertCurrentAddress(String str) {
        currentAddressBox.setValue(str);
    }

    public String getCurrentAddress() {
        String str = currentAddressBox.getValue();
        return str;
    }

    public void insertPermanentAddress(String str) {
        permanentAddress.setValue(str);
    }

    public String getPermanentAddress() {
        String str = permanentAddress.getValue();
        return str;
    }

    public void clickSubmit() {
        submitButton.scrollTo();
        sleep(100);
        submitButton.click();
    }

    public void clickWebTablesTab() {
        webTablesTab.click();
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<String> getTableValues() {

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < rows.size(); i++) {
            SelenideElement row = rows.get(i);

            ElementsCollection cl = row.$$("td");

            for(int j = 0; j < cl.size(); j++) {
                String value = cl.get(j).getText();
                list.add(value);
            }
        }
        return list;
    }
}
