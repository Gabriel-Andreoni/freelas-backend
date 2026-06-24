package com.example.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.example.Records.ContractRecord;
import com.example.entities.ContractsList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.net.httpserver.HttpExchange;

public class ContractsPostRequest implements Handle {

    private final ObjectMapper objectMapper = new ObjectMapper()
    .registerModule(new JavaTimeModule())
    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    
    @Override
    public void handleRequest(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        
        ContractRecord contract = objectMapper.readValue(body, ContractRecord.class);
        ContractsList.addContract(contract);

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
