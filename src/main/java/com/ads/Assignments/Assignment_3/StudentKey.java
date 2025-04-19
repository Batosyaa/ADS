package com.ads.Assignments.Assignment_3;

import java.util.Objects;

public class StudentKey {
    private String name;
    private int id;

    public StudentKey(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentKey)) return false;
        StudentKey that = (StudentKey) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 29 * result + id;
        return result;
    }
    
    @Override
    public String toString() {
        return "{" + "name: " + name + ", id: " + id + "}";
    }
    
}
