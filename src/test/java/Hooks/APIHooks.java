package Hooks;

import io.cucumber.java.Before;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class APIHooks {
    @Before
    public static void setup() {
        RestAssured.filters(new AllureRestAssured());
    }
}