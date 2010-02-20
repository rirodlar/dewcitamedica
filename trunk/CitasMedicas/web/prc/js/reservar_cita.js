// JavaScript Document
function cboEspecialidad_onchange () {
  var frm = document.forms[0];
  frm.__ARGUMENT.value = "cargarMedicos";
  frm.submit();
}

function btnVerHorario_onclick () {
  __doPostBack("buscarHorario");
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
		__doPostBack("reservar");
    } else
		alert("Debe seleccionar un horario");
}