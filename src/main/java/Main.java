

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Main
 */

@WebServlet ("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Welcome to my Shop";
		int radio = -1;
		
		String gender = "";
		boolean check = true;
		try {
			radio = Integer.parseInt(request.getParameter("rb"));
		} catch(Exception e) {
			gender = "Please select a gender.";
		} if(request.getParameter("firstName")=="" && request.getParameter("lastName")=="") {
			out.println(
					"<html>\n" +
					"<head><link rel=\"stylesheet\" href=\"style.css\">\n" +
					"<title>" + title + "</title></head>\n" +
					"<body background-color=\"black\">\n" +
					"<h1>" + title + "</h1>\n" +
					"<ul>\n" +
					"Please enter your first and last name." +
					"</ul>\n" +
					"</body></html>");
			check = false;
		} else if(request.getParameter("firstName")=="") {
			out.println(
					"<html>\n" +
					"<head><link rel=\"stylesheet\" href=\"style.css\">\n" +
					"<title>" + title + "</title></head>\n" +
					"<body background-color=\"black\">\n" +
					"<h1>" + title + "</h1>\n" +
					"<ul>\n" +
					"Please enter your first name." +
					"</ul>\n" +
					"</body></html>");
			check = false;
		} else if(request.getParameter("lastName")=="") {
			out.println(
					"<html>\n" +
					"<head><link rel=\"stylesheet\" href=\"style.css\">\n" +
					"<title>" + title + "</title></head>\n" +
					"<body background-color=\"black\">\n" +
					"<h1>" + title + "</h1>\n" +
					"<ul>\n" +
					"Please enter your last name." +
					"</ul>\n" +
					"</body></html>");
			check = false;
		} 
		switch(radio) {
		case 0: gender = "Thank you Mr. " + request.getParameter("firstName") + " " + request.getParameter("lastName") + ".";break;
		case 1: gender = "Thank you Ms. " + request.getParameter("firstName") + " " + request.getParameter("lastName") + ".";break;
		case 2: gender = "Thank you " + request.getParameter("firstName") + " " + request.getParameter("lastName") + ".";break;
		default: gender = "Please select a gender.";
		} if(check) {
			out.println(
					"<html>\n" +
					"<head><link rel=\"stylesheet\" href=\"style.css\">\n" +
					"<title>" + title + "</title></head>\n" +
					"<body background-color=\"black\">\n" +
					"<h1>" + title + "</h1>\n" +
					"<ul>\n" +
					gender +
					"</ul>\n" +
					"</body></html>");
		}

	}
}
