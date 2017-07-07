package AdministratorServlet;

import Database.AddCourseDao;
import Page.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/27.
 */
@WebServlet(name = "AdminVerApp",value = "/AdminVerApp")
public class AdminVerApp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        int n;
        n = Integer.valueOf(request.getParameter("ID"));
        String type=request.getParameter("type");
        boolean success=false;
        AddCourseDao dao = new AddCourseDao();
        ArrayList<Course> list = (ArrayList<Course>) request.getSession().getAttribute("teacoulist");

        if (list == null) {
            list = new ArrayList<Course>();

        } else {
            Course c = (Course) list.get(n);
            request.getSession().setAttribute("Teacou", c);
            if(type.equals("1")){
            success=dao.updateTeaCou("通过审核",c);
            if(!success){
                out.print("<script language='javascript'>alert('操作失败！');"
                        + "window.location.href='Administrator/Admin-Verify.jsp';</script>");
            }else{
                out.print("<script language='javascript'>alert('通过审核！');"
                        + "window.location.href='Administrator/Admin-CouAdd.jsp';</script>");
            }
        }else{
           success=dao.updateTeaCou("未通过审核",c);
                if(!success){
                    out.print("<script language='javascript'>alert('操作失败！');"
                            + "window.location.href='Admin-Verify.jsp';</script>");
                }else{
                    out.print("<script language='javascript'>alert('未通过审核！');"
                            + "window.location.href='Admin-Verify.jsp';</script>");
                }
            }
        }
    }
}