package StudentServlst;

import DAO.CourseDAO;
import Page.CoursePage;
import Page.StudentPage;
import StudentServlst.Student.Graph;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 16689 on 2017/6/29.
 */
@WebServlet(name = "ChooseCourse",value = "/ChooseCourse")
public class ChooseCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseid;
        courseid=request.getParameter("courseid");
        CourseDAO courseDAO=new CourseDAO();
        StudentPage studentPage= (StudentPage) request.getSession().getAttribute("studentpage");
        CoursePage coursePage=courseDAO.GetById(courseid);
        Graph graph=new Graph(studentPage,coursePage);
        request.getSession().setAttribute("graph",graph);
        response.sendRedirect("Student/StuCourseLearning.jsp");
    }
}
