package com.ads.assignments.assignment_3;

public class TestingClass {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, StudentVal> table = new MyHashTable<>(50);

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(
                i,
                "CODE" + ((int)(Math.random() * 5000)) 
            );

            StudentVal value = new StudentVal(
                "Student" + i,
                18 + (i % 10),    // Age: 18-27
                Math.round((2.0 + Math.random() * 2.0) * 100.0) / 100.0  // GPA: 2.0 - 4.0
            );

            table.put(key, value);
        }

        table.printBucketSizes();
    }
}
