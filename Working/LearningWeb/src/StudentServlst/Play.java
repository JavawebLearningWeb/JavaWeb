package StudentServlst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 16689 on 2017/7/1.
 */
@WebServlet(name = "Play",value = "/Play")
public class Play extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address,kind;
        address=request.getParameter("address");
        kind=request.getParameter("kind");
        request.getSession().setAttribute("address",address);
        if(kind.equals("ppt"))
        {
            response.sendRedirect("Student/PlayPPT.jsp");
        }
        if (kind.equals("视频")){
            response.sendRedirect("Student/PlayMP4.jsp");
        }

    }
}
