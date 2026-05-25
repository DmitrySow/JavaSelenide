package Pages.Data;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String dep;

    public User(String firstName, String lastName, String email, String age, String salary, String dep) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.dep = dep;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDep() {
        return dep;
    }
}
