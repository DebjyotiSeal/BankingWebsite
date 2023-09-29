package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/setaccount")
public class Setaccount extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String acn=req.getParameter("acno");
	long acno=Long.parseLong(acn);
	req.getSession().setAttribute("acno",acno);//here if i want to use in further operation i can use it
	req.getRequestDispatcher("Accounthomee2.jsp").include(req, resp);
}
}
