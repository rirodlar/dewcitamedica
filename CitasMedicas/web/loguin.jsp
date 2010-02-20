<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Ingreso al sistema</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
</head>

<body class="principal">
	<div id="main_loguin">
        <div class="loguin_bg">
        <div class="title_login">
        <div class="form_login">
        <form id="frmLogeo" name="frmLogeo" method="post" action="Control">
          <input id="__ACTION" name="__ACTION" type="HIDDEN" value="login" />
          <input id="__ARGUMENT" name="__ARGUMENT" type="HIDDEN" value="validar" />
          <table border="0" cellpadding="0" cellspacing="0" align="center" width="210px">
            <tr>
                <td><b>Usuario:</b></td>
                <td>&nbsp;</td>
                <td><input name="username" type="text" id="username" value="" class="x4" style="width:140px" /></td>
            </tr>
            <tr><td colspan="3">&nbsp;</td></tr>
            <tr>
                <td><b>Password</b></td>
                <td>&nbsp;</td>
                <td><input name="password" type="password" id="password" value="" class="x4" style="width:140px" /></td>
            </tr>
            <tr><td colspan="3">&nbsp;</td></tr>
            <tr>
            	<td align="center">&nbsp;</td>
            	<td align="center">&nbsp;</td>
            	<td align="left"><input name="btnEnviar" type="submit" value="Enviar" class="x7g" style="BACKGROUND-IMAGE: url(resources/img/btn-bg1.gif)" /></td>
            </tr>
        </table>
        <p/>
        <table border="0" cellpadding="0" cellspacing="0" align="center" width="300px">
        	<tr>
            	<td colspan="3"><span class="x2o">${errorMsg}</span></td>
            </tr>
        </table>
        </form>
        </div>
        </div>
        <img src="resources/img/footer_logo.gif" alt="" title="" align="right" />
        </div>
		<div id="footer_loguin">&copy; Medical Clinic 2008. All Rights Reserved</div>
    </div>
</body>
</html>
