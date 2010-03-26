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
        <script type="text/javascript" src="<s:url value='/prc/js/consulta.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/style.css'/>" media="screen" />
        <script type="text/javascript">
            function btnVerHorario_onclick () {
                frmConsulta.action = '<s:url value="/consulta/consultarCita.action"/>'
                frmConsulta.submit();
            }
            function cerrarSesion() {
                frmConsulta.action = '<s:url value="/login/logout.action"/>'
                frmConsulta.submit();
            }
        </script>
    <!--[if IE 6]>
    <link rel="stylesheet" type="text/css" href="../resources/css/iecss.css" />
    <![endif]-->
<title>Consulta de Citas</title>
</head>
<body class="principal">
<div id="main_container">
	<div class="header">
    	<div id="logo"><a href="index.jsp"><img src="../resources/img/logo.png" alt="" title="" width="162" height="54" border="0" /></a></div>
    
    	<div class="right_header">
   
            <div class="top_menu">
            <div style="width:90px;float:left;margin:0 3px 0 3px;">&nbsp;</div>
            <a href="../login.jsp" class="login">Salir</a>
            </div>
        
            <div id="menu">
                <ul>                                              
                    <li><a href="../home.jsp" title="">Inicio</a></li>
                    <li><a href="#" title="">Nosotros</a></li>
                    <li><a class="current" href="#" title="">Citas</a></li>
                    <li><a href="horario.jsp" title="">Horarios</a></li>
                </ul>
            </div>
        
        </div>
    </div>
    <div id="profundidad">&nbsp;Consulta de Citas</div>
    
    <div id="contenido">
    <!-- Aqui el contenido de la pagina -->
    		<div class="box_title">
                    	<div class="title_icon"><img src="../resources/img/mini_icon1.gif" alt="" title="" /></div>
                        <h2>Mis <span class="dark_blue">Citas</span></h2>
            </div>
      <div class="caja_contenido">
        <p>Por favor, seleccione la cita de la que desea ver el detalle.</p>
        <br/>
        <s:form action="" method="POST" name="frmConsulta">
            <s:hidden name="__ACTION" />
            <s:hidden name="__ARGUMENT" />
      	<table width="840px" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="100%">Semana:
                	<input name="txtSemana" type="text" id="txtSemana" value="${fechaSemana}" class="x4" style="width:70px" />
                    <IMG src="<s:url value='/resources/img/cdp.gif'/>" name="imgFechaDesde" id="imgFechaDesde" width="19" height="24" border="0" alt="Buscar Fecha de Venta" align="top" style="cursor:hand"/>
					<script type="text/javascript">
                          Calendar.setup({
                          input : "txtSemana", // Input Id")
                          ifFormat : "%d/%m/%Y", // Date format");
                          button : "imgFechaDesde" // Button Id");
                          });
                    </script>
                </td>
                <td width="1%">
                	<input type="button" name="btnBuscar" id="btnBuscar" class="x7g" value="Ver Horario" onclick="javascript:btnVerHorario_onclick()" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" />
                </td>
            </tr>
        </table>
        </s:form>
        <br/>
          <table class="x1h" cellspacing="0" cellpadding="0" width="840px" border="0">
            <tr>
              <th class="x4j" width="91" scope="col">Hora</th>
              	<c:forEach var="diaSemana" items="${cabeceraSemana}">
                    <th class="x4j" width="107" scope="col">${diaSemana}</th>
                </c:forEach>
            </tr>
            <c:forEach var="atencion" items="${horarioAtencion}" varStatus="i">
            <tr>
              <td class="x4x">${atencion.rango}</td>
              <td class="x4x" align="center">
              	<c:forEach var="lunes" items="${horarioLunes}">
                	<c:if test="${atencion.horaInicio == lunes.horaInicio && atencion.minutoInicio == lunes.minutoInicio}"> <!-- Si existe horario -->
                    	<c:if test="${lunes.cita != null}"><!-- Si existe cita -->
                            <c:choose>
                                <c:when test="${lunes.cita.estado=='PENDIENTE'}">
                                    <a href="#" title="${lunes.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/view_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" title="${lunes.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/write_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                     </c:if>
                 </c:forEach>
              </td>
              <td class="x4x" align="center">
              	<c:forEach var="martes" items="${horarioMartes}">
                	<c:if test="${atencion.horaInicio == martes.horaInicio && atencion.minutoInicio == martes.minutoInicio}"> <!-- Si existe horario -->
                    	<c:if test="${martes.cita != null}"><!-- Si existe cita -->
                        	<c:choose>
                                <c:when test="${martes.cita.estado=='PENDIENTE'}">
                                    <a href="#" title="${martes.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/view_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" title="${martes.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/write_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                     </c:if>
                 </c:forEach>
              </td>
              <td class="x4x" align="center">
              	<c:forEach var="miercoles" items="${horarioMiercoles}">
                	<c:if test="${atencion.horaInicio == miercoles.horaInicio && atencion.minutoInicio == miercoles.minutoInicio}"> <!-- Si existe horario -->
                    	<c:if test="${miercoles.cita != null}"><!-- Si existe cita -->
                        	<c:choose>
                                <c:when test="${miercoles.cita.estado=='PENDIENTE'}">
                                    <a href="#" title="${miercoles.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/view_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" title="${miercoles.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/write_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                     </c:if>
                 </c:forEach>
              </td>
              <td class="x4x" align="center">
              	<c:forEach var="jueves" items="${horarioJueves}">
                	<c:if test="${atencion.horaInicio == jueves.horaInicio && atencion.minutoInicio == jueves.minutoInicio}"> <!-- Si existe horario -->
                    	<c:if test="${jueves.cita != null}"><!-- Si existe cita -->
                        	<c:choose>
                                <c:when test="${jueves.cita.estado=='PENDIENTE'}">
                                    <a href="#" title="${jueves.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/view_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" title="${jueves.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/write_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                     </c:if>
                 </c:forEach>
              </td>
              <td class="x4x" align="center">
              	<c:forEach var="viernes" items="${horarioViernes}">
                	<c:if test="${atencion.horaInicio == viernes.horaInicio && atencion.minutoInicio == viernes.minutoInicio}"> <!-- Si existe horario -->
                    	<c:if test="${viernes.cita != null}"><!-- Si existe cita -->
                        	<c:choose>
                                <c:when test="${viernes.cita.estado=='PENDIENTE'}">
                                    <a href="#" title="${viernes.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/view_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" title="${viernes.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/write_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                     </c:if>
                 </c:forEach>
              </td>
              <td class="x4x" align="center">
              	<c:forEach var="sabado" items="${horarioSabado}">
                	<c:if test="${atencion.horaInicio == sabado.horaInicio && atencion.minutoInicio == sabado.minutoInicio}"> <!-- Si existe horario -->
                    	<c:if test="${sabado.cita != null}"><!-- Si existe cita -->
                        	<c:choose>
                                <c:when test="${sabado.cita.estado=='PENDIENTE'}">
                                    <a href="#" title="${sabado.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/view_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" title="${sabado.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/write_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                     </c:if>
                 </c:forEach>
              </td>
              <td class="x4x" align="center">
              	<c:forEach var="domingo" items="${horarioDomingo}">
                	<c:if test="${atencion.horaInicio == domingo.horaInicio && atencion.minutoInicio == domingo.minutoInicio}"> <!-- Si existe horario -->
                    	<c:if test="${domingo.cita != null}"><!-- Si existe cita -->
                        	<c:choose>
                                <c:when test="${domingo.cita.estado=='PENDIENTE'}">
                                    <a href="#" title="${domingo.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/view_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" title="${domingo.cita.paciente.nombreCompleto}"><img src="<s:url value='/resources/img/write_enabled.gif'/>" border="0" width="16" height="16" /></a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                     </c:if>
                 </c:forEach>
              </td>
             </tr>
             </c:forEach>
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
