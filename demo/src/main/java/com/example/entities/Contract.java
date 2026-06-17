package com.example.entities;

import java.time.LocalDate;

public class Contract {
    private LocalDate date;
    private Integer contractHours;
    private Double valuePerHour;

    public Contract(LocalDate date, Integer contrarHours, Double valuePerHour) {
        this.date = date;
        this.contractHours = contrarHours;
        this.valuePerHour = valuePerHour;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getContractHours() {
        return contractHours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Double calcularValores() {
        return valuePerHour * contractHours;
    }
}
