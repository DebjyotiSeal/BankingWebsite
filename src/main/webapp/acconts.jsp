<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_Active_Account_page</h1>
<%List<Bank_account>list=(List<Bank_account>)request.getSession().getAttribute("list");
if(list.isEmpty())
{%>
<h1>No_Active_Account_is_presented</h1>
<%} else{%>
<%for(Bank_account bank_account:list) {%>	
<a href="setaccount?acno=<%=bank_account.getAcc_no() %>"><button><%=bank_account.getAcc_no() %></button></a>
<%} %>
<%} %>
</body>
</html>