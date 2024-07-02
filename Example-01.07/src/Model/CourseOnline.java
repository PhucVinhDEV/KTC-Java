package Model;

import java.util.List;

public class CourseOnline extends Course {

    private String NenTang;
    private int ThoiLuong;

    public CourseOnline(int courseId) {
        super(courseId);
    }

    public CourseOnline(int courseId, String courseName, String mentorName, int credit, String nenTang, int thoiLuong) {
        super(courseId, courseName, mentorName, credit);
        NenTang = nenTang;
        ThoiLuong = thoiLuong;
    }

    public String getNenTang() {
        return NenTang;
    }

    public void setNenTang(String nenTang) {
        NenTang = nenTang;
    }

    public int getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        ThoiLuong = thoiLuong;
    }
}
