<%@ page import="meTube.domain.models.view.DetailsTubeViewModel" %>
<%@ page import="meTube.util.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>meTube</title>
</head>
<body>
<div class="p-3 mb-2 bg-light text-dark">
    <% DetailsTubeViewModel tubeViewModel = (DetailsTubeViewModel) request.getAttribute(Constants.DETAILS_PAGE_ATTRIBUTE_NAME); %>
    <article>
        <span class="text-center">
            <h1><%= tubeViewModel.getName()%>
            </h1>
            <br/>
            <hr/>
        </span>
    </article>
    <main>
        <span class="text-center">
            <p><%= tubeViewModel.getDescription()%>
            </p>
        <hr/>
        <br/>
        </span>
        <div class="class row">
            <div class="class col col-md-6 d-flex justify-content-center">
                <a class="text-right" href="<%= tubeViewModel.getYoutubeLink() %>">Link To Video</a>
            </div>
            <div class="class col col-md-6 d-flex justify-content-center">
                <span class="text-left"><%= tubeViewModel.getUploader() %></span>
            </div>
        </div>
        <br/>
        <hr/>
        <div class="text-center">
            <a href="/">Back to Home page</a>
        </div>
    </main>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
