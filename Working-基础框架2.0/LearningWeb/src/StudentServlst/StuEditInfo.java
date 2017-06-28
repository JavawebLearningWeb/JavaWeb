package StudentServlst;

import DAO.StudentDAO;
import Page.StudentPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ycbhci on 2017/6/27.
 */
@WebServlet(name = "StuEditInfo",value = "/StuEditInfo")
public class StuEditInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentPage studentPage= (StudentPage) request.getSession().getAttribute("studentpage");
        String name,birthday,gendar,status,grade,email = null,major;
         name=request.getParameter("name");
         birthday=request.getParameter("birthday");
         java.sql.Date dbirthday= (java.sql.Date) new Date(birthday);
         gendar=request.getParameter("gendar");
         status=request.getParameter("status");
         email=request.getParameter("email");
         grade=request.getParameter("grade");
         major=request.getParameter("major");
          if(!name.equals(studentPage.getName())||!dbirthday.equals(studentPage.getBirthday())||!gendar.equals(studentPage.getGendar())
                  ||!status.equals(studentPage.getStatus())||!grade.equals(studentPage.getStatus())||!major.equals(studentPage.getMajor()))
          {
              StudentPage studentPage1=new StudentPage();
              studentPage1.setId(studentPage.getId());
              studentPage1.setUsername(studentPage.getUsername());
              studentPage1.setPassword(studentPage.getPassword());
              studentPage1.setPicture(studentPage.getPicture());
              studentPage1.setGrade(grade);
              studentPage1.setMajor(major);
              studentPage1.setGendar(gendar);
              studentPage1.setEmail(email);
              studentPage1.setBirthday(dbirthday);
              studentPage1.setName(name);
              studentPage1.setStatus(status);
              StudentDAO studentDAO=new StudentDAO();
              studentDAO.Update(studentPage1);
              request.getSession().setAttribute("studentpage",studentPage1);

          }
         response.sendRedirect("Student/StuBaseInfo.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
