package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by wacharapongnachiengmai on 3/16/2017 AD.
 */
public class StudentDao {
    private Connection connection;

    public StudentDao() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:university.sqlite");
            System.out.println("Database conected.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        String sqlText = null;
        Student student = null;
        try {
            Statement statement = this.connection.createStatement();
            sqlText = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(sqlText);
            while (resultSet.next()){
                student = new Student();
                student.setStudentId(resultSet.getString("student_id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setStudentLineId(resultSet.getString("student_line_id"));
                students.add(student);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void add(Student student) {

    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
