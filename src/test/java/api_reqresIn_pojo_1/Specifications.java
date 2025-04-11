package api_reqresIn_pojo_1;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification RequestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification ResponeSpec(int code) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }

    public static void InstallSpecifications(RequestSpecification Request, ResponseSpecification Response) {
        RestAssured.requestSpecification = Request;
        RestAssured.responseSpecification = Response;
    }

}
