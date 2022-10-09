package com.ibs.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    @Story("JsonPlaceholder")
    @Description("Возвращается {0} Todos")
    public void testTodoCountIsEqualToSize(){
        when()
                .get("https://jsonplaceholder.typicode.com/todos")
                .then()
                .assertThat()
                .body("$", hasSize(200));
    }

    @Test
    @Story("JsonPlaceholder")
    @Description("Возвращаеться {0} users")
    public void testUserCountIsEqualToSize() {
        when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .assertThat()
                .body("$", hasSize(10));
    }

    @Test
    @Story("JsonPlaceholder")
    @Description("ID = 1")
    public void testTodoOne(){
        when()
                .get("https://jsonplaceholder.typicode.com/todos/1")
                .then()
                .assertThat()
                .body("userId", equalTo(1))
                .and()
                .body("title", equalTo("delectus aut autem"));
    }
}
