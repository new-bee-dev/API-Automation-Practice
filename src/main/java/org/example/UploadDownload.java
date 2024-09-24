package org.example;

import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;

public class UploadDownload {
    public static void main(String[] args) throws IOException {
        //upload
//        File file = new File(System.getProperty("user.dir") + "/src/main/resources/sample-image.png");
//
//        Response response = given().contentType("multipart/form-data").multiPart("file", file)
//                .post("https://the-internet.herokuapp.com/upload")
//                .andReturn();
//        response.getBody().prettyPrint();

        //download
        Response responseDownload = given().get("http://localhost:3000/comments").andReturn();
        byte[] bytes = responseDownload.asByteArray();
        File fileDownload = new File(System.getProperty("user.dir") + "/src/main/resources/output.txt");
        Files.write(fileDownload.toPath(), bytes);

    }
}
