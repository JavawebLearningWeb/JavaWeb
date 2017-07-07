package TeacherServlet;

import DAO.ExamDAO;
import Page.ExamPage;

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

/**
 * Created by zyl on 2017/7/1.
 */
@WebServlet(name = "Tshow2",value = "/Tshow2.do")
@MultipartConfig(location="D:\\",fileSizeThreshold=1024)
public class Tshow2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chapterid=request.getParameter("chapterid");
        String answer=request.getParameter("answer");

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Part part=request.getPart("myfile");
        String path1;

        String path="D:\\IJ存储\\Working (1)\\Working\\LearningWeb\\web\\T-resource\\pic";
        File f=new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        path=path+"\\"+request.getParameter("chaptername")+".jpg";
        path1="../T-resource/pic/"+request.getParameter("chaptername")+".jpg";
        part.write(path);
        ServletContext con=this.getServletContext();

        ExamPage ep=new ExamPage();
        ep.setAddress(path1);
        ep.setAnswer(answer);
        ep.setChapterid(chapterid);
        ExamDAO ed=new ExamDAO();
        if(ed.GetByColumn("chapter",chapterid)==null){
            ed.Add(ep);
        }else{
            ed.Update(ep);
        }

        response.sendRedirect("../Tshow");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
