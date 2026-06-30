package com.example.Records;

import java.util.ArrayList;

import com.example.entities.Department;

public record WorkerRecord(String name, String email, Department department, ArrayList<ContractRecord> contracts) {}