package com.ads.assignments.assignment_3;

public class StudentKey {
    private final String name;
    private final int id;

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
        if (this.id != that.id) return false;
        if (this.name == null && that.name != null) return false;
        return !(this.name != null && !this.name.equals(that.name));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.length() * 13);
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "{" + "name: " + name + ", id: " + id + "}";
    }
}
