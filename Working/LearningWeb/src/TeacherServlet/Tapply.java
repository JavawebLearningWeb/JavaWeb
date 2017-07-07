package TeacherServlet;

import DAO.AddcourseDAO;
import Page.AddcoursePage;
import Page.TeacherPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zyl on 2017/6/26.
 */
@WebServlet("/applyclass.do")
public class Tapply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String classname=request.getParameter("classname");
        TeacherPage tp=new TeacherPage();
        tp=(TeacherPage)request.getSession().getAttribute("teacher");
        String tid=tp.getId();
       String qq1=null;String qq2=null;
        String qq3=null;String qq4=null;
       String kind=request.getParameter("dd");
       qq1=request.getParameter("qq1");
        qq2=request.getParameter("qq2");
        qq3=request.getParameter("qq3");
        qq4=request.getParameter("qq4");
       String f = null;
        AddcoursePage ap=new AddcoursePage();
        ap.setTeacherid(tid);
        ap.setCourse(classname);
        ap.setPrecourseid1(qq1);
        ap.setPrecourseid2(qq2);
        ap.setPrecourseid3(qq3);
        ap.setPrecourseid4(qq4);
        ap.setResult("未查看");
        AddcourseDAO ad=new AddcourseDAO();
        boolean flag= ad.Add(ap);
        if(flag==true){
            f = "<li>发送成功！<li>";
        }
        else{
             f="<li>发送失败！<li>";
        }
        request.getSession().setAttribute("flag",f);

        response.sendRedirect("/Tbfapply");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
