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
 * Created by Administrator on 2017/6/28.
 */
@WebServlet(name = "AdminCouAdd",value = "/AdminCouAdd")
public class AdminCouAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        AddCourseDao dao = new AddCourseDao();
        CoursePage c = new CoursePage();
        c.setId(request.getParameter("Cno"));
        String cname = request.getParameter("Cname");
        c.setName(cname);
        String tid = request.getParameter("Tno");
        c.setTeacherid(tid);
        c.setKind(request.getParameter("Ckind"));
        boolean success1 = false;
        success1 = dao.findExistCourse(cname, tid);
        if (!success1) {
            out.print("<script language='javascript'>alert('该老师已存在改课程！');"
                    + "window.location.href='Administrator/Admin-CouAdd.jsp';</script>");
        } else {

            boolean success = false;

            success = dao.addCourse(c);



                if (!success) {
                    out.print("<script language='javascript'>alert('添加失败！');"
                            + "window.location.href='Administrator/Admin-CouAdd.jsp';</script>");
                } else {
                    out.print("<script language='javascript'>alert('添加成功！');"
                            + "window.location.href='Administrator/Admin-CouSel.jsp';</script>");
                }
            }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
