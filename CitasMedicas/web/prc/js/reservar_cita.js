// JavaScript Document
function cboEspecialidad_onchange () {
  __doPostBack("../ReservaCitaServlet", "cboEspecialidad_onchange", "_self");
}

function btnVerHorario_onclick () {
  __doPostBack("../ReservaCitaServlet", "btnVerHorario_onclick", "_self");
}

function btnReservar_onclick () {
	var frm = document.forms[0]; 
	//Validar seleccion
	if (frm.rbtCita.value == "")
		alert("Por favor debe seleccionar una opcion");
	else 
		alert("Se selecciono una opcion");
}