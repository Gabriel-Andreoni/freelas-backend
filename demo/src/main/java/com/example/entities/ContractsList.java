package com.example.entities;

import java.util.ArrayList;

import com.example.Records.ContractRecord;
public class ContractsList {
    private static ArrayList<ContractRecord> contractsList = new ArrayList<>();

    public static void addWorker(ContractRecord contract) {
        contractsList.add(contract);
    }

    public static ArrayList<ContractRecord> listWorkers() {
        return contractsList;
    }
}
