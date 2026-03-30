import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

class GoogleSearchExample {

    public static void main(String[] args) {
        // Устанавливаем настройки Selenide (можно опустить, если необходимо)
        Configuration.browser = "chrome"; // Используем браузер Chrome

        // Открываем страницу Google
        open("https://www.google.com");

        // Находим поле ввода поискового запроса и вводим запрос
        $("[name='q']").setValue("Selenide").pressEnter();

        // Ждем несколько секунд, чтобы увидеть результаты (можно заменить на ожидание конкретного элемента)
        sleep(3000);

    }
}