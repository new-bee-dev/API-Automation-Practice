package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MyFirstTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeSuite
    void setUp() {
        System.out.println("Setup started!");
        String baseUri = "https://reqres.in/api/users";
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseUri);
        requestSpec = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpec = responseSpecBuilder.build();

    }

    @Test
    void executeGetRequest() {
       Response response = given().spec(requestSpec).
                queryParam("page", 13)
        .when().
                get()
               .andReturn();
       response.getBody().prettyPrint();
       response.then().spec(responseSpec);
       JsonPath jPath = response.jsonPath();
       String result = jPath.getString("support.url");
       System.out.println(result);

    }

    @Test
    void executePostReq() {
        String body = "{\n" +
                "    \"name\": \"priya\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given().body(body)
                .when().post()
                .then().log().all()
                .assertThat().statusCode(201)
                .body("id", is(notNullValue()));
    }

    @Test
    void executePatchReq() {
        String body = "{\n" +
                "    \"name\": \"preety\",\n" +
                "}";
        RestAssured.basePath = "93";
        given().body(body)
                .when().put()
                .then().log().all()
                .assertThat().statusCode(200)
                .body("updatedAt", is(notNullValue()));
    }

    @AfterSuite
    void tearDown() {
        System.out.println("Tear down started!");
    }

}
