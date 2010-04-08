<%-- 
    Document   : errorPage
    Created on : 22/02/2010, 09:09:01 PM
    Author     : Grupo 4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medical clinic - Error</title>
        <link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/style.css'/>" media="screen" />
    </head>
    <body class="principal">
        <div id="main_loguin">
            <div class="loguin_bg">
            	<div style="padding-left:30px; float:left; width:162px">
                    <a href="home.jsp"><img src="<s:url value='/resources/img/logo.png' />" alt="" title="" width="162" height="54" border="0" /></a>
                </div>
                <div style="float:right; padding-right:30px;"><img src="<s:url value='/resources/img/d001.gif' />" width="165" height="230" /></div>
                <div style="padding-left:30px; padding-top:70px; text-align:center"><span class="msg01"><span class="error">Error</span><p/>${errorMsg}</span>
                <p/>Comun&iacute;quese con su Administrador de Sistemas.
                </div>
			</div>
            <div id="footer_loguin">&copy; Medical Clinic 2008. All Rights Reserved</div>
        </div>
    </body>
</html>
