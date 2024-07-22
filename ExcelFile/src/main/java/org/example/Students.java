package org.example;

public class Students {
    private int id;
    private String name;

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Students() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'';
    }
}
