package TeacherServlet;

import DAO.ChapterDAO;
import DAO.ExamDAO;
import Page.ChapterPage;

import mixedclass.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyl on 2017/7/1.
 */
@WebServlet(name = "Tshow",value = "/Tshow")
public class Tshow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid;
        if(request.getParameter("cid")!=null){
            cid=request.getParameter("cid");
            request.getSession().setAttribute("cid", cid);}
        else{
            cid=(String)request.getSession().getAttribute("cid");
        }
        ChapterDAO cd=new ChapterDAO();
        ExamDAO ed=new ExamDAO();
        List<ChapterPage> chlist1=cd.GetAllByColumn("courseid",cid);
        request.getSession().setAttribute("chlist1",chlist1);

        List<chapterexam> celist=new ArrayList<>();
        for(int i=0;i<chlist1.size();i++){
            chapterexam ce=new chapterexam();
            ce.setChaptername(chlist1.get(i).getName());
            ce.setChapternumber(chlist1.get(i).getNumber());
            if(ed.GetByColumn("chapterid",(String)chlist1.get(i).getId())!=null){
                ce.setAddress(ed.GetByColumn("chapterid",(String)chlist1.get(i).getId()).getAddress());
                ce.setAnswer(ed.GetByColumn("chapterid",(String)chlist1.get(i).getId()).getAnswer());
            }
            else{
                ce.setAddress("#");
                ce.setAnswer(null);
            }
            celist.add(ce);
        }

        request.getSession().setAttribute("celist",celist);



        response.sendRedirect("teacher/T-show2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
