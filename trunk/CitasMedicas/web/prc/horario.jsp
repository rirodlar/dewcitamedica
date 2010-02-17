<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" type="text/javascript" src="../resources/jss/tools/Utiles.js"></script>
    <link rel="stylesheet" type="text/css" media="all" href="../resources/css/calendario/calendar-win2k-2.css" />
    <script type="text/javascript" src="../resources/jss/calendario/calendar.js"></script>
    <script type="text/javascript" src="../resources/jss/calendario/calendar-es.js"></script>
    <script type="text/javascript" src="../resources/jss/calendario/calendar-setup.js"></script>
    <script type="text/javascript" src="js/horario.js"></script>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css" media="screen" />
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
                    <li><a class="current" href="consulta.jsp" title="">Servicios</a></li>
                    <li><a href="#" title="">Cont&aacute;ctenos</a></li>
                </ul>
            </div>
        
        </div>
    </div>
    <div id="profundidad">&nbsp;<a href="consulta.jsp" class="enlace">Consulta de Citas</a>&nbsp;|&nbsp;Horarios</div>
    <div id="contenido">
    <!-- Aqui el contenido de la pagina -->
    		<div class="box_title">
                    	<div class="title_icon"><img src="../resources/img/mini_icon1.gif" alt="" title="" /></div>
                        <h2>Mi <span class="dark_blue">Horario</span></h2>
            </div>
      <div class="caja_contenido">
        <p>Por favor, seleccione la semana a editar.</p>
        <br/>
      	<table width="840px" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="100%">Semana:
                	<input name="txtSemana" type="text" id="txtSemana" value="02/02/2010" class="x4" style="width:70px" />
                    <IMG src="../resources/img/cdp.gif" name="imgFechaDesde" id="imgFechaDesde" width="19" height="24" border="0" alt="Buscar Semana" align="top" style="cursor:hand"/>
					<script type="text/javascript">
                          Calendar.setup({
                          input : "txtSemana", // Input Id")
                          ifFormat : "%d/%m/%Y", // Date format");
                          button : "imgFechaDesde" // Button Id");
                          });
                    </script>
                </td>
                <td width="1%">
                	<input type="button" name="btnBuscar" id="btnBuscar" class="x7g" value="Ver Horario" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" onclick="javascript:btnAbrirHorario_onclick()" />
                </td>
            </tr>
        </table>
        <br/>
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
              <td class="x4x">09:00 - 09:20</td>
              <td class="x4x" align="center"><input type="checkbox" /></td>
              <td class="x4x" align="center"><input type="checkbox" /></td>
              <td class="x4x" align="center"><input type="checkbox" /></td>
              <td class="x4x" align="center"><input type="checkbox" /></td>
              <td class="x4x" align="center"><input type="checkbox" /></td>
              <td class="x4x" align="center"><input type="checkbox" /></td>
              <td class="x4x" align="center"><input type="checkbox" /></td>
            </tr>
             <tr>
              <td class="x4x">09:20 - 09:40</td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
            </tr>
              <tr>
               <td class="x4x">09:40 - 10:00</td>
               	<td class="x4x" align="center"><input type="checkbox" /></td>
              	<td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
              </tr>
              <tr>
               <td class="x4x">10:00 - 10:20</td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
              	<td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
              </tr>
              <tr>
               <td class="x4x">10:20 - 10:40</td>
               <td class="x4x" align="center"><input type="checkbox" /></td>
              	<td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
                <td class="x4x" align="center"><input type="checkbox" /></td>
              </tr>
          </table>
          <br/>
          <table width="840px" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="163">Semana:
                	<input name="txtSemanaCopia" type="text" id="txtSemanaCopia" value="02/02/2010" class="x4" style="width:70px" />
                    <IMG src="../resources/img/cdp.gif" name="imgSemanaCopia" id="imgSemanaCopia" width="19" height="24" border="0" alt="Buscar Semana" align="top" style="cursor:hand"/>
					<script type="text/javascript">
                          Calendar.setup({
                          input : "txtSemanaCopia", // Input Id")
                          ifFormat : "%d/%m/%Y", // Date format");
                          button : "imgSemanaCopia" // Button Id");
                          });
                    </script>
                </td>
                <td width="15">&nbsp;</td>
                <td width="120"><input type="button" name="btnCopiar" id="btnCopiar" class="x7g" value="Copiar Horario" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" /></td>
                <td width="15">&nbsp;</td>
                <td width="82"><input type="button" name="btnEliminar" id="btnEliminar" class="x7g" value="Eliminar" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" /></td>
                <td width="14">&nbsp;</td>
                <td width="82"><input type="button" name="btnGuardar" id="btnGuardar" class="x7g" value="Guardar" style="BACKGROUND-IMAGE: url(../resources/img/btn-bg1.gif)" /></td>
                <td width="349">&nbsp;</td>
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