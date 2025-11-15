package com.example.servlet;

import com.example.model.Student;
import com.example.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    private StudentService studentService;
    
    @Override
    public void init() throws ServletException {
        studentService = StudentService.getInstance();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/add-student.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        
        if (id == null || id.trim().isEmpty() || 
            name == null || name.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            course == null || course.trim().isEmpty()) {
            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("/add-student.jsp").forward(request, response);
            return;
        }
        
        Student student = new Student(id, name, email, course);
        boolean added = studentService.addStudent(student);
        
        if (added) {
            response.sendRedirect(request.getContextPath() + "/students");
        } else {
            request.setAttribute("error", "Student with ID " + id + " already exists!");
            request.getRequestDispatcher("/add-student.jsp").forward(request, response);
        }
    }
}
