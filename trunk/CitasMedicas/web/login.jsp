<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Ingreso al sistema</title>
        <link href="<s:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body class="principal">
        <div id="main_loguin">
            <div class="loguin_bg">
                <div class="title_login">
                    <div class="form_login">
                        <s:form action="login" namespace="/logueo" method="POST" name="frmLogin">
                            <table border="0" cellpadding="0" cellspacing="0" align="center" width="210px">
                                <tr>
                                    <td><b>Usuario:</b></td>
                                    <td>&nbsp;</td>
                                    <td><s:textfield name="username" cssClass="x4" cssStyle="width:150px" /></td>
                                </tr>
                                <tr><td colspan="3">&nbsp;</td></tr>
                                <tr>
                                    <td><b>Password:</b></td>
                                    <td>&nbsp;</td>
                                    <td><s:password name="password" cssClass="x4" cssStyle="width:150px" /></td>
                                </tr>
                                <tr><td colspan="3">&nbsp;</td></tr>
                                <tr>
                                    <td align="center">&nbsp;</td>
                                    <td align="center">&nbsp;</td>
                                    <td align="left"><s:submit name="btnEnviar" value="Enviar" cssClass="x7g" cssStyle="BACKGROUND-IMAGE: url(resources/img/btn-bg1.gif)" /></td>
                                </tr>
                            </table>
                            <br />
                            <table border="0" cellpadding="0" cellspacing="0" align="center" width="300px">
                                <tr>
                                    <td colspan="3"><span class="errorMessage">${errorMsg}</span></td>
                                </tr>
                            </table>
                        </s:form>
                    </div>
                </div>
                <img src="<s:url value='/resources/img/footer_logo.gif' />" alt="" title="" align="right" />
            </div>
            <div id="footer_loguin">&copy; Medical Clinic 2008. All Rights Reserved</div>
        </div>
    </body>
</html>
