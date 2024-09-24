package org.example;

import org.asynchttpclient.Dsl;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;

import java.util.concurrent.ExecutionException;

public class AsyncRequests {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListenableFuture<Response> responseFuture = Dsl.asyncHttpClient().prepareGet("https://reqres.in/api/users/?delay=5").execute();
        Response response = responseFuture.get();
        System.out.println(response.getStatusCode());
        System.out.println(response);
    }
}
