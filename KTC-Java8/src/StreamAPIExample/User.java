package StreamAPIExample;

import java.util.List;
import java.time.LocalDate;

public class User {
    private String name;
    private int age;
    private List<String> courses;
    private String email;
    private String gender;
    private LocalDate birthDate;

    public User(String name, int age, List<String> courses, String email, String gender, LocalDate birthDate) {
        this.name = name;
        this.age = age;
        this.courses = courses;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public User() {
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

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
