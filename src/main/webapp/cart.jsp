<%@page import="HomeBook.model.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import  = "HomeBook.model.Book"%>
<%@page import  = "HomeBook.model.Category_object"%>
<%@page import  = "java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="cart.css">
</head>
<body>

<nav>

        <div class="home">
            <a class="home__item" href="/WebBook/home">Book<p class="home-text">Store</p></a>
        </div>

        <div class="search-input">
            <form class="search-form" method="post" action="/WebBook/search" name="search">
                <input class="search-insert" type="text" name="titleBook"  placeholder="Search name book">
                <button type="submit" name="save">Search</button>
            </form>
            
	        <form class="search-form" action = "/WebBook/category" method="post" name="category">
	                <select name = "item">
	                  
                    <%List<Category_object> list1 =  (List<Category_object>) request.getAttribute("listCategory1");
                        for(Category_object c : list1){ %>
                            <option value= "<%=c.getId() %>"><%= c.getName() %></option>
                        <% } %>  
	                    
	                </select>
	                <input type="submit" value="Select">
            </form>  
            
        </div>
        
        
    </nav>


<div class="content">
        <h4 class="header">List Book</h4>
      <table border ="1" width="500" align="center">
         <tr bgcolor="whitesmoke ">
          <th><b>ID</b></th>
          <th><b>Quantity</b></th>
          <th><b>R</b></th>
          
         </tr>
     
        <%List<Item> std =  (List<Item>)session.getAttribute("cart");
            for(Item b : std){%>
           
                <tr>
                    <td><%= b.getBook().getTitle() %></td>
                    <td><%= b.getQuantity() %></td>
                    <td style="text-align: center;"><a class="return-btn" href="/WebBook/cart?&action=return&id=<%=b.getBook().getId() %>">Return</a></td>
                </tr>
                <%}%>
        </table> 
       
    </div>
    
</body>
</html>