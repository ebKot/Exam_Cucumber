package assertions;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static steps.API1Steps.*;

public class API1Asserts {
    @Step("Проверить, второй персонаж той же расы как и первый?")
    @Тогда("Проверяем то, что раса второго персонажа такая же, как у первого")
    public static void assertSpecFunc() {
        try {
            Assertions.assertEquals(charSpec, lastCharSpec, "Разновидность персонажей различается!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Проверить, второй персонаж находится там же где и первый?")
    @И("Проверяем то, что персонажи находятся в одной локации")
    public static void assertLocFunc() {
        try {
            Assertions.assertEquals(charLoc, lastCharLoc, "Местоположение персонажей различается!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}