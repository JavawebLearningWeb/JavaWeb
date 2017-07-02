package StudentServlst;

import StudentServlst.Student.Graph;
import StudentServlst.Student.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 16689 on 2017/7/2.
 */
@WebServlet(name = "StuTest",value = "/StuTest")
public class StuTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Graph graph= (Graph) request.getSession().getAttribute("graph");
        Question question=new Question(graph.getStudentPage(),graph.getCoursePage(),graph.getLearninngchapterPage());
        request.getSession().setAttribute("question",question);
        response.sendRedirect("Student/StuTest.jsp");


    }
}
