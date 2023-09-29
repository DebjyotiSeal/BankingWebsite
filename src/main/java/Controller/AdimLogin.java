package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bank_account;

@WebServlet("/adminLogin")
public class AdimLogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if (email.equals("admin") && password.equals("admin")) 
		{
			resp.getWriter().print("<h1>Admin login successful</h1>");
		//req.getRequestDispatcher("AccountHome.jsp").forward(req, resp);
			BankDao bankDao = new BankDao();
			List<Bank_account> bankAccountList = bankDao.fetchAll();
			req.getSession().setAttribute("bankAccountList",bankAccountList);
			req.getRequestDispatcher("AccountHome.jsp").include(req, resp);
		} 
		else 
		{
			resp.getWriter().print("<h1>Invalid Credentials</h1>");
			req.getRequestDispatcher("adminLogin.html").include(req, resp);
		}
	}
}
