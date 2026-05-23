package apiReq;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.openqa.selenium.devtools.v128.network.model.Request;

public class Spec {

    public static RequestSpecification ReqSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification ResSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

    }

    public static ResponseSpecification ResSpec500() {
        return new ResponseSpecBuilder()
                .expectStatusCode(500)
                .build();

    }

    public static void instSpec(RequestSpecification req, ResponseSpecification res) {
        RestAssured.requestSpecification = req;
        RestAssured.responseSpecification = res;
    }
}