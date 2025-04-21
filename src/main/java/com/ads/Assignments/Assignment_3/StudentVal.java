package com.ads.assignments.assignment_3;

public class StudentVal {
    private final String name;
    private final int age;
    private final double gpa;

    public StudentVal(String name, int age, double studentGpa) {
        this.name = name;
        this.age = age;
        this.gpa = studentGpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "{" + "name: " + name + ", age: " + age + ", gpa: " + gpa + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentVal)) return false;
        StudentVal that = (StudentVal) o;
        return age == that.age && Double.compare(that.gpa, gpa) == 0 &&
               (name != null ? name.equals(that.name) : that.name == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        long temp = Double.doubleToLongBits(gpa);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        return result;
    }
    
}
