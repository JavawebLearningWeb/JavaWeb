package TeacherServlet;

import DAO.ChapterDAO;
import DAO.DataDAO;
import Page.ChapterPage;
import Page.DataPage;

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
 * Created by zyl on 2017/6/27.
 */
@WebServlet(name = "Tdisplaystu",value = "/Tdisplaystu")
public class Tdisplaystu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid=request.getParameter("cid");
        request.getSession().setAttribute("cid", cid);
        ChapterDAO cd=new ChapterDAO();
        List<ChapterPage> chlist=cd.GetAllByColumn("courseid",cid);

        request.getSession().setAttribute("chlist",chlist);

        response.sendRedirect("teacher/T-display2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
