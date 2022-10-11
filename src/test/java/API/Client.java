package API;

import API.static_data.WebUrl;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Client {

    private final RequestSpecification spec;

    public Client(RequestSpecification spec) {
        this.spec = spec;
    }

    public Client() {
        spec = given().filter(new AllureRestAssured());
    }

    public Response getRequestSpec(Map<String, String> queryParam, String basePath) {
        final RequestSpecification requestSpecification = this.spec
                .contentType(ContentType.JSON)
                .queryParams(queryParam)
                .baseUri(WebUrl.STACK_EXCHANGE_URL)
                .basePath(basePath);
        return requestSpecification
                .log().all()
                .get()
                .then()
                .log().all()
                .extract()
                .response();
    }
}
