package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SerializerTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void testSerializer() throws JsonProcessingException {
        BlogPost post = new BlogPost();
        post.setId("5");
        post.setTitle("Post 5");
        post.setViews(200);
        RestAssured.baseURI = "http://localhost:3000/posts";

        String json = MAPPER.writeValueAsString(post);

        Response response = given().contentType("application/json").log().all().body(json).when().post().andReturn();
        response.getBody().prettyPrint();
        response.then().statusCode(201);

        //RestAssured.basePath = "4";


    }

    @Test
    void testDeserializer() throws JsonProcessingException {
        RestAssured.baseURI = "http://localhost:3000/posts";
        Type type = new TypeReference<List<BlogPost>>() {}.getType();
        List<BlogPost> blogPostlist = given().when().get().as(type);
        System.out.println(blogPostlist.toString());
    }
}
