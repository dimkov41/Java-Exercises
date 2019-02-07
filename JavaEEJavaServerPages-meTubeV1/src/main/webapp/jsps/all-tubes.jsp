<%@ page import="meTube.domain.models.bindingModel.TubeBindingModel" %>
<%@ page import="java.util.List" %>
<%@ page import="meTube.domain.models.service.TubeServiceModel" %>
<%@ page import="meTube.util.Constants" %>
<%@ page import="meTube.domain.models.view.AllTubesViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>MeTube</title>
</head>
<body>
<div class="text-center p-3 mb-2 bg-light text-dark">
    <header>
        <h1>All Tubes</h1>
        <br/>
        <hr/>
        <h2>Check our tubes below.</h2>
        <br/>
        <hr/>
    </header>
    <main>
        <ul>
            <% List<AllTubesViewModel> tubeNames = (List<AllTubesViewModel>) request.getAttribute(Constants.ALL_TUBES_VIEW_MODEL_ATTRIBUTE_NAME); %>
            <% for (AllTubesViewModel currentTube : tubeNames) {%>
            <li>
                <a href="${pageContext.request.contextPath}/details/tube?name=<%=currentTube.getName()%>">
                    <%=currentTube.getName()%>
                </a>
            </li>
            <%}%>
        </ul>
        <br/>
        <hr/>
        <a href="/">Back to Home</a>
    </main>
</div>
<%@include file='footer.jsp'%>
</body>
</html>
