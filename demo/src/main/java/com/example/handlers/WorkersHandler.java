package com.example.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class WorkersHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            InputStream is = exchange.getRequestBody();

            String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            System.out.println("JSON recebido: " + body);

            String jsonResponse = """
                    {
                        "status": "sucesso",
                        "mensagem": "Colaborador cadastrado com sucesso!"            
                    }
                    """;

            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");

            byte[] responseBytes = jsonResponse.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(201, responseBytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        } else {
            String erro = "Método não permitido. Use POST!";
            exchange.sendResponseHeaders(405, erro.length());

            OutputStream os = exchange.getResponseBody();
            os.write(erro.getBytes());
            os.close();
        }
    }
}
