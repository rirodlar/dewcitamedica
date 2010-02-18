<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Medical Theme Css Template</title>
</head>
<body class="principal">
    <form method="post" action="ReservaCitaServlet">
    <INPUT id="__ARGUMENT" name="__ARGUMENT" type="HIDDEN"/>
    <div id="main_container">
        <div id="profundidad">&nbsp;Reserva de Citas</div>
        <div id="contenido">
            <div class="caja_contenido">
                <form action="" method="post" name="frmReserva">
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
                        <c:forEach var="atencion" items="${horarioAtencion}">
                            <tr>
                                <td class="x4x" align="center">${atencion.rango}</td>
                                <td class="x4x" align="center">
                                    <c:forEach var="lunes" items="${horarioLunes}">
                                        <c:if test="${atencion.horaInicio == lunes.horaInicio && atencion.minutoInicio == lunes.minutoInicio}">
                                            <input type="radio" name="radio" id="${lunes.horarioId}" value="radio" />
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="x4x" align="center">
                                    <c:forEach var="martes" items="${horarioMartes}">
                                        <c:if test="${atencion.horaInicio == martes.horaInicio && atencion.minutoInicio == martes.minutoInicio}">
                                            <input type="radio" name="radio" id="${martes.horarioId}" value="radio" />
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="x4x" align="center">
                                    <c:forEach var="miercoles" items="${horarioMiercoles}">
                                        <c:if test="${atencion.horaInicio == miercoles.horaInicio && atencion.minutoInicio == miercoles.minutoInicio}">
                                            <input type="radio" name="radio" id="${miercoles.horarioId}" value="radio" />
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="x4x" align="center">
                                    <c:forEach var="jueves" items="${horarioJueves}">
                                        <c:if test="${atencion.horaInicio == jueves.horaInicio && atencion.minutoInicio == jueves.minutoInicio}">
                                            <input type="radio" name="radio" id="${jueves.horarioId}" value="radio" />
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="x4x" align="center">
                                    <c:forEach var="viernes" items="${horarioViernes}">
                                        <c:if test="${atencion.horaInicio == viernes.horaInicio && atencion.minutoInicio == viernes.minutoInicio}">
                                            <input type="radio" name="radio" id="${viernes.horarioId}" value="radio" />
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="x4x" align="center">
                                    <c:forEach var="sabado" items="${horarioSabado}">
                                        <c:if test="${atencion.horaInicio == sabado.horaInicio && atencion.minutoInicio == sabado.minutoInicio}">
                                            <input type="radio" name="radio" id="${sabado.horarioId}" value="radio" />
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="x4x" align="center">
                                    <c:forEach var="domingo" items="${horarioDomingo}">
                                        <c:if test="${atencion.horaInicio == domingo.horaInicio && atencion.minutoInicio == domingo.minutoInicio}">
                                            <input type="radio" name="radio" id="${domingo.horarioId}" value="radio" />
                                        </c:if>
                                    </c:forEach>
                                </td>

                            </tr>
                        </c:forEach>
                    </table>
                    <a href="#" title="Ver Cita"><img src="../resources/img/tip.gif" border="0" width="16" height="16" />
                    </a>
                </form>
            </div>
        </div>
    </div>
        <input type="submit" value="Reservar">
    </form>
</body>
</html>