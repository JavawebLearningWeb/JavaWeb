package StudentServlst;

import DAO.ChapterDAO;
import Page.ChapterPage;
import StudentServlst.Student.Graph;
import StudentServlst.Student.LearningData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 16689 on 2017/7/1.
 * 处理学生学习的课程
 */
@WebServlet(name = "LearnChapter",value = "/LearnChapter")
public class LearnChapter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String chapterid=request.getParameter("id");
        Graph graph= (Graph) request.getSession().getAttribute("graph");
        ChapterDAO chapterDAO=new ChapterDAO();
        ChapterPage learningchapterpage=chapterDAO.GetById(chapterid);
        graph.setLearninngchapterPage(learningchapterpage);//设置正在学习的章节
        request.getSession().setAttribute("graph",graph);
        LearningData learningData=new LearningData(learningchapterpage);
        request.getSession().setAttribute("learningdata",learningData);
        response.sendRedirect("Student/StuChapterLearning.jsp");
    }
}
