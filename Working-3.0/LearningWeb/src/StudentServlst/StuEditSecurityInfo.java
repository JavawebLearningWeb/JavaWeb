package StudentServlst;

import DAO.StudentDAO;
import Page.StudentPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ycbhci on 2017/6/28.
 */
@WebServlet(name = "StuEditSecurityInfo",value = "/StuEditSecurityInfo")

public class StuEditSecurityInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentPage studentPage= (StudentPage) request.getSession().getAttribute("studentpage");
        String password;
        password=request.getParameter("password");
        studentPage.setPassword(password);
        StudentDAO studentDAO=new StudentDAO();
        studentDAO.Update(studentPage);
        request.getSession().setAttribute("studentpage",studentPage);
        response.sendRedirect("Student/StuSecurityInfo.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
