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
        <script type="text/javascript">
            function btnGuardar_onclick () {
                frmDiagnostico.action = '<s:url value="/diagnostico/diagnosticar.action"/>';
                frmDiagnostico.submit();
            }
            function cerrarSesion() {
                frmDiagnostico.action = '<s:url value="/login/logout.action"/>'
                frmDiagnostico.submit();
            }
	    function lnkConsultarCita_onclick () {
                frmDiagnostico.action = '<s:url value="/consulta/consultarCita.action"/>';
                frmDiagnostico.submit();
            }
        </script>
    <!--[if IE 6]>
    <link rel="stylesheet" type="text/css" href="../resources/css/iecss.css" />
    <![endif]-->
<title>Registrar Diagnostico</title>
</head>
<body class="principal">
<div id="main_container">
	<div class="header">
    	<div id="logo"><a href="index.jsp"><img src="../resources/img/logo.png" alt="" title="" width="162" height="54" border="0" /></a></div>
    
    	<div class="right_header">
   
            <div class="top_menu">
            <div style="width:90px;float:left;margin:0 3px 0 3px;">&nbsp;</div>
            <a href="javascript:cerrarSesion()" class="login">Salir</a>
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
    <div id="profundidad">&nbsp;<a href="javascript:lnkConsultarCita_onclick()" class="enlace">Consulta de Citas</a> &gt; Diagn&oacute;stico</div>
    
    <div id="contenido">
    <!-- Aqui el contenido de la pagina -->
    		<div class="box_title">
                    	<div class="title_icon"><img src="../resources/img/mini_icon1.gif" alt="" title="" /></div>
                        <h2>Mis <span class="dark_blue">Diagn&oacute;sticos</span></h2>
            </div>
      <div class="caja_contenido">
        <p>Por favor, registre los datos necesarios para la cita realizada.</p>
        <br/>
        <s:form action="" method="POST" name="frmDiagnostico">
      	<table width="840px" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td colspan="3" align="center"><table width="840px" align="left" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td colspan="3" align="center"><span class="titulo">"${cita.paciente.nombreCompleto}"</span></td>
                <td width="115" rowspan="6"><img src="../resources/img/foto_carnetx.jpg" width="112" height="129" /></td>
              </tr>
              <tr>
                <td width="420">&nbsp;</td>
                <td width="72">&nbsp;</td>
                <td width="233">&nbsp;</td>
              </tr>
              <tr>
                <td align="left"><b>Fec. Nac.:</b> ${cita.paciente.fechaNacimientoFormat}</td>
                <td align="left"><b>Peso:</b> </td>
                <td align="left"><input type="text" name="txtPeso" id="txtPeso" class="x4" style="width:150px" value="${cita.paciente.peso}" /></td>
              </tr>
              <tr>
                <td align="left"><b>Edad:</b> ${cita.paciente.edad} años</td>
                <td align="left"><b>Estatura:</b> </td>
                <td align="left"><input type="text" name="txtEstatura" id="txtEstatura" class="x4" style="width:150px" value="${cita.paciente.estatura}" /></td>
              </tr>
              <tr>
                <td align="left"><b>Tipo de Sangre:</b> O+</td>
                <td align="left">&nbsp;</td>
                <td align="left">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td width="420"><b>Médico:</b> ${cita.horario.medico.nombreCompleto}</td>
            <td width="420"><b>Especialidad:</b> ${cita.horario.especialidad.nombre}</td>
          </tr>
          <tr>
            <td><b>Fecha Cita:</b> ${cita.horario.fechaInicioFormat}</td>
            <td><b>Hora Cita:</b> ${horaCita}</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><b>S&iacute;ntomas:</b></td>
            <td><b>Diagnóstico:</b></td>
          </tr>
          <tr>
            <td><textarea name="txtSintomas" id="txtSintomas" cols="100" rows="3" class="x4" style="width:350px">${cita.sintoma}</textarea></td>
            <td><textarea name="txtDiagnostico" id="txtDiagnostico" cols="100" rows="3" class="x4" style="width:350px">${cita.diagnostico}</textarea></td>
          </tr>
          <tr>
            <td><b>Receta:</b></td>
            <td><b>An&aacute;lisis:</b></td>
          </tr>
          <tr>
            <td><textarea name="txtReceta" id="txtReceta" cols="100" rows="3" class="x4" style="width:350px">${cita.receta}</textarea></td>
            <td><textarea name="txtAnalisis" id="txtAnalisis" cols="100" rows="3" class="x4" style="width:350px">${cita.analisis}</textarea></td>
          </tr>
          <tr>
            <td colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td><b>Observaciones: </b><input type="text" name="txtObservaciones" id="txtObservaciones" class="x4" style="width:260px" value="${cita.observaciones}" />
            </td>
            <td><b>Fec. pr&oacute;xima cita:</b>
              <input type="text" name="txtProximaCita" id="txtProximaCita" class="x4" style="width:70px" readonly="readonly" value="${cita.fechaProximaCitaFormat}" />
              <IMG src="<s:url value='/resources/img/cdp.gif'/>" name="imgProximaCita" id="imgProximaCita" width="19" height="24" border="0" alt="Buscar Fecha Cita" align="top" style="cursor:hand" />
				<script type="text/javascript">
                    Calendar.setup({
                        input : "txtProximaCita", // Input Id")
                        ifFormat : "%d/%m/%Y", // Date format");
                        button : "imgProximaCita" // Button Id");
                    });
                </script>
             </td>
          </tr>
          <tr>
            <td colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="3"><input type="button" name="btnGuardar" id="btnGuardar" class="x7g" value="Guardar" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" onclick="javascript:btnGuardar_onclick()" /></td>
          </tr>
        </table>
		</s:form>
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
