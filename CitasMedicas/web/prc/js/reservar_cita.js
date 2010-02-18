// JavaScript Document
function cboCombo01_onchange () {
  f = document.forms[0];  
  params = "";
  var url = "../ReservaCitaServlet?"+params;
  __doPostBack(url, "cboCombo01_onchange", "cargaMedico", "_self");
}
function cboCombo02_onchange () {
  f = document.forms[0];  
  params = "";
  var url = "../ReservaCitaServlet?"+params;
  __doPostBack(url, "cboCombo02_onchange", "cargaHorario", "_self");
}