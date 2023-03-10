package com.krysov.tests;

import com.krysov.models.lombok.LoginBodyLombokModel;
import com.krysov.models.lombok.LoginResponseLombokModel;
import com.krysov.models.pojo.LoginBodyModel;
import com.krysov.models.pojo.LoginResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static com.krysov.helpers.CustomApiListener.withCustomTemplates;
import static com.krysov.specs.LoginSpecs.loginRequestSpec;
import static com.krysov.specs.LoginSpecs.loginResponseSpec;
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
    @Test
    void loginLombokTest() {
        LoginBodyLombokModel data = new LoginBodyLombokModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        LoginResponseLombokModel response = given()
                .log().uri()
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponseLombokModel.class);
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
    @Test
    void loginWithAllureTest() {
        LoginBodyLombokModel data = new LoginBodyLombokModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        LoginResponseLombokModel response = given()
                .log().uri()
                .log().headers()
                .log().body()
                .filter(new AllureRestAssured())
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponseLombokModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    void loginWithCustomListenerTest() {
        LoginBodyLombokModel data = new LoginBodyLombokModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        LoginResponseLombokModel response = given()
                .log().uri()
                .log().headers()
                .log().body()
                .filter(withCustomTemplates())
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponseLombokModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    void loginWithSpecsTest() {
        LoginBodyLombokModel data = new LoginBodyLombokModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        LoginResponseLombokModel response = given(loginRequestSpec)
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(loginResponseSpec)
                .extract().as(LoginResponseLombokModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }
}
