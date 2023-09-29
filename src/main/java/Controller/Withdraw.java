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

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
   String amt    =req.getParameter("amount");
   
   double amount     =Double.parseDouble(amt);
   
  long acno   = (Long) req.getSession().getAttribute("acno");
  
  BankDao bankDao  =new BankDao();
 Bank_account bankAccount   = bankDao.fetch(acno);
 
 if(amount>bankAccount.getBalance())
 {
	 resp.getWriter().print("<h1>Insufficient balance your available balance is : "+bankAccount.getBalance()+"</h1>");
	 req.getRequestDispatcher("Accounthomee2.jsp").include(req, resp);
 }
 
 else
 {
	 if(amount>bankAccount.getAcc_limit())
	 {
		 
		 resp.getWriter().print("<h1>your exceeding your account limit your acoount limit is :"+bankAccount.getAcc_limit()+"</h1>");
		 req.getRequestDispatcher("Accounthomee2.jsp").include(req, resp);
	 }
	 
	 else
	 {
		 bankAccount.setBalance(bankAccount.getBalance()-amount);
		 Banktransaction banktransactions	=new Banktransaction();
			//banktransactions.setT_id(0);
			 banktransactions.setDeposit(0);
			 banktransactions.setWithdraw(amount);
			banktransactions.setBalance(bankAccount.getBalance());
			banktransactions.setDatetime(LocalDateTime.now());  //localdatetime is the class name now() is the static method.
			
			List<Banktransaction> list     =bankAccount.getBanktransations();
			list.add(banktransactions);
		 
		 bankDao.update(bankAccount);
		 
		 resp.getWriter().print("<h1>your amount has been withdrawn successfully</h1>");
		 req.getRequestDispatcher("Accounthomee2.jsp").include(req, resp);
	 }
 }
 
}
}
