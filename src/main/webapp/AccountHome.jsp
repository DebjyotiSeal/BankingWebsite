<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accounts Details</title>
<style>
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
	    border: 1px solid rgb(153, 148, 148);
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
	    height: 650px;;
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
	body{
	    background-image: url("Image/table back ground.jpg");
	    background-position: center;
	    background-size: cover;
	    background-repeat: no-repeat;
	}
	#tab{
	    overflow: scroll;
	    height: auto;
	    width: auto;
	}
		

</style>
</head>
<body>
<div id="head"> <h1>Welcome to Account Home</h1></div>
	<%
	List<Bank_account> list = (List<Bank_account>) request.getSession().getAttribute("bankAccountList");
	%>

    <div id="main">
       <div id="tab">
        <table border="1">

            <tr>
                <th>Acc_no</th>
                <th>Acc_type</th>
                <th>Acc_limit</th>
                <th>Balance</th>
                <th>Status</th>
                <th>Customer_Name</th>
                <th>Customer_Id</th>
                <th>Change_status</th>
            </tr>

            <%
            for (Bank_account bankAccount : list) {
            %>
            <tr>

                <td><%=bankAccount.getAcc_no()%></td>
                <td><%=bankAccount.getAccountType()%></td>
                <td><%=bankAccount.getAcc_limit()%></td>
                <td><%=bankAccount.getBalance()%></td>
                <td><%=bankAccount.isStatus()%></td>
                <td><%=bankAccount.getCustomer().getName()%></td>
                <td><%=bankAccount.getCustomer().getCust_id()%></td>
                <td><a href="changestatus?acno=<%=bankAccount.getAcc_no()%>"><button>CHANGE STATUS</button></a></td>

            </tr>
            <%
            }
            %>
        </table>
       </div> 
	    <div id="btn"><button><a href="Home.html">Back</a></button>  </div>
    </div>
	
</body>
</html>