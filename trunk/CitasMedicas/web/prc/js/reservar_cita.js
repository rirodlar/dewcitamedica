// JavaScript Document
function btnReservar_onclick () {
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
        frmReserva.action = '../reserva/reservarCita.action';
        frmReserva.submit();
    } else
        alert("Debe seleccionar un horario");
}
