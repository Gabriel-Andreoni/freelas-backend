package com.example.Records;

import java.time.LocalDate;

public record ContractRecord(LocalDate date, Integer contractHours, Double valuePerHour) {}
