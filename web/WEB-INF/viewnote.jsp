<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <form  method="post" action="note">
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <b><label>Title:</label></b>
        <p>${note.title}</p>
        <b><label>Contents:</label></b>
        <p>${note.contents}</p>
        <a href="note?edit=true">Edit</a>
        </form>
    </body>
</html>
