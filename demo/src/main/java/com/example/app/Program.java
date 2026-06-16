package com.example.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.example.entities.Contract;
import com.example.entities.Department;
import com.example.entities.Worker;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("BEM VINDO AO SISTEMA DE CADASTRO DE FREELAS");
        
        System.out.print("Nome do colaborador: ");
        String name = sc.nextLine();
        
        System.out.print("E-mail do colaborador: ");
        String email = sc.nextLine();

        System.out.print("Departamento do colaborador: ");
        Department department = new Department(sc.nextLine());

        System.out.print("Quantos contratos esse colaborador vai ter? ");
        Integer contractsQuantity = sc.nextInt();
        sc.nextLine();

        Worker worker = new Worker(name, email, department);

        for(Integer i = 0; i < contractsQuantity; i++) {
            Integer contador = i + 1;
            System.out.println("Insira os dados do " + contador + "º " + "contrato");

            System.out.print("Data: ");
            LocalDate date = LocalDate.parse(sc.nextLine(), formatter);

            System.out.print("Quantidade de horas do contrato: ");
            Integer contractHours = sc.nextInt();
            sc.nextLine();

            System.out.print("Valor por hora do contrato: ");
            Double valuePerHour = sc.nextDouble();
            sc.nextLine();

            Contract contract = new Contract(date, contractHours, valuePerHour);
            worker.adicionarContrato(contract);
        }

        sc.close();

        System.out.println("================================================");
        System.out.println("Colaborador e contratos cadastrados com sucesso.");
        System.out.println("================================================");

        System.out.println(worker);
        System.out.println("================================================");
        worker.exibirContratos();
        System.out.println("================================================");
        
    }
}
