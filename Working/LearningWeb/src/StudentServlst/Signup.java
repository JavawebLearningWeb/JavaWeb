package StudentServlst;

import DAO.StudentDAO;
import Page.StudentPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by 16689 on 2017/6/28.
 */
@WebServlet(name = "Signup",value = "/Signup")
public class Signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username,password,dbirthday,gender,status,grade,email,major,picture,name;
        Date birthday=null;
        username=request.getParameter("username");
        password=request.getParameter("password");
        dbirthday=request.getParameter("birthday");
        birthday=Date.valueOf(dbirthday);
        gender=request.getParameter("sex");
        email=request.getParameter("email");
        name=request.getParameter("name");
        major=request.getParameter("profession");
        grade=request.getParameter("grade");
        status=request.getParameter("education background");
        picture="stuimg/女孩2.jpg";//默认照片的路径



        StudentPage studentPage=new StudentPage();
        studentPage.setBirthday(birthday);
        studentPage.setEmail(email);
        studentPage.setGendar(gender);
        studentPage.setGrade(grade);
        studentPage.setMajor(major);
        studentPage.setName(name);
        studentPage.setUsername(username);
        studentPage.setPassword(password);
        studentPage.setStatus(status);
        studentPage.setPicture(picture);

        StudentDAO studentDAO=new StudentDAO();
        studentDAO.Add(studentPage);
        response.sendRedirect("Student/login.jsp");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
