<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page import  = "HomeBook.model.Book"%>
<%@page import  = "HomeBook.model.Category_object"%>
<%@page import  = "java.util.List"%>

  
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="index1.css">

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
          <th><b>Title</b></th>
          <th><b>Author</b></th>
          <th><b>Published year</b></th>
          <th><b>Category ID</b></th>
          <th>B</th>
         </tr>
     
        <%List<Book> std =  (List<Book>)request.getAttribute("listBook");
            for(Book b : std){%>
           
                <tr>
                    <td><%=b.getId()%></td>
                    <td><%=b.getTitle()%></td>
                    <td><%=b.getAuthor()%></td>
                    <td><%=b.getPublished_year()%></td>
                    <td><%=b.getCategry_id()%></td>
                    <td><a class ="borrow-btn" href="/WebBook/cart?&action=buy&id=<%=b.getId()%>">Borrow</a></td>
                </tr>
                <%}%>
        </table> 
       
    </div>
	

	
</body>

</html>