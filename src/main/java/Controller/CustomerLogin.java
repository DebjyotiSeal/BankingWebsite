package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.CoustomerDao;
import Dto.CoustomerDto;


@WebServlet("/login")
public class CustomerLogin extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String custidd=req.getParameter("custidd");
	String pwd=req.getParameter("pwdd");
	
	int custid=Integer.parseInt(custidd);
	
	CoustomerDao customerdao=new CoustomerDao();
	CoustomerDto  customer = customerdao.login(custid);
	
	if(customer==null)
	{
		resp.getWriter().print("<div id=\"out\" ><h1 style=\"color: black;\">you have entered invalid coustomerid</h1></div>");
		req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
	}                                                               
	else
	{   
	if(customer.getPassword().equals(pwd))
	{
		resp.getWriter().print("<h1 style=\"color: black;\">Login success</h1>");
		req.getSession().setAttribute("customer", customer); //here if want i want to use the information of customer i should go for session tracking=>(req.getSession().setAttribute("customer", customer);) 
		req.getRequestDispatcher("customerhome.html").include(req, resp);
		}
	else
	{
		resp.getWriter().print("<div id=\"out\"><h1 style=\"color: black;\"> you have entered invalid password</h1></div>");
		req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
	}
	}
}
}
