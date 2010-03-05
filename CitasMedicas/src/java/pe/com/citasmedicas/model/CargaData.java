package pe.com.citasmedicas.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author dew - Grupo 04
 */
public class CargaData {

    public static List<Horario> HORARIO_ATENCION = null;

    public static void inicializar() {
        // Horarios de atención de la clinica
        HORARIO_ATENCION = new ArrayList<Horario>();
        Calendar cal = new GregorianCalendar(2010, 0, 1);
        Calendar calAux = new GregorianCalendar(2010, 0, 1);
        Calendar[] atencion = new Calendar[2];
        cal.set(Calendar.HOUR_OF_DAY, 8);
        calAux.setTimeInMillis(cal.getTimeInMillis());
        atencion[0] = calAux;
        while(cal.get(Calendar.HOUR_OF_DAY) < 21){
            cal.add(Calendar.MINUTE, 30);
            calAux = new GregorianCalendar();
            calAux.setTimeInMillis(cal.getTimeInMillis());
            atencion[1] = calAux;
            Horario horario = new Horario();
            horario.setFechaInicio(atencion[0].getTime());
            horario.setFechaFin(atencion[1].getTime());
            HORARIO_ATENCION.add(horario);
            atencion = new Calendar[2];
            calAux = new GregorianCalendar();
            calAux.setTimeInMillis(cal.getTimeInMillis());
            atencion[0] = calAux;
        }
    }

    public static void main(String arg[]){
        CargaData.inicializar();
        for(Horario h : CargaData.HORARIO_ATENCION){
            System.out.println(h.getFechaInicio() + " - " + h.getFechaFin());
        }
    }
}
