<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Option</title>
<style>
*{
    box-sizing: border-box;
    margin: 0%;
    padding: 0%;
    text-decoration: none;
}
body{
    background-image: url("Image/background.jpg");
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
	    height: 650px;;
	    width: auto;
	    display: flex;
	    justify-content: space-between;
	    flex-direction: column;
	}
	#btn{
        height: 300px;
        width: auto;
	    display: flex;
	    justify-content: space-between;
	    align-items: center;
        flex-direction: column;
	}
	body{
	    background-color: bisque;
	}
    #main{
    height: 650px;;
    width: auto;
    display: flex;
    justify-content: center;
    align-items: center;
}
    #in{
    height: 400px;
    width: 600px;
    box-shadow: 0 0 20px #7a7878;
    display: flex;
    justify-content:space-evenly;
    align-items: center;
    flex-direction: column;
    border: 1px solid gray;
}

</style>
</head>
<body>
<div id="head"><h1>Welcome_to_Account_Home2</h1></div>
    <div id="main">
        <div id="in">
            <div id="btn">
                <a href="Deposit.html"><button>Deposit</button></a>
                <a href="Withdraw.html"><button>Withdraw</button></a>
                <a href="Checkbalance.jsp"><button>Checkbalance</button></a>
                <a href="Viewtransaction.jsp"><button>Viewtransaction</button></a>
                <a href="logout"><button>logout</button></a>
            </div>
        </div>
    </div>
</body>
</html>