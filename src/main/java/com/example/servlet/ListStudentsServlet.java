package com.example.servlet;

import com.example.model.Student;
import com.example.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListStudentsServlet extends HttpServlet {
    private StudentService studentService;
    
    @Override
    public void init() throws ServletException {
        studentService = StudentService.getInstance();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/list-students.jsp").forward(request, response);
    }
}
