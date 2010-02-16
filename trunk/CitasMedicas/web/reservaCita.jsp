<%-- 
    Document   : reservaCita
    Created on : 15/02/2010, 07:11:14 PM
    Author     : rSaenz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reserva de Citas</h1>
        <table width="840px" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td><label>Especialidad:
                    <select name="cboEspecialidad" id="cboEspecialidad" style="width:240px">
                      <c:forEach items="${especialidades}" var="especialidad">
                        <option value="${especialidad.especialidadId}"
                          <c:if test="${especialidad.especialidadId==especialidadId}">
                            selected="selected"
                          </c:if>
                        >${especialidad.nombre}</option>
                      </c:forEach>
                    </select>
                    </label></td>
                  <td><label>Médico:
                    <select name="cboMedico" id="cboMedico" style="width:240px">
                      <c:forEach items="${medicos}" var="medico">
                        <option value="${medico.personaId}"
                          <c:if test="${especialidad.especialidadId==especialidadId}">
                            selected="selected"
                          </c:if>
                          >${medico.nombreCompleto}</option>
                      </c:forEach>
                    </select>
                    </label></td>
          </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>

                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td><label>
                    <input type="button" name="btnBuscar" id="btnBuscar" value="Ver Horario" />
                    </label></td>
                  <td><label>
                    <input type="button" name="btnReservar" id="btnReservar" value="Reservar" />
                    </label></td>

          </tr>
          </table>
    </body>
</html>
