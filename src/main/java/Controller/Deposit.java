package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bank_account;
import Dto.Banktransaction;

@WebServlet("/deposit")
public class Deposit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String amt=req.getParameter("amount");
		double amount=Double.parseDouble(amt);
		
	Long acn=(Long) req.getSession().getAttribute("acno");
	
	BankDao bankDao=new BankDao();
	Bank_account bank_account=bankDao.fetch(acn);
	
	bank_account.setBalance(bank_account.getBalance()+amount);
	
	Banktransaction banktransation=new Banktransaction();
	
	banktransation.setDeposit(amount);
	
	banktransation.setWithdraw(0);
	
	banktransation.setBalance(bank_account.getBalance());
	
	banktransation.setDatetime(LocalDateTime.now());//localdatetime is the class name and now is method
	
	List<Banktransaction>list=bank_account.getBanktransations();
	
	list.add(banktransation);
	
	bankDao.update(bank_account);
	
	resp.getWriter().print("<h1>Your Amount has been Deposited Successfully</h1>");
	
	req.getRequestDispatcher("Accounthomee2.jsp").include(req, resp);
	}
}
