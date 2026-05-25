package Pages.Components;

import Pages.Data.User;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegFormOfTable {

    private final SelenideElement firstname = $x("//input[@placeholder = 'First Name']");
    private final SelenideElement lastName = $x("//input[@placeholder = 'Last Name']");
    private final SelenideElement email = $("input[placeholder = 'name@example.com']");
    private final SelenideElement age = $("input[placeholder = 'Age']");
    private final SelenideElement salary = $x("//input[@placeholder = 'Salary']");
    private final SelenideElement department = $("input[placeholder = 'Department']");
    private final SelenideElement submitBotton = $x("//button[contains(text(), 'Submit')]");

    public void fillRegForm(User user) {
        firstname.setValue(user.getFirstName());
        lastName.setValue(user.getLastName());
        email.setValue(user.getEmail());
        age.setValue(user.getAge());
        salary.setValue(user.getSalary());
        department.setValue(user.getDep());
    }

    public SelenideElement getFirstname() {
        return firstname;
    }

    public SelenideElement getLastName() {
        return lastName;
    }

    public SelenideElement getEmail() {
        return email;
    }

    public SelenideElement getAge() {
        return age;
    }

    public SelenideElement getSalary() {
        return salary;
    }

    public SelenideElement getDepartment() {
        return department;
    }

    public SelenideElement getSubmitBotton() {
        return submitBotton;
    }
}
