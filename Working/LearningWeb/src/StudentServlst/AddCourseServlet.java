package StudentServlst;


import Page.StudentPage;
import StudentServlst.Student.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 16689 on 2017/7/1.
 */
@WebServlet(name = "AddCourseServlet",value = "/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentPage studentPage= (StudentPage) request.getSession().getAttribute("studentpage");
        Course course=new Course(studentPage);
        request.getSession().setAttribute("course",course);
        response.sendRedirect("Student/AddCourse.jsp");
    }
}
