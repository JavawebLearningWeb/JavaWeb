package TeacherServlet;

import DAO.ChapterDAO;
import DAO.DataDAO;
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
import java.util.List;

/**
 * Created by zyl on 2017/7/2.
 */
@WebServlet(name = "Tdupload",value = "/dupload.do")
@MultipartConfig(location="D:\\",fileSizeThreshold=1024)
public class Tdupload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Part part=request.getPart("myfile");
        String path1;

        String path="D:\\IJ存储\\Working (1)\\Working\\LearningWeb\\web\\teacher\\T-resource\\video";
        File f=new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        if(request.getParameter("kind").equals("PPT"))
        {
            path=path+"\\"+request.getParameter("dname")+".pptx";
            path1="../teacher/T-resource/video/"+request.getParameter("dname")+".pptx";
        }
        else if(request.getParameter("kind").equals("视频"))
        {
            path=path+"\\"+request.getParameter("dname")+".mp4";
            path1="../teacher/T-resource/video/"+request.getParameter("dname")+".mp4";
        }
        else{
            path="#";
            path1="#";
        }
        part.write(path);
        ServletContext con=this.getServletContext();
        DataPage dp=new DataPage();
        String cid=(String)request.getSession().getAttribute("cid");
        String chapterid=request.getParameter("chapterid");
        request.getSession().setAttribute("cid", cid);
        dp.setAddress(path1);
        dp.setKind(request.getParameter("kind"));
        dp.setName(request.getParameter("dname"));
        dp.setChapterid(chapterid);
        DataDAO dd=new DataDAO();

        if(dd.GetByColumn("chapterid",chapterid)==null){
        dd.Add(dp);}
        else{
            dd.Update(dp);
        }

        response.sendRedirect("/Tbfupload");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
