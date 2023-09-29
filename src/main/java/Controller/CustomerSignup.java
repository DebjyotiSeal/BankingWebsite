package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CoustomerDao;
import Dto.CoustomerDto;

@WebServlet("/customersignup")
public class CustomerSignup extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");

		String mobile = req.getParameter("mob");

		String email = req.getParameter("email");

		String password = req.getParameter("password");

		String dob = req.getParameter("dob");

		String gender = req.getParameter("gender");

		CoustomerDao coustomerDao = new CoustomerDao();

		Date date = Date.valueOf(dob);

		Period period = Period.between(date.toLocalDate(), LocalDate.now());

		int age = period.getYears();

		if (age < 18)

		{

			resp.getWriter().print("<h1 style=\"color: aliceblue;\">you have to be 18 to create an account</h1>");
			req.getRequestDispatcher("customersignup.html").include(req, resp);
		}

		else

		{
			if (coustomerDao.check1(email).isEmpty() && coustomerDao.check2(mobile).isEmpty())

			{// resp.getWriter().print(<h1>you are eligible to create an account</h1>);
				CoustomerDto coustomer = new CoustomerDto();

				coustomer.setName(name);

				coustomer.setEmail(email);

				coustomer.setMobile(mobile);

				coustomer.setGender(gender);

				coustomer.setPassword(password);

				coustomer.setDate(date);

				coustomerDao.save(coustomer);
				CoustomerDto cs = coustomerDao.check1(email).get(0);
				int custid = cs.getCust_id();
				if (cs.getGender().equals("male")) {
					resp.getWriter().print("<div id=\"out\" ><h1 style=\"color: aliceblue;\">hello "+name+" sir</h1></div>");
				} else {
					resp.getWriter().print("hello madam");
				}
				resp.getWriter().print(" <div id=\"out\" ><h1 style=\"color: aliceblue;\">your coustomer_id is: "+custid+" </h1></div>");
				req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
			}

			
			else

			{
				resp.getWriter().print("<h1 style=\"color: aliceblue;\">Account is already Present</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}

		}

	}

}
