package StudentServlst;

import StudentServlst.Student.Graph;
import StudentServlst.Student.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 16689 on 2017/7/2.
 */
@WebServlet(name = "Evaluate",value = "/Evaluate")
public class Evaluate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Question question= (Question) request.getSession().getAttribute("question");
        Graph graph= (Graph) request.getSession().getAttribute("graph");
        ArrayList<String> answer=new ArrayList<>();
        for (int i=0;i<question.getCount();i++)
        {
            String pram="radio"+i;
            answer.add(request.getParameter(pram));
        }
        question.evaluate(answer);
        if(question.getGrade()>=60)//及格分
        {
         graph.passexam(question.getGrade());
         request.getSession().setAttribute("graph",graph);
            response.sendRedirect("Student/StuCourseLearning.jsp");
        }
        else
        {//没有通过测试
            response.sendRedirect("Student/FailedTest.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
