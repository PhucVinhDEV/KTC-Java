package StreamAPIExample;

import StreamAPI.Student;

import java.util.List;

public class Person {
    private String name;
    private int age;
    List<String> course;

    public Person(String name, int age, List<String> course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                '}';
    }
}
