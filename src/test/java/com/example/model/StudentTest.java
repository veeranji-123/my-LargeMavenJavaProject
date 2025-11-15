package com.example.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    
    @Test
    public void testStudentCreation() {
        Student student = new Student("1", "John Doe", "john@example.com", "Computer Science");
        
        assertEquals("1", student.getId());
        assertEquals("John Doe", student.getName());
        assertEquals("john@example.com", student.getEmail());
        assertEquals("Computer Science", student.getCourse());
    }
    
    @Test
    public void testStudentSetters() {
        Student student = new Student();
        student.setId("2");
        student.setName("Jane Smith");
        student.setEmail("jane@example.com");
        student.setCourse("Mathematics");
        
        assertEquals("2", student.getId());
        assertEquals("Jane Smith", student.getName());
        assertEquals("jane@example.com", student.getEmail());
        assertEquals("Mathematics", student.getCourse());
    }
    
    @Test
    public void testToString() {
        Student student = new Student("1", "John Doe", "john@example.com", "Computer Science");
        String expected = "Student{id='1', name='John Doe', email='john@example.com', course='Computer Science'}";
        
        assertEquals(expected, student.toString());
    }
}
