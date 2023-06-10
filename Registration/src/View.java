

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDao rdao=new RegisterDao();
		 
	        PrintWriter out = response.getWriter();
	        List<Member>    list =rdao.getAllUserData();
	        if (list != null) {
	            for (Member member : list) {
	                out.print("<tr> <td>" + member.getUname()
	                          + "</td> <td>" + member.getPassword()
	                          + "</td> </tr>"+member.getEmail()
	                          +"</td> </tr>"+member.getPhone());
	            }
	            
	        }
	    }
}

