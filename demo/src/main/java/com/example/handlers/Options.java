package com.example.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class Options implements Handle {

    @Override
    public void handleRequest(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(204, -1);
        exchange.close();
    }
}