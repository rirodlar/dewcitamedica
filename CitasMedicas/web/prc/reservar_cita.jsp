<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
﻿<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" type="text/javascript" src="../resources/jss/tools/Utiles.js"></script>
    <link rel="stylesheet" type="text/css" media="all" href="../resources/css/calendario/calendar-win2k-2.css" />
    <script type="text/javascript" src="../resources/jss/calendario/calendar.js"></script>
    <script type="text/javascript" src="../resources/jss/calendario/calendar-es.js"></script>
    <script type="text/javascript" src="../resources/jss/calendario/calendar-setup.js"></script>
    <script type="text/javascript" src="js/consulta.js"></script>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css" media="screen" />
    <script type="text/javascript" src="js/reservar_cita.js"></script>
    <script type="text/javascript" src="../resources/jss/tools/Utiles.js"></script>
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
            <a href="consulta.jsp" class="login">ingresar</a>
            <a href="#" class="sign_up">registro</a>
            </div>
        
            <div id="menu">
                <ul>                                              
                    <li><a href="../index.jsp" title="">Inicio</a></li>
                    <li><a href="#" title="">Nosotros</a></li>
                    <li><a class="current" href="#" title="">Servicios</a></li>
                    <li><a href="#" title="">Cont&aacute;ctenos</a></li>
                </ul>
            </div>
        
        </div>
    </div>
    <div id="profundidad">&nbsp;Reserva de Citas</div>
    
    <div id="contenido">
    <!-- Aqui el contenido de la pagina -->
    		<div class="box_title">
                    	<div class="title_icon"><img src="../resources/img/mini_icon1.gif" alt="" title="" /></div>
                        <h2>Reservar <span class="dark_blue">Cita</span></h2>
            </div>
      <div class="caja_contenido">
        <p>Por favor, seleccione los criterios necesarios para la b&uacute;squeda.</p>
        <br/>
        <form action="" method="post" name="frmReserva">
        <INPUT id="__ACTION" name="__ACTION" type="HIDDEN"/>
        <INPUT id="__ARGUMENT" name="__ARGUMENT" type="HIDDEN"/>
        <table width="840px" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td><label>Especialidad:
                    <select name="cboEspecialidad" id="lstEspecialidad" class="x4" style="width:200px" onchange="javascript:cboCombo01_onchange();">
                        <c:forEach var="especialidad" items="${especialidades}">
                            <option value="${especialidad.especialidadId}"
                                    <c:if test="${especialidad.especialidadId == especialidadId}">
                                    selected="selected"
                                    </c:if>
                            >${especialidad.nombre}</option>
                        </c:forEach>
                    </select>
                    </label></td>
                  <td><label>Médico:
                    <select name="cboMedico" id="cboMedico" class="x4" style="width:200px" onchange="javascript:cboCombo02_onchange();">
                        <c:forEach var="medico" items="${medicos}">
                            <option value="${medico.personaId}"
                                    <c:if test="${medico.personaId == medicoId}">
                                    selected="selected"
                                    </c:if>
                            >${medico.nombreCompleto}</option>
                        </c:forEach>
                    </select>
                    </label></td>
                  <td>Semana:
                	<input name="txtSemana" type="text" id="txtSemana" value="02/02/2010" class="x4" style="width:70px" />
                    <IMG src="../resources/img/cdp.gif" name="imgFechaDesde" id="imgFechaDesde" width="19" height="24" border="0" alt="Buscar Fecha de Venta" align="top" style="cursor:hand"/>
					<script type="text/javascript">
                          Calendar.setup({
                          input : "txtSemana", // Input Id")
                          ifFormat : "%d/%m/%Y", // Date format");
                          button : "imgFechaDesde" // Button Id");
                          });
                    </script></td>
          </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td><label>
                    <input type="button" name="btnBuscar" id="btnBuscar" class="x7g" value="Ver Horario" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" />
                    </label></td>
                  <td><label>
                    <input type="button" name="btnReservar" id="btnReservar" class="x7g" value="Reservar" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)"/>
                    </label></td>
          </tr>
          </table>
        <br/>
        <p align="left">Usted posee una cita para el día martes 02 de febrero a las 15:20 horas.</p>
          <table class="x1h" cellspacing="0" cellpadding="0" width="840px" border="0">
            <tr>
              <th class="x4j" width="91" scope="col">Hora</th>
              <th class="x4j" width="107" scope="col">Lun 01</th>
              <th class="x4j" width="107" scope="col">Mar 02</th>
              <th class="x4j" width="107" scope="col">Mie 03</th>
              <th class="x4j" width="107" scope="col">Jue 04</th>
              <th class="x4j" width="107" scope="col">Vie 05</th>
              <th class="x4j" width="107" scope="col">Sab 06</th>
              <th class="x4j" width="107" scope="col">Dom 07</th>
            </tr>
            <tr>
              <td class="x4x" align="center">09:00 - 09:20</td>
              <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              <td class="x4x" align="center">
              	<a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
              </td>
              <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
             </tr>
             <tr>
              <td class="x4x" align="center">09:20 - 09:40</td>
               <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
               <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
               <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
               <td class="x4x" align="center">
              	<a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
              </td>
               <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
               <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
               <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              </tr>
              <tr>
               <td class="x4x" align="center">09:40 - 10:00</td>
               	<td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              	<td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center">
              	<a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
              </td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              </tr>
              <tr>
               <td class="x4x" align="center">10:00 - 10:20</td>
               <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              	<td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center">
              	<a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
              </td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              </tr>
              <tr>
               <td class="x4x" align="center">10:20 - 10:40</td>
               <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              	<td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center">
              	<a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                </td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              </tr>
              <tr>
                <td class="x4x" align="center">10:40 - 11:00</td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              </tr>
              <tr>
                <td class="x4x" align="center">11:00 - 11:20</td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              </tr>
              <tr>
                <td class="x4x" align="center">11:20 - 11:40</td>
                <td class="x4x" align="center">
              	<a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                </td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              </tr>
              <tr>
                <td class="x4x" align="center">11:40 - 12:00</td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
                <td class="x4x" align="center"><input type="radio" name="radio" id="radio" value="radio" /></td>
              </tr>
          </table>
          </form>

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
