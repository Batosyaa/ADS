package com.ads.assignments.assignment_3;

public class MyTestingClass {
    private final int id;
    private final String code;

    public MyTestingClass(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTestingClass)) return false;
        MyTestingClass that = (MyTestingClass) o;
        if (this.id != that.id) return false;
        return this.code != null ? this.code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        if (code != null) {
            for (int i = 0; i < code.length(); i++) {
                hash = 31 * hash + code.charAt(i);
            }
        }
    return hash;
    }


    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", code='" + code + "'}";
    }
}
