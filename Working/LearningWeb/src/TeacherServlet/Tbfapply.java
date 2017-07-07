package TeacherServlet;

import DAO.CourseDAO;
import Page.Course;
import Page.CoursePage;
import Page.TeacherPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zyl on 2017/6/29.
 */
@WebServlet(name = "Tbfapply",value = "/Tbfapply")
public class Tbfapply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CourseDAO cd=new CourseDAO();
        List<CoursePage> cplist=cd.GetAll();

        request.getSession().setAttribute("cplist",cplist);
        response.sendRedirect("teacher/T-applypage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
