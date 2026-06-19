package com.example.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.example.entities.WorkersList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

public class GetRequest implements Handle {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleRequest(HttpExchange exchange) throws IOException {
        String jsonResponse = objectMapper.writeValueAsString(WorkersList.listWorkers());

        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");

        byte[] responseBytes = jsonResponse.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, responseBytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(responseBytes);
        os.close();
    }
}