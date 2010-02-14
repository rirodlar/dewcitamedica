package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Horario;

/**
 *
 * @author dew - Grupo 04
 */
public class CitaDao {

    /**
     * Obtiene una cita por su id
     * @param Integer citaId
     * @return Cita
     */
    public Cita getCitaPorId(Integer citaId) {
        if (citaId == null) {
            return null;
        }
        Cita cita = null;
        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getCitaId().intValue() == citaId.intValue()) {
                cita = citaAux;
                break;
            }
        }
        return cita;
    }

    /**
     * Obtiene la cita de un horario específico
     * @param Horario horario
     * @return Cita
     */
    public Cita getCitaPorHorario(Horario horario) {
        if (horario == null) {
            return null;
        }
        Cita cita = null;
        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getHorario().equals(horario)) {
                cita = citaAux;
                break;
            }
        }
        return cita;
    }
}
