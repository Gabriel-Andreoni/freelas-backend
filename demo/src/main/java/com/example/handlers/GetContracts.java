package com.example.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

public class GetContracts implements Handle {
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public void handleRequest(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        LocalDate contractDate = LocalDate.parse(body);
        

        String jsonResponse = """
                {
                    "status": "sucesso",
                    "mensagem": "Contratos Encontrados"
                }
                """;

        byte[] responseBytes = jsonResponse.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(201, responseBytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(responseBytes);
        os.close();
    }
}
