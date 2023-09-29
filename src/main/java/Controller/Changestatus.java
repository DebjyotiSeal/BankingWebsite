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
@WebServlet("/changestatus")
public class Changestatus  extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String acn=req.getParameter("acno");
	long acno=Long.parseLong(acn);
	BankDao bankDao=new BankDao();
	Bank_account bankAccount = bankDao.fetch(acno);
	
	if (bankAccount.isStatus()) {
		bankAccount.setStatus(false);
	} else {
		bankAccount.setStatus(true);
	}
	
	bankDao.update(bankAccount);
	
	List<Bank_account> bankAccountList = bankDao.fetchAll();
	req.getSession().setAttribute("bankAccountList", bankAccountList);
	req.getRequestDispatcher("AccountHome.jsp").include(req, resp);

}
}
