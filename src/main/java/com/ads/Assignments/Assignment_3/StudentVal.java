package com.ads.Assignments.Assignment_3;

public class StudentVal {
    private String name;
    private int age;
    private double gpa;

    public StudentVal(String name, int age, double studentGpa) {
        this.name = name;
        this.age = age;
        this.gpa = studentGpa;
    }

    public String getName() {
        return name;
    }

    public int GetAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "{" + "name: " + name + ", age: " + age + ", gpa: " + gpa + "}";
    }
    
}
