package AdministratorServlet;

import DAO.TeacherDAO;
import Page.TeacherPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/6/26.
 */
@WebServlet(name = "AdminTeaAdd",value = "/AdminTeaAdd")
public class AdminTeaAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        TeacherDAO dao = new TeacherDAO();
        TeacherPage t = new TeacherPage();
        t.setUsername(request.getParameter("Tno"));
        t.setName(request.getParameter("Tname"));
        t.setPassword(request.getParameter("Tpswd"));
        t.setGender(request.getParameter("Tsex"));
        t.setMajor(request.getParameter("Tprofession"));
        t.setStatus(request.getParameter("Tstatus"));
        t.setEmail(request.getParameter("Temail"));
        t.setIntroduction("这个人很懒，什么也没有留下");
        boolean success = dao.Add(t);
        if (!success) {
            out.print("<script language='javascript'>alert('添加失败！');"
                    + "window.location.href='Administrator/Admin-TeaAdd.jsp';</script>");
        } else {
            out.print("<script language='javascript'>alert('添加成功！');"
                    + "window.location.href='Administrator/Admin-TeaSel.jsp';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
