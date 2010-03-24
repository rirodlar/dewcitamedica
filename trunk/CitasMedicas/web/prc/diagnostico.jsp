<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" type="text/javascript" src="<s:url value='/resources/jss/tools/Utiles.js'/>"></script>
    <link rel="stylesheet" type="text/css" media="all" href="<s:url value='/resources/css/calendario/calendar-win2k-2.css'/>" />
    <script type="text/javascript" src="<s:url value='/resources/jss/calendario/calendar.js'/>"></script>
    <script type="text/javascript" src="<s:url value='/resources/jss/calendario/calendar-es.js'/>"></script>
    <script type="text/javascript" src="<s:url value='/resources/jss/calendario/calendar-setup.js'/>"></script>
    <script type="text/javascript" src="<s:url value='/prc/js/diagnostico.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/style.css'/>" media="screen" />
    <script type="text/javascript" src="<s:url value='/resources/jss/tools/Utiles.js'/>"></script>
    <!--[if IE 6]>
    <link rel="stylesheet" type="text/css" href="../resources/css/iecss.css" />
    <![endif]-->
<title>Medical Theme Css Template</title>
</head>
<body class="principal">
<div id="main_container">
	<div class="header">
    	<div id="logo"><a href="index.jsp"><img src="../resources/img/logo.png" alt="" title="" width="162" height="54" border="0" /></a></div>
    
    	<div class="right_header">
   
            <div class="top_menu">
            <div style="width:90px;float:left;margin:0 3px 0 3px;">&nbsp;</div>
            <a href="../loguin.jsp" class="login">Salir</a>
            </div>
        
            <div id="menu">
                <ul>                                              
                    <li><a href="../home.jsp" title="">Inicio</a></li>
                    <li><a href="#" title="">Nosotros</a></li>
                    <li><a class="current" href="#" title="">Citas</a></li>
                    <li><a href="horario.jsp" title="">Horario</a></li>
                </ul>
            </div>
        
        </div>
    </div>
    <div id="profundidad">&nbsp;<a href="consulta.jsp" class="enlace">Consulta de Citas</a> &gt; Diagn&oacute;stico</div>
    
    <div id="contenido">
    <!-- Aqui el contenido de la pagina -->
    		<div class="box_title">
                    	<div class="title_icon"><img src="../resources/img/mini_icon1.gif" alt="" title="" /></div>
                        <h2>Mis <span class="dark_blue">Diagn&oacute;sticos</span></h2>
            </div>
      <div class="caja_contenido">
        <p>Por favor, registre los datos necesarios para la cita realizada.</p>
        <br/>
      	<table width="840px" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td colspan="4" align="center"><table width="840px" align="left" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="728" align="center"><span class="titulo">La Rosa Flores, Claribel</span></td>
                <td width="112" rowspan="6"><img src="../resources/img/foto_carnet.jpg" width="112" height="129" /></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><b>Fec. Nac.:</b> 15/03/1979</td>
              </tr>
              <tr>
                <td><b>Edad:</b> 30 años</td>
              </tr>
              <tr>
                <td><b>Tipo de Sangre:</b> O+</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><b>Médico:</b> Paredes Horacio, Alfredo</td>
            <td>&nbsp;</td>
            <td><b>Especialidad:</b> Cardiología</td>
          </tr>
          <tr>
            <td><b>Fecha Cita:</b> Martes 02 de Febrero</td>
            <td>&nbsp;</td>
            <td><b>Hora Cita:</b> 15:00</td>
          </tr>
          <tr>
            <td><b>S&iacute;ntomas:</b></td>
            <td>&nbsp;</td>
            <td><b>Diagnóstico:</b></td>
          </tr>
          <tr>
            <td><textarea name="txtS&iacute;ntomas" id="txtSintomas" cols="100" rows="3" class="x4" style="width:350px">Tos constante.</textarea></td>
            <td>&nbsp;</td>
            <td><textarea name="txtDiagnostico" id="txtDiagnostico" cols="100" rows="3" class="x4" style="width:350px">Consulta para despistaje.</textarea></td>
          </tr>
          <tr>
            <td><b>Receta:</b></td>
            <td>&nbsp;</td>
            <td><b>An&aacute;lisis:</b></td>
          </tr>
          <tr>
            <td><textarea name="txtS&iacute;ntomas" id="txtSintomas" cols="100" rows="3" class="x4" style="width:350px">Pastillas</textarea></td>
            <td>&nbsp;</td>
            <td><textarea name="txtDiagnostico" id="txtDiagnostico" cols="100" rows="3" class="x4" style="width:350px">Radiografia</textarea></td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr>
            <td><b>Fec. pr&oacute;xima cita:</b>
              <input type="text" name="txtProximaCita" id="txtProximaCita" class="x4" style="width:70px" readonly="readonly" />
              <IMG src="<s:url value='/resources/img/cdp.gif'/>" name="imgFechaDesde" id="imgFechaDesde" width="19" height="24" border="0" alt="Buscar Fecha de Reserva" align="top" style="cursor:hand" />
				<script type="text/javascript">
                    Calendar.setup({
                        input : "txtSemana", // Input Id")
                        ifFormat : "%d/%m/%Y", // Date format");
                        button : "imgFechaDesde" // Button Id");
                    });
                </script>
            </td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4"><input type="button" name="btnGuardar" id="btnGuardar" class="x7g" value="Guardar" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" /></td>
          </tr>
        </table>

        </div>
  
    </div>     
            
    <div id="footer">
     	<div class="copyright">
        <img src="../resources/img/footer_logo.gif" alt="" title="" />
        </div>
        <div class="center_footer">&copy; Medical Clinic 2008. All Rights Reserved</div>
    	<div class="footer_links">
        <a href="http://csstemplatesmarket.com"><img src="../resources/img/csstemplatesmarket.gif" alt="csstemplatesmarket" title="csstemplatesmarket" border="0" /></a>
        </div>
    </div>
</div>
</body>
</html>
