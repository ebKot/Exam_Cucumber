package steps;

import configuration.propertiesSetUp;
import methods.APIMethods;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

public class API1Steps {
    private static final String uri1 = propertiesSetUp.getProperty("url1");
    private static final int code1 = 200;
    public static String charId, charName, charLoc, charSpec, charLastEp, lastCharId, lastCharName, lastCharLoc, lastCharSpec;


    @Step("Найти информацию по персонажу c id {id}.")
    @Когда("Отправляем GET-запрос для поиска информации по персонажу с id {string}")
    public static void gettingCharInfoFunc(String id) {
        Response gettingCharInfo = new APIMethods().GETMethod(uri1, "/character/" + id, code1);
        charId = new JSONObject(gettingCharInfo.getBody().asString()).get("id").toString();
        charName = new JSONObject(gettingCharInfo.getBody().asString()).get("name").toString();
        charLoc = new JSONObject(gettingCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
        charSpec = new JSONObject(gettingCharInfo.getBody().asString()).get("species").toString();
        gettingCharInfo.then().log().body();
    }

    @Step("Найти последний эпизод с первым персонажем.")
    @Затем("Выбираем из ответа последний эпизод, где появлялся первый персонаж")
    public static void gettingLastEpFunc() {
        Response gettingLastEp = new APIMethods().GETMethod(uri1, "/character/" + charId, code1);
        int episode = (new JSONObject(gettingLastEp.getBody().asString()).getJSONArray("episode").length() - 1);
        charLastEp = new JSONObject(gettingLastEp.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
    }

    @Step("Получить из списка последнего эпизода последнего персонажа.")
    @И("Получаем из списка последнего эпизода последнего персонажа")
    public static void gettingLastCharIdFunc() {
        Response gettingLastCharId = new APIMethods().GETMethod(uri1, "/episode/" + charLastEp, code1);
        int character = (new JSONObject(gettingLastCharId.getBody().asString()).getJSONArray("characters").length() - 1);
        lastCharId = new JSONObject(gettingLastCharId.getBody().asString()).getJSONArray("characters").get(character).toString().replaceAll("[^0-9]", "");
    }

    @Step("Получить данные по местонахождению и расе второго персонажа.")
    @И("Получаем данные по местонахождению и расе второго персонажа")
    public static void gettingLastCharInfoFunc() {
        Response gettingLastCharInfo = new APIMethods().GETMethod(uri1, "/character/" + lastCharId, code1);
        lastCharName = new JSONObject(gettingLastCharInfo.getBody().asString()).get("name").toString();
        lastCharLoc = new JSONObject(gettingLastCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
        lastCharSpec = new JSONObject(gettingLastCharInfo.getBody().asString()).get("species").toString();
        gettingLastCharInfo.then().log().body();
    }
}