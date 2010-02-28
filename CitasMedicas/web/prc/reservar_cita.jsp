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
        <script type="text/javascript" src="<s:url value='/prc/js/reservar_cita.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/style.css'/>" media="screen" />
        <script type="text/javascript" src="<s:url value='/resources/jss/tools/Utiles.js'/>"></script>
        <script type="text/javascript">
            function cboEspecialidad_onchange () {
                frmReserva.action = '<s:url value="/reserva/cargarMedicos.action"/>';
                frmReserva.submit();
            }
            function btnVerHorario_onclick () {
                frmReserva.action = '<s:url value="/reserva/buscarHorario.action"/>'
                frmReserva.submit();
            }
            function cerrarSesion() {
                frmReserva.action = '<s:url value="/login/logout.action"/>'
                frmReserva.submit();
            }
        </script>
        <title>Reservar Cita</title>
    </head>
    <body class="principal">
        <div id="main_container">
            <div class="header">
                <div id="logo"><a href="<s:url value='/home.jsp'/>"><img src="<s:url value='/resources/img/logo.png'/>" alt="" title="" width="162" height="54" border="0" /></a></div>
                <div class="right_header">
                    <div class="top_menu">
                        <div style="width:90px;float:left;margin:0 3px 0 3px;">&nbsp;</div>
                        <a href="javascript:cerrarSesion();" class="login">Salir</a>
                    </div>
                    <div id="menu">
                        <ul>
                            <li><a href="<s:url value='/home.jsp'/>" title="">Inicio</a></li>
                            <li><a href="#" title="">Nosotros</a></li>
                            <li><a class="current" href="#" title="">Reservas</a></li>
                            <li><a href="#" title="">Cont&aacute;ctenos</a></li>
                        </ul>
                    </div>

                </div>
            </div>
            <div id="profundidad">&nbsp;Reserva de Citas</div>
            <div class="xh"><b>Usuario:</b> ${usuario.persona.nombreCompleto}</div>
            <div id="contenido">
                <!-- Aqui el contenido de la pagina -->
                <div class="box_title">
                    <div class="title_icon"><img src="<s:url value='/resources/img/mini_icon1.gif'/>" alt="" title="" /></div>
                    <h2>Reservar <span class="dark_blue">Cita</span></h2>
                </div>
                <div class="caja_contenido">
                    <p>Por favor, seleccione los criterios necesarios para la b&uacute;squeda.</p>
                    <br/>
                    <s:form action="" method="POST" name="frmReserva">
                        <s:hidden name="__ACTION" />
                        <s:hidden name="__ARGUMENT" />
                        <table width="840px" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td><label>Especialidad:
                                        <select name="cboEspecialidad" id="cboEspecialidad" class="x4" style="width:200px" onchange="javascript:cboEspecialidad_onchange(); ">
                                            <c:forEach var="especialidad" items="${especialidades}">
                                                <option value="${especialidad.especialidadId}"
                                                        <c:if test="${especialidad.especialidadId == especialidadId}">
                                                            selected="selected"
                                                        </c:if>
                                                        >${especialidad.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </label></td>
                                <td><label>M&eacute;dico:
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
                                    <input name="txtSemana" type="text" id="txtSemana" value="${fechaSemana}" class="x4" style="width:70px" readonly="readonly" />
                                    <IMG src="<s:url value='/resources/img/cdp.gif'/>" name="imgFechaDesde" id="imgFechaDesde" width="19" height="24" border="0" alt="Buscar Fecha de Venta" align="top" style="cursor:hand"/>
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
                        <p align="left">
                            <strong>Sus citas pendientes son:</strong>
                            <c:forEach var="citaPendiente" items="${citasPendientes}">
                                <br />${citaPendiente}
                            </c:forEach>
                            <c:if test="${errorMsg != null}">
                                <br /><br /><span class="x2o">${errorMsg}</span><br />
                            </c:if>
                        </p>
                        <table class=x1i cellSpacing=0 cellPadding=0 width="840px" border=0>
                            <tbody>
                                <tr>
                                    <td width="100%"></td>
                                    <td><input type="button" name="btnReservar" id="btnReservar" class="x7g" value="Reservar" onclick="javascript:btnReservar_onclick()" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)"/></td>
                                </tr>
                            </tbody>
                        </table>
                        <table class="x1h" cellspacing="0" cellpadding="0" width="840px" border="0">
                            <tr>
                                <th class="x4j" width="91" scope="col">Hora</th>
                                <c:forEach var="diaSemana" items="${cabeceraSemana}">
                                    <th class="x4j" width="107" scope="col">${diaSemana}</th>
                                </c:forEach>
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
                                            <c:forEach var="lunes" items="${horarioLunes}">
                                                <c:if test="${atencion.horaInicio == lunes.horaInicio && atencion.minutoInicio == lunes.minutoInicio}"> <!-- Si existe horario -->
                                                    <c:choose>
                                                        <c:when test="${lunes.cita == null}"> <!-- Si no existe cita -->
                                                            <input type="radio" name="rbtCita" id="${lunes.horarioId}" value="${lunes.horarioId}"/>
                                                        </c:when>
                                                        <c:otherwise> <!-- Si existe cita -->
                                                            <c:choose>
                                                                <c:when test="${lunes.cita.paciente.personaId==usuario.persona.personaId}"> <!--Cita del paciente-->
                                                                    <c:choose>
                                                                        <c:when test="${lunes.cita.estado=='PENDIENTE'}">
                                                                            <input type="radio" name="rbtCita" id="${lunes.horarioId}" value="${lunes.horarioId}" checked="checked" />
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:when>
                                                                    <c:otherwise> <!--Cita de otro paciente-->
                                                                    <a href="#" title="No disponible"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                        </td>
                                        <td class="${pageScope.estilo}" width="107" align="center">
                                            <c:forEach var="martes" items="${horarioMartes}">
                                                <c:if test="${atencion.horaInicio == martes.horaInicio && atencion.minutoInicio == martes.minutoInicio}"> <!-- Si existe horario -->
                                                    <c:choose>
                                                        <c:when test="${martes.cita == null}"> <!-- Si no existe cita -->
                                                            <input type="radio" name="rbtCita" id="${martes.horarioId}" value="${martes.horarioId}"/>
                                                        </c:when>
                                                        <c:otherwise> <!-- Si existe cita -->
                                                            <c:choose>
                                                                <c:when test="${martes.cita.paciente.personaId==usuario.persona.personaId}"> <!--Cita del paciente-->
                                                                    <c:choose>
                                                                        <c:when test="${martes.cita.estado=='PENDIENTE'}">
                                                                            <input type="radio" name="rbtCita" id="${martes.horarioId}" value="${martes.horarioId}" checked="checked" />
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:when>
                                                                    <c:otherwise> <!--Cita de otro paciente-->
                                                                    <a href="#" title="No disponible"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                        </td>
                                        <td class="${pageScope.estilo}" width="107" align="center">
                                            <c:forEach var="miercoles" items="${horarioMiercoles}">
                                                <c:if test="${atencion.horaInicio == miercoles.horaInicio && atencion.minutoInicio == miercoles.minutoInicio}"> <!-- Si existe horario -->
                                                    <c:choose>
                                                        <c:when test="${miercoles.cita == null}"> <!-- Si no existe cita -->
                                                            <input type="radio" name="rbtCita" id="${miercoles.horarioId}" value="${miercoles.horarioId}"/>
                                                        </c:when>
                                                        <c:otherwise> <!-- Si existe cita -->
                                                            <c:choose>
                                                                <c:when test="${miercoles.cita.paciente.personaId==usuario.persona.personaId}"> <!--Cita del paciente-->
                                                                    <c:choose>
                                                                        <c:when test="${miercoles.cita.estado=='PENDIENTE'}">
                                                                            <input type="radio" name="rbtCita" id="${miercoles.horarioId}" value="${miercoles.horarioId}" checked="checked" />
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:when>
                                                                    <c:otherwise> <!--Cita de otro paciente-->
                                                                    <a href="#" title="No disponible"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                        </td>
                                        <td class="${pageScope.estilo}" width="107" align="center">
                                            <c:forEach var="jueves" items="${horarioJueves}">
                                                <c:if test="${atencion.horaInicio == jueves.horaInicio && atencion.minutoInicio == jueves.minutoInicio}"> <!-- Si existe horario -->
                                                    <c:choose>
                                                        <c:when test="${jueves.cita == null}"> <!-- Si no existe cita -->
                                                            <input type="radio" name="rbtCita" id="${jueves.horarioId}" value="${jueves.horarioId}"/>
                                                        </c:when>
                                                        <c:otherwise> <!-- Si existe cita -->
                                                            <c:choose>
                                                                <c:when test="${jueves.cita.paciente.personaId==usuario.persona.personaId}"> <!--Cita del paciente-->
                                                                    <c:choose>
                                                                        <c:when test="${jueves.cita.estado=='PENDIENTE'}">
                                                                            <input type="radio" name="rbtCita" id="${jueves.horarioId}" value="${jueves.horarioId}" checked="checked" />
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:when>
                                                                    <c:otherwise> <!--Cita de otro paciente-->
                                                                    <a href="#" title="No disponible"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                        </td>
                                        <td class="${pageScope.estilo}" width="107" align="center">
                                            <c:forEach var="viernes" items="${horarioViernes}">
                                                <c:if test="${atencion.horaInicio == viernes.horaInicio && atencion.minutoInicio == viernes.minutoInicio}"> <!-- Si existe horario -->
                                                    <c:choose>
                                                        <c:when test="${viernes.cita == null}"> <!-- Si no existe cita -->
                                                            <input type="radio" name="rbtCita" id="${viernes.horarioId}" value="${viernes.horarioId}"/>
                                                        </c:when>
                                                        <c:otherwise> <!-- Si existe cita -->
                                                            <c:choose>
                                                                <c:when test="${viernes.cita.paciente.personaId==usuario.persona.personaId}"> <!--Cita del paciente-->
                                                                    <c:choose>
                                                                        <c:when test="${viernes.cita.estado=='PENDIENTE'}">
                                                                            <input type="radio" name="rbtCita" id="${viernes.horarioId}" value="${viernes.horarioId}" checked="checked" />
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:when>
                                                                    <c:otherwise> <!--Cita de otro paciente-->
                                                                    <a href="#" title="No disponible"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                        </td>
                                        <td class="${pageScope.estilo}" width="107" align="center">
                                            <c:forEach var="sabado" items="${horarioSabado}">
                                                <c:if test="${atencion.horaInicio == sabado.horaInicio && atencion.minutoInicio == sabado.minutoInicio}"> <!-- Si existe horario -->
                                                    <c:choose>
                                                        <c:when test="${sabado.cita == null}"> <!-- Si no existe cita -->
                                                            <input type="radio" name="rbtCita" id="${sabado.horarioId}" value="${sabado.horarioId}"/>
                                                        </c:when>
                                                        <c:otherwise> <!-- Si existe cita -->
                                                            <c:choose>
                                                                <c:when test="${sabado.cita.paciente.personaId==usuario.persona.personaId}"> <!--Cita del paciente-->
                                                                    <c:choose>
                                                                        <c:when test="${sabado.cita.estado=='PENDIENTE'}">
                                                                            <input type="radio" name="rbtCita" id="${sabado.horarioId}" value="${sabado.horarioId}" checked="checked" />
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:when>
                                                                    <c:otherwise> <!--Cita de otro paciente-->
                                                                    <a href="#" title="No disponible"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                        </td>
                                        <td class="${pageScope.estilo}" width="107" align="center">
                                            <c:forEach var="domingo" items="${horarioDomingo}">
                                                <c:if test="${atencion.horaInicio == domingo.horaInicio && atencion.minutoInicio == domingo.minutoInicio}"> <!-- Si existe horario -->
                                                    <c:choose>
                                                        <c:when test="${domingo.cita == null}"> <!-- Si no existe cita -->
                                                            <input type="radio" name="rbtCita" id="${domingo.horarioId}" value="${domingo.horarioId}"/>
                                                        </c:when>
                                                        <c:otherwise> <!-- Si existe cita -->
                                                            <c:choose>
                                                                <c:when test="${domingo.cita.paciente.personaId==usuario.persona.personaId}"> <!--Cita del paciente-->
                                                                    <c:choose>
                                                                        <c:when test="${domingo.cita.estado=='PENDIENTE'}">
                                                                            <input type="radio" name="rbtCita" id="${domingo.horarioId}" value="${domingo.horarioId}" checked="checked" />
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:when>
                                                                    <c:otherwise> <!--Cita de otro paciente-->
                                                                    <a href="#" title="No disponible"><img src="../resources/img/tip.gif" border="0" width="16" height="16" /></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            ${filtro}
                        </div>
                    </s:form>
                </div>
            </div>
            <div id="footer">
                <div class="copyright">
                    <img src="../resources/img/footer_logo.gif" alt="" title="" />
                </div>
                <div class="center_footer">&copy; Medical Clinic 2008. All Rights Reserved</div>
            </div>
        </div>
    </body>
</html>
