package com.krysov.models.pojo;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class LoginBodyModel {

    private String email, password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Test
    void loginTest() {

//        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

//        given()
//                .log().uri()
//                .contentType(JSON)
//                .body(data)
//                .when()
//                .post("https://reqres.in/api/login")
//                .then()
//                .log().status()
//                .log().body()
//                .statusCode(200)
//                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
}
