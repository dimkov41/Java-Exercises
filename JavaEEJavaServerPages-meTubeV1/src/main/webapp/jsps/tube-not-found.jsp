<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<div class="text-center p-3 mb-2 bg-light text-dark">
    <h2><%=request.getAttribute("javax.servlet.error.message")%></h2>
    <br/>
    <hr/>
    <a href="/">Back to Home page</a>
</div>
<%@include file='footer.jsp'%>
</body>
</html>
