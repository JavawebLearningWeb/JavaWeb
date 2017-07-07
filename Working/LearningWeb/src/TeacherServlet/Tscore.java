package TeacherServlet;

import DAO.ChapterDAO;
import DAO.CourseDAO;
import DAO.ProgressDAO;
import DAO.StudentDAO;
import Page.ProgressPage;
import mixedclass.chapterstu;

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
@WebServlet(name = "Tscore",value = "/Tscore")
public class Tscore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chid=request.getParameter("chid");
        request.getSession().setAttribute("chid",chid);
        String cid=(String)request.getSession().getAttribute("cid");
       // ProgressPage pp=new ProgressPage();
        ProgressDAO pd=new ProgressDAO();
        ChapterDAO cd=new ChapterDAO();
        CourseDAO cod=new CourseDAO();
        StudentDAO sd=new StudentDAO();
        List<ProgressPage> plist=pd.GetAllByColumn("chapterid",chid,"courseid",cid);
        List<chapterstu> cslist=new ArrayList<>();

        if(plist!=null){
        for(int i=0;i<plist.size();i++){
            chapterstu cs=new chapterstu();
            cs.setCoursename(cod.GetById(cid).getName());
            cs.setChaptername(cd.GetById(chid).getName());

            cs.setStudentid(plist.get(i).getStudentid());
            cs.setStudentname(sd.GetById(plist.get(i).getStudentid()).getName());


            cs.setExamscore(plist.get(i).getExamscore());
            cslist.add(cs);
        }}
        else{
            chapterstu cs=new chapterstu();

            cs.setCoursename(cod.GetById(cid).getName());
            cs.setChaptername(cd.GetById(chid).getName());

            cs.setStudentid(null);
            cs.setCoursename(null);
            cslist.add(cs);
        }



        request.getSession().setAttribute("cname",cod.GetById(cid).getName());
        request.getSession().setAttribute("chname",cd.GetById(chid).getName());
        request.getSession().setAttribute("plist",cslist);



        response.sendRedirect("teacher/T-score.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
