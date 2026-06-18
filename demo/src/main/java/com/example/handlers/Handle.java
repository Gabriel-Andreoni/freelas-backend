package com.example.handlers;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;

interface Handle {
    abstract public void handleRequest(HttpExchange exchange) throws IOException;
}
