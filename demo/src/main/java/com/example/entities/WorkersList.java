package com.example.entities;

import java.util.ArrayList;

import com.example.Records.WorkerRecord;

public class WorkersList {
    private static ArrayList<WorkerRecord> workersList = new ArrayList<>();

    public static void addWorker(WorkerRecord worker) {
        workersList.add(worker);
    }

}
