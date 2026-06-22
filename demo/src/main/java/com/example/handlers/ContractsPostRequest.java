package com.example.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpExchange;

public class ContractsPostRequest implements Handle {
    
    @Override
    public void handleRequest(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

        System.out.println("Body recebido: " + body);

        String jsonResponse = """
                {
                    "status": "sucesso",
                    "mensagem": "Contrato cadastrado com sucesso!"
                }
                """;
        
        byte[] responseBytes = jsonResponse.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(201, responseBytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(responseBytes);
        os.close();
    }
}
