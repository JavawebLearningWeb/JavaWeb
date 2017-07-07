package TeacherServlet;

import DAO.CourseDAO;
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
 * Created by zyl on 2017/6/27.
 */
@WebServlet(name = "Tdisplayclass",value = "/Tdisplayclass")
public class Tdisplayclass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDAO cd=new CourseDAO();
        TeacherPage tp=new TeacherPage();
        tp=(TeacherPage)request.getSession().getAttribute("teacher");
        List<CoursePage> clist=cd.GetAllByColumn("teacherid",tp.getId());
        request.getSession().setAttribute("clist", clist);
        int i=Integer.parseInt(request.getParameter("i"));
         if(i==1){

             response.sendRedirect("teacher/T-uploadpage.jsp");
         }
         else if(i==2){

             response.sendRedirect("teacher/T-display.jsp");
         }
         else if(i==3){

             response.sendRedirect("teacher/T-courset.jsp");
         }
         else if(i==4){
             response.sendRedirect("teacher/T-show.jsp");
         }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
