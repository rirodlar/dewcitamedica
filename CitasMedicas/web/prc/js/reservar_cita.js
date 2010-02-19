// JavaScript Document
function cboEspecialidad_onchange () {
  __doPostBack("../ReservaCitaServlet", "cboEspecialidad_onchange", "_self");
}

function btnVerHorario_onclick () {
  __doPostBack("../ReservaCitaServlet", "btnVerHorario_onclick", "_self");
}

function btnReservar_onclick () {
	var frm = document.forms[0]; 
	var seleccion = false;
	//Validar seleccion
	var citas = document.getElementsByName("rbtCita");
	
	for (var i = 0 ; i < citas.length ; i++) {
        if (citas[i].checked ) {
            seleccion = true;
			break
        }
    }
	
	if (seleccion) {
		__doPostBack("../ReservaCitaServlet", "btnReservar_onclick", "_self");
    } else
		alert("Debe seleccionar un horario");
}