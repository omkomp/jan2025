package api_reqresIn_pojo_1;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Reqres_Test {
    private final static String URL = "https://reqres.in/";

    /**
     * Тест1:
     * 1.Используя сервис https://reqres.in/ получить список пользователей со второй (2) страницы
     * 2.Убедиться что имена файлов-аватаров пользователей совпадат
     * 3.Убедиться что емайл пользователей имеет окончание reqres.in
     */
    @Test
    public void CheckAvatar() {
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        users.forEach(x -> Assert.assertTrue(x.getEmail().endsWith("@reqres.in")));
/**
 * либо проверить через стрим, все то же самое
 */
        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
        Assert.assertTrue(users.stream().allMatch(x -> x.getAvatar().contains(x.getId().toString())));

        /**
         * еще одна такая же проверка только через списки и цикл
         */
        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue("Avatar не содержит ID: " + ids, avatars.get(i).contains(ids.get(i)));
        }
    }


    /**
     * Тест1(тут те же тесты, только с использованием спецификаций):
     * 1.Используя сервис https://reqres.in/ получить список пользователей со второй (2) страницы
     * 2.Убедиться что имена файлов-аватаров пользователей совпадат
     * 3.Убедиться что емайл пользователей имеет окончание reqres.in
     */
    @Test
    public void CheckAvatarWithSpecifications() {
        /**
         * статус код ставим тот который хотим проверить
         */
        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(200));
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        users.forEach(x -> Assert.assertTrue(x.getEmail().endsWith("@reqres.in")));
    }


    /**
     * Тест2.1:
     * 1.Используя сервис https://reqres.in протестировать регистрацию пользователя в системе
     * -успешная регистрация
     */
    @Test
    public void SuccessRegister() {
        /**
         * статус код ставим тот который хотим проверить
         */
        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(200));
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");

        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }


    /**
     * Тест2.2:
     * 1.Используя сервис https://reqres.in протестировать регистрацию пользователя в системе
     * -регистрация с ошибкой из-за отсутствия пароля
     */
    @Test
    public void UnSuccessRegister() {

        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(400));

        String error = "Missing password";
        Register user = new Register("eve.holt@reqres.in", "");

        UnsuccessReg UnsuccessReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(UnsuccessReg.class);
        Assert.assertEquals(error, UnsuccessReg.getError());

    }


    /**
     * Тест3:
     * 1.Используя сервис https://reqres.in убедиться, что операция LIST<RESOURCE> возвращает данные,
     * отсортированные по годам
     */
    @Test
    public void CheckSortedYears() {

        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(200));

        List<Years> years = given()
                .when()
                .get("/api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", Years.class);

        List<Integer> OnlyYears = years.stream().map(Years::getYear).collect(Collectors.toList());
        List<Integer> SortedYears = OnlyYears.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(SortedYears, OnlyYears);
        System.out.println("OnlyYears- фактический рез-т" + "  " + OnlyYears);
        System.out.println("SortedYears- ожидаемый рез-т" + " " + SortedYears);
    }




    /**
     * Тест4.1:
     * -Используя сервис https://reqres.in попробовать удалить второго пользователя и сравнить статус коды
     */
    @Test
    public void CheckUserDeleted() {

        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(204));

        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();
    }




    /**
     * Тест4.2:
     * -Используя сервис https://reqres.in обновить информацию о пользователе и сравнить дату обновления
     * с текущей датой на машине
     */
    @Test
    public void CheckTime() {

        Specifications.InstallSpecifications(Specifications.RequestSpec(URL), Specifications.ResponeSpec(200));
        UserTime userTime = new UserTime("morpheus", "zion resident");
        UserTimeResponse userTimeResponse = given()
                .body(userTime)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String CurrentTime= Clock.systemUTC().instant().toString().replaceAll("^([^:]*:[^:]*):.*$", "$1");

         Assert.assertEquals(userTimeResponse.getUpdatedAt().replaceAll("^([^:]*:[^:]*):.*$", "$1"), CurrentTime);
    }


}