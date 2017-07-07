package AdministratorServlet;

import DAO.RelationDAO;
import DAO.TeacherDAO;
import Database.AddCourseDao;
import Page.Course;
import Page.RelationPage;
import Page.TeacherPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/25.
 */
@WebServlet(name = "AdminDelete",value= "/AdminDelete")
public class AdminDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        int n;
        n= Integer.valueOf(request.getParameter("ID"));
        String type=request.getParameter("type");
        boolean success=false;
        if(type.equals("2")){
            TeacherDAO dao=new TeacherDAO();
            ArrayList<TeacherPage> list= (ArrayList<TeacherPage> )request.getSession().getAttribute("teacherlist");
            if(list==null){
                list=new ArrayList<TeacherPage>();

            }else{

                TeacherPage t=(TeacherPage) list.get(n);

                success=dao.Del(t);
                if(!success){
                    out.print("<script language='javascript'>alert('删除失败！');"
                            + "window.location.href='Administrator/Admin-TeaSel.jsp';</script>");
                }else{
                    out.print("<script language='javascript'>alert('删除成功！');"
                            + "window.location.href='Administrator/Admin-TeaSel.jsp';</script>");
                }
            }
        }else if(type.equals("3")){
            AddCourseDao dao=new AddCourseDao();
            ArrayList<Course> list= (ArrayList<Course> )request.getSession().getAttribute("courselist");
            if(list==null){
                list=new ArrayList<Course>();

            }else{

                Course c=(Course) list.get(n);

                success=dao.deleteCourse(c.getCp().getId());
                if(!success){
                    out.print("<script language='javascript'>alert('删除失败！');"
                            + "window.location.href='Administrator/Admin-CouSel.jsp';</script>");
                }else{
                    out.print("<script language='javascript'>alert('删除成功！');"
                            + "window.location.href='Administrator/Admin-CouSel.jsp';</script>");
                }
            }
        }else{
            RelationDAO dao=new RelationDAO();
            ArrayList<RelationPage> list= (ArrayList<RelationPage> )request.getSession().getAttribute("relationlist");
            if(list==null){
                list=new ArrayList<RelationPage>();

            }else{

                RelationPage r=(RelationPage) list.get(n);

                success=dao.Del(r);
                if(!success){
                    out.print("<script language='javascript'>alert('删除失败！');"
                            + "window.location.href='Administrator/Admin-RelSel.jsp';</script>");
                }else{
                    out.print("<script language='javascript'>alert('删除成功！');"
                            + "window.location.href='Administrator/Admin-RelSel.jsp';</script>");
                }
            }
        }
    }
}
