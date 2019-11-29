<%@page language="java" import="java.util.*" %>
<html>
<head>
<title>Data Page</title>
</head>
<body> 
<table border="1" width="303">
<tr>
<td width="119"><b>EMPNAME</b></td>
<td width="168"><b>EMPID</b></td>
<td width="168"><b>EMAIL</b></td>
<td width="168"><b>CONTACT</b></td>
<td width="168"><b>ADDRESS</b></td>
</tr>
<% Iterator itr;%>
<% List data= (List)request.getAttribute("data");
for (itr=data.iterator(); itr.hasNext(); )
{
%>
<tr>
<td width="119"><%=itr.next()%></td>
<td width="168"><%=itr.next()%></td>
<td width="168"><%=itr.next()%></td>
<td width="168"><%=itr.next()%></td>


</tr>
<%}%>
</table>
</body>
</html>