package com.dat.java.core.api;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HttpClientDemo {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // GET request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .header("User-Agent", "Java 11 HttpClient Bot")
                .header("Accept", "application/json")
                .build();
        System.out.println(httpRequest);

        // POST request
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .header("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Hello, World!"))
                .build();

        System.out.println(postRequest);
        HttpClient client = HttpClient.newBuilder()
                .proxy(ProxySelector.getDefault())
                .build();
        HttpResponse<String> response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        System.out.println(response.statusCode());
    }
}
