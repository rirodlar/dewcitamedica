<%-- 
    Document   : logeoPrueba
    Created on : 17/02/2010, 03:33:04 PM
    Author     : rSaenz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Logeo</h1>
        <form id="frmLogeo" name="frmLogeo" method="post" action="LoginServlet">
            <label>Usuario
                <input type="text" name="username" id="username" />
            </label>
            <br />
            <label>Contraseña
                <input type="password" name="password" id="password" />
            </label>
            <br />${error}
            <br /><input name="btnEnviar" type="submit" value="Enviar" />
        </form>

    </body>
</html>
