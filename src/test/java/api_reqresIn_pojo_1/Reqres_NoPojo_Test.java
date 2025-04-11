package api_reqresIn_pojo_1;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Reqres_NoPojo_Test {
    private final static String URL = "https://reqres.in/";

    /**
     * Тест1, без Pojo классов:
     * 1.Используя сервис https://reqres.in/ получить список пользователей со второй (2) страницы
     * 2.Убедиться что имена файлов-аватаров пользователей совпадат
     * 3.Убедиться что емайл пользователей имеет окончание reqres.in
     */
    @Test
    public void CheckAvatarNoPojoTest() {
        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(200));
        Response response = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))
                .body("data.id", notNullValue())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.get("data.email");
        List<String> avatar = jsonPath.get("data.avatar");
        List<Integer> ids = jsonPath.get("data.id");
        for (int i = 0; i < avatar.size(); i++) {
            Assert.assertTrue(avatar.get(i).contains(ids.get(i).toString()));
        }
        Assert.assertTrue(emails.stream().allMatch(x -> x.endsWith("@reqres.in")));
    }


    /**
     * Тест2.1 Без Pojo классов:
     * 1.Используя сервис https://reqres.in протестировать регистрацию пользователя в системе
     * -успешная регистрация
     */
    @Test

    public void SuccessfullRegNoPojoTest() {
        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(200));
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .body("id", equalTo(id))
                .body("token", equalTo(token));
    }


    /**
     * Тест2.2:
     * 1.Используя сервис https://reqres.in протестировать регистрацию пользователя в системе
     * -регистрация с ошибкой из-за отсутствия пароля
     */
    @Test
    public void UnSuccessRegisterNoPojoTest() {
        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(400));
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        given()
                .when()
                .body(user)
                .post("/api/register")
                .then().log().all()
                .body("error", equalTo("Missing password"));
    }


    /**
     * Тест3 Без Pojo классов:
     * 1.Используя сервис https://reqres.in убедиться, что операция LIST<RESOURCE> возвращает данные,
     * отсортированные по годам
     */
    @Test
    public void CheckSortedYearsNoPojoTest() {
        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(200));
        Response response = given()
                .when()
                .get("/api/unknown")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<Integer> year = jsonPath.getList("data.year");


        Assert.assertEquals(year.stream().sorted().collect(Collectors.toList()), year);
    }


    /**
     * Тест4.2 Без Pojo классов:
     * -Используя сервис https://reqres.in обновить информацию о пользователе и сравнить дату обновления
     * с текущей датой на машине
     */
    @Test
    public void CheckTimeNoPojoTest() {
        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(200));
        Response response = given()
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String time = jsonPath.getString("updatedAt").replaceAll("^([^:]*:[^:]*):.*$", "$1");
        String localTime = Clock.systemUTC().instant().toString().replaceAll("^([^:]*:[^:]*):.*$", "$1");

        System.out.println("time:      " + time);
        System.out.println("localTime: " + localTime);
        Assert.assertEquals(time, localTime);

    }
}
