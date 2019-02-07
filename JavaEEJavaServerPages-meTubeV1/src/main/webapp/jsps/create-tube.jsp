<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="tube-not-found.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>MeTube</title>
</head>
<body>
<div class="text-center p-3 mb-2 bg-light text-dark">
    <header>
        <h1>Create Tube!</h1>
        <hr/>
    </header>
    <main>
        <form action="/create/tube" method="post">
            <label>Title: <br/>
                <input type="text" name="title"/>
            </label>
            <hr/>
            <br/>
            <label>Description: <br/>
                <textarea rows="4" cols="50" name="description"></textarea>
            </label>
            <hr/>
            <br/>
            <label>YouTube Link: <br/>
                <input type="text" name="youtubeLink"/>
            </label>
            <hr/>
            <br/>
            <label>Uploader: <br/>
                <input type="text" name="uploader"/>
            </label>
            <hr/>
            <br/>
            <input type="submit" class="btn btn-info" value="Create Tube"/>
        </form>
        <br/>
        <hr/>
        <a href="/">Back to Home page</a>
    </main>
</div>
<%@include file='footer.jsp'%>
</body>
</html>
