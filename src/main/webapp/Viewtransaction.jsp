<%@page import="Dto.Banktransaction"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Transaction</title>
<style >
*{
    box-sizing: border-box;
    margin: 0%;
    padding: 0%;
}
table {
    border-collapse: collapse;
    width: 100%;
  }

  th, td {
    border: 1px solid rgb(14, 13, 13);
    padding: 8px;
    text-align: left;
  }
  th{
    text-transform: uppercase;
  }

  .btn {
    padding: 8px 12px;
    font-size: 14px;
    text-align: center;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
  }
  body{
    background-image: url("Image/table back ground.jpg");
    background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
}
  button
{
    height: 40px;
    width: 250px;
    border-radius: 10px ;
    border-top: none;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-weight: bold;
}
button:hover{
    background-color: rgb(125, 150, 150);
    box-shadow: 0 0 20px #646161;
    color: white;
    height: 47px;
    width: 277px;
    font-size: 15px;
}
button:hover>a{
    color: white;
}
a
{
    color: black;
    text-decoration: none;
}
#head
{
    text-transform: uppercase;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    border: 1px solid grey;
    text-align: center;
    padding: 10px;
    box-shadow: 0 0 20px #646161;
}
#main{
    height: 650px;
    width: auto;
    display: flex;
    justify-content: space-between;
    flex-direction: column;
}
#btn{
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 20px;
}
#tab{
    overflow: scroll;
    height: auto;
    width: auto;
}
#head2{
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 50px;
    width: auto;
}
#s1 {
    height: 50px;
    width: 50%;
}
#s2{
    height: 50px;
    width: 50%;
}
</style>
</head>
<body>
<div id="head"><h1>Welcome_to_Transaction_history_page</h1></div>

<%long acno=(Long)request.getSession().getAttribute("acno");
        BankDao bankDao=new BankDao();
        Bank_account bank_account=bankDao.fetch(acno);
        List<Banktransaction> list=bank_account.getBanktransations();
%>
        <div id="head2">
            <div id="s1"><h1>Acc_no:<%=acno %></h1></div>
            <div id="s2"><h1>Acc_type:<%=bank_account.getAccountType() %></h1></div>
        </div>
    
        
        <div id="main">
            <div id="tab">
                <table border="1">
                <tr>
                <th>Transaction_id</th>
                <th>Deposit</th>
                <th>Withdraw</th>
                <th>Balance</th>
                <th>Date_time</th>
                </tr>
                <%for(Banktransaction banktransaction:list) {%>
                <tr>
                <th><%=banktransaction.getT_id() %></th>
                <th><%=banktransaction.getDeposit() %></th>
                <th><%=banktransaction.getWithdraw() %></th>
                <th><%=banktransaction.getBalance() %></th>
                <th><%=banktransaction.getDatetime() %></th>
                </tr>
                
                <%} %>
                
                </table>
                
                <div id="btn"><button><a href="Accounthomee2.jsp">Back</a></button></div>
            </div>
        </div>
</body>
</html>