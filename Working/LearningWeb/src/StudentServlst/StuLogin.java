package StudentServlst;

import DAO.StudentDAO;
import Page.StudentPage;
import StudentServlst.Student.SelectedCourses;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by ycbhci on 2017/6/26.
 */
@WebServlet(name="StuLogin",value = "/StuLogin")
public class StuLogin extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name,password;
        name=request.getParameter("myusername");
        password=request.getParameter("mypassword");
        StudentDAO studentDAO=new StudentDAO();
        StudentPage studentPage=studentDAO.GetByColumn("username",name);
        if (studentPage!=null)
        {
            if(studentPage.getPassword().equals(password))
            {

                request.getSession().setAttribute("studentpage",studentPage);
                SelectedCourses selectedcourses =new SelectedCourses(studentPage);
                request.getSession().setAttribute("selectedcourses",selectedcourses);
                response.sendRedirect("Student/stu_home.jsp");


            }
            else {
                response.sendRedirect("Student/login.jsp");
            }
        }
        else
        {
            response.sendRedirect("Student/login.jsp");
        }
        //数据库的操作










    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
