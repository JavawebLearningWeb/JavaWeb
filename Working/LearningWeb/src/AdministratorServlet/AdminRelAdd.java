package AdministratorServlet;

import Database.AddCourseDao;
import Page.CoursePage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/7/2.
 */
@WebServlet(name = "AdminRelAdd",value = "/AdminRelAdd")
public class AdminRelAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        AddCourseDao dao = new AddCourseDao();

        String cno=request.getParameter("Cno");
        String cid = request.getParameter("Cid");
        String cpreid = request.getParameter("Cpreid");
        boolean success1 = false;
        success1 = dao.addprecourseid(cid,cpreid,cno);

            if (!success1) {
                out.print("<script language='javascript'>alert('添加失败！');"
                        + "window.location.href='Administrator/Admin-RelAdd.jsp';</script>");
            } else {
                out.print("<script language='javascript'>alert('添加成功！');"
                        + "window.location.href='Administrator/Admin-RelSel.jsp';</script>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
