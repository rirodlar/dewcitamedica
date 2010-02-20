<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Medical clinic - Home</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript">
	function servicios () {
  		__doPostBack("Control", "reservarCita", "iniciar", "_self");
	}
	function login () {
  		__doPostBack("Control", "login", "iniciar", "_self");
	}
</script>
<script type="text/javascript" src="resources/jss/tools/Utiles.js"></script>
</head>
<body class="principal">
<div id="main_container">
	<div class="header">
    	<div id="logo"><a href="home.jsp"><img src="resources/img/logo.png" alt="" title="" width="162" height="54" border="0" /></a></div>

    	<div class="right_header">

            <div class="top_menu">
            <a href="javascript:login()" class="login">ingresar</a>
            <a href="#" class="sign_up">registro</a>
            </div>

            <div id="menu">
                <ul>
                    <li><a class="current" href="#" title="">Inicio</a></li>
                    <li><a href="#" title="">Nosotros</a></li>
                    <li><a href="javascript:servicios()" title="">Servicios</a></li>
                    <li><a href="#" title="">Cont&aacute;ctenos</a></li>
                </ul>
            </div>

        </div>

    </div>
    <div id="middle_box">
    	<div class="middle_box_content"><img src="resources/img/banner_content.jpg" alt="" title="" /></div>
    </div>


    <div class="pattern_bg">

    	<div class="pattern_box">
            <div class="pattern_box_icon"><img src="resources/img/icon1.png" alt="" title="" width="70" height="112" /></div>
            <div class="pattern_content">
            <h1>Temas <span class="blue">de Salud</span></h1>
            <p class="pat">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
            </p>
            </div>
        </div>


    	<div class="pattern_box">
            <div class="pattern_box_icon"><img src="resources/img/icon2.png" alt="" title="" width="70" height="112" /></div>
            <div class="pattern_content">
            <h1>Busque <span class="blue"> Tratamientos</span></h1>
            <p class="pat">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
            </p>
            </div>
        </div>


    </div>

    <div id="main_content">

 			<div class="box_content">
					<div class="box_title">
                    	<div class="title_icon"><img src="resources/img/mini_icon1.gif" alt="" title="" /></div>
                        <h2>Pregunta <span class="dark_blue">al Experto</span></h2>
                    </div>

                    <div class="box_text_content" style="background-image:url(resources/img/bg_experta.jpg); background-repeat:no-repeat; background-position:bottom; height:200px">
                    	<img src="resources/img/checked.gif" alt="" title="" class="box_icon" />
                        <div class="texto_medico">
                        <i>Isabel Valencia:</i><br/>
                        ¿Cu&aacute;les son los s&iacute;ntomas de alarma de un infarto al miocardio?</div>
                        <a href="#" class="details">+ m&aacute;s preguntas</a>
                    </div>
      </div>


 			<div class="box_content">
					<div class="box_title">
                    	<div class="title_icon"><img src="resources/img/mini_icon2.gif" alt="" title="" /></div>
                        <h2>Conozca<span class="dark_blue"> Sobre...</span></h2>
                    </div>

                    <div class="box_text_content">
                   	  <img src="resources/img/checked.gif" alt="" title="" class="box_icon" />
                        <div class="box_text">
                        <b>Gripe</b><br/>Consulta las recomendaciones de nuestros especialistas en el "Especial sobre gripe estacional y gripe A".
                        </div>
                        <a href="#" class="details">+ ver m&aacute;s</a>
  					</div>

                    <div class="box_text_content" style="background-image:url(resources/img/corazon.jpg); background-repeat:no-repeat; background-position:bottom">
                    	<img src="resources/img/checked.gif" alt="" title="" class="box_icon" />
                        <div class="box_text">
                        <b>Anatomia del Corazón en 3D</b><br/>La anatomía de nuestro órgano motor en movimiento. Aprende divertiendote.

            </div>
                        <a href="#" class="details">+ ver m&aacute;s</a>
                    </div>

            </div>


  			<div class="box_content">
					<div class="box_title">
                    	<div class="title_icon"><img src="resources/img/mini_icon3.gif" alt="" title="" /></div>
                        <h2>Para <span class="dark_blue">tener en cuenta</span></h2>
                    </div>

                    <div class="box_text_content">
                    	<img src="resources/img/calendar.gif" alt="" title="" class="box_icon" />
                        <div class="box_text">
                      <b>Día del Alzheimer:</b><br/>El 21 de septiembre ha sido elegido por la OMS desde hace ya algunos años para celebrar...</div>
                        <a href="#" class="details">+ ver m&aacute;s</a>
                    </div>

                    <div class="box_text_content">
                    	<img src="resources/img/calendar.gif" alt="" title="" class="box_icon" />
                        <div class="box_text">
                        <b>Se acerca la vacuna del SIDA</b><br/>
                        El reciente descubrimiento de dos anticuerpos del sistema inmune que atacan al virus del sida abriría una puerta a la creación de...</div>
                        <a href="#" class="details">+ ver m&aacute;s</a>
                    </div>

            </div>
        <div class="clear"></div>
       </div>
	<form action="" method="post" name="frmHome">
    	<input id="__ACTION" name="__ACTION" type="HIDDEN" />
        <input id="__ARGUMENT" name="__ARGUMENT" type="HIDDEN" />
    </form>
     <div id="footer">
     	<div class="copyright">
        <img src="resources/img/footer_logo.gif" alt="" title="" />
        </div>
        <div class="center_footer">&copy; Medical Clinic 2008. All Rights Reserved</div>
    	<div class="footer_links">
        <a href="http://csstemplatesmarket.com"><img src="resources/img/csstemplatesmarket.gif" alt="csstemplatesmarket" title="csstemplatesmarket" border="0" /></a>
        </div>

    </div>

</div>
</body>
</html>
