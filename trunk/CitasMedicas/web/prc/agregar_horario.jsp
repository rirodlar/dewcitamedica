<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" media="all" href="../resources/css/calendario/calendar-win2k-2.css" />
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css" media="screen" />
    <!--[if IE 6]>
    <link rel="stylesheet" type="text/css" href="../resources/css/iecss.css" />
    <![endif]-->
<title>Documento sin título</title>
</head>

<body class="flotante">
<div class="x7q">
        <div class="box_title">
                    <div class="title_icon"><img src="../resources/img/mini_icon1.gif" alt="" title="" /></div>
                    <h2>Agregar <span class="dark_blue">Horario</span></h2>
        </div>
        <br/>
        <div style="padding-left:15px">
        <p>Por favor, ingrese la hora de inicio y la hora fin de atenci&oacute;n.</p>
        <br/>
      	<table width="400" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="40%">De:
                    <select name="cboHoraInicio" id="cboHoraInicio" class="x4" style="width:120px">
                    	<option>Seleccione</option>
                        <option>06:00 - 06:20</option>
                        <option>06:20 - 06:40</option>
                        <option>06:40 - 07:00</option>
                        <option>07:00 - 07:20</option>
                    </select>
                </td>
              <td width="18%">&nbsp;</td>
                <td width="42%">Hasta:
                    <select name="cboHoraInicio" id="cboHoraInicio" class="x4" style="width:120px">
                    	<option>Seleccione</option>
                        <option>06:00 - 06:20</option>
                        <option>06:20 - 06:40</option>
                        <option>06:40 - 07:00</option>
                        <option>07:00 - 07:20</option>
                    </select>
                </td>
            </tr>
            <tr>
              <td height="42">&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td colspan="3" align="center"><input type="button" name="btnAgregar" id="btnAgregar" class="x7g" value="Agregar" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" onclick="javascript:window.close()" /></td>
            </tr>
        </table>
        </div>
    </div>
</body>
</html>
