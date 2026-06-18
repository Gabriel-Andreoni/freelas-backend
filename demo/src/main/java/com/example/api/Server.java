package com.example.api;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.example.handlers.WorkersHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
    public static void main(String[] args) throws IOException {
        // 1. Cria o servidor na porta 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // 2. Associa o endpoint "/workers" ao nosso Handler
        server.createContext("/workers", new WorkersHandler());

        // 3. Inicializa o servidor
        server.setExecutor(null); // Usa o executor padrão
        System.out.println("Servidor rodando puro na porta 8080...");
        server.start();
    }
}
