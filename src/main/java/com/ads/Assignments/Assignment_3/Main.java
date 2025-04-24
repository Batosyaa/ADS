package com.ads.assignments.assignment_3;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, StudentVal> table = new MyHashTable<>(250);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(1_000_000);

            StringBuilder code = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                code.append((char) ('A' + random.nextInt(26)));
            }
            code.append(random.nextInt(10000));

            MyTestingClass key = new MyTestingClass(id, code.toString());

            StudentVal value = new StudentVal(
                "Student" + i,
                18 + random.nextInt(10),
                Math.round((2.0 + random.nextDouble() * 2.0) * 100.0) / 100.0
            );

            table.put(key, value);
        }
        
        table.printBucketSizes();
    }
}
