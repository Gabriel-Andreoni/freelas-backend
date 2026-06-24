package com.example.Records;

import com.example.entities.Contract;
import com.example.entities.Department;

public record WorkerRecord(String name, String email, Department department, Contract contract) {}