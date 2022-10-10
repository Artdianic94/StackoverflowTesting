package tests.APItests.restassuredtests;


import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import staticdata.Endpoints;

import static io.restassured.RestAssured.given;

public class BaseRestAssuredTest {
    Endpoints endpoints = new Endpoints();

    @Test
    public void getTenLastAnswers() {
        given()
                .log()
                .all()
                .when()
                .get(endpoints.getStackExchangeAnswers())
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }
}


