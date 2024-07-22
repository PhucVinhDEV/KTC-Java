package Enity;


public class Student {
    private int stId;
    private String name;

    // Constructors
    public Student() {
    }

    public Student(int stId, String name) {
        this.stId = stId;
        this.name = name;
    }

    // Getters and Setters
    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method (optional for debugging)
    @Override
    public String toString() {
        return "Student{" +
                "stId=" + stId +
                ", name='" + name + '\'' +
                '}';
    }
}

