package Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dao.CoustomerDao;
import Dto.Bank_account;
import Dto.CoustomerDto;

@WebServlet("/createbankaccount")
public class Create_BankAccount extends HttpServlet {
	
	private BankDao bankDao;
	private CoustomerDao customerdao;
	public Create_BankAccount() {
		bankDao=new BankDao();
		customerdao=new CoustomerDao();
	}
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String banktype = req.getParameter("banktype");
	CoustomerDto cutomer = (CoustomerDto) req.getSession().getAttribute("customer");
	
	List<Bank_account> list = cutomer.getBankAccounts();
	boolean flag=true;
	for(Bank_account bankAccount: list) 
	{
		if (bankAccount.getAccountType().equals(banktype)) 
		{
			flag=false;
		break;
			//resp.getWriter().print("<h1>Bank Account is exited</h1>");
		} 		
	}
		if(flag)
		{
			Bank_account bankAccount2=new Bank_account();
			bankAccount2.setAccountType(banktype);
			if (banktype.equals("savings")) 
				bankAccount2.setAcc_limit(10000);
			 else 
				bankAccount2.setAcc_limit(15000);
			
			bankAccount2.setAccountType(banktype);
			bankAccount2.setCustomer(cutomer);
			bankDao.save(bankAccount2);
			
			
			List<Bank_account> list2= list;
			list2.add(bankAccount2);
			cutomer.setBankAccounts(list2);
			customerdao.update(cutomer);
			
			resp.getWriter().print("<h1>Bank account created successfully</h1>");
			resp.getWriter().print("<h1> Waiting for Manager Approval.</h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1 style=\"color: white;\">Bank account is already existed successfully</h1>");
			req.getRequestDispatcher("select_type_of_account.jsp").include(req, resp);

		}
}
}
