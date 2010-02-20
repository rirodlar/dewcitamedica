package pe.com.citasmedicas.controller;

import pe.com.citasmedicas.accion.HomeAccion;
import pe.com.citasmedicas.accion.LoginAccion;
import pe.com.citasmedicas.accion.diagnosticar.DiagnosticarAccion;
import pe.com.citasmedicas.accion.horario.MantenerHorarioAccion;
import pe.com.citasmedicas.accion.reservarcita.ReservarCitaAccion;

public class FabricaAccion {

    /**
     * Recibe el identificador de la Accion Solicitada, y devuelve una nueva
     * instancia de la Accion especifica Asociada.
     * 
     * Por cada Proceso, se creara una clase que implemente de Accion y en la
     * vista correspondiente indicarle su identificador para que se asocie de
     * esta forma
     */
    public static Accion crearAccion(String claseAccion) {
        //Reservar Cita
        if (claseAccion.equals("login")) {
            return new LoginAccion();
        }
        //Reservar Cita
        else if (claseAccion.equals("reservarCita")) {
            return new ReservarCitaAccion();
        }
        //Diagnosticar
        else if (claseAccion.equals("diagnosticar")) {
            return new DiagnosticarAccion();
        }
        //Mantenimiento de Horario
        else if (claseAccion.equals("mantHorario")) {
            return new MantenerHorarioAccion();
        }
        //
        else{
            return new HomeAccion();
        }
    }
}
