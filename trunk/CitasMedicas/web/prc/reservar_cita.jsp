<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" type="text/javascript" src="../resources/jss/tools/Utiles.js"></script>
    <link rel="stylesheet" type="text/css" media="all" href="../resources/css/calendario/calendar-win2k-2.css" />
    <script type="text/javascript" src="../resources/jss/calendario/calendar.js"></script>
    <script type="text/javascript" src="../resources/jss/calendario/calendar-es.js"></script>
    <script type="text/javascript" src="../resources/jss/calendario/calendar-setup.js"></script>
    <script type="text/javascript" src="js/reservar_cita.js"></script>
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
                    <li><a href="../home.jsp" title="">Inicio</a></li>
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
        <table width="840px" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td><label>Especialidad:
                    <select name="cboEspecialidad" id="lstEspecialidad" class="x4" style="width:200px" onchange="javascript:cboEspecialidad_onchange();">
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
                    <select name="cboMedico" id="cboMedico" class="x4" style="width:200px">
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
                    <input type="button" name="btnVerHorario" id="btnVerHorario" class="x7g" value="Ver Horario" onclick="javascript:btnVerHorario_onclick()" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" />
                    </label></td>
                  <td>&nbsp;</td>
          </tr>
          </table>
        <br/>
        <p align="left">Usted posee una cita para el día martes 02 de febrero a las 15:20 horas.</p>
        <table class=x1i cellSpacing=0 cellPadding=0 width="840px" border=0>
            <tbody>
                <tr>
                    <td width="100%"></td>
                    <td><input type="button" name="btnReservar" id="btnReservar" class="x7g" value="Reservar" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)"/></td>
                </tr>
            </tbody>
        </table>
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
            </table>
            <div id="scroll">
            <table class="x1h" cellspacing="0" cellpadding="0" width="840px" border="0">
            <c:forEach var="atencion" items="${horarioAtencion}" varStatus="i">
            	<c:choose>
                	<c:when test="${i.first}"><c:set var="estilo" value="x4xf"/></c:when>
                    <c:otherwise><c:set var="estilo" value="x4x"/></c:otherwise>
            	</c:choose>
            <tr>
              <td class="${pageScope.estilo}" width="91" align="center">${atencion.rango}</td>
              <td class="${pageScope.estilo}" width="107" align="center">
              	<c:set var="horarioLibre" value="false"/>
                <c:forEach var="lunes" items="${horarioLunes}">
                    <c:if test="${atencion.horaInicio == lunes.horaInicio && atencion.minutoInicio == lunes.minutoInicio}">
                   		<input type="radio" name="radio" id="radio" value="radio" />
                    	<c:set var="horarioLibre" value="true"/>
                    </c:if>
                </c:forEach>
                <c:if test="${pageScope.horarioLibre == false}">
                	<a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                </c:if>
              </td>
              <td class="${pageScope.estilo}" width="107" align="center">
                <c:forEach var="martes" items="${horarioMartes}">
                    <c:if test="${atencion.horaInicio == lunes.horaInicio && atencion.minutoInicio == martes.minutoInicio}">
                   		<input type="radio" name="radio" id="radio" value="radio" />
                    </c:if>
                </c:forEach>
              </td>
              <td class="${pageScope.estilo}" width="107" align="center">
                <c:forEach var="miercoles" items="${horarioMiercoles}">
                    <c:if test="${atencion.horaInicio == miercoles.horaInicio && atencion.minutoInicio == miercoles.minutoInicio}">
                        <input type="radio" name="radio" id="radio" value="radio" />
                    </c:if>
                </c:forEach>
              </td>
              <td class="${pageScope.estilo}" width="107" align="center">
                <c:forEach var="jueves" items="${horarioJueves}">
                    <c:if test="${atencion.horaInicio == jueves.horaInicio && atencion.minutoInicio == jueves.minutoInicio}">
                        <input type="radio" name="radio" id="radio" value="radio" />
                    </c:if>
                </c:forEach>
              </td>
              <td class="${pageScope.estilo}" width="107" align="center">
                <c:forEach var="viernes" items="${horarioViernes}">
                    <c:if test="${atencion.horaInicio == viernes.horaInicio && atencion.minutoInicio == viernes.minutoInicio}">
                        <input type="radio" name="radio" id="radio" value="radio" />
                    </c:if>
                </c:forEach>
              </td>
              <td class="${pageScope.estilo}" width="107" align="center">
                <c:forEach var="sabado" items="${horarioSabado}">
                    <c:if test="${atencion.horaInicio == sabado.horaInicio && atencion.minutoInicio == sabado.minutoInicio}">
                        <input type="radio" name="radio" id="radio" value="radio" />
                    </c:if>
                </c:forEach>
              </td>
              <td class="${pageScope.estilo}" width="107" align="center">
                <c:forEach var="domingo" items="${horarioDomingo}">
                    <c:if test="${atencion.horaInicio == domingo.horaInicio && atencion.minutoInicio == domingo.minutoInicio}">
                        <input type="radio" name="radio" id="radio" value="radio" />
                    </c:if>
                </c:forEach>
              </td>
             </tr>
             </c:forEach>
          </table>
          </div>
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
