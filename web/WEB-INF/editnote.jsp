<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <b><label>Title:</label></b>
            <input type="text" name="note_title" value="${note.title}">
            <b><label>Contents:</label></b>
            <input type="text" name="contents_title" value="${note.contents}">
            <input type="submit" value="Save">
        </form>
    </body>
</html>