package AdministratorServlet;

import Database.AddCourseDao;
import Page.Course;
import Page.CoursePage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/6/30.
 */
@WebServlet(name = "AdminCouUpd",value = "/AdminCouUpd")
public class AdminCouUpd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String cno=(String) request.getSession().getAttribute("CourseCno");
        PrintWriter out=response.getWriter();
        AddCourseDao dao=new AddCourseDao();
        Course c=new Course();
        CoursePage cp=new CoursePage();
        cp.setId(request.getParameter("Cno"));;
        cp.setName(request.getParameter("Cname"));
        cp.setKind(request.getParameter("Ckind"));
        cp.setIntroduction(request.getParameter("Cintroduction"));
        c.setCp(cp);

        boolean success=false;
        success=dao.updateCourse(c, cno);
        if(!success){
            out.print("<script language='javascript'>alert('修改失败！');"
                    + "window.location.href='Administrator/Admin-CouSel.jsp';</script>");
        }else{
            out.print("<script language='javascript'>alert('修改成功！');"
                    + "window.location.href='Administrator/Admin-CouSel.jsp';</script>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
