package TeacherServlet;

import DAO.AssociationDAO;
import DAO.ChapterDAO;
import Page.AssociationPage;
import Page.ChapterPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyl on 2017/6/29.
 */
@WebServlet(name = "Tcourset2",value = "/Tcourset2")
public class Tcourset2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String cid;
        if(request.getParameter("cid")!=null){
         cid=request.getParameter("cid");
        request.getSession().setAttribute("cid", cid);}
        else{
            cid=(String)request.getSession().getAttribute("cid");
        }
        ChapterDAO cd=new ChapterDAO();
        List<ChapterPage> chlist=cd.GetAllByColumn("courseid",cid);
        AssociationDAO ad=new AssociationDAO();
        List<AssociationPage> aslist=new ArrayList();
        request.getSession().setAttribute("chlist",chlist);
        response.sendRedirect("teacher/T-courset2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
