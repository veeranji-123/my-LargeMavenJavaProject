package com.example.servlet;

import com.example.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {
    private StudentService studentService;
    
    @Override
    public void init() throws ServletException {
        studentService = StudentService.getInstance();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String id = request.getParameter("id");
        
        if (id != null && !id.trim().isEmpty()) {
            studentService.deleteStudent(id);
        }
        
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
