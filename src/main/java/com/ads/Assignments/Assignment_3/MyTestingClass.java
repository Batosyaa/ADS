package com.ads.Assignments.Assignment_3;

import java.util.Random;

public class MyTestingClass {
    public static void main(String[] args) {
        int M = 80;
        MyHashTable<StudentKey, StudentVal> hashTable = new MyHashTable<>(M);
        Random random = new Random();

        String[] sampleNames = {"John", "Jane", "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah"};

        for (int i = 0; i < 10_000; i++) {
            String keyName = sampleNames[random.nextInt(sampleNames.length)];
            int keyId = random.nextInt(10000);
            StudentKey key = new StudentKey(keyName, keyId);

            String studentName = sampleNames[random.nextInt(sampleNames.length)];
            int studentAge = 17 + random.nextInt(10);
            double studentGpa = 2.0 + random.nextDouble() * 1.5;
            StudentVal value = new StudentVal(studentName, studentAge, studentGpa);
        }
    }
}
