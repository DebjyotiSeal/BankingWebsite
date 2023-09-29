<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Page</title>
<style>
		*{
		    margin: 0%;
		    padding: 0%;
		    box-sizing: border-box;
		    text-transform: uppercase;
		}
		#head{
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    color: aquamarine;

		    Background: linear-gradient(rgb(100, 100, 100), rgb(255, 255, 255));
		}
		#head>h1{
		    color:black;
		    font-family: Arial, Helvetica, sans-serif;
		    font-style: italic;
		}
		a{
		    font-size: 20px;
		    text-transform: uppercase;
		    text-decoration: none;
		}
		#main{
		    height: 700px;
		    width: auto;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    background-image: url("Image/acount balance.jpg");
		    background-size: contain;
		    background-position: center;
		    background-repeat: no-repeat;
		}
		#btn{
		    width: 100%;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		}
		#bal{
		    height: 200px;
		    width: 100%;
		    display: flex;
		    align-items: center;
		}
		#bal>h2{
		    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
		    color: #141414;
		    text-transform: uppercase;
		}
		#in{
		    height: 350px;
		    width: 50%;
		    display: flex;
		    justify-content: space-between;
		    align-items: center;
		    flex-direction: column;
		    box-shadow: 0 0 20px #7a7878;
		}
		button{
		   
		    height: 30px;
		    width: 150px;
		    border-radius: 7px ;
		    border-top:none ;
		    border-left: none;
		    border-right: none;
		    box-shadow: 0 0 20px #646161;
		    font-family: Verdana, Geneva, Tahoma, sans-serif;
		    font-weight: bold;
		}
		button:hover{
		    background-color: rgb(82, 87, 87);
		    box-shadow: 0 0 20px #646161;
		    color: antiquewhite;
		    height: 35px;
		    width: 170px;
		    font-size: 20px;
		}
		#balan{
		color: white;
		}
</style>
</head>
<body>
<div id="head"><h1>Welcome to Balance Page</h1></div>

    <div id="main">

        <%
        long acno = (Long) request.getSession().getAttribute("acno");
        %>
        <%
        BankDao bankDao = new BankDao();
        Bank_account bankAccount = bankDao.fetch(acno);
        double balance = bankAccount.getBalance();
        %>
        <div id="in">
            <div id="bal">
                <h2 id="balan">
                your account balance is:
                <%=balance%>
                </h2>
            </div>
    
            <div id="btn">
            <button><a href="Accounthomee2.jsp">Back</a></button>
            </div>
        </div>
        
    </div>
</body>
</html>