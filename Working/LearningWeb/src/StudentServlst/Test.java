package StudentServlst;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ycbhci on 2017/6/28.
 */
@WebServlet(name = "Test", value = "/Test")
@MultipartConfig(location = "D:\\", fileSizeThreshold = 1024)
public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Part p = request.getPart("filename");

        String name = p.getHeader("content-disposition");
        String[] ss = name.split("\"");
        String path=null;
        if(ss.length>3)
        {
             path="stuimg/"+ss[3];
        }
        else
        {
             path="路径为空";
        }

        out.println("<html><head></head><body>" + path + "</body></html>");


        //  System.out.println(ss[1]);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
