package steps;

import configuration.propertiesSetUp;
import methods.APIMethods;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class API2Steps {
    private static final String uri2 = propertiesSetUp.getProperty("url2");
    private static final int code2 = 201;
    public static JSONObject bodyJson;
    public static String name, job, id, createdAt;

    @Step("Создать запрос для создания пользователя.")
    @Когда("Отправляем POST-запрос для создания пользователя")
    public static void createUserFunc() throws IOException {
        bodyJson = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/jsonFile.json"))));
        bodyJson.put("name", "Tomato");
        bodyJson.put("job", "Eat maket");

        Response createUser = new APIMethods().POSTMethod(uri2, ContentType.JSON, bodyJson.toString(), "/api/users", code2);
        name = new JSONObject(createUser.getBody().asString()).get("name").toString();
        job = new JSONObject(createUser.getBody().asString()).get("job").toString();
        id = new JSONObject(createUser.getBody().asString()).get("id").toString();
        createdAt = new JSONObject(createUser.getBody().asString()).get("createdAt").toString();
    }
}