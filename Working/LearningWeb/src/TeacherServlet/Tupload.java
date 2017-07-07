package TeacherServlet;

import DAO.ChapterDAO;
import DAO.DataDAO;
import Entity.DataEntity;
import Page.ChapterPage;
import Page.DataPage;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zyl on 2017/6/26.
 */
@WebServlet(name = "Tupload",value = "/upload.do")

public class Tupload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid=(String)request.getSession().getAttribute("cid");
        ChapterPage cp=new ChapterPage();
        cp.setCourseid(cid);
        cp.setName(request.getParameter("cname"));
        cp.setNumber(request.getParameter("number"));
        System.out.print(request.getParameter("cname"));
        ChapterDAO cd=new ChapterDAO();
        cd.Add(cp);
        response.sendRedirect("/Tbfupload");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              doPost(request,response);
    }
}
