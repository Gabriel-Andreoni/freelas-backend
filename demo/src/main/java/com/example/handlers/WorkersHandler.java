package com.example.handlers;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;



public class WorkersHandler implements HttpHandler {
    private final PostRequest postRequest = new PostRequest();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        switch (exchange.getRequestMethod().toUpperCase()) {
            case "POST" -> postRequest.handleRequest(exchange);
        }
    }
}
