package TeacherServlet;

import DAO.ChapterDAO;
import DAO.CourseDAO;
import DAO.DataDAO;
import Page.ChapterPage;
import Page.CoursePage;
import Page.DataPage;
import mixedclass.chapterdata;

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
@WebServlet(name = "Tbfupload",value = "/Tbfupload")
public class Tbfupload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid;
        if(request.getParameter("cid")!=null){
        cid=request.getParameter("cid");
       request.getSession().setAttribute("cid", cid);}
       else{
           cid=(String) request.getSession().getAttribute("cid");
        }
        ChapterDAO cd=new ChapterDAO();DataDAO dd=new DataDAO();
        List<ChapterPage> chlist=cd.GetAllByColumn("courseid",cid);

        List<chapterdata> cdlist=new ArrayList<chapterdata>(){};

        for (int i=0;i<chlist.size();i++)
        {
            chapterdata chd=new chapterdata();
            chd.setChname(chlist.get(i).getName());

            chd.setnumber(chlist.get(i).getNumber());
            if(dd.GetAll()!=null){

            if(dd.GetAllByColumn("chapterid",chlist.get(i).getId()).size()!=0){


                DataPage dp=new DataPage();
                dp=dd.GetAllByColumn("chapterid",chlist.get(i).getId()).get(0);
                chd.setAddress(dp.getAddress());

                chd.setName(dp.getName());
                chd.setKind(dp.getKind());

            }}
            else{
                chd.setAddress("#");
                chd.setKind(null);
                chd.setName(null);
            }
              cdlist.add(chd);

        }
        request.getSession().setAttribute("cchlist",chlist);
       request.getSession().setAttribute("chlist",cdlist);

        response.sendRedirect("teacher/T-uploadpage2.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
