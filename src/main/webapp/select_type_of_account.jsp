<%@page import="Dto.CoustomerDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SelectAccountType</title>
	<style>
		*{
		    box-sizing: border-box;
		    margin: 0%;
		    padding: 0%;
		    text-decoration: none;
		    text-transform: uppercase;
		}
		body{
		    background-image: url("Image/5556661.jpg");
		    background-position: center;
		    background-size: cover;
		}
		#head{
		    height: 70px;
		    width: auto;
		    border: 1px solid gray;
		    display: flex;
		    align-items: center;
		    flex-direction: column;
		    color: rgb(231, 226, 226);
		
		}
		#main{
		    height: 700px;
		    width: auto;
		    border: 1px solid gray;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		}
		#in{
		    height: 400px;
		    width: 600px;
		    border: 1px solid gray;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    flex-direction: column;
		    box-shadow: 0 0 20px #646161;
		}
		#type{
		    margin-bottom: 20px;
		    color: rgb(231, 226, 226);
		
		}
		#btn{
		    width: 350px;
		    margin-top: 40px;
		    display: flex;
		    justify-content:space-around;
		    align-items: center;
		}
		button{
		    height: 30px;
		    width: 100px;
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
		    width: 140px;
		    font-size: 20px;
		}
		a{
		    color: black;
		}
		#radio{
		    display: flex;
		    justify-content:space-around;
		    align-items: center;
		}
		label{
		    font-size: 20px;
		    color: rgb(231, 226, 226);
		    min-width: 100px; 
		    margin-right: 15px;
		    font-family: fantasy;
		}
		input[type="radio"]{
		height: 20px;
		width: 20px;
		}
		#hi{
		color: white;
		}

	</style>
</head>
<body>
 <% CoustomerDto customer=(CoustomerDto)request.getSession().getAttribute("customer"); %>

<div id="head">
    <div id="name"><h1>Hello  <%=customer.getName()%> Sir....</h1></div>
</div>

<div id="main">
    <div id="in">
        <div id="type"><h1>Select type of account</h1></div> 
    
        <form action="createbankaccount">
            <div id="radio">
                <div>
                    <label for="save">Saving</label>
                    <input type="radio" name="banktype" id="save" value="savings" required="required">
                </div>
                <div>
                    <label for="current">Current</label>
                    <input type="radio" name="banktype" id="current" value="current">
                </div>
            </div>
            
            
            <div id="btn">
                <div><button type="submit">Submit</button> </div>
                <div><button type="reset">cancel</button></div>
               <div><button> <a href="CustomerLogin.html">Back</a></button></div>
            </div>
        </form>  
            
    </div>
</div>

</body>
</html>