package StudentServlst;

import DAO.CourseDAO;
import Page.CoursePage;
import StudentServlst.Student.Course;
import StudentServlst.Student.SelectedCourses;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 16689 on 2017/7/1.
 */
@WebServlet(name = "AddCourseToDb",value = "/AddCourseToDb")
public class AddCourseToDb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String courseid=request.getParameter("courseid");
        CourseDAO courseDAO=new CourseDAO();
        CoursePage coursePage=courseDAO.GetById(courseid);
        Course course= (Course) request.getSession().getAttribute("course");
        course.setLearningcourse(coursePage);
        request.getSession().setAttribute("course",course);
        SelectedCourses selectedcourses=new SelectedCourses(course.getStudentPage());
        request.getSession().setAttribute("selectedcourses",selectedcourses);;//存储已经选择课程
        response.sendRedirect("Student/stu_home.jsp");
    }
}
