package com.example.service;

import com.example.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StudentService {
    private static StudentService instance;
    private final List<Student> students;
    
    private StudentService() {
        students = new CopyOnWriteArrayList<>();
        addSampleData();
    }
    
    public static synchronized StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }
    
    private void addSampleData() {
        students.add(new Student("1", "John Doe", "john@example.com", "Computer Science"));
        students.add(new Student("2", "Jane Smith", "jane@example.com", "Mathematics"));
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    public Student getStudentById(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public boolean addStudent(Student student) {
        if (student == null || student.getId() == null || student.getId().trim().isEmpty()) {
            return false;
        }
        if (getStudentById(student.getId()) != null) {
            return false;
        }
        return students.add(student);
    }
    
    public boolean deleteStudent(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }
    
    public int getStudentCount() {
        return students.size();
    }
}
