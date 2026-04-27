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

    //Web Tables
    private final SelenideElement webTablesTab = $("[href='/webtables']");
    private final ElementsCollection rows = $$("tbody tr");

    public void clickTextBoxTab() {
        textBoxTab.click();
    }

    public void insertFullName(String str) {
        fullNameBox.setValue(str);
    }

    public void getFullName() {
        String str = fullNameBox.getValue();
        System.out.println(str);
    }

    public void insertEmail(String str) {
        emailBox.setValue(str);
    }

    public void getEmail() {
        String str = emailBox.getValue();
        System.out.println(str);
    }

    public void insertCurrentAddress(String str) {
        currentAddressBox.setValue(str);
    }

    public void getCurrentAddress() {
        String str = currentAddressBox.getValue();
        System.out.println(str);
    }

    public void insertPermanentAddress(String str) {
        permanentAddress.setValue(str);
    }

    public void getPermanentAddress() {
        String str = permanentAddress.getValue();
        System.out.println(str);
    }

    public void clickSubmit() {
        submitButton.scrollTo();
        sleep(100);
        submitButton.click();
    }

    public void getValue(SelenideElement elem) {
        String str = elem.getValue();
        System.out.print(str);
    }

    public void clickWebTablesTab() {
        webTablesTab.click();
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
