package com.example.handlers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

public class ContractsGetRequest implements Handle {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void handleRequest(HttpExchange exchange) throws IOException {

        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");

    }
}
