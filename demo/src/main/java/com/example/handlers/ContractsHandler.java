package com.example.handlers;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ContractsHandler implements HttpHandler {
    ContractsPostRequest contractsPostRequest = new ContractsPostRequest();
    ContractsGetRequest contractsGetRequest = new ContractsGetRequest();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "content-type");

        String route = exchange.getRequestMethod().toUpperCase() + " " + exchange.getRequestURI().getPath();

        switch(route) {
            case "POST /contracts" -> contractsPostRequest.handleRequest(exchange);
            case "GET /contracts" -> contractsGetRequest.handleRequest(exchange);
        }
    }
}
