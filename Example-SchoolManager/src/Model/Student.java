package Model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private static int idCounter = 1;
    private int studentID;
    private String name;
    private LocalDate dateOfBirth;
    private String cccd;
    private LocalDate registrationDate;
    private boolean isDropped;
    private String dropReason;

    public Student(String name, String dob, String cccd) {
        this.studentID = idCounter++;
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.cccd = cccd;
        this.isDropped = false;
    }

    // Getter and Setter methods

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Student.idCounter = idCounter;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isDropped() {
        return isDropped;
    }

    public void setDropped(boolean dropped) {
        isDropped = dropped;
    }

    public String getDropReason() {
        return dropReason;
    }

    public void setDropReason(String dropReason) {
        this.dropReason = dropReason;
    }
/*

Period trong Java là một lớp thuộc gói java.time
và được sử dụng để đại diện cho một khoảng thời gian theo năm, tháng và ngày.
 Nó đặc biệt hữu ích để tính toán sự khác biệt giữa hai ngày.
 */
    public boolean isEligible() {
        int age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
        return age >= 18 && age <= 20;
    }

    @Override
    public String toString() {
        return
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cccd='" + cccd + '\'' +
                ", registrationDate=" + registrationDate +
                ", isDropped=" + isDropped +
                ", dropReason='" + dropReason ;
    }
}
