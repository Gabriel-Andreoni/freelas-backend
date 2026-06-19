package com.example.handlers;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class WorkersHandler implements HttpHandler {
    private final PostRequest postRequest = new PostRequest();
    private final GetRequest getRequest = new GetRequest();
    private final Options options = new Options();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "content-type");


        switch (exchange.getRequestMethod().toUpperCase()) {
            case "POST" -> postRequest.handleRequest(exchange);
            case "GET" -> getRequest.handleRequest(exchange);
            case "OPTIONS" -> options.handleRequest(exchange);
        }
    }
}
