package com.example.smartcampus;

import com.example.smartcampus.config.ApplicationConfig;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/api/v1/";

    public static HttpServer startServer() {
        return GrizzlyHttpServerFactory.createHttpServer(
                URI.create(BASE_URI),
                new ApplicationConfig()
        );
    }

    public static void main(String[] args) {
        try {
            HttpServer server = startServer();
            System.out.println("Server started at " + BASE_URI);
            System.out.println("Server is running...");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}