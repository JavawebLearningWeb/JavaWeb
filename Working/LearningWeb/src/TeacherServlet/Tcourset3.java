package TeacherServlet;

import DAO.AddcourseDAO;
import DAO.AssociationDAO;
import Page.AddcoursePage;
import Page.AssociationPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zyl on 2017/6/29.
 */
@WebServlet("/courset3.do")
public class Tcourset3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proid=request.getParameter("qq1");
        String chaid=(String)request.getSession().getAttribute("chaid");
        String f=null;
        boolean flag = false;
        AssociationPage ap=new AssociationPage();
        ap.setChapterid(chaid);
        ap.setProchapterid(proid);
        AssociationDAO ad=new AssociationDAO();
        flag=ad.Add(ap);

        if(flag==true){
            f = "<li>保存成功！<li>";
        }
        else{
            f="<li>保存失败！<li>";
        }
        request.getSession().setAttribute("result2",f);

        response.sendRedirect("/Tcourset2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
