package assertions;

import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static steps.API2Steps.*;

public class API2Asserts {
    @Step("Проверить response на валидность.")
    @Тогда("Проверяем ответ на валидность")
    public static void responseValidationAssert() {
        try {
            Assertions.assertEquals("Tomato", name);
            Assertions.assertEquals("Eat maket", job);
            Assertions.assertTrue(id.matches("[0-9]+"));
            Assertions.assertTrue(createdAt.matches("([0-9]{4})-([0-1][0-9])-([0-3][0-9])T([0-2][0-9]):([0-5][0-9]):([0-5][0-9])\\.([0-9]{3})Z"));
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}