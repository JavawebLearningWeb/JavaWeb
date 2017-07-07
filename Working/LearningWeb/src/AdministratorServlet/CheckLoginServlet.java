package AdministratorServlet;

import DAO.TeacherDAO;
import Database.AddCourseDao;
import Page.TeacherPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */
@WebServlet(name = "CheckLoginServlet",value="/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String kind=request.getParameter("kind");

        String username=request.getParameter("myusername").trim();
        String password=request.getParameter("mypassword").trim();
        if(kind.equals("admin")){
            AddCourseDao dao =new AddCourseDao();
            boolean success=false;
            success=dao.JudgeAdmin(username, password);
            if(!success){
                out.print("<script language='javascript'>alert('管理员账号或密码不正确，请重试！');"
                        + "window.location.href='login_ad.jsp';</script>");
            }else{
                response.sendRedirect("Administrator/AdminHeadPage.jsp");
            }
        }
        else{
            TeacherDAO td=new TeacherDAO();
            List<TeacherPage> tplist=new ArrayList<>();
            tplist=td.GetAll();
            TeacherPage tp=new TeacherPage();
            for(int i=0;i<tplist.size();i++){
                if(tplist.get(i).getPassword().equals(password)){
                    if(tplist.get(i).getUsername().equals(username)){
                        tp=tplist.get(i);
                    }
                }
            }
            if(tp!=null){
            request.getSession().setAttribute("teacher",tp);
            response.sendRedirect("teacher/T-homepage.jsp");}
            else{
                out.print("<script language='javascript'>alert('老师账号或密码不正确，请重试！');"
                        + "window.location.href='login_ad.jsp';</script>");

            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
