package Tests;

import apiReq.RegCheck;
import apiReq.Register;
import apiReq.Spec;
import apiReq.UserData;
import dev.failsafe.internal.util.Assert;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static io.restassured.RestAssured.given;

public class apiTest {

    private final static String url = "https://reqres.in/";

    @Test
    @DisplayName("Проверка 1")
    public void checkUsersTest(){
        Spec.instSpec(Spec.ReqSpec(url), Spec.ResSpec200());
        List<UserData> users = given()
                .header("x-api-key", "reqres_1d80d0e613d54231a9780bbaf8323545")//передал токен
                .when()
                //.contentType(ContentType.JSON) - тип данных в ответе. Убрали, так как он есть в спеке
                .get("api/users?page=2")//метод + url
                .then().log().all()//логирую все
                .extract()//извлечь
                .body()//из тела запроса
                .jsonPath()
                .getList("data", UserData.class);//json-путь в указанный класс

        //users.stream()//делаю стрим из списка
        //        .forEach(x-> assertTrue(x.getAvatar().contains(x.getId().toString())));

        //assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith(("reqres.in"))));
        //все ли элементы потока заканчиваются на указанную строку

        List<String> avatars = users.stream().map(user -> user.getAvatar()).collect(Collectors.toList());
        List<String> ids = users.stream().map(user -> user.getId().toString()).collect(Collectors.toList());

        for(int i = 0; i < users.size(); i++) {
            assertTrue(
                    avatars.get(i).contains(ids.get(i))
            );
        }
    }

    @Test
    @DisplayName("Тест на регистрацию")
    public void newUserTest() {
        Spec.instSpec(Spec.ReqSpec(url), Spec.ResSpec200());

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4"; //Это я ожидаю

        Register user = new Register("eve.holt@reqres.in", "pistol");

        RegCheck regCheck = given()
                .body(user)                    // 1. Устанавливаем тело запроса
                .header("x-api-key", "reqres_1d80d0e613d54231a9780bbaf8323545") //передаю токен
                .when()                        // 2. Маркер начала действия
                .post("api/register")          // 3. Выполняем POST-запрос
                .then()                        // 4. Маркер начала проверок
                .log()                         // 5. Настройка логирования
                .all()                         // 6. Логируем всё (заголовки, тело, статус)
                .extract()                     // 7. Извлекаем данные из ответа
                .as(RegCheck.class);           // 8. Преобразуем JSON в объект RegCheck

        assertThat(regCheck.getId()).isNotNull();
        assertThat(id).isEqualTo(regCheck.getId());
        assertThat(regCheck.getToken()).isNotNull();
        assertThat(token).isEqualTo(regCheck.getToken());



    }
}
