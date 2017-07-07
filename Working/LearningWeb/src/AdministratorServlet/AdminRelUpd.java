package AdministratorServlet;

import DAO.RelationDAO;
import Database.AddCourseDao;
import Page.Course;
import Page.CoursePage;
import Page.RelationPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/7/3.
 */
@WebServlet(name = "AdminRelUpd",value = "/AdminRelUpd")
public class AdminRelUpd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String rno=(String) request.getSession().getAttribute("Relationid");
        PrintWriter out=response.getWriter();
        RelationDAO dao=new RelationDAO();
        RelationPage r=new RelationPage();
        r.setId(request.getParameter("Cno"));
        r.setCourseid(request.getParameter("Cid"));
        r.setFrontcourseid(request.getParameter("Cpreid"));

        boolean success=false;
        success=dao.Update(r);
        if(!success){
            out.print("<script language='javascript'>alert('修改失败！');"
                    + "window.location.href='Administrator/Admin-RelSel.jsp';</script>");
        }else{
            out.print("<script language='javascript'>alert('修改成功！');"
                    + "window.location.href='Administrator/Admin-RelSel.jsp';</script>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
