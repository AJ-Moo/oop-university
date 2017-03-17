package gui;

import model.Student;
import model.StudentDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Created by wacharapongnachiengmai on 3/16/2017 AD.
 */
public class UniversityFrame {
    private JPanel panel1;
    private JTable studentTable;
    private JTextField studentIdText;
    private JTextField studentNameText;
    private JTextField studentLineText;
    private JButton studentNewBtn;
    private JButton studentDeleteBtn;
    private JButton studentEditBtn;
    private JLabel titleLabel;
    private JLabel studentIdLabel;
    private JLabel studentNameLabel;
    private JLabel studentLineLabel;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("ตัวจัดการข้อมูลนักศึกษา");
        jFrame.setContentPane(new UniversityFrame().panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Object columnName[] = {"Student Id", "Student Name", "Student Line Id"};
        DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);
//        add data
        ArrayList<Student> students = null;
        StudentDao studentDao = new StudentDao();
        students = studentDao.getAll();
        for (Student student :
                students) {
            Object[] studentData = {student.getStudentId(), student.getStudentName(), student.getStudentLineId()};
            tableModel.addRow(studentData);
        }
        studentDao.close();
        studentTable = new JTable(tableModel);
    }
}
