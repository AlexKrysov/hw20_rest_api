package com.krysov.tests;

import com.krysov.models.pojo.LoginBodyModel;
import com.krysov.models.pojo.LoginResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class ReqresTests {



    @Test
    void loginTest() {
        LoginBodyModel data = new LoginBodyModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        LoginResponse response =
        given()
                .log().uri()
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponse.class);
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
}
