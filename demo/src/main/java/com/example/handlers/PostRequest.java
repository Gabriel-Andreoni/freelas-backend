package com.example.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.example.Records.WorkerRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

public class PostRequest implements Handle {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void handleRequest(HttpExchange exchange) throws IOException {
        
        InputStream is = exchange.getRequestBody();

        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

        System.out.println("JSON recebido: " + body);

        //WorkerRecord worker = objectMapper.readValue(body, WorkerRecord.class);

        String jsonResponse = """
                {
                    "status": "sucesso",
                    "mensagem": "Colaborador cadastrado com sucesso!"
                }
                """;

        byte[] responseBytes = jsonResponse.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(201, responseBytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(responseBytes);
        os.close();
    }
}
