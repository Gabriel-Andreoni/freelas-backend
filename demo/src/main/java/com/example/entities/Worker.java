package com.example.entities;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Worker {
    private String name;
    private String email;
    private Department department;

    private ArrayList<Contract> contracts = new ArrayList<>();

    Locale localeBR = Locale.forLanguageTag("pt-BR");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeBR);


    public Worker(String name, String email, Department department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department.getName();
    }

    public void adicionarContrato(Contract contract) {
        contracts.add(contract);
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\n" +
        "Email: " + email + "\n" +
        "Departamento: " + getDepartment();
    }

    public void exibirContratos() {
        for (Contract c : contracts) {
            System.out.println("Data do contrato: " + c.getDate());
            System.out.println("Quantidade de horas: " + c.getContractHours());
            System.out.println("Valor por hora: " + c.getValuePerHour());
            System.out.println("Valor total do contrato: " + currencyFormatter.format(c.calcularValores()));
        }
    }


}
