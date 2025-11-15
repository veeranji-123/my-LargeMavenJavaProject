package com.example.service;

import com.example.model.Student;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class StudentServiceTest {
    private StudentService studentService;
    
    @Before
    public void setUp() {
        studentService = StudentService.getInstance();
    }
    
    @Test
    public void testGetInstance() {
        assertNotNull(studentService);
        assertEquals(studentService, StudentService.getInstance());
    }
    
    @Test
    public void testGetAllStudents() {
        List<Student> students = studentService.getAllStudents();
        assertNotNull(students);
        assertTrue(students.size() >= 2);
    }
    
    @Test
    public void testAddStudent() {
        Student newStudent = new Student("999", "Test Student", "test@example.com", "Testing");
        boolean result = studentService.addStudent(newStudent);
        
        assertTrue(result);
        Student retrieved = studentService.getStudentById("999");
        assertNotNull(retrieved);
        assertEquals("Test Student", retrieved.getName());
        
        studentService.deleteStudent("999");
    }
    
    @Test
    public void testAddDuplicateStudent() {
        Student student1 = new Student("888", "Duplicate Test", "dup@example.com", "Testing");
        studentService.addStudent(student1);
        
        Student student2 = new Student("888", "Another Name", "another@example.com", "Testing");
        boolean result = studentService.addStudent(student2);
        
        assertFalse(result);
        
        studentService.deleteStudent("888");
    }
    
    @Test
    public void testGetStudentById() {
        Student student = new Student("777", "Find Me", "findme@example.com", "Testing");
        studentService.addStudent(student);
        
        Student found = studentService.getStudentById("777");
        assertNotNull(found);
        assertEquals("Find Me", found.getName());
        
        studentService.deleteStudent("777");
    }
    
    @Test
    public void testGetStudentByIdNotFound() {
        Student notFound = studentService.getStudentById("nonexistent");
        assertNull(notFound);
    }
    
    @Test
    public void testDeleteStudent() {
        Student student = new Student("666", "Delete Me", "delete@example.com", "Testing");
        studentService.addStudent(student);
        
        boolean deleted = studentService.deleteStudent("666");
        assertTrue(deleted);
        
        Student notFound = studentService.getStudentById("666");
        assertNull(notFound);
    }
    
    @Test
    public void testDeleteNonexistentStudent() {
        boolean deleted = studentService.deleteStudent("nonexistent");
        assertFalse(deleted);
    }
    
    @Test
    public void testGetStudentCount() {
        int count = studentService.getStudentCount();
        assertTrue(count >= 2);
    }
    
    @Test
    public void testAddNullStudent() {
        boolean result = studentService.addStudent(null);
        assertFalse(result);
    }
    
    @Test
    public void testAddStudentWithNullId() {
        Student student = new Student(null, "No ID", "noid@example.com", "Testing");
        boolean result = studentService.addStudent(student);
        assertFalse(result);
    }
    
    @Test
    public void testAddStudentWithEmptyId() {
        Student student = new Student("  ", "Empty ID", "emptyid@example.com", "Testing");
        boolean result = studentService.addStudent(student);
        assertFalse(result);
    }
}
