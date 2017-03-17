package model;

/**
 * Created by wacharapongnachiengmai on 3/16/2017 AD.
 */
public class Student {
    private String studentId;
    private String studentName;
    private String studentLineId;

    public Student(String studentId, String studentName, String studentLineId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentLineId = studentLineId;
    }

    public Student() {

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLineId() {
        return studentLineId;
    }

    public void setStudentLineId(String studentLineId) {
        this.studentLineId = studentLineId;
    }
}
