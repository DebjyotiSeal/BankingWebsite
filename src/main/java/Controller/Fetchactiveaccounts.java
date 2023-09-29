package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Bank_account;
import Dto.CoustomerDto;
@WebServlet("/fetchactiveaccounts")
public class Fetchactiveaccounts extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CoustomerDto coustomerDto=(CoustomerDto) req.getSession().getAttribute("customer");
	List<Bank_account> list=coustomerDto.getBankAccounts();
	List<Bank_account> list2=new ArrayList<Bank_account>();
	for(Bank_account bank_account:list)
	{
		if(bank_account.isStatus())
		{
			list2.add(bank_account);//active account are presented inside list2
		}
	}
	req.getSession().setAttribute("list", list2);
	req.getRequestDispatcher("acconts.jsp").include(req,resp);
}
}
