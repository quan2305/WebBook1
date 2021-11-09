<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import  = "HomeBook.model.History"%>
<%@page import  = "HomeBook.model.Category_object"%>
<%@page import  = "java.util.List"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
        <h4 class="list">List Book</h4>
      <table border ="1" width="500" align="center">
         <tr bgcolor="whitesmoke ">
          <th><b>id_user</b></th>
          <th><b>id_return</b></th>
          <th><b>borrow</b></th>
          <th><b>return</b></th>
         </tr>
     
        <%List<History> histories =  (List<History>)session.getAttribute("history");
            for(History his : histories){%>
           
                <tr>
                    <td><%= his.getId_user() %></td>
                    <td><%= his.getId_book() %></td>
                    <td><%= his.getBorrow_date() %></td>
                     <td><%= his.getReturn_date() %> </td>
                    
                </tr>
                <%}%>
        </table> 
       
    </div>
</body>
</html>